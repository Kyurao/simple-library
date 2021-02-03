package com.kyurao.simplelibray.controller;

import com.kyurao.simplelibray.dto.request.BookReq;
import com.kyurao.simplelibray.dto.response.BookRes;
import com.kyurao.simplelibray.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("{id}")
    public BookRes getBook(@PathVariable Long id) {
        return bookService.getBook(id);
    }

    @GetMapping("all")
    public List<BookRes> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("create")
    public void createNewBook(@RequestBody BookReq req) {
        bookService.addNewBook(req);
    }

    @PutMapping("update/{id}")
    public void updateBook(@PathVariable Long id,
                           @RequestBody BookReq req) {
        bookService.editBook(id, req);
    }

    @DeleteMapping("delete/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
