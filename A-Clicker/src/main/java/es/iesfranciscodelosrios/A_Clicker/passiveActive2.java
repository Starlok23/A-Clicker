package es.iesfranciscodelosrios.A_Clicker;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import es.iesfranciscodelosrios.Connection.Connect;
import es.iesfranciscodelosrios.Model.structures;
import javafx.application.Platform;

public class passiveActive2 implements Runnable {
	private List<structures> list;

	public passiveActive2(List<structures> list) {
		// TODO Auto-generated constructor stub
		this.list = list;
	}

	@Override
	public void run() {
		while (true) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getName().equals("Factory") && list.get(i).getLevel() >= 1) {
					String user = DataService.user.getUsername();
					Connection miCon = Connect.getConnect();
					String sql = "UPDATE username SET counter = counter + 5 WHERE user = ?";
					try {
						PreparedStatement st = miCon.prepareStatement(sql);
						st.setString(1, user);
						st.executeUpdate();
						DataService.user.setCounter(DataService.user.getCounter() + 5);
						Platform.runLater(new Runnable() {

							@Override
							public void run() {
								DataService.counter.set(DataService.user.getCounter());

							}
						});
					} catch (SQLException e) {
						e.printStackTrace();
					}
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}

			}
		}
	}

}
