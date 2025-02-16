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

        System.out.println("seeYouLater");
    }

    private static void help() {
        System.out.println("Hello. The next features are implemented:\n    " +
                "'greater than 7' answer (int range)\n    " +
                "array of int numbers including multiples of 3\n    " +
                "John greetings\n\ntype 'bracket' to get answer about bracket issue\n\n" +
                "type 'exit' to quit\n");
    }

    private static void inputParser(String input) {
        if (isNumber(input)){
            hello(input);
        } else if (isSequence(input)) {
            multipl(input);
        }
        else {
            commands(input);
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

    private static void commands(String input) {
        if (input.equals("John")) {
            System.out.println("Hello John!");
        } else if (input.equals("bracket")) {
            System.out.println("Given bracket sequence: [((())()(())]]\n" +
            "A bracket sequence is considered correct\nif every opening bracket has a corresponding closing bracket\n" +
            "There are 2 options to correct brackets\n" +
            "Option 1: [(( ))( )(( ))] //removed excess\n" +
            "Option 2: [[( (( ))( )(( )) )]] //added absence");
        } else {
            System.out.println("There is no such name or command");
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
            System.out.println("There are no array elements that are multiples of 3");
        }
    } //done
}
