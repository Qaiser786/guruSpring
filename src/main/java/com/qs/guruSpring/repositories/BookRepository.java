package com.qs.guruSpring.repositories;

import com.qs.guruSpring.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by used on 8/25/2017.
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
