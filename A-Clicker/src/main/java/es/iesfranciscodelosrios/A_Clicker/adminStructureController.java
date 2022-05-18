package es.iesfranciscodelosrios.A_Clicker;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import es.iesfranciscodelosrios.Model.structures;
import es.iesfranciscodelosrios.ModelDAO.structuresDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class adminStructureController implements Initializable{

	@FXML 
	private TableView<structures> structureView;
	
	@FXML
	private TableColumn<structures, String> colIdStructures;
	
	@FXML
	private TableColumn<structures, String> colName;
	
	@FXML
	private TableColumn<structures, String> colDescription;
	
	@FXML
	private TableColumn<structures, Integer> colLevel;
	
	@FXML
	private TableColumn<structures, Integer> colCost;
	
	@FXML
	private Button btnAdd;
	
	@FXML
	private Button btnRemove;
	
	@FXML
	private Button btnModify;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		this.colIdStructures.setCellValueFactory(new PropertyValueFactory<>("IdStructures"));
		this.colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
		this.colDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
		this.colLevel.setCellValueFactory(new PropertyValueFactory<>("Level"));
		this.colCost.setCellValueFactory(new PropertyValueFactory<>("Cost"));
		structuresDAO st = new structuresDAO();
		ObservableList<structures> list = st.getAll();
		this.structureView.setItems(list);
	}
	
	/**
	 *  Metodo para añadir una mejora
	 * @param e
	 */
	public void actionAdd(ActionEvent e) {
		//App.setRoot();
	}
	
	/**
	 *  Metodo para eliminar una mejora
	 * @param e
	 */
	public void actionRemove(ActionEvent e) {
		structuresDAO st = new structuresDAO();
		structures str = this.structureView.getSelectionModel().getSelectedItem();
		if(str != null) {
			st.delete(str.getName());
		}
	}
	
	/**
	 * Metodo para modificar una mejora
	 * @param e
	 * @throws IOException 
	 */
	public void actionModify(ActionEvent e) throws IOException {
		App.setRoot("structureControl");
	}

}
