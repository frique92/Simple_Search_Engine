package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String pathData = "";
        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                if ("--data".equals(args[i])) {
                    pathData = args[i + 1];
                    break;
                }
            }
        }

        SearchEngine search = new SearchEngine(pathData);
        search.start();
    }
}

class SearchEngine {

    String pathData;
    private ArrayList<String> people;
    private Scanner scanner;
    private boolean searchIsWorking;
    private Map<String, ArrayList<Integer>> mapIndex;

    SearchEngine() {
        people = new ArrayList<>();
        scanner = new Scanner(System.in);
        searchIsWorking = true;
        mapIndex = new HashMap<>();
    }

    SearchEngine(String pathData) {
        this();
        this.pathData = pathData;
    }


    public void start() {

        if ("".equals(pathData)) {
            addPeople();
        } else {
            importData();
        }

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
            String person = scanner.nextLine();
            addOnePerson(person);
        }

    }

    private void addOnePerson(String person) {
        people.add(person);

        String[] wordsOfPerson = person.toLowerCase().split("\\s+");
        for (String word : wordsOfPerson) {
            ArrayList<Integer> indexPerson;

            if (mapIndex.containsKey(word)) indexPerson = mapIndex.get(word);
            else indexPerson = new ArrayList<>();

            indexPerson.add(people.indexOf(person));

            mapIndex.put(word, indexPerson);

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

        if (mapIndex.containsKey(dataToSearch)) {
            ArrayList<Integer> indexWord = mapIndex.get(dataToSearch);
            System.out.println(indexWord.size() + "person found:");

            for (Integer index : indexWord) {
                System.out.println(people.get(index));
            }
        } else System.out.println("No matching people found.");

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

    private void importData() {
        File file = new File(pathData);

        try (Scanner scannerFile = new Scanner(file)) {
            while (scannerFile.hasNext()) {
                String person = scannerFile.nextLine();
                addOnePerson(person);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + pathData);
        }
    }
}