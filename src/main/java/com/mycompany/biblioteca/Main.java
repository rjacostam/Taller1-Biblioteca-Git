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
    
}
