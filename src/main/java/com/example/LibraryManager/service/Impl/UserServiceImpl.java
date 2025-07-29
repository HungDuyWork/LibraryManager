package com.example.LibraryManager.service.Impl;

import com.example.LibraryManager.dto.request.BorrowBooksRequest;
import com.example.LibraryManager.dto.request.ReturnBooksRequest;
import com.example.LibraryManager.dto.request.UserCreationRequest;
import com.example.LibraryManager.dto.response.BorrowBooksResponse;
import com.example.LibraryManager.dto.response.BorrowedBookResponse;
import com.example.LibraryManager.dto.response.UserResponse;
import com.example.LibraryManager.entity.Book;
import com.example.LibraryManager.entity.BorrowRecord;
import com.example.LibraryManager.entity.Dept;
import com.example.LibraryManager.entity.User;
import com.example.LibraryManager.map.UserMapper;
import com.example.LibraryManager.repository.BookRepository;
import com.example.LibraryManager.repository.BorrowRecordRepository;
import com.example.LibraryManager.repository.DeptRepository;
import com.example.LibraryManager.repository.UserRepository;
import com.example.LibraryManager.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DeptRepository deptRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BorrowRecordRepository borrowRecordRepository;

    @Override
    public UserResponse addUser(UserCreationRequest request) {
        Dept dept = deptRepository.findById(request.getDeptId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khoa với ID: " + request.getDeptId()));
        User user = userMapper.createUser(request);
        user.setDept(dept);
        userRepository.save(user);
        return userMapper.createUserResponse(user);
    }

    @Override
    public UserResponse updateUser(String userEmail, UserCreationRequest request) {
        User user = userRepository.findByUserEmail(userEmail) ;
        if (user == null) {
            throw new RuntimeException("Không tìm thấy người dùng với email: " + userEmail);
        }
        userMapper.updateUser(request, user);
        Dept dept = deptRepository.findById(request.getDeptId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khoa với ID: " + request.getDeptId()));
        user.setDept(dept);
        userRepository.save(user);
        return userMapper.createUserResponse(user);
    }

    @Override
    @Transactional
    public BorrowBooksResponse borrowBooks(BorrowBooksRequest request) {
        User user = userRepository.findByUserEmail(request.getUserEmail());
        if (user == null) {
            throw new RuntimeException("Không tìm thấy người dùng với email: " + request.getUserEmail());
        }

        List<BorrowedBookResponse> resultList = new ArrayList<>();
        LocalDate borrowedDate = LocalDate.now();
        LocalDate dueDate = borrowedDate.plusMonths(6);

        for (String bookName : request.getBookNames()) {
            Book book = bookRepository.findByBookName(bookName);
            if (book == null) {
                throw new RuntimeException("Không tìm thấy sách với tên: " + bookName);
            }
            if (book.getBookQuantity() < 1) {
                throw new RuntimeException("Sách '" + bookName + "' đã hết.");
            }

            // Trừ số lượng sách
            book.setBookQuantity(book.getBookQuantity() - 1);
            bookRepository.save(book);

            // Tạo bản ghi BorrowRecord để lưu lịch sử
            BorrowRecord record = BorrowRecord.builder()
                    .user(user)
                    .book(book)
                    .borrowedDate(borrowedDate)
                    .dueDate(dueDate)
                    .isReturned(false)
                    .returnedDate(null)
                    .build();
            borrowRecordRepository.save(record);

            // Tạo phản hồi
            BorrowedBookResponse response = BorrowedBookResponse.builder()
                    .bookName(book.getBookName())
                    .bookAuthor(book.getBookAuthor())
                    .quantity(1)
                    .borrowedDate(borrowedDate)
                    .dueDate(dueDate)
                    .build();

            resultList.add(response);
        }

        BorrowBooksResponse finalResponse = new BorrowBooksResponse();
        finalResponse.setBorrowedBooks(resultList);
        return finalResponse;
    }

    @Override
    @Transactional
    public BorrowBooksResponse returnBooks(ReturnBooksRequest request) {
        User user = userRepository.findByUserEmail(request.getUserEmail());
        if (user == null) {
            throw new RuntimeException("Không tìm thấy người dùng với email: " + request.getUserEmail());
        }

        List<BorrowedBookResponse> returnedList = new ArrayList<>();
        LocalDate returnedDate = LocalDate.now();

        for (String bookName : request.getBookNames()) {
            Book book = bookRepository.findByBookName(bookName);
            if (book == null) {
                throw new RuntimeException("Không tìm thấy sách với tên: " + bookName);
            }

            BorrowRecord record = borrowRecordRepository
                    .findTopByUserAndBookAndIsReturnedFalseOrderByBorrowedDateDesc(user, book)
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy bản ghi chưa trả cho sách: " + bookName));

            // Cập nhật bản ghi mượn
            record.setReturned(true);
            record.setReturnedDate(returnedDate);
            borrowRecordRepository.save(record);

            // Cập nhật lại số lượng sách
            book.setBookQuantity(book.getBookQuantity() + 1);
            bookRepository.save(book);

            // Tạo phản hồi
            BorrowedBookResponse response = BorrowedBookResponse.builder()
                    .bookName(book.getBookName())
                    .bookAuthor(book.getBookAuthor())
                    .quantity(1)
                    .borrowedDate(record.getBorrowedDate())
                    .dueDate(record.getDueDate())
                    .returnedDate(record.getReturnedDate())
                    .returned(record.isReturned())
                    .build();


            returnedList.add(response);
        }

        BorrowBooksResponse finalResponse = new BorrowBooksResponse();
        finalResponse.setBorrowedBooks(returnedList);
        return finalResponse;
    }
}
