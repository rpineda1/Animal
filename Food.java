package Animal;
public class Food extends Thread{

	synchronized void eat(long rest) {
		try {
			Thread.sleep(rest); // giving an advantage to the animal while they eat
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
