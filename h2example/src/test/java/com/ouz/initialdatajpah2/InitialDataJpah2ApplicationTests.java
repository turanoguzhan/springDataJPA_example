package com.ouz.initialdatajpah2;

import com.ouz.initialdatajpah2.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class InitialDataJpah2ApplicationTests {

	@Autowired
	BookRepository bookRepository;

	@Test
	void testBookRepository(){
		long count = bookRepository.count();

		assertThat(count).isGreaterThan(0);
	}

	@Test
	void contextLoads() {
	}

}
