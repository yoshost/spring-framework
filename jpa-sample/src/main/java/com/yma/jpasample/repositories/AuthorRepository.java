package com.yma.jpasample.repositories;

import com.yma.jpasample.model.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    List<Author> findAllByFirstNameContainingIgnoreCase(String name);

    //Update Author

    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age where  a.id = :id")
    int updateAuthor(int age, int id);

    List<Author> findByNamedQuery(@Param("age") int age);

    @Modifying
    @Transactional
    void updateByNamedQuery(@Param("age") int age);
}
