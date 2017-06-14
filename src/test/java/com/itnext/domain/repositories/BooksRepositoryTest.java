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
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by rodrigo.chaves on 13/06/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BooksRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository booksRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    private Book book;

    private Category category;
    
    @Test
    public void findByCategoryId() throws Exception {
        List<Book> booksByCategory = booksRepository.findByCategory(category);
        assertFalse(booksByCategory.isEmpty());
        assertEquals(booksByCategory.get(0).getCategory().getId(), category.getId());
    }

    @Before
    public void setup() {
        this.createCategories();
        this.createBook();
        this.createAuthor();

    }

    private void createBook() {
        book = new Book();
        book.setName("Patterns of Enterprise Application Architecture");
        book.setCategory(category);
        book.setPrice(10d);
        booksRepository.save(book);
    }

    private void createCategories() {

        category = new Category();
        category.setName("Health");
        categoryRepository.save(category);

        category = new Category();
        category.setName("Business");
        categoryRepository.save(category);

        category = new Category();
        category.setName("Computer Science");
        categoryRepository.save(category);
    }

    private void createAuthor() {
        Author author = new Author();
        author.setName("Martin Fowler");
        author.setBooks(new ArrayList<Book>() {
            {
                add(book);
            }
        });
        authorRepository.save(author);
    }

}