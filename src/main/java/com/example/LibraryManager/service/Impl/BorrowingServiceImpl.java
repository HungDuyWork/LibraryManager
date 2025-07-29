package com.example.LibraryManager.service.Impl;

import com.example.LibraryManager.dto.response.BorrowBooksResponse;
import com.example.LibraryManager.dto.response.BorrowedBookResponse;
import com.example.LibraryManager.entity.BorrowRecord;
import com.example.LibraryManager.entity.User;
import com.example.LibraryManager.repository.BorrowRecordRepository;
import com.example.LibraryManager.repository.UserRepository;
import com.example.LibraryManager.service.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowingServiceImpl implements BorrowingService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BorrowRecordRepository borrowRecordRepository;

    @Override
    public BorrowBooksResponse getBorrowHistory(String userEmail) {
        User user = userRepository.findByUserEmail(userEmail);
        if (user == null) {
            throw new RuntimeException("Không tìm thấy người dùng với email: " + userEmail);
        }

        List<BorrowRecord> records = borrowRecordRepository.findAllByUser(user);

        List<BorrowedBookResponse> history = records.stream()
                .map(record -> BorrowedBookResponse.builder()
                        .bookName(record.getBook().getBookName())
                        .bookAuthor(record.getBook().getBookAuthor())
                        .quantity(1)
                        .borrowedDate(record.getBorrowedDate())
                        .dueDate(record.getDueDate())
                        .returnedDate(record.getReturnedDate())
                        .returned(record.isReturned())
                        .build())
                .toList();

        BorrowBooksResponse response = new BorrowBooksResponse();
        response.setBorrowedBooks(history);
        return response;
    }

}
