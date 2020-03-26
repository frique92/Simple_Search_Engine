package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SearchEngine search = new SearchEngine();
        search.start();
    }
}

class SearchEngine {

    private ArrayList<String> people;
    private Scanner scanner;
    private boolean searchIsWorking;

    SearchEngine() {
        people = new ArrayList<>();
        scanner = new Scanner(System.in);
        searchIsWorking = true;
    }

    public void start() {
        addPeople();

        while (searchIsWorking) {
            showMenu();

            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    findPerson();
                    break;
                case 2:
                    printAllPeople();
                    break;
                case 0:
                    exit();
                    break;
                default:
                    System.out.println("Incorrect option! Try again.");
            }
        }
    }

    private void addPeople() {

        System.out.println("Enter the number of people:");
        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter all people:");
        for (int i = 0; i < numberOfPeople; i++) {
            people.add(scanner.nextLine());
        }

    }

    private void showMenu() {
        System.out.println("=== Menu ===");
        System.out.println("1. Find a person");
        System.out.println("2. Print all people");
        System.out.println("0. Exit");
    }

    private void findPerson() {
        System.out.println("\n" +
                "Enter a name or email to search all suitable people.");
        String dataToSearch = scanner.nextLine().trim().toLowerCase();

        ArrayList<String> foundPeople = new ArrayList<>();

        for (String person : people) {
            if (person.trim().toLowerCase().contains(dataToSearch)) foundPeople.add(person);
        }

        if (!foundPeople.isEmpty()) {
            for (String foundPerson : foundPeople) {
                System.out.println(foundPerson);
            }
        } else {
            System.out.println("No matching people found.");
        }
    }

    private void printAllPeople() {
        System.out.println("=== List of people ===");
        for (String person : people) {
            System.out.println(person);
        }
    }

    private void exit() {
        searchIsWorking = false;
        System.out.println("Bye!");
    }
}