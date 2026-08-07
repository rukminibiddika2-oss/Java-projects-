package inheritance;

abstract class Base {
	int x;

	void Name() {
		System.out.println("My name is ABCD");
	}

	abstract void Age();
}

public class AbstractDemo extends Base {

	@Override
	void Age() {
		System.out.println("Age in sub class is: 19");

	}

	public static void main(String[] args) {
		AbstractDemo ad = new AbstractDemo();
		System.out.println(ad.x);
		ad.Name();
		ad.Age();
	}
}
