import java.io.FileReader;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main (String[] args) {
        fileReader("help.txt");
        //help(); //replaced with fileReader method

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

        System.out.println(">seeYouLater<");
    }

 /*   private static void help() {          //replaced with fileReader method
        System.out.println("""
                Hello. The next features are implemented:
                    \
                'greater than 7' answer (int range)
                    \
                array of int numbers including multiples of 3
                    \
                John greetings
                
                type 'bracket' to get answer about bracket issue
                
                type 'exit' to quit
                """);
    }
 */

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
            fileReader("bracket.txt");
      /*      System.out.println("""
            Given bracket sequence: [((())()(())]]
            A bracket sequence is considered correct
            if every opening bracket has a corresponding closing bracket
            There are 2 options to correct brackets:
            Option 1: [(( ))( )(( ))] //removed excess
            Option 2: [[( (( ))( )(( )) )]] //added absence
            """); */
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

    private static void fileReader(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("file reading error: " + e.getMessage());
        }
    }
}
