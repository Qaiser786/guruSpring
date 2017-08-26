package com.qs.guruSpring.bootstrap;

import com.qs.guruSpring.model.Author;
import com.qs.guruSpring.model.Book;
import com.qs.guruSpring.model.Publisher;
import com.qs.guruSpring.repositories.AuthorRepository;
import com.qs.guruSpring.repositories.BookRepository;
import com.qs.guruSpring.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by used on 8/25/2017.
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
        Publisher publisher = new Publisher();
        publisher.setName("IsmailKhan");
        publisherRepository.save(publisher);

        Author eric = new Author("jerry","jawans");
        Book ddd = new Book("Domain Driven Design","1234",publisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Malik","Habib");
        Book noEJB = new Book("Web Development","465",publisher);

        rod.getBooks().add(noEJB);


        authorRepository.save(rod);
        bookRepository.save(noEJB);


    }
}
