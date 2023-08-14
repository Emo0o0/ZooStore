package com.example.zoostore.persistence.repository;

import com.example.zoostore.persistence.entities.Multimedia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MultimediaRepository extends JpaRepository<Multimedia, UUID> {
}
