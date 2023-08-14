package com.example.zoostore.persistence.repository;

import com.example.zoostore.persistence.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TagRepository extends JpaRepository<Tag, UUID> {

    Tag findByTitle(String tagTitle);
    Boolean existsByTitle(String tagTitle);


}
