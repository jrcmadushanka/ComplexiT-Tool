import java.util.ArrayList;
import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the Code Here!");
		
		ArrayList<String> code = new ArrayList<>();
		
		int line = 0;
		String lineConetent = "";

		while(scan.hasNext()) {
			
			lineConetent = scan.nextLine();
			code.add(lineConetent);
			System.out.println("Scanned code line "+ line++ + " " + lineConetent);

		}
		
		scan.close();
		
		System.out.println("Done");

	}

}
