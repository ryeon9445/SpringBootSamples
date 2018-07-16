package sample.elasticsearch.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import sample.elasticsearch.model.Book;

import java.util.List;

/**
 * Created by CBR on 2018. 7. 16..
 */
public interface BookService
{
    Book save(Book book);

    void delete(Book book);

    Book findOne(String id);

    Iterable<Book> findAll();

    Page<Book> findByAuthor(String author, PageRequest pageRequest);

    List<Book> findByTitle(String title);
}
