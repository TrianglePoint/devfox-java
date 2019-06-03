
public class Square implements Thing {

	@Override
	public void draw(int number) {
		for(int i = 0; i < number; i++) {
			for(int j = 0; j < number; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
