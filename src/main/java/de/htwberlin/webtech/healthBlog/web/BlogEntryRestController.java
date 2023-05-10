package de.htwberlin.webtech.healthBlog.web;

import de.htwberlin.webtech.healthBlog.service.BlogEntryService;
import de.htwberlin.webtech.healthBlog.web.api.BlogEntry;
import de.htwberlin.webtech.healthBlog.web.api.BlogEntryCreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class BlogEntryRestController {

    private final BlogEntryService blogEntryService;

    public BlogEntryRestController(BlogEntryService blogEntryService) {
        this.blogEntryService = blogEntryService;
    }

    @GetMapping(path = "/api/v1/blog-entries")
    public ResponseEntity<List<BlogEntry>> fetchBlogEntries(){
        return ResponseEntity.ok(blogEntryService.findAll());

    }
    @PostMapping(path = "/api/v1/blog-entries")
    public ResponseEntity<Void> createBlogEntry(@RequestBody BlogEntryCreateRequest request) throws URISyntaxException {
       var blogEntry = blogEntryService.create(request);
       URI uri = new URI("/api/v1/blog-entries/" + blogEntry.getId());
       return ResponseEntity.created(uri).build();
    }

}
