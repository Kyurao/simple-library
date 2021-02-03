package com.kyurao.simplelibray.service;

import com.kyurao.simplelibray.domain.Book;
import com.kyurao.simplelibray.domain.enums.BookState;
import com.kyurao.simplelibray.dto.request.BookReq;
import com.kyurao.simplelibray.dto.response.BookRes;
import com.kyurao.simplelibray.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public void addNewBook(BookReq req) {
        Book book = new Book();
        updateBookFromRequestDto(req, book);
        book.setState(BookState.AVAILABLE);
        bookRepository.save(book);
    }

    public BookRes getBook(Long id) {
       return bookToDto(findById(id));
    }

    public List<BookRes> getAllBooks() {
        return findAllBooks()
                .stream()
                .map(this::bookToDto)
                .collect(Collectors.toList());
    }

    public void editBook(Long id, BookReq req) {
        Book book = findById(id);
        updateBookFromRequestDto(req, book);
        bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    Book findById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    void save(Book book) {
        bookRepository.save(book);
    }

    private List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    private void updateBookFromRequestDto(BookReq req, Book book) {
        book.setName(req.getName());
        book.setAuthor(req.getAuthor());
        book.setPublicationYear(req.getPublicationYear());
    }

    BookRes bookToDto(Book book) {
        BookRes res = new BookRes();
        res.setId(book.getId());
        res.setName(book.getName());
        res.setAuthor(book.getAuthor());
        res.setPublicationYear(book.getPublicationYear());

        return res;
    }

    List<BookRes> bookToDto(Collection<Book> books) {
        return books
                .stream()
                .map(this::bookToDto)
                .collect(Collectors.toList());
    }
}
