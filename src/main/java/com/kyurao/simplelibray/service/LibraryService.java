package com.kyurao.simplelibray.service;

import com.kyurao.simplelibray.domain.Book;
import com.kyurao.simplelibray.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.kyurao.simplelibray.domain.enums.BookState.AVAILABLE;
import static com.kyurao.simplelibray.domain.enums.BookState.TAKEN;

@Service
@RequiredArgsConstructor
public class LibraryService {

    private final UserService userService;
    private final BookService bookService;

    public void takeBook(Long userId, Long bookId) {
        Book book = bookService.findById(bookId);
        if (book.getState() == AVAILABLE) {
            User user = userService.findById(userId);
            book.setState(TAKEN);
            book.setClient(user);
            bookService.save(book);
        } else {
            throw new RuntimeException("The current book has been already taken");
        }
    }

    public void returnBook(Long bookId) {
        Book book = bookService.findById(bookId);
        if (book.getState() == TAKEN) {
            book.setState(AVAILABLE);
            book.setClient(null);
            bookService.save(book);
        } else {
            throw new RuntimeException("The current book was not taken");
        }
    }

}
