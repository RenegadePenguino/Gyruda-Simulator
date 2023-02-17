package gyruda;

public class Main {
	public static void main (String[] args) {
		int numTests = 1000000;
		double totalPower = 0;
		for (int i = 0; i< numTests; i++) {
			Gyruda test = new Gyruda();
			totalPower+=test.castGyruda(7, 5, false);
			System.out.println(i);
		}
		System.out.println(totalPower/numTests);
	}
}
