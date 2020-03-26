import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split("\\s+");

        for (String number : numbers) {

            int res = Integer.parseInt(number);
            res--;
            System.out.print(res + " ");
        }

    }
}