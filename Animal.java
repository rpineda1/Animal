package Animal;
public class Animal extends Thread implements Runnable {

	private String name; // name of the animal
	private int position; // the position in the race (there can only be 2 positions)
	private int speed; // speed of the animal (will determine a winner)
	private int restMax; // how long the Animal rests between each time it runs
	private boolean winner = false; // determine winner if false return loser
	private Animal(String name) {
		this.name = name;
	}
	public int getPosition() {

		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public void setRestMax(int restMax) {
		this.restMax = restMax;
	}
	public void Food(Food food) {
	}
	public int getRestMax() {
		return restMax;
	}
	public static void main(String[] args) {

		Animal hare = new Animal("Ms Hare"); // adds statistics for the hare 
		new Food();
		hare.setPosition(0);
		hare.setSpeed(9);
		hare.setRestMax(220);
		hare.winner = false;
		hare.setDaemon(false); // user
		Animal tortoise = new Animal("Mr tortoise"); // adds statistics for the tortoise
		new Food();
		tortoise.setPosition(0);
		tortoise.setSpeed(5);
		tortoise.setRestMax(165);
		tortoise.winner = false;
		tortoise.setDaemon(false); // user

		hare.start();
		tortoise.start();
	}

	synchronized public void run() {
		Food food = new Food();
		System.out.println("And "+name+"'s off! \n");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while (position <= 120 && !winner) {
			position += speed;
			System.out.println( name + " started to eat!");
			food.eat(getRestMax());
			System.out.println( name + " stopped eatting!");
			try {
				Thread.sleep(getRestMax());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + " ran yard " + getPosition());
			if (position >= 120) {
				winner = true;
				System.out.println("\nWinner is: " + name + "!");
				System.exit(0); // stops program execution immediately
			}

		}
		if (position <= 120) {
			winner = false;
			System.out.println("\nthe Loser is: " + name + "!");
		}
	}
}


