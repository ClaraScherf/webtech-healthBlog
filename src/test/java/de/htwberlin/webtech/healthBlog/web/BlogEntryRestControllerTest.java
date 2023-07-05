package de.htwberlin.webtech.healthBlog.web;


import de.htwberlin.webtech.healthBlog.service.BlogEntryService;
import de.htwberlin.webtech.healthBlog.web.api.BlogEntry;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BlogEntryRestController.class)
class BlogEntryRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BlogEntryService blogEntryService;

    private LocalDate currentTime = LocalDate.now();

    @Test
    @DisplayName("should return found entry from entry service")
    void should_return_found_entry_from_entry_service() throws Exception {
        //given
        var entries = List.of(
                new BlogEntry(1, currentTime, 10000, 2500, 0, "Nice!"),
                new BlogEntry(2, currentTime, 8800, 2200, 1, "Top!")
        );

        doReturn(entries).when(blogEntryService).findAll();

        //when
        mockMvc.perform(get("/api/v1/blog-entries"))
            //then
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.size()").value(2))
            .andExpect(jsonPath("$[0].id").value(1))
            //.andExpect(jsonPath("$[0].date").value("2023-01-01"))
            .andExpect(jsonPath("$[0].steps").value(10000))
            .andExpect(jsonPath("$[0].calories").value(2500))
            .andExpect(jsonPath("$[0].emojis").value(0))
            .andExpect(jsonPath("$[0].diaryEntry").value("Nice!"))
            .andExpect(jsonPath("$[1].id").value(2))
            //.andExpect(jsonPath("$[1].date").value(LocalDate.of(2023, 1, 2)))
            .andExpect(jsonPath("$[1].steps").value(8800))
            .andExpect(jsonPath("$[1].calories").value(2200))
            .andExpect(jsonPath("$[1].emojis").value(1))
            .andExpect(jsonPath("$[1].diaryEntry").value("Top!"));
    }

    @Test
    @DisplayName("should return 404 if entry is not found")
    void should_return_404_if_person_is_not_found() throws Exception {
        //given
        doReturn(null).when(blogEntryService).findById(anyLong());

        //when
        mockMvc.perform(get("/api/v1/blog-entries/123"))
            //then
            .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("should return 201 http status and Location header when creating an entry")
    void should_return_201_http_status_and_location_header_when_creating_an_entry() throws Exception {
        //given
        String entryToCreateAsJson = "{\"date\":\"2023-01-01\",\"calories\":2500,\"steps\":10000,\"emojis\":0,\"diaryEntry\":\"Nice!\"}";
        var entry = new BlogEntry(1, LocalDate.of(2023, 1, 1), 2500, 10000, 0, "Nice!");
        doReturn(entry).when(blogEntryService).create(any());

        //when
        mockMvc.perform(
                post("/api/v1/blog-entries")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(entryToCreateAsJson)
            )
            //then
            .andExpect(status().isCreated())
            .andExpect(header().exists("Location"))
            .andExpect(header().string("Location", Matchers.equalTo("/api/v1/blog-entries/" + entry.getId())));
    }

    @Test
    @DisplayName("should validate create entry request")
    void should_validate_create_entry_request() throws Exception {
        // given
        String entryToCreateAsJson = "{\"date\":\"\",\"calories\":0,\"steps\":0,\"emojis\":0,\"diaryEntry\":\"Nice!\"}";

        // when
        mockMvc.perform(
                        post("/api/v1/blog-entries")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(entryToCreateAsJson)
                )
                // then
                .andExpect(status().isBadRequest());
    }
}
