import java.util.ArrayList;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the Code Here!");

        ArrayList<String> code = new ArrayList<>();
        ArrayList<String> tokens;

        int line = 0;
        String lineContent = "";

        while (true) {

            lineContent = scan.nextLine();

            if (!lineContent.isEmpty()) {
                code.add(lineContent);

                System.out.println("test::test".contains("::"));
                System.out.println("------------------------------------------------------------------------");
                System.out.println(line++ + " " + lineContent.trim());

                tokens = Demo.complexityDueToSize(lineContent);

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

    private static ArrayList complexityDueToSize(String statement) {

        int complexity = 0;
        String[] words = statement.split(" ");

        String[] args = {"+", "-", "*", "/", "%", "++", "--", "==", "!=", ">", "<", ">=", "<=", "&&", "||", "!", "|",
                "^", "~", ">>", "<<", ">>>", "<<<", "+=", "-=", "*=", "/=", "=", ">>>=", "|=", "&=", "%=", "<<=", ">>=", "^=",
                ",", "->", ".", "::", "void", "double", "int", "float", "string", "printf",  "println", "count", "cin", "if", "for",
                "while", "do-while", "switch", "case", "String", "Class", "method", "object", "variable", "class", "import",
                "endl",  "\n", "\t"};

        ArrayList<String> tokens = new ArrayList();

        tokens.add(0, Integer.toString(complexity));
        for (String word : words
        ) {

            if (word.startsWith("\"") && word.endsWith("\"")){
                if (!tokens.contains(word)) {
                    tokens.add("\"" + word + "\"");
                }
                complexity++;
                continue;
            }
            for (String arg: args
                 ) {
                if (word.contains(arg)){
                    if (!tokens.contains(arg)) {
                        tokens.add(arg);
                    }
                    complexity++;
                }
            }
        }

        tokens.set(0, Integer.toString(complexity));

        return tokens;
    }
}

