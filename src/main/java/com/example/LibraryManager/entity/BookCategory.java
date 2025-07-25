package com.example.LibraryManager.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "book_category")
public class BookCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long categoryId;      // Id của thể loại sách
    String categoryName;  // Tên thể loại (ví dụ: Tiểu thuyết, Lịch sử, ...)
}
