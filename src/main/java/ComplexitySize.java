import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComplexitySize {

    public static ArrayList complexityDueToSize(String statement) {

        int complexity = 0;
        String[] words = statement.split(" ");
        List<String> wordList = new ArrayList<>(Arrays.asList(words));

        String[] strings = statement.split("\"");

        String[] args = {"- ", "*", "/ ", "% ", "++", "--", "== ", "!=", " > ", " < ", ">=", "<=", "&&", "||", "!", "| ",
                "^ ", " ~ ", ">> ", "<< ", ">>>", "<<<", "+=", "-=", "*=", "/=", "= ", ">>>=", "|=", "&=", "%=", "<<=", ">>=", "^=",
                ",", "->", "::", "void ", "double ", "int ", "float ", "string ", "printf", "print(", "println", "count",
                " cin", "if ", "if(", "for ", "while ", "do-while", "do{", "do {", "switch ", "switch (", "case ",
                "String ", "Class", "method", "object", "variable", "class", "import", "default:", "default ", "endl", "\\n",
                "\\t", "[]"};

        String[] argLevel2 = {"new", "delete", "throw", "throws"};

        ArrayList<String> tokens = new ArrayList();

        tokens.add(0, Integer.toString(complexity));

        for (String word : words
        ) {
            boolean numeric = true;
            Double num = 0.0;

            if (word.startsWith("\"") && word.endsWith("\"")) {
                continue;
            }

            word = word + " ";

            for (String arg : args
            ) {
                if (word.contains(arg)) {

                    if (!tokens.contains(arg)) {
                        tokens.add(arg);
                    }
                    complexity++;
                }
            }

            for (String arg : argLevel2
            ) {
                if (word.contains(arg)) {

                    if (!tokens.contains(arg)) {
                        tokens.add(arg);
                    }
                    complexity += 2;
                }
            }

            try {
                num = Double.parseDouble(word);
            } catch (NumberFormatException e) {
                numeric = false;
            }
            if (numeric) {
                if (!tokens.contains(Double.toString(num))) {
                    tokens.add(Double.toString(num));
                }
                complexity++;
            }

        }

        for (String word : wordList
        ) {
            for (int i = 0; i < word.length(); i++) {

                if (String.valueOf(word.charAt(i)).equals(".")) {

                    if (!tokens.contains(".")) {
                        tokens.add(".");
                    }
                    complexity++;
                }
                if (String.valueOf(word.charAt(i)).equals("+")) {

                    if ((i - 1) >= 0) {
                        if (String.valueOf(word.charAt(i - 1)).equals("+")) {
                            continue;
                        }
                    } else if ((i + 1) < word.length()) {
                        if (String.valueOf(word.charAt(i + 1)).equals("+")) {
                            continue;
                        }
                    } else {
                        if (!tokens.contains(".")) {

                            tokens.add("+");
                        }
                        complexity++;
                    }
                }
            }
        }

        int stringCount = 0;

        for (String s : strings
        ) {
            stringCount++;
            if (stringCount % 2 == 0) {
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
