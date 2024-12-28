package com.example.library;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully: " + book.getTitle());
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (Book book : books) {
                System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor() +
                        ", Available: " + (book.isAvailable() ? "Yes" : "No"));
            }
        }
    }

    public String borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    return "You have successfully borrowed: " + book.getTitle();
                } else {
                    return "The book '" + book.getTitle() + "' is currently not available.";
                }
            }
        }
        return "The book '" + title + "' is not available in the library.";
    }

    public String returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    return "You have successfully returned: " + book.getTitle();
                } else {
                    return "The book '" + book.getTitle() + "' was not borrowed.";
                }
            }
        }
        return "The book '" + title + "' is not available in the library.";
    }
}
