package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Tree;

public class TreesDao {

	private Connection con; 
	private final String GET_TREES_QUERY = "SELECT * FROM Trees";
	private final String GET_TREE_BY_ID_QUERY = "SELECT * FROM trees WHERE id = ?";
	private final String LOG_NEW_TREE_QUERY = "INSERT INTO trees(name, fruit_bearing, family, lifespan) VALUES (?, ?, ?, ?)";
	private final String DELETE_TREE_BY_ID_QUERY = "DELETE FROM trees WHERE id = ?"; 
	
	public TreesDao() {
		con = DBConnection.getCon(); 
	}
	
	public List<Tree> getTrees() throws SQLException {
		ResultSet rs = con.prepareStatement(GET_TREES_QUERY).executeQuery(); 
		List<Tree> trees = new ArrayList<Tree>();
		
		while (rs.next()) {
			trees.add(populateTree(rs.getInt(1), rs.getString(2), rs.getString(3).charAt(0), rs.getString(4), rs.getInt(5))); 
		}
		
		return trees; 
	
	}
	
	public Tree getTreeById(int id) throws SQLException {
		PreparedStatement ps = con.prepareStatement(GET_TREE_BY_ID_QUERY);
		ps.setInt(1, id); 
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populateTree(rs.getInt(1), rs.getString(2), rs.getString(3).charAt(0), rs.getString(4), rs.getInt(5));
	}
	
	public void logNewTree(String treeName, char fruitBearing, String treeFamily, int treeLifespan) throws SQLException {
		PreparedStatement ps = con.prepareStatement(LOG_NEW_TREE_QUERY); 
		ps.setString(1, treeName);
		ps.setObject(2, fruitBearing, java.sql.Types.CHAR);
		ps.setString(3, treeFamily);
		ps.setInt(4, treeLifespan);
		ps.executeUpdate(); 
	}
	
	public void deleteTreeById(int id) throws SQLException {
		PreparedStatement ps = con.prepareStatement(DELETE_TREE_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	private Tree populateTree(int treeId, String treeName, char fruitBearing, String treeFamily, int treeLifespan) {
		return new Tree(treeId, treeName, fruitBearing, treeFamily, treeLifespan);  
	}
}
