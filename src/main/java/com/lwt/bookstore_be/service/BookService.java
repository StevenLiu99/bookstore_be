package com.lwt.bookstore_be.service;

import com.lwt.bookstore_be.entity.BookEntity;

import java.util.List;

public interface BookService {

    BookEntity findBookById(Integer id);
    Boolean updateBook(BookEntity bookEntity);
    List<BookEntity> getBooks();
    Boolean deleteBook(Integer id);

}
