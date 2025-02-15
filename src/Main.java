import java.util.Scanner;

public class Main {
    public static void main (String[] args) {

        help();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();

            if ("exit".equalsIgnoreCase(input)) {
                break;
            }
            inputParser(input);
        }
        scanner.close();

        System.out.println("seeYouLater"); //check
    }

    private static void help() {
        System.out.println("Hello. The next features are implemented:");
        System.out.println("    'greater than 7' answer (int range)");
        System.out.println("    array of int numbers including multiples of 3");
        System.out.println("    John greetings\n");
        System.out.println("type 'bracket' to get answer about bracket issue\n");
        System.out.println("type 'exit' to quit\n");
    }

    private static void inputParser(String input) {
        if (isNumber(input)){
            hello(input);
        } else if (isSequence(input)) {
            multipl(input);
        }
        else {
            john(input);
        }
    } //done

    private static boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    } //done

    private static boolean isSequence(String input) {
        String[] parts = input.split("[,\\s]+");
        for (String part : parts) {
            if (!isNumber(part)) {
                return false;
            }
        }
        return parts.length > 1;
    } //done

    private static void hello(String input) {
        if (Integer.parseInt(input) > 7) {
            System.out.println("Hello!");
        } else {
            System.out.println("try another number");
        }

    } //done

    private static void john(String input) {
        if (input.equals("John")) {
            System.out.println("Hello John!");
        } else if (input.equals("bracket")) {
            System.out.println("Given bracket sequence: [((())()(())]]");
            System.out.println("A bracket sequence is considered correct\nif every opening bracket has a corresponding closing bracket");
            System.out.println("There are 2 options to correct brackets");
            System.out.println("Option 1: [(( ))( )(( ))] //removed excess");
            System.out.println("Option 2: [[( (( ))( )(( )) )]] //added absence");
        } else {
            System.out.println("There is no such name");
        }
    } //done

    private static void multipl(String input) {
        String[] array = input.split("[,\\s]+");
        int prccesd = 0;
        for (String elem : array) {
            prccesd = Integer.parseInt(elem);
            if (prccesd % 3 == 0) {
                System.out.println(prccesd);
            }
        }
        if (prccesd % 3 != 0) {
            System.out.println("no 333");
        }
    } //done
}
