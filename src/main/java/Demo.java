import java.util.ArrayList;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the Code Here!");

        ArrayList<String> code = new ArrayList<>();
        ArrayList<String> tokens;
        ArrayList<String> cstokens;

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
                cstokens = Demo.complexityDueToControllStructure(lineContent);

                System.out.print("\n ~~~~~~~~~~~~~ Cs : " + tokens.get(0) + " ~~~~~~~~~~~~~~~~~~~~ Tokens :");
                System.out.print("\n ~~~~~~~~~~~~~ Ctc : " + cstokens.get(0) + " ~~~~~~~~~~~~~~~~~~~~ Controll Structure Tokens :");

                tokens.remove(0);

                for (String token : tokens
                ) {
                    System.out.print(token + " , ");
                }
                System.out.println("\n");
                for (String cstoken : cstokens
                        ) {
                            System.out.print(cstoken + " , ");
                        }
                System.out.println("\n");
            }
        }

    }

    private static ArrayList complexityDueToSize(String statement) {

        int complexity = 0;
        String[] words = statement.split(" ");

        String[] args = {" + ", " - ", "*", "/", "%", "++", "--", "==", "!=", ">", "<", ">=", "<=", "&&", "||", "!", "|",
                "^", "~", ">>", "<<", ">>>", "<<<", "+=", "-=", "*=", "/=", " =", ">>>=", "|=", "&=", "%=", "<<=", ">>=", "^=",
                ",", "->", ".", "::", "void", "double", " int", "float", "string", "printf",  "println", "count", "cin", "if", "for",
                "while", "do-while", "switch", "case", "String", "Class", "method", "object", "variable", "class", "import",
                "endl"};

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
    
    //Implement the method complexityDueToControllStructure
    private static ArrayList complexityDueToControllStructure(String statement) {

        int complexity = 0;
        String[] words = statement.split(" ");
        
        String[] arg1 = {"if"," & "," | "," && "," || ","catch"};
        String[] arg2 = {"for", "while"};
        String[] arg3 = {"case"};

        ArrayList<String> cstokens = new ArrayList();

        cstokens.add(0, Integer.toString(complexity));
        for (String word : words
        ) {

            if (word.startsWith("\"") && word.endsWith("\"")){
                if (!cstokens.contains(word)) {
                    cstokens.add("\"" + word + "\"");
                }
                complexity++;
                continue;
            }
            for (String arg11: arg1
                 ) {
                if (word.contains(arg11)){
                    if (!cstokens.contains(arg11)) {
                        cstokens.add(arg11);
                    }
                    complexity++;
                }
            }
            for (String arg22: arg2
                    ) {
                   if (word.contains(arg22)){
                       if (!cstokens.contains(arg22)) {
                           cstokens.add(arg22);
                       }
                       complexity+=2;
                   }
               }
            for (String arg33: arg3
                    ) {
                   if (word.contains(arg33)){
                       if (!cstokens.contains(arg33)) {
                           cstokens.add(arg33);
                       }
                       complexity++;
                   }
               }
        }

        cstokens.set(0, Integer.toString(complexity));

        return cstokens;
    }
}

