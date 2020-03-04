package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
  private  final PublisherRepository publisherRepository;
    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        Publisher publisher =new Publisher();
        publisher.setName("Surendra Publication");
        publisher.setCity("Bengalore");
        publisher.setState("Karanataka");
        publisherRepository.save(publisher);

        System.out.println("Number of publishers :"+publisherRepository.count());

        Author author = new Author("Eric","Evans");
        Book book = new Book("Domain Driven Design","12341");
        author.getBooks().add(book);
        book.getAuthors().add(author);
        book.setPublisher(publisher);
        publisher.getBooks().add(book);
        authorRepository.save(author);
        bookRepository.save(book);
        publisherRepository.save(publisher);

        Author author1 = new Author("Rod","Johnson");
        Book book1 = new Book("J2EE Development Without EJB","21231");
        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);
        book1.setPublisher(publisher);
        publisher.getBooks().add(book1);
        authorRepository.save(author1);
        bookRepository.save(book1);
       publisherRepository.save(publisher);
        System.out.println("Started in bootstrap");
        System.out.println("Number of Books: "+ bookRepository.count());
        System.out.println("Books count for publisher :"+ publisher.getBooks().size());
    }
}
