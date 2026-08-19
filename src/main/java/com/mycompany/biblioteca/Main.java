package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Client> clients = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    
    static ArrayList<Book> books = new ArrayList<>();


    public static void main(String[] args) {
       
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


    
}
