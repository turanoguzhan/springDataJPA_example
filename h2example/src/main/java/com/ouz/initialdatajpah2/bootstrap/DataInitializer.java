package com.ouz.initialdatajpah2.bootstrap;

import com.ouz.initialdatajpah2.domain.Book;
import com.ouz.initialdatajpah2.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Book book1 = new Book(1L,"Tutunamayanlar","12312-213213-123","İletişim Yayınları");

        Book savedBook1 = bookRepository.save(book1);

        System.out.println("Saved Tutunamayanlar => "+savedBook1);

        Book bookDDD = new Book(2L,"Domain Driven Design","0011-1312312-123"," APress - O'Reilly");

        Book savedDDDBook = bookRepository.save(bookDDD);
        System.out.println("Saved DDD => "+savedDDDBook);

        bookRepository.findAll().forEach(System.out::println);
    }
}
