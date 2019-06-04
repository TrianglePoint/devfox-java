import java.util.Scanner;

public class JavaTest {

	public static void main(String[] args) {
		JavaTest javaTest = new JavaTest();
		javaTest.executeTest();
	}

	public void executeTest() {
		Thing thing = new Rhombus(); // Changed that each by test.
		Scanner scanner = new Scanner(System.in);
		int answer;
		
		do {
			System.out.print("Insert number (END : -1) : ");
			answer = scanner.nextInt();
			
			thing.draw(answer);
		}while(answer != -1);
		
		System.out.println("END");
	}
}
