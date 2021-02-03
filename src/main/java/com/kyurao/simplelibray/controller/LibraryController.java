package com.kyurao.simplelibray.controller;

import com.kyurao.simplelibray.dto.response.UserWithBookRes;
import com.kyurao.simplelibray.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("library")
@RequiredArgsConstructor
public class LibraryController {
    private final LibraryService libraryService;

    @PutMapping("take")
    public void takeBook(@RequestParam("user") Long userId, ///library/take?user=1&book=27
                         @RequestParam("book") Long bookId) {
        libraryService.takeBook(userId, bookId);
    }

    @PutMapping("return")
    public void returnBook(@RequestParam("book") Long bookId) {
        libraryService.returnBook(bookId);
    }

    @GetMapping("user/{id}/books") //library/user/1/books
    public UserWithBookRes getUserWithBooks(@PathVariable Long id) {
        return libraryService.getUserBooksInfo(id);
    }

    @GetMapping("user-with-books/all") //library/user-with-books/all
    public List<UserWithBookRes> getAllUsersWithTheirBooks() {
        return libraryService.getAllUsersWithTheirBooks();
    }
}
