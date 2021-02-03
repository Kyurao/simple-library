package com.kyurao.simplelibrary.service;

import com.kyurao.simplelibrary.domain.Book;
import com.kyurao.simplelibrary.domain.User;
import com.kyurao.simplelibrary.dto.response.UserWithBookRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.kyurao.simplelibrary.domain.enums.BookState.AVAILABLE;
import static com.kyurao.simplelibrary.domain.enums.BookState.TAKEN;

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

    public UserWithBookRes getUserBooksInfo(Long userId) {
        User user = userService.findById(userId);

        return getUserWithBookRes(user);
    }

    public List<UserWithBookRes> getAllUsersWithTheirBooks() {
        return userService.findAllUsers()
                .stream()
                .map(this::getUserWithBookRes)
                .collect(Collectors.toList());
    }

    private UserWithBookRes getUserWithBookRes(User user) {
        UserWithBookRes res = new UserWithBookRes();
        res.setUserId(user.getId());
        res.setFirstName(user.getFirstName());
        res.setLastName(user.getLastName());
        res.setUserBooks(bookService.bookToDto(user.getTakenBooks()));
        return res;
    }
}
