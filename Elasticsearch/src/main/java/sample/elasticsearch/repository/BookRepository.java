package sample.elasticsearch.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import sample.elasticsearch.model.Book;

import java.util.List;

/**
 * Created by CBR on 2018. 7. 16..
 */
public interface BookRepository extends ElasticsearchRepository<Book, String>
{
    Page<Book> findByAuthor(String author, Pageable pageable);
    List<Book> findByTitle(String title);
}
