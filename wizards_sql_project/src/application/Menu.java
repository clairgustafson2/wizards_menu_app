package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import entity.House;
import entity.Characters;
import dao.CharacterDao;
import dao.HouseDao;

public class Menu {
	
	private HouseDao houseDao = new HouseDao();
	private CharacterDao characterDao = new CharacterDao();
	private Scanner scanner= new Scanner(System.in);
	private List<String> options = Arrays.asList("Display Houses", "Display a House", "Create House", 
			"Create Character", "Update Character", "Delete Character");

	public void start() {
		
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
		try {
			if (selection.equals("1")) {
				//displayHouses();
			} else if (selection.equals("2")) {
				//displayHouse();
			} else if (selection.equals("3")) {
				createHouse();
			} else if (selection.equals("4")) {
				createCharacter();
			} else if (selection.equals("5")) {
				updateCharacter();
			} else if (selection.equals("6")) {
				deleteCharacter();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			System.out.println("Press enter to continue... ");
			scanner.nextLine();
			
		} while (!selection .equals("-1"));
	}
	private void printMenu() {
		System.out.println("Select an option\n -------------------------------------");
		for(int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}
	// 1. display houses
	private void displayHouses() throws SQLException {
		List<House> houses = HouseDao.getHouses(); //ERROR:wants to make getHouses() static in HouseDao
		for(House house : houses) {
			System.out.println(house.getHouseId() + " : " + house.getName());
		}
	}

	// 2. display a house by id and lists characters in that house
	private void displayHouse() throws SQLException {
		System.out.print("Enter house id: ");
		int id = Integer.parseInt(scanner.nextLine());
		House house = HouseDao.getHouseById(id);  //ERROR:wants to make getHouses() static in HouseDao
		System.out.println(house.getHouseId() + " : " + house.getName());
		for (Character character : house.getCharacters()) {
			System.out.println("\tCharacterId: " + character.getCharacterId() //ERROR:method getCharacterId() is undefined for the type Character
		+ " - Name: "
		+ character.getFirstName() + " " //ERROR:method getFirstName() is undefined for the type Character
		+ character.getLastName()); //ERROR:method getFirstName() getLastName() is undefined for the type Character
		}
	}
	
	// 3. creates a house
	private void createHouse() throws SQLException {
		System.out.print("Enter new house name: ");
		String houseName = scanner.nextLine();
		houseDao.createNewHouse(houseName);
	}
	
	// 4. creates a new character
	private void createCharacter() throws SQLException {
		System.out.print("Enter first name of new character: ");
		String firstName = scanner.nextLine();
		System.out.print("Enter last name of new character: ");
		String lastName = scanner.nextLine();
		System.out.print("Enter house id for new character: ");
		int houseId = Integer.parseInt(scanner.nextLine());
		characterDao.createNewCharacter(firstName, lastName, houseId);
	}
	// 5. update character first name or last name by character id
	private void updateCharacter() throws SQLException {
		System.out.print("Enter first name of new character: ");
		String firstName = scanner.nextLine();
		System.out.print("Enter last name of new character: ");
		String lastName = scanner.nextLine();
		int id = Integer.parseInt(scanner.nextLine());
		characterDao.updateCharacterById(id, firstName, lastName);
	}
	
	// 6. deletes a character by id
	private void deleteCharacter() throws SQLException {
		System.out.print("Enter id of character you wish to delete: ");
		int id = Integer.parseInt(scanner.nextLine());
		characterDao.deleteCharactersById(id);
	}

}
