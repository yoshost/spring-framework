package com.yma.jpasample.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // table per class for inheritance
//@Inheritance(strategy = InheritanceType.JOINED) // Join table for inheritance
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //Single table strategy for inheritance
//@DiscriminatorColumn(name = "resource_type") //Single table strategy for inheritance
public class Resource {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private int size;

    private String url;

    @OneToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;
}
