package com.example.LibraryManager.service.Impl;

import com.example.LibraryManager.dto.response.UserResponse;
import com.example.LibraryManager.entity.Book;
import com.example.LibraryManager.entity.User;
import com.example.LibraryManager.map.UserMapper;
import com.example.LibraryManager.repository.BookRepository;
import com.example.LibraryManager.repository.BorrowRecordRepository;
import com.example.LibraryManager.repository.BorrowingBooksRepository;
import com.example.LibraryManager.repository.UserRepository;
import com.example.LibraryManager.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BorrowingBooksRepository borrowingBooksRepository;
    @Autowired
    private BorrowRecordRepository borrowRecordRepository;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserResponse> getUsersByBorrowedBookName(String bookName) {
        Book book = bookRepository.findByBookName(bookName);
        if (book == null) {
            throw new RuntimeException("Không tìm thấy sách với tên: " + bookName);
        }

        List<User> users = userRepository.findUsersByBookId(book.getBookId());
        if (users == null || users.isEmpty()) {
            throw new RuntimeException("Không tìm thấy người dùng nào mượn sách: " + bookName);
        }

        return userMapper.createUserResponses(users);
    }

}
