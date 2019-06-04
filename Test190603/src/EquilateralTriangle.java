
public class EquilateralTriangle implements Thing {

	@Override
	public void draw(int number) {
		if(number == -1) {
			return;
		}
		if(number < 3 || number % 2 == 0) {
			System.out.println("ERROR - insert number like [3, 5, ...]");
			return;
		}
		
		for(int i = 1; i <= number; i+=2) {
			printWhiteSpace((number-i)/2);
			
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			
			printWhiteSpace((number-i)/2);
			
			System.out.println();
		}
	}
	
	private void printWhiteSpace(int number) {
		for(int i = 0; i < number; i++) {
			System.out.print(" ");
		}
	}

}
