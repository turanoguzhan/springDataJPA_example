package com.ouz.initialdatajpah2.repository;

import com.ouz.initialdatajpah2.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
