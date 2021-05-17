import java.util.ArrayList;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        ComplexitySize cs = new ComplexitySize();

        System.out.println("Enter the Code Here");

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

                tokens = cs.complexityDueToSize(lineContent);

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

}

