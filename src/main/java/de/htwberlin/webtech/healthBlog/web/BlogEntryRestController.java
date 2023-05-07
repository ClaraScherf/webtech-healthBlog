package de.htwberlin.webtech.healthBlog.web;

import de.htwberlin.webtech.healthBlog.web.api.BlogEntry;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BlogEntryRestController {

    private List<BlogEntry> blogEntries;

    public BlogEntryRestController(){
        blogEntries = new ArrayList<>();
        blogEntries.add(new BlogEntry(1, LocalDate.of(2020, 1, 1), 1000, 2000,
                0, "Ich bin heute 1000 Schritte gelaufen."));
        blogEntries.add(new BlogEntry(2, LocalDate.of(2020, 1, 2), 2000, 3000,
                1, "Ich bin heute 2000 Schritte gelaufen."));
    }

    @GetMapping(path = "/api/v1/blog-entries")
    public ResponseEntity<List<BlogEntry>> fetchBlogEntries(){
        return ResponseEntity.ok(blogEntries);

    }

}
