package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import dao.TreesDao;
import entity.Tree;

public class TreeMenu {

	private TreesDao treesDao = new TreesDao(); 
	private Scanner s = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display all Tree Names", 
			"Display all Tree Families",
			"Display details about a Tree", 
			"Log New Tree", "Delete A Tree From List");
	
	public void start() {
		String selection = ""; 
		
		do {
			printMenu(); 
			selection = s.nextLine(); 
			
			try {
				if(selection.equals("1")) {
					displayTrees(); 
				} else if (selection.equals("2")) {
					displayFamilies(); 
				} else if (selection.equals("3")) {
					displayTree();
				} else if (selection.equals("4")) {
					logNewTree(); 
				} else if (selection.equals("5")) {
					deleteTree(); 
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			System.out.println("Press enter to continue....");
			s.nextLine(); 
			
		} while (!selection.equals("-1"));

	}
	
	private void printMenu() {
		System.out.println("Select an Option:\n--------------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}
	
	private void displayTrees() throws SQLException {
		List<Tree> trees = treesDao.getTrees(); 
		for (Tree tree : trees) {
			System.out.println(tree.getTreeId() + ": " + tree.getTreeName());
		}
	}
	
	private void displayFamilies() throws SQLException {
		List<Tree> trees = treesDao.getTrees(); 
		Set<String> familyNames = new HashSet<String>(); 
		for (Tree tree : trees) {
			familyNames.add(tree.getTreeFamily()); 
		}
		for (String name : familyNames) {
			System.out.println(name);
		}
	}
	
	private void displayTree() throws SQLException {
		System.out.println("Enter tree id: ");
		int id = Integer.parseInt(s.nextLine()); 
		Tree tree = treesDao.getTreeById(id);
		System.out.println(tree.getTreeId() + ": NAME: " + tree.getTreeName() + ", FRUIT BEARING?: " + 
		tree.getFruitBearing() + ", TREE FAMILY: " + tree.getTreeFamily() + ", LIFESPAN: " + tree.getTreeLifespan());
	}
	
	private void logNewTree() throws SQLException {
		System.out.println("Enter name of tree: ");
		String treeName = s.nextLine();
		System.out.println("Is the tree fruit bearing? (Y/N): ");
		char fruitBearing = s.nextLine().charAt(0);
		System.out.println("Provide Tree Family: ");
		String treeFamily = s.nextLine(); 
		System.out.println("What is the average lifespan of " + treeName + " tree?: ");
		int treeLifespan = s.nextInt(); 
		treesDao.logNewTree(treeName, fruitBearing, treeFamily, treeLifespan);
	}
	
	private void deleteTree() throws SQLException {
		System.out.println("Enter tree id to delete: ");
		int id = Integer.parseInt(s.nextLine());
		treesDao.deleteTreeById(id);
	}

}
