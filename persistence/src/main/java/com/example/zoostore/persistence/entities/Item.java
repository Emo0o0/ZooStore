package com.example.zoostore.persistence.entities;


import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;

    private String description;

//    @Column(columnDefinition = "boolean default false")
    private boolean archived = false;

    @ManyToOne
    @JoinColumn(columnDefinition = "vendor_id", nullable = false) //error
    private Vendor vendor;

    @OneToMany(mappedBy = "item")
    private Set<Multimedia> multimedia;

    @ManyToMany
    @JoinTable(
            name = "item_tag",
            joinColumns = {@JoinColumn(name = "item_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")}
    )
    private Set<Tag> tags;


}
