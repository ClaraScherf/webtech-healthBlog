package de.htwberlin.webtech.healthBlog.web;

import de.htwberlin.webtech.healthBlog.service.BlogEntryService;
import de.htwberlin.webtech.healthBlog.web.api.BlogEntry;
import de.htwberlin.webtech.healthBlog.web.api.BlogEntryManipulationRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@Validated
public class BlogEntryRestController {

    private final BlogEntryService blogEntryService;

    public BlogEntryRestController(BlogEntryService blogEntryService) {
        this.blogEntryService = blogEntryService;
    }

    @GetMapping(path = "/api/v1/blog-entries")
    public ResponseEntity<List<BlogEntry>> fetchBlogEntries(){
        return ResponseEntity.ok(blogEntryService.findAll());

    }

    @GetMapping(path = "/api/v1/blog-entries/{id}")
    public ResponseEntity<BlogEntry> fetchBlogEntryById(@PathVariable Long id){
        var blogEntry = blogEntryService.findById(id);
        return blogEntry != null? ResponseEntity.ok(blogEntry) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/blog-entries")
    public ResponseEntity<Void> createBlogEntry(@Valid @RequestBody BlogEntryManipulationRequest request)
            throws URISyntaxException {
            var blogEntry = blogEntryService.create(request);
            URI uri = new URI("/api/v1/blog-entries/" + blogEntry.getId());
            return ResponseEntity
                    .created(uri)
                    .header("Access-Control-Expose-Headers", "Location")
                    .build();
        }

    @PutMapping(path = "/api/v1/blog-entries/{id}")
    public ResponseEntity<BlogEntry> updateBlogEntry(@PathVariable Long id,
                                                     @RequestBody BlogEntryManipulationRequest request){
        var blogEntry = blogEntryService.update(id, request);
        return blogEntry != null? ResponseEntity.ok(blogEntry) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/blog-entries/{id}")
    public ResponseEntity<Void> deleteBlogEntry(@PathVariable Long id){
        boolean successful = blogEntryService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    /*private boolean validate(BlogEntryManipulationRequest request) {
        return request.getDate() != null
                && request.getCalories() > 0
                && request.getSteps() > 0
                && request.getEmojis() <= 0 && request.getEmojis() <= 2
                && request.getDiaryEntry() != null
                && !request.getDiaryEntry().isBlank();
    }*/

}
