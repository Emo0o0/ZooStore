package com.example.zoostore.persistence.repository;

import com.example.zoostore.persistence.entities.Item;
import com.example.zoostore.persistence.entities.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface ItemRepository extends JpaRepository<Item, UUID> {

    Page<Item> findItemByTagsContaining(Tag tag, Pageable pageable);

    List<Item> getAllByIdIn(List<UUID> uuids);

}
