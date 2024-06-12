package myPack;

public class MethodDemo {

	public static void main(String[] args) {
		String[] messages = {"HEllo", "My", "Name", "Is: "};
		displayMessage(messages);
		System.out.println(15 + 5);

	}

	public static void displayMessage(String... strings) {
		for (String s: strings) {
			System.out.println(s);
		}
	}

}
