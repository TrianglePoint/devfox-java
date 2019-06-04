
public class Rhombus implements Thing {

	@Override
	public void draw(int number) {
		if(number == -1) {
			return;
		}
		if(number < 3 || number % 2 == 0) {
			System.out.println("ERROR - insert number like [3, 5, ...]");
			return;
		}
		
		for(int i = 1; i <= number*2-1; i+=2) {
			int star;
			if(i / number == 0) {
				star = i;
			}else {
				star = number - (i % number);
			}
			
			printWhiteSpace((number-star)/2);
			printStar(star);
			printWhiteSpace((number-star)/2);
			
			System.out.println();
		}
	}
	
	private void printStar(int number) {
		for(int i = 0; i < number; i++) {
			System.out.print("*");
		}
	}
	
	private void printWhiteSpace(int number) {
		for(int i = 0; i < number; i++) {
			System.out.print(" ");
		}
	}
	
}
