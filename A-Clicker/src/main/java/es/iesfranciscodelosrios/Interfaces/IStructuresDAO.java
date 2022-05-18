package es.iesfranciscodelosrios.Interfaces;

import java.util.Collection;
import java.util.List;

import es.iesfranciscodelosrios.Model.structures;
import javafx.collections.ObservableList;

public interface IStructuresDAO<T, K> {

	boolean insert(T ob);

	ObservableList<structures> getInfo();

	boolean levelUp(String name, int cost, String user);

	ObservableList<structures> getAll();
	
	boolean delete(String name);

}
