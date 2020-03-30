import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        scanner.nextLine();

        String[] arr = scanner.nextLine().split("\\s+");

        int[] digits = new int[count];

        for (int i = 0; i < arr.length; i++) {
            digits[i] = Integer.parseInt(arr[i]);
        }

        int result = 1;
        int maxCount = 1;
        int lastDigit = digits[0];

        for (int i = 1; i < digits.length; i++) {
            if (digits[i] > lastDigit) maxCount++;
            else maxCount = 1;

            result = Math.max(result, maxCount);
            lastDigit = digits[i];
        }

        System.out.println(result);
    }
}