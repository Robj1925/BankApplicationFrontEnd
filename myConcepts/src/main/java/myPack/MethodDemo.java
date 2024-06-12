package myPack;

public class MethodDemo {

	public static void main(String[] args) {
		String[] messages = {"HEllo", "My", "Name", "Is: "};
		displayMessage(messages);

	}

	public static void displayMessage(String... strings) {
		for (String s: strings) {
			System.out.println(s);
		}
	}

}
