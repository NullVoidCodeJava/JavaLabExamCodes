package tester;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

import entity.Address;
import entity.Person;

public class Tester {
    private static final Scanner scanner = new Scanner(System.in);
    private static final LinkedHashSet<Person> people = new LinkedHashSet<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add new person");
            System.out.println("2. Display all");
            System.out.println("3. Find by name");
            System.out.println("4. Save in file");
            System.out.println("5. Load from file");
            System.out.println("6. Display in sorted order of dist and name");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addNewPerson();
                    break;
                case 2:
                    displayAll();
                    break;
                case 3:
                    findByName();
                    break;
                case 4:
                    saveInFile();
                    break;
                case 5:
                    loadFromFile();
                    break;
                case 6:
                    displaySorted();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
        scanner.close();
    }

    private static void addNewPerson() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        if (isPersonExists(name)) {
            System.out.println("Person with the same name already exists.");
            return;
        }
        System.out.print("Enter birth date (dd/MM/yyyy): ");
        String birthDateStr = scanner.nextLine();
        Date birthDate;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            birthDate = sdf.parse(birthDateStr);
        } catch (Exception e) {
            System.out.println("Invalid date format. Please enter date in dd/MM/yyyy format.");
            return;
        }
        System.out.print("Enter area: ");
        String area = scanner.nextLine();
        System.out.print("Enter district: ");
        String dist = scanner.nextLine();
        System.out.print("Enter pin: ");
        int pin = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Address address = new Address(area, dist, pin);
        Person person = new Person(name, birthDate, address);
        people.add(person);
        System.out.println("Person added successfully.");
    }

    private static boolean isPersonExists(String name) {
        for (Person person : people) {
            if (person.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    private static void displayAll() {
        if (people.isEmpty()) {
            System.out.println("No people to display.");
            return;
        }
        for (Person person : people) {
            System.out.println("Name: " + person.getName());
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String formattedDate = sdf.format(person.getBirthDate());
            System.out.println("Birth Date: " + formattedDate);
            Address address = person.getHomeAddr();
            System.out.println("Address: " + address.getArea() + ", " + address.getDist() + ", " + address.getPin());
        }
    }

    private static void findByName() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();
        boolean found = false;
        for (Person person : people) {
            if (person.getName().equals(name)) {
                found = true;
                break;
            }
        }
        System.out.println(found ? "Person found." : "Person not found.");
    }

    private static void saveInFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("people.ser"))) {
            oos.writeObject(people);
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("people.ser"))) {
            LinkedHashSet<Person> loadedPeople = (LinkedHashSet<Person>) ois.readObject();
            people.clear();
            people.addAll(loadedPeople);
            System.out.println("Data loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void displaySorted() {
        List<Person> sortedPeople = new ArrayList<>(people);
        sortedPeople.sort(Comparator.comparing(Person::getHomeAddr, Comparator.comparing(Address::getDist).thenComparing(Person::getName)));

        for (Person person : sortedPeople) {
            System.out.println("Name: " + person.getName());
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String formattedDate = sdf.format(person.getBirthDate());
            System.out.println("Birth Date: " + formattedDate);
            Address address = person.getHomeAddr();
            System.out.println("Address: " + address.getArea() + ", " + address.getDist() + ", " + address.getPin());
        }
    }
}