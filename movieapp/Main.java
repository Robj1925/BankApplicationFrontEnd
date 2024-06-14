package movieapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * MovieApp: Single Flow Console App-->Frontend
 * Stakeholders: Admin(CRUD), Viewer(Watch)
 * */

public class Main { //hoisting
	//admin: admin, admin123
	//viewer: rohit, rohit123
	
	static Scanner scanner = new Scanner(System.in);
	static String loginType = "";
	static int idIncrementor = 1;//2
	static List<Viewer> viewers = new ArrayList<>();
	static List<Movie> movies = new ArrayList<>();
	
	
	public static void main(String[] args) {
		 populateSomeData();
         displayHeader();
         startApp();
         displayFooter();
	}

	private static void populateSomeData() {
		 Viewer v1 = new Viewer("rohit", "rohit123");
		 Viewer v2 = new Viewer("mohit", "mohit123");
		 Viewer v3 = new Viewer("shobhit", "shobhit123");
		 
		 viewers.add(v1);
		 viewers.add(v2);
		 viewers.add(v3);
	}

	private static void startApp() {
	   boolean loginStatus = attemptLogin();
	   
	   if(loginStatus) {
		   if(loginType.equals("admin")) {
			   adminHome();
		   }else {//viewer
			   viewerHome();
		   }
	   }else {
		   System.out.println("Invalid Credentials!");
	   }
	}

	private static void viewerHome() {
		// TODO Auto-generated method stub
		
	}

	private static void adminHome() {
		System.out.println("Please select one among the following choice \n Display Movies List:1, Add Movie:2, Delete Movie:3, Update Movie:4");
		String choice = scanner.nextLine();
		switch (choice) {
		case "1":
			listMoviesList();
			break;
		case "2":
			addMovie();
			break;
		default:
			break;
		}
		
	}

	private static void addMovie() {
		//ask the user for movie-name and rating and store it inside the collection
		//can you repeat it? hint:use Loops
		
		//no of movies admin wants to add?
		//have an infinite, yes/no: indefinite no of movies can be added.
		
		
	}

	private static void listMoviesList() {
		// TODO Auto-generated method stub
		if(movies.isEmpty()) {
			System.out.println("Nothing to show, please come again later");
		}else {
			for(int i=0; i<movies.size(); i++) {
				System.out.println(movies.get(i));
			}
		}
		adminHome();
	}

	private static boolean attemptLogin() {
		System.out.println("Please enter username and password, separated by spaces:");
		String usernamePassword = scanner.nextLine();
		String tokens[] = usernamePassword.split(" ");
		String username = tokens[0];
		String password = tokens[1];
		if(username.equals("admin") && password.equals("admin123")) {
			loginType = "admin";
			return true;
		}
		else if(checkIfRegistered(username, password)) {
			loginType = "viewer";
			return true;
		}
		return false;
	}

	private static boolean checkIfRegistered(String username, String password) {
		for(Viewer viewer : viewers) {
			if(viewer.username.equals(username) && viewer.password.equals(password)) {
				return true;
			}
		}
		return false;
	}

	private static void displayHeader() {
	 System.out.println("*******Welcome to the MovieApp*************");
	}
	
	private static void displayFooter() {
		System.out.println("*******Thanks for using the MovieApp. Hope to see you again*************");
	}
}


class Admin extends Object{
	
}

class Viewer extends Object{
	int id;
	String username;
	String password;
	
	public Viewer(String username, String password) {
		super();
		this.id = Main.idIncrementor++;
		this.username = username;
		this.password = password;
	}
	
	
}

class Movie{
	int id;
	String name;
	int rating;
	
	public Movie(String name, int rating) {
		super();
		this.id = Main.idIncrementor++;
		this.name = name;
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "id: " + this.id + ", name: " + this.name + ", rating:" + this.rating ;
	}
	
}

