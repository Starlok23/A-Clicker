package es.iesfranciscodelosrios.ModelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import es.iesfranciscodelosrios.A_Clicker.DataService;
import es.iesfranciscodelosrios.Connection.Connect;
import es.iesfranciscodelosrios.Interfaces.IStructuresDAO;
import es.iesfranciscodelosrios.Model.structures;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class structuresDAO implements es.iesfranciscodelosrios.Interfaces.IStructuresDAO<structures, Integer> {

	Connection miCon = null;
	List<structures> passiveList = new ArrayList<>();

	/**
	 *  Metodo para insertar datos de mejoras
	 */
	@Override
	public boolean insert(structures ob) {
		miCon = Connect.getConnect();
		boolean result = false;
		String sql = "INSERT INTO structures(name, description, level, cost) VALUES(?, ?, ?, ?)";
		try {
			PreparedStatement sentence = miCon.prepareStatement(sql);
			sentence.setString(1, ob.getName());
			sentence.setString(2, ob.getDescription());
			sentence.setInt(3, ob.getLevel());
			sentence.setInt(4, ob.getCost());
			sentence.executeUpdate();
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 *  Metodo para obtener el nombre, la descripción, el nivel y el coste de las mejoras
	 */
	@Override
	public ObservableList<structures> getInfo() {
		String sql = "SELECT name, description, level, cost FROM structures";
		miCon = Connect.getConnect();
		ObservableList<structures> list = FXCollections.observableArrayList();
		try {
			Statement st = miCon.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String name = rs.getString("name");
				String description = rs.getString("description");
				int level = rs.getInt("level");
				int cost = rs.getInt("cost");
				structures set = new structures(name, description, level, cost);
				list.add(set);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 *  Metodo para obtener toda la información de las mejoras
	 */
	@Override
	public ObservableList<structures> getAll() {
		String sql = "SELECT idStructures, name, description, level, cost FROM structures";
		miCon = Connect.getConnect();
		ObservableList<structures> list = FXCollections.observableArrayList();
		try {
			Statement st = miCon.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int idStructures = rs.getInt("idStructures");
				String name = rs.getString("name");
				String description = rs.getString("description");
				int level = rs.getInt("level");
				int cost = rs.getInt("cost");
				structures set = new structures(idStructures, name, description, level, cost);
				list.add(set);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 *  Metodo para obtener el nombre, la descripción, el nivel y el coste de las mejoras
	 * @return
	 */
	public List<structures> passiveInfo() {
		String sql = "SELECT name, description, level, cost FROM structures";
		miCon = Connect.getConnect();
		List<structures> passiveList = new ArrayList<>();
		try {
			Statement st = miCon.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String name = rs.getString("name");
				String description = rs.getString("description");
				int level = rs.getInt("level");
				int cost = rs.getInt("cost");
				structures set = new structures(name, description, level, cost);
				passiveList.add(set);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return passiveList;
	}

	/**
	 *  Metodo para subir de nivel las mejoras
	 */
	@Override
	public boolean levelUp(String name, int cost, String user) {
		Connection miCon = Connect.getConnect();
		boolean result = false;
		String sql = "UPDATE structures SET level = level + 1 WHERE name = ?";
		String sql1 = "UPDATE username SET counter = counter - (SELECT cost FROM structures WHERE name = ?) WHERE user = ?";
		try {
			PreparedStatement st = miCon.prepareStatement(sql);
			st.setString(1, name);
			PreparedStatement st1 = miCon.prepareStatement(sql1);
			st1.setString(1, name);
			st1.setString(2, user);
			st.executeUpdate();
			st1.executeUpdate();
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 *  Metodo para eliminar una mejora
	 */
	@Override
	public boolean delete(String name) {
		Connection miCon = Connect.getConnect();
		boolean result = false;
		String sql = "DELETE FROM structures WHERE name = ?";
		PreparedStatement st;
		try {
			st = miCon.prepareStatement(sql);
			st.setString(1, name);
			st.executeUpdate();
			result = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
	

}
