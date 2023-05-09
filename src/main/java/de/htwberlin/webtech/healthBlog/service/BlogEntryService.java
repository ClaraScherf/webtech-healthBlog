package de.htwberlin.webtech.healthBlog.service;

import de.htwberlin.webtech.healthBlog.persistence.BlogEntryEntity;
import de.htwberlin.webtech.healthBlog.persistence.BlogEntryRepository;
import de.htwberlin.webtech.healthBlog.web.api.BlogEntry;
import de.htwberlin.webtech.healthBlog.web.api.BlogEntryRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogEntryService {

    private final BlogEntryRepository entryRepo;

    public BlogEntryService(BlogEntryRepository entryRepo){
        this.entryRepo = entryRepo;
    }

    public List<BlogEntry> findAll(){
        List<BlogEntryEntity> entry = entryRepo.findAll();
        return entry.stream()
                .map(this::transformEnity)
                .collect(Collectors.toList());

    }
    public BlogEntry create(BlogEntryRequest request){
        var blogEntity = new BlogEntryEntity(request.getDate(), request.getSteps(), request.getCalories(), request.getEmojis(), request.getDiaryEntry());
        blogEntity = entryRepo.save(blogEntity);
        return transformEnity(blogEntity);
    }

    private BlogEntry transformEnity(BlogEntryEntity entity) {
        return new BlogEntry(
                entity.getId(),
                entity.getDate(),
                entity.getSteps(),
                entity.getCalories(),
                entity.getEmojis(),
                entity.getDiaryEntry()
        );
    }
}
