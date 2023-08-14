package com.example.zoostore.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
//@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class Multimedia {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String url;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    public String toString() {
        return "Id: " + id + System.lineSeparator() +
                "Url: " + url + System.lineSeparator() +
                "Item:{ " + item + System.lineSeparator() + "}" + System.lineSeparator();
    }

}
