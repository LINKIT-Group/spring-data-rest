package com.itnext.domain.repositories;

import com.itnext.domain.entities.Author;
import com.itnext.domain.entities.Book;
import com.itnext.domain.entities.Category;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * Created by rodrigo.chaves on 13/06/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorRepositoryTest {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository booksRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    private Book book;

    private Author author;

    private Category category;

    @Before
    public void setup() {
        this.createCategory();
        this.createBook();
        this.createAuthor();

    }

    @Test
    public void findByBookId() throws Exception {

        Author authorByBooksById = authorRepository.findOneByBooks(book);
        assertFalse(authorByBooksById.getBooks().isEmpty());
        assertEquals(authorByBooksById.getId(), author.getId());

    }

    private void createBook() {
        book = new Book();
        book.setName("Patterns of Enterprise Application Architecture 2");
        book.setCategory(category);
        book.setPrice(10d);
        booksRepository.save(book);
    }

    private void createCategory() {
        category = new Category();
        category.setName("Computer Science");
        categoryRepository.save(category);
    }

    private void createAuthor() {
        author = new Author();
        author.setName("Martin Fowler");
        author.setBooks(new ArrayList<Book>() {
            {
                add(book);
            }
        });
        authorRepository.save(author);
    }
}