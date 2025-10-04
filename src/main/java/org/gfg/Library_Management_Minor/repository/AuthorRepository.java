package org.gfg.Library_Management_Minor.repository;

import org.gfg.Library_Management_Minor.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepository extends JpaRepository<Author, Integer> {


    //native Query
    @Query(value = "select * from author where author_email = :authorEmail", nativeQuery = true)
    Author getAuthorByEmail(String authorEmail);
}

