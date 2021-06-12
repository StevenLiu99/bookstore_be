package com.lwt.bookstore_be.controller;

import com.lwt.bookstore_be.constant.Constant;
import com.lwt.bookstore_be.entity.BookEntity;
import com.lwt.bookstore_be.entity.ResultBean;
import com.lwt.bookstore_be.service.BookService;
import com.lwt.bookstore_be.utils.msgutils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/getBooks")
    public List<BookEntity> getBooks(@RequestBody Map<String, String> params) {
        return bookService.getBooks();
    }

    @RequestMapping("/getBook")
    public BookEntity getBook(@RequestParam("id") Integer id){
        return bookService.findBookById(id);
    }

    @RequestMapping("/updateBook")
    public ResultBean<Boolean> updateBook(@RequestBody Map<String, String> params) {

//        BookEntity bookEntity = new BookEntity();

        Integer id = Integer.parseInt(params.get("id"));
        BookEntity oldBook = bookService.findBookById(id);

        String name = params.get("name");
        String author = params.get("author");
        String isbn = params.get("isbn");
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(params.get("price")));
        Integer inventory = Integer.parseInt(params.get("inventory"));

        oldBook.setAuthor(author);
        oldBook.setName(name);
        oldBook.setIsbn(isbn);
        oldBook.setPrice(price);
        oldBook.setInventory(inventory);

        return ResultBean.success(bookService.updateBook(oldBook));
    }

    @RequestMapping("/deleteBook")
    public ResultBean<Boolean> deleteBook(@RequestBody Map<String, String> params) {
        Integer id = Integer.parseInt(params.get("id"));
        return ResultBean.success(bookService.deleteBook(id));
    }
}
