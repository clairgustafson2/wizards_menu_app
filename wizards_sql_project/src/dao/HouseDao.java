package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.House;

public class HouseDao {
	
	private Connection connection;
	private CharacterDao characterDao = new CharacterDao();
	private final String GET_HOUSE_QUERY = "SELECT * FROM house";
	private final String GET_HOUSE_BY_ID_QUERY = "SELECT * FROM house WHERE id = ?";
	private final String CREATE_NEW_HOUSE_QUERY = "INSERT INTO house(house_name) VALUES(?)";
	
	public HouseDao() {
		connection = DBConnection.getConnection();	
	}

	// 1. displays all houses
	public List<House> getHouses() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_HOUSE_QUERY).executeQuery();
		List<House> houses = new ArrayList<House>();
		
		while (rs.next()) {
			houses.add(populateHouse(rs.getInt(1), rs.getString(2)));
		}
		return houses;
	}

	// 2. displays a house and its characters by house id
	public House getHouseById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_HOUSE_BY_ID_QUERY);
		ps.setInt(1,id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populateHouse(rs.getInt(1), rs.getString(2));
	}

	// 3. creates a new house
	public void createNewHouse(String houseName) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_HOUSE_QUERY);
		ps.setString(1, houseName);
		ps.executeUpdate();	
	}
	
	// 2.a populates houses with characters
	private House populateHouse(int id, String houseName) throws SQLException {
		return new House(id, houseName, characterDao.getCharactersByHouseId(id)); 	
	}
}
