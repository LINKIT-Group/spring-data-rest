package com.itnext.domain.repositories;

import com.itnext.domain.entities.Book;
import com.itnext.domain.entities.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by rodrigo.chaves on 12/06/2017.
 */
@RepositoryRestResource(collectionResourceRel = "books", path = "books")
public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> findByCategory(Category category);
}