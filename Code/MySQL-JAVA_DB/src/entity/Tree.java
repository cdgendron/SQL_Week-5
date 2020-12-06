package entity;

public class Tree {

	private int treeId;
	private String treeName; 
	private char fruitBearing; 
	private String treeFamily;
	private int treeLifespan; 
	
	public Tree(int treeId, String treeName, char fruitBearing, String treeFamily, int treeLifespan) {
		this.setTreeId(treeId);
		this.setTreeName(treeName); 
		this.setFruitBearing(fruitBearing); 
		this.setTreeFamily(treeFamily); 
		this.setTreeLifespan(treeLifespan); 
	}

	public int getTreeId() {
		return treeId;
	}

	public void setTreeId(int treeId) {
		this.treeId = treeId;
	}

	public String getTreeName() {
		return treeName;
	}

	public void setTreeName(String treeName) {
		this.treeName = treeName;
	}

	public char getFruitBearing() {
		return fruitBearing;
	}

	public void setFruitBearing(char fruitBearing) {
		this.fruitBearing = fruitBearing;
	}

	public String getTreeFamily() {
		return treeFamily;
	}

	public void setTreeFamily(String treeFamily) {
		this.treeFamily = treeFamily;
	}

	public int getTreeLifespan() {
		return treeLifespan;
	}

	public void setTreeLifespan(int treeLifespan) {
		this.treeLifespan = treeLifespan;
	}
}
