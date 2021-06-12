package com.lwt.bookstore_be.serviceimpl;

import com.lwt.bookstore_be.dao.BookDao;
import com.lwt.bookstore_be.entity.BookEntity;
import com.lwt.bookstore_be.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public BookEntity findBookById(Integer id) {
        return bookDao.findOne(id);
    }

    @Override
    public Boolean updateBook(BookEntity bookEntity) {
        bookDao.updateOne(bookEntity);
        return true;
    }

    @Override
    public List<BookEntity> getBooks() {
        return bookDao.getBooks();
    }

    @Override
    public Boolean deleteBook(Integer id) {
        bookDao.deleteOne(id);
        return true;
    }
}
