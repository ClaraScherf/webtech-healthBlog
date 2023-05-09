package de.htwberlin.webtech.healthBlog.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogEntryRepository extends JpaRepository<BlogEntryEntity, Long> {
}
