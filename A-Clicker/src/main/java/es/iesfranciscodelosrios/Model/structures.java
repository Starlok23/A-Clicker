package es.iesfranciscodelosrios.Model;

public class structures {

	public int idStructures;
	public String name;
	public int level;
	public String description;
	public int cost;
	public int maxLevel;

	public int getMaxLevel() {
		return maxLevel;
	}

	public void setMaxLevel(int maxLevel) {
		this.maxLevel = maxLevel;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getIdStructures() {
		return idStructures;
	}

	public void setIdStructures(int idStructures) {
		this.idStructures = idStructures;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public structures(int idStructures, String name, String description, int level, int cost, int maxLevel) {
		this.idStructures = idStructures;
		this.name = name;
		this.description = description;
		this.level = level;
		this.cost = cost;
		this.maxLevel = maxLevel;
	}

	public structures(String name, String description, int level, int cost) {
		this.name = name;
		this.description = description;
		this.level = level;
		this.cost = cost;
	}

	public structures() {
	}

	public structures(int idStructures, String name, String description, int level, int cost) {
		this.idStructures = idStructures;
		this.name = name;
		this.description = description;
		this.level = level;
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "structures [idStructures=" + idStructures + ", name=" + name + ", level=" + level + ", description="
				+ description + ", cost=" + cost + "]";
	}

}
