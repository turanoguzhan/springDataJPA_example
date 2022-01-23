package com.ouz.initialdatajpah2;

import com.ouz.initialdatajpah2.domain.Book;
import com.ouz.initialdatajpah2.repository.BookRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

// testMethodOrder annotation çalıştırılacak test methodlarina sira vermemizi saglar.
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
// DataJpaTest annotation repository test etmemizi sağlayan minimum contexti getirir.
@DataJpaTest
public class SpringBootJPATestSlice {

    @Autowired
    BookRepository bookRepository;

    // her bir transactional test methodu calisip isini tamamladiginda rollback ile degisikligi geri alir.
    // bir sonraki testte o deger kullanılmak isteniyor ise eger bu durumu çözebilmek için @Rollback(value=false) yapıyoruz.ç
    // @Rollback(value=false)
    @Commit// we can use commit annotation instead of Rollback annotation.
    @Order(1)
    @Test
    void testJpaTestSplice(){
        long countBefore = bookRepository.count();

        bookRepository.save(new Book("My Book","12312313","MySelff Yayıncılık"));

        long countAfter = bookRepository.count();

        assertThat(countBefore).isLessThan(countAfter);
    }

    @Order(2)
    @Test
    void testJpaTestSpliceTransaction(){
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(1);
    }

}
