package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Author bob = new Author("Juliusz", "Cezar");
        Book mbb = new Book("Memelogy by Bob", "331213762");
        bob.getBooks().add(mbb);
        mbb.getAuthors().add(bob);

        authorRepository.save(bob);
        bookRepository.save(mbb);

        Author greg = new Author("Greg", "Rosik");
        Book fj = new Book("Finding Job", "36773216899");
        greg.getBooks().add(fj);
        fj.getAuthors().add(greg);

        authorRepository.save(greg);
        bookRepository.save(fj);
    }
}
