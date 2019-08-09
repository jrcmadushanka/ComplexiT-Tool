import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the Code Here! \n Enter \"--run-complex--\" to calculate complexity");

        ArrayList<String> code = new ArrayList<>();
        ArrayList<String> tokens;

        int line = 0;
        String lineContent = "";

        while (true) {

            lineContent = scan.nextLine();

            if (!lineContent.isEmpty()) {
                code.add(lineContent);

                System.out.println("------------------------------------------------------------------------");
                System.out.println(line++ + " " + lineContent);

                tokens = Demo.complexityDueToize(lineContent);

                System.out.print("\n ~~~~~~~~~~~~~ Cs : " + tokens.get(0) + " ~~~~~~~~~~~~~~~~~~~~ Tokens :");

                tokens.remove(0);

                for (String token : tokens
                ) {
                    System.out.print(token + " , ");
                }
                System.out.println("\n");
            }
        }

    }

    public static ArrayList complexityDueToize(String statement) {

        int complexity = 0;
        String[] words = statement.split(" ");
        String[] argLvl1 = {"+", "-", "*", "/", "%", "++", "--", "==", "!=", ">", "<", ">=", "<=", "&&", "||", "!", "|",
                "^", "~", ">>", "<<", ">>>", "<<<", "+=", "-=", "*=", "/=", "=", ">>>=", "|=", "&=", "%=", "<<=", ">>=", "^=",
        };
        String[] argLvl2 = {"++", "--",};

        ArrayList<String> tokens = new ArrayList();

        List<String> Lvl1Args = Arrays.asList(argLvl1);
        tokens.add(0, Integer.toString(complexity));
        for (String word : words
        ) {
            if (Lvl1Args.contains(word)){
               tokens.add(word);
               complexity++;
            }
        }

        tokens.set(0, Integer.toString(complexity));

        return tokens;
    }
}

