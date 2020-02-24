package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher gpc = new Publisher();
        gpc.setName("Gdansk publishing company");

        publisherRepository.save(gpc);

        Author bob = new Author("Julius", "Bob");
        Book mbb = new Book("Memelogy by Bob", "331253762");

        bob.getBooks().add(mbb);
        mbb.getAuthors().add(bob);

        mbb.setPublisher(gpc);
        gpc.getBooks().add(mbb);

        authorRepository.save(bob);
        bookRepository.save(mbb);
        publisherRepository.save(gpc);

        Author greg = new Author("Greg", "Rosik");
        Book fj = new Book("Token Mall", "36773216899");

        greg.getBooks().add(fj);
        fj.getAuthors().add(greg);

        fj.setPublisher(gpc);
        gpc.getBooks().add(fj);

        authorRepository.save(greg);
        bookRepository.save(fj);
        publisherRepository.save(gpc);
    }
}
