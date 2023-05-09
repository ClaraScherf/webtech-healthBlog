package de.htwberlin.webtech.healthBlog.web;

import de.htwberlin.webtech.healthBlog.service.BlogEntryService;
import de.htwberlin.webtech.healthBlog.web.api.BlogEntry;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
