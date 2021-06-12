package com.lwt.bookstore_be.daoimpl;

import com.lwt.bookstore_be.dao.BookDao;
import com.lwt.bookstore_be.entity.BookEntity;
import com.lwt.bookstore_be.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public BookEntity findOne(Integer id) {
        return bookRepository.getOne(id);
    }

    @Override
    public List<BookEntity> getBooks() {
        return bookRepository.getBooks();
    }

    @Override
    public void updateOne(BookEntity bookEntity) {
        bookRepository.save(bookEntity);
    }

    @Override
    public void deleteOne(Integer id) {
        bookRepository.deleteById(id);
    }
}
