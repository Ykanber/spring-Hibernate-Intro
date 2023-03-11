package yk.springframework.intro;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import yk.springframework.intro.domain.AuthorUuid;
import yk.springframework.intro.domain.BookUuid;
import yk.springframework.intro.repositories.AuthorUUIDRepository;
import yk.springframework.intro.repositories.BookRepository;
import yk.springframework.intro.repositories.BookUUIDRepository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ActiveProfiles("local")
@DataJpaTest
@ComponentScan(basePackages = {"yk.springframework.intro.bootstrap"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MysqlIntegrationTest {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorUUIDRepository authorUUIDRepository;
    @Autowired
    BookUUIDRepository bookUUIDRepository;
    @Test
    void name() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(2);
    }

    @Test
    void AuthorUuidRepoTest() {
        AuthorUuid authorUuid = authorUUIDRepository.save(new AuthorUuid());
        assertThat(authorUuid).isNotNull();
        assertThat(authorUuid.getId()).isNotNull();

        AuthorUuid fetched = authorUUIDRepository.getById(authorUuid.getId());
        assertThat(fetched).isNotNull();
    }
    @Test
    void BookUuidRepoTest(){
        BookUuid bookUuid = bookUUIDRepository.save(new BookUuid());
        assertThat(bookUuid).isNotNull();
        assertThat(bookUuid.getId()).isNotNull();

        BookUuid fetched= bookUUIDRepository.getById(bookUuid.getId());
        assertThat(fetched.getId()).isNotNull();
    }
}









