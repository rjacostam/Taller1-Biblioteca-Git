package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Client> clients = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

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
    
}
