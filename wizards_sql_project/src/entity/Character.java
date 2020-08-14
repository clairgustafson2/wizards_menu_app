package entity;

public class Character {

	private int charactertId;
	private String firstName;
	private String lastName;
	
	public Character(int characterId, String firstName, String lastName) {
		this.setCharactertId(characterId);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		
	}

	public int getCharactertId() {
		return charactertId;
	}

	public void setCharactertId(int charactertId) {
		this.charactertId = charactertId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
}
