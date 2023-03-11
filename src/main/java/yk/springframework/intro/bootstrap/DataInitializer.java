package yk.springframework.intro.bootstrap;

import org.springframework.context.annotation.Profile;
import yk.springframework.intro.domain.AuthorUuid;
import yk.springframework.intro.domain.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import yk.springframework.intro.domain.BookUuid;
import yk.springframework.intro.repositories.AuthorUUIDRepository;
import yk.springframework.intro.repositories.BookRepository;
import yk.springframework.intro.repositories.BookUUIDRepository;

@Profile({"local","default"})
@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorUUIDRepository authorUUIDRepository;

    private final BookUUIDRepository bookUUIDRepository;
    public DataInitializer(BookRepository bookRepository,AuthorUUIDRepository authorUUIDRepository, BookUUIDRepository bookUUIDRepository) {
        this.bookRepository = bookRepository;
        this.authorUUIDRepository = authorUUIDRepository;
        this.bookUUIDRepository = bookUUIDRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();

        Book bookDDD = new Book("Domain Driven Design", "123", "RandomHouse",null);
        Book savedDDD = bookRepository.save(bookDDD);

        Book bookSIA = new Book("Spring In Action", "234234", "Oriely",null);
        Book savedSIA = bookRepository.save(bookSIA);

        bookRepository.findAll().forEach(book -> {
            System.out.println("Book Id: " + book.getId());
            System.out.println("Book Title: " + book.getTitle());
        });

        AuthorUuid authorUUID = new AuthorUuid();
        authorUUID.setFirstName("Yavuz");
        authorUUID.setLastName("Kanber");
        AuthorUuid savedAuthor = authorUUIDRepository.save(authorUUID);
        System.out.println("Saved author UUID: " + savedAuthor.getId());

        BookUuid bookUuid = new BookUuid();
        bookUuid.setTitle("UUid");
        BookUuid savedBookUuid = bookUUIDRepository.save(bookUuid);
        System.out.println("Saved Book UUID = "+  savedBookUuid.getId());

    }
}
