package de.htwberlin.webtech.healthBlog.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogEntryRepository extends JpaRepository<BlogEntryEntity, Long> {

    List<BlogEntryEntity> findAllByCalories(int calories);

}


