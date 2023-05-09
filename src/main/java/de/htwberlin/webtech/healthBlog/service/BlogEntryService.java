package de.htwberlin.webtech.healthBlog.service;

import de.htwberlin.webtech.healthBlog.persistence.BlogEntryEntity;
import de.htwberlin.webtech.healthBlog.persistence.BlogEntryRepository;
import de.htwberlin.webtech.healthBlog.web.api.BlogEntry;
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
                .map(blogEntryEntity -> new BlogEntry(
                        blogEntryEntity.getId(),
                        blogEntryEntity.getDate(),
                        blogEntryEntity.getSteps(),
                        blogEntryEntity.getCalories(),
                        blogEntryEntity.getEmojis(),
                        blogEntryEntity.getDiaryEntry()
                        ))
                .collect(Collectors.toList());

    }
}
