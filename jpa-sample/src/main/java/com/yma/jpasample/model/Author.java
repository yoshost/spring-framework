package com.yma.jpasample.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@NamedQueries({
        @NamedQuery(
                name = "Author.findByNamedQuery",
                query = "select a from Author a where  a.age > :age"
        ),
        @NamedQuery(
                name = "Author.updateByNamedQuery",
                query = "update Author  a set a.age = :age"
        )
})
public class Author {

    @Id
    @GeneratedValue
    private Integer id;

    private String  firstName;
    private String  lastName;
    private String  email;

    private int age;


    @ManyToMany(mappedBy = "authors")
    private List<Course> courses;


}
