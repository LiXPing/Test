import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		// 1秒 = 1000毫秒 = 1000x1000微秒 = 1000x1000x1000纳秒
		for (int i = 0; i < 10; i++) {
			System.out.println(System.nanoTime());
		}
		System.out.println();
		
		Random random;
		
		for (int i = 0; i < 5; i++) {
			random = new Random(System.nanoTime()); // seed
			System.out.println(random.nextInt());
		}
	}

}