package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of people:");
        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        ArrayList<String> people = new ArrayList<>();

        System.out.println("Enter all people:");
        for (int i = 0; i < numberOfPeople; i++) {
            people.add(scanner.nextLine());
        }

        System.out.println("\nEnter the number of search queries:");
        int numberOfSearch = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfSearch; i++) {
            System.out.println("\nEnter data to search people:");
            String dataToSearch = scanner.nextLine().trim().toLowerCase();

            ArrayList<String> foundPeople = new ArrayList<>();

            for (String person : people) {

//                String[] words = person.trim().toLowerCase().split("\\s+");
//
//                for (String word : words) {
//                    if (dataToSearch.equals(word)) {
//                        foundPeople.add(person);
//                        break;
//                    }
//                }

                if (person.trim().toLowerCase().contains(dataToSearch)) foundPeople.add(person);

            }

            if (!foundPeople.isEmpty()) {
                System.out.println("Found people:");
                for (String foundPerson : foundPeople) {
                    System.out.println(foundPerson);
                }
            } else {
                System.out.println("No matching people found.");
            }
        }





    }
}
