package com.example.library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n***** Library Menu *****");
            System.out.println("1. Add a Book");
            System.out.println("2. List All Books");
            System.out.println("3. Borrow a Book");
            System.out.println("4. Return a Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter Book ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter Book Title: ");
                        String title = scanner.nextLine();

                        System.out.print("Enter Book Author: ");
                        String author = scanner.nextLine();

                        library.addBook(new Book(id, title, author, true));
                        break;

                    case 2:
                        library.listBooks();
                        break;

                    case 3:
                        System.out.print("Enter the title of the book to borrow: ");
                        String borrowTitle = scanner.nextLine();
                        System.out.println(library.borrowBook(borrowTitle));
                        break;

                    case 4:
                        System.out.print("Enter the title of the book to return: ");
                        String returnTitle = scanner.nextLine();
                        System.out.println(library.returnBook(returnTitle));
                        break;

                    case 5:
                        System.out.println("Exiting the program...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }
}
