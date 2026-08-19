package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Client> clients = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    
    static ArrayList<Book> books = new ArrayList<>();
    
    static ArrayList<Loan> loans = new ArrayList<>();



public static void main(String[] args) {
    int option;
    do {
        System.out.println("\n==================================");
        System.out.println("     MUNICIPAL LIBRARY SYSTEM     ");
        System.out.println("==================================");
        System.out.println("1. Register Client");
        System.out.println("2. List Clients");
        System.out.println("3. Update Client");
        System.out.println("4. Delete Client");
        System.out.println("5. Register Book");
        System.out.println("6. List Books");
        System.out.println("7. Update Book");
        System.out.println("8. Delete Book");
        System.out.println("9. Process Loan");
        System.out.println("10. Process Return");
        System.out.println("11. List Active Loans");
        System.out.println("0. Exit");
        System.out.print("Select an option: ");
        try {
            option = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            option = -1;
        }

        switch (option) {
            case 1: createClient(); break;
            case 2: listClients(); break;
            case 3: updateClient(); break;
            case 4: deleteClient(); break;
            case 5: createBook(); break;
            case 6: listBooks(); break;
            case 7: updateBook(); break;
            case 8: deleteBook(); break;
            case 9: registerLoan(); break;
            case 10: registerReturn(); break;
            case 11: listActiveLoans(); break;
            case 0: System.out.println("Closing system..."); break;
            default: System.out.println("Invalid option. Try again.");
        }
    } while (option != 0);
}



    
public static void createClient() {
    System.out.println("\n--- Register Client ---");
    System.out.print("ID: "); 
    String id = sc.nextLine();
    System.out.print("Name: "); 
    String name = sc.nextLine();
    System.out.print("Phone: "); 
    String phone = sc.nextLine();
    System.out.print("Email: "); 
    String email = sc.nextLine();

    clients.add(new Client(id, name, phone, email));
    System.out.println("Client registered successfully.");
}
public static void listClients() {
    System.out.println("\n--- Client List ---");
    if (clients.isEmpty()) {
        System.out.println("No registered clients found.");
        return;
    }
    for (Client c : clients) {
        System.out.println("ID: " + c.getId() + " | Name: " + c.getName() + " | Phone: " + c.getPhone() + " | Email: " + c.getEmail());
    }
}
public static Client findClientById(String id) {
    for (Client c : clients) {
        if (c.getId().equals(id)) {
            return c;
        }
    }
    return null;
}
public static void updateClient() {
    System.out.println("\n--- Update Client ---");
    System.out.print("Enter Client ID to update: ");
    String id = sc.nextLine();
    Client c = findClientById(id);
    if (c == null) {
        System.out.println("Client not found.");
        return;
    }
    System.out.print("New Name (" + c.getName() + "): "); 
    c.setName(sc.nextLine());
    System.out.print("New Phone (" + c.getPhone() + "): "); 
    c.setPhone(sc.nextLine());
    System.out.print("New Email (" + c.getEmail() + "): "); 
    c.setEmail(sc.nextLine());
    System.out.println("Client updated successfully.");
}
public static void deleteClient() {
    System.out.println("\n--- Delete Client ---");
    System.out.print("Enter Client ID to delete: ");
    String id = sc.nextLine();
    Client c = findClientById(id);
    if (c == null) {
        System.out.println("Client not found.");
        return;
    }
    clients.remove(c);
    System.out.println("Client deleted successfully.");
}

public static void createBook() {
    System.out.println("\n--- Register Book ---");
    System.out.print("Code: "); 
    String code = sc.nextLine();
    System.out.print("Title: "); 
    String title = sc.nextLine();
    System.out.print("Publication Year: "); 
    String year = sc.nextLine();
    System.out.print("Author: "); 
    String author = sc.nextLine();

    books.add(new Book(code, title, year, author));
    System.out.println("Book registered successfully.");
}

public static void listBooks() {
    System.out.println("\n--- Book List ---");
    if (books.isEmpty()) {
        System.out.println("No books found.");
        return;
    }
    for (Book b : books) {
        System.out.println("Code: " + b.getCode() + " | Title: " + b.getTitle() + " | Author: " + b.getAuthor() + " | Available: " + (b.isAvailable() ? "Yes" : "No"));
    }
}

public static Book findBookByCode(String code) {
    for (Book b : books) {
        if (b.getCode().equals(code)) {
            return b;
        }
    }
    return null;
}

public static void updateBook() {
    System.out.println("\n--- Update Book ---");
    System.out.print("Enter Book Code to update: ");
    String code = sc.nextLine();
    Book b = findBookByCode(code);
    if (b == null) {
        System.out.println("Book not found.");
        return;
    }
    System.out.print("New Title (" + b.getTitle() + "): "); 
    b.title = sc.nextLine();
    System.out.print("New Publication Year (" + b.getPublicationYear() + "): "); 
    b.publicationYear = sc.nextLine();
    System.out.println("Book updated successfully.");
}

public static void deleteBook() {
    System.out.println("\n--- Delete Book ---");
    System.out.print("Enter Book Code to delete: ");
    String code = sc.nextLine();
    Book b = findBookByCode(code);
    if (b == null) {
        System.out.println("Book not found.");
        return;
    }
    books.remove(b);
    System.out.println("Book deleted successfully.");
}

public static void registerLoan() {
    System.out.println("\n--- Register Loan ---");
    System.out.print("Enter Client ID: ");
    String clientId = sc.nextLine();
    Client c = findClientById(clientId);
    if (c == null) { 
        System.out.println("Client not found."); 
        return; 
    }
    
    System.out.print("Enter Book Code: ");
    String bookCode = sc.nextLine();
    Book b = findBookByCode(bookCode);
    if (b == null) { 
        System.out.println("Book not found."); 
        return; 
    }
    if (!b.isAvailable()) { 
        System.out.println("This book is already loaned."); 
        return; 
    }

    System.out.print("Enter Loan ID: ");
    String loanId = sc.nextLine();
    
    b.setAvailable(false);
    loans.add(new Loan(loanId, c, b));
    System.out.println("Loan processed successfully.");
}

public static void registerReturn() {
    System.out.println("\n--- Register Return ---");
    System.out.print("Enter Book Code to return: ");
    String bookCode = sc.nextLine();
    Book b = findBookByCode(bookCode);
    if (b == null) { 
        System.out.println("Book not found."); 
        return; 
    }
    
    for (Loan l : loans) {
        if (l.getBook().getCode().equals(bookCode) && l.getStatus().equals("Active")) {
            l.setStatus("Returned");
            b.setAvailable(true);
            System.out.println("Return completed successfully.");
            return;
        }
    }
    System.out.println("No active loan found for this book.");
}

public static void listActiveLoans() {
    System.out.println("\n--- Active Loans ---");
    boolean hasActive = false;
    for (Loan l : loans) {
        if (l.getStatus().equals("Active")) {
            System.out.println("Loan ID: " + l.getLoanId() + " | Client: " + l.getClient().getName() + " | Book: " + l.getBook().getTitle());
            hasActive = true;
        }
    }
    if (!hasActive) {
        System.out.println("No active loans at the moment.");
    }
}



    
}
