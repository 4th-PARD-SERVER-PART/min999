package com.example.seminar4.book.service;


import com.example.seminar4.book.dto.BookRequest;
import com.example.seminar4.book.dto.BookResponse;
import com.example.seminar4.book.entity.Book;
import com.example.seminar4.book.repo.BookRepo;
import com.example.seminar4.user.entity.User;
import com.example.seminar4.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService
{
    private  final UserRepo userRepo;
    private  final BookRepo bookRepo;

    public void createBook(Long userId, BookRequest. BookCreateRequest req){
        Optional<User> u = userRepo.findById(userId); //
        //없어도 괜찮음
        //없으면 예외뜨던데
        User user = u.get();
        Book book = Book.from(req.getTitle(), user);
        bookRepo.save(book);

    }


    public BookResponse.BookReadResponse readBook(Long bookId) {
        Optional<Book> b = bookRepo.findById(bookId);
        Book book = b.get();
        return new BookResponse.BookReadResponse(bookId, book.getTitle());

    }
}
