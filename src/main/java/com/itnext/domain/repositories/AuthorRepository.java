package com.itnext.domain.repositories;

import com.itnext.domain.entities.Author;
import com.itnext.domain.entities.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by rodrigo.chaves on 12/06/2017.
 */
@RepositoryRestResource(collectionResourceRel = "authors", path = "authors")
public interface AuthorRepository extends MongoRepository<Author, String> {
    Author findOneByBooks(Book book);
}