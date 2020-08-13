package entity;

import java.util.List;

public class House {
	
	private int houseId;
	private String name;
	private List<Character> characters;
	
	public House (int houseId, String name, List<Character> characters) {
		this.setHouseId(houseId);
		this.setName(name);
		this.setCharacters(characters);
		
	}

	public int getHouseId() {
		return houseId;
	}

	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Character> getCharacters() {
		return characters;
	}

	public void setCharacters(List<Character> characters) {
		this.characters = characters;
	}

	
}
