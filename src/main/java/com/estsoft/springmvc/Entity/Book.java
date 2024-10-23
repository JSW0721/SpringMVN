package com.estsoft.springmvc.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    public String id;
    @Column(columnDefinition = "varchar(255) not null")
    public String name;
    @Column(columnDefinition = "varchar(255) not null")
    public String author;
}
