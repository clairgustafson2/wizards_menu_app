package entity;

import java.util.List;

public class House {
	
	private int houseId;
	private String houseName;
	private List<Character> characters;
	
	public House (int houseId, String houseName, List<Character> characters) {
		this.setHouseId(houseId);
		this.setHouseName(houseName);
		this.setCharacters(characters);
		
	}

	public int getHouseId() {
		return houseId;
	}

	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public List<Character> getCharacters() {
		return characters;
	}

	public void setCharacters(List<Character> characters) {
		this.characters = characters;
	}	
}
