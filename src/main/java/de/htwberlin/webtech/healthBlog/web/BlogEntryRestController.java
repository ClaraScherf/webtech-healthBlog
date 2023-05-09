package de.htwberlin.webtech.healthBlog.web;

import de.htwberlin.webtech.healthBlog.service.BlogEntryService;
import de.htwberlin.webtech.healthBlog.web.api.BlogEntry;
import de.htwberlin.webtech.healthBlog.web.api.BlogEntryRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.net.URI;
import java.net.URISyntaxException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BlogEntryRestController {

   private final BlogEntryService blogEntryService;

   public BlogEntryRestController(BlogEntryService blogEntryService){
       this.blogEntryService = blogEntryService;
   }

    @GetMapping(path = "/api/v1/blog-entries")
    public ResponseEntity<List<BlogEntry>> fetchBlogEntries(){
        return ResponseEntity.ok(blogEntryService.findAll());

    }
    @PostMapping(path = "/api/vi/blog-entries")
    public ResponseEntity<Void> createEntry(@RequestBody BlogEntryRequest request) throws URISyntaxException {

       var blog_entries = blogEntryService.create(request);
       URI uri = new URI("/api/vi/blog-entries" + blog_entries.getId());
       return ResponseEntity.created(uri).build();
    }

}
