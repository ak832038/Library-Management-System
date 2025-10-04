package org.gfg.Library_Management_Minor.repository;

import org.gfg.Library_Management_Minor.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
