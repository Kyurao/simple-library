package com.kyurao.simplelibrary.repository;

import com.kyurao.simplelibrary.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
