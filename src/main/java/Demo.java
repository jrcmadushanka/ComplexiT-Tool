import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the Code Here!");

        ArrayList<String> code = new ArrayList<>();
        ArrayList<String> tokens;

        int line = 0;
        String lineContent = "";

        while (scan.hasNext()) {

            lineContent = scan.nextLine();

            if (!lineContent.isEmpty()) {
                code.add(lineContent);

                System.out.println( "===========================================================================" );
                System.out.println(line++ + " " + lineContent.trim()); //8

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

        scan.close();

    }

    private static ArrayList complexityDueToSize(String statement) {

        int complexity = 0;
        String[] words = statement.split(" ");
        List<String> wordList = new ArrayList<>(Arrays.asList(words));

        String[] strings = statement.split("\"");

        String[] args = {"- ", "*", "/ ", "% ", "++", "--", "== ", "!=", " > ", " < ", ">=", "<=", "&&", "||", "!", "| ",
                "^ ", "~ ", ">> ", "<< ", ">>>", "<<<", "+=", "-=", "*=", "/=", "= ", ">>>=", "|=", "&=", "%=", "<<=", ">>=", "^=",
                ",", "->", "::", "void ", "double ", "int ", "float ", "string ", "printf",  "println", "count",
                " cin", "if ", "if(", "for ","while ", "do-while","do{","do {", "switch ","switch (", "case ",
                "String", "Class", "method", "object", "variable", "class", "import","default:","default ", "endl",  "\\n", "\\t"};
        String[] argLevel2 = {".", "+"};

        List<String> level2Args = Arrays.asList(argLevel2);

        ArrayList<String> tokens = new ArrayList();

        tokens.add(0, Integer.toString(complexity));

        for (String word : words
        ) {
            if (word.startsWith("\"") && word.endsWith("\"")){
                continue;
            }

            word = word + " ";

            for (String arg: args
                 ) {
                if (word.contains(arg)){

                   // if (!tokens.contains(arg)) {
                        tokens.add(arg);
                        if(!level2Args.contains(word.trim())){
                            wordList.remove(word.trim());
                            wordList.add(word.trim().replace(arg,""));
                            System.out.println(word.trim());
                            System.out.println(wordList.indexOf(arg.trim()));
                            System.out.println(wordList.get(wordList.indexOf(word.trim())));
                        }
                   // }
                    complexity++;
                }
            }

        }

        for (String word: wordList
             ) {
            System.out.println(word);
            for (int i = 0; i < word.length() ; i++) {

                if (String.valueOf(word.charAt(i)).equals(".")) {

                    // if (!tokens.contains(".")) {
                    tokens.add(".");
                    //  }
                    complexity++;
                }
                if (String.valueOf(word.charAt(i)).equals("+")) {

                    // if (!tokens.contains(".")) {
                    tokens.add("+");
                    //  }
                    complexity++;
                }
            }
        }

        int stringCount = 0;

        for (String s: strings
        ) {
            stringCount++;
            if (stringCount % 2 == 0){
                if (!tokens.contains(s)) {
                    tokens.add(s);
                }
                complexity++;
            }
            continue;
        }

        tokens.set(0, Integer.toString(complexity));

        return tokens;
    }
}

