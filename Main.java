import java.util.Scanner;

class MyThread extends Thread {
	static int count;
	static char characterS = 'A';
	public static String lock = "lock";
	char characterP;

	public MyThread(char character) {
		this.characterP = character;
	}

	public MyThread(char character, int num) {
		this.characterP = character;
		count = num;
	}

	@Override
	public void run() {
		super.run();
		for (int i = 0; i < count; i++) {
			printC();
		}
	}

	public void printC() {
		while (characterS != characterP){
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
		
		synchronized (lock) {
			System.out.print(characterP);
			characterS += 1;
			if (characterS == 'E') {
				characterS = 'A';
			}
		}
	}
}

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		Scanner scanner = new Scanner(System.in);
		int sum = scanner.nextInt();
		new MyThread('A', sum).start();
		new MyThread('B').start();
		new MyThread('C').start();
		new MyThread('D').start();
	}


}
