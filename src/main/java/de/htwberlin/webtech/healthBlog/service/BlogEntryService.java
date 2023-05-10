package de.htwberlin.webtech.healthBlog.service;

import de.htwberlin.webtech.healthBlog.persistence.BlogEntryEntity;
import de.htwberlin.webtech.healthBlog.persistence.BlogEntryRepository;
import de.htwberlin.webtech.healthBlog.web.api.BlogEntry;
import de.htwberlin.webtech.healthBlog.web.api.BlogEntryCreateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogEntryService {

    private final BlogEntryRepository blogEntryRepository;

    public BlogEntryService(BlogEntryRepository blogEntryRepository){
        this.blogEntryRepository = blogEntryRepository;
    }

    public List<BlogEntry> findAll(){
        List<BlogEntryEntity> blogEntries = blogEntryRepository.findAll();
        return blogEntries.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());

    }

    public BlogEntry findById(Long id){
        var blogEntryEntity = blogEntryRepository.findById(id);
        return blogEntryEntity.map(this::transformEntity).orElse(null);
    }

    public BlogEntry create(BlogEntryCreateRequest request){
        var blogEntryEntity = new BlogEntryEntity(request.getDate(), request.getSteps(), request.getCalories(),
                request.getEmojis(), request.getDiaryEntry());
        blogEntryEntity = blogEntryRepository.save(blogEntryEntity);
        return transformEntity(blogEntryEntity);
    }

    private BlogEntry transformEntity(BlogEntryEntity blogEntryEntity) {
        return new BlogEntry(
                blogEntryEntity.getId(),
                blogEntryEntity.getDate(),
                blogEntryEntity.getSteps(),
                blogEntryEntity.getCalories(),
                blogEntryEntity.getEmojis(),
                blogEntryEntity.getDiaryEntry()
        );
    }
}
