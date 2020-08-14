package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Character;

public class CharacterDao {
	
	private Connection connection;
	private final String CREATE_NEW_CHARACTER_QUERY = "INSERT INTO characters(first_name, last_name, house_id) VALUES (?, ?, ?)";
	private final String UPDATE_CHARACTER_BY_ID_QUERY = "UPDATE characters SET first_name = ?, last_name = ? WHERE id =?";
	private final String GET_CHARACTERS_BY_HOUSE_ID_QUERY = "SELECT * FROM characters WHERE house_id = ?";
	private final String DELETE_CHARACTER_BY_ID_QUERY = "DELETE FROM characters WHERE id = ?";
	
	public CharacterDao() {
		connection = DBConnection.getConnection();
	}
	
	//1. create a character
	public void createNewCharacter(String firstName, String lastName, int houseId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_CHARACTER_QUERY);
		ps.setString(1, firstName);
		ps.setString(2, lastName);
		ps.setInt(3, houseId);
		ps.executeUpdate();
	}
	
	// 2. update a character
	public void updateCharacterById (String firstName, String lastName, int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_CHARACTER_BY_ID_QUERY);
		ps.setString(1, firstName);
		ps.setString(2,lastName );
		ps.setInt(3, id );
		ps.executeUpdate();
	}
	
	// 3. makes a list of characters by their house needed for houseDao
	public List<Character> getCharactersByHouseId(int houseId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_CHARACTERS_BY_HOUSE_ID_QUERY);
		ps.setInt(1, houseId);
		ResultSet fs = ps.executeQuery();
		List<Character> characters = new ArrayList<Character>();
		
		while (fs.next()) {
			characters.add(new Character (fs.getInt(1), fs.getString(2), fs.getString(3)));
		}	
		return characters;
	}
	
	//4. delete a character by id
	public void deleteCharactersById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_CHARACTER_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
		
}
