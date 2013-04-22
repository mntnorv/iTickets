/*
 * Created by JFormDesigner on Fri Apr 19 22:28:30 EEST 2013
 */

package kestar.ui;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import kestar.data.Client;

/**
 * @author Kestutis Taraskevicius
 */
public class ClientsPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private List<Client> clients;
	
	public ClientsPanel() {
		initComponents();
	}
	
	public void setClients(List<Client> clients) {
		this.clients = clients;
		clientsTable.setModel(new ClientsTableModel(this.clients));
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		scrollPane = new JScrollPane();
		clientsTable = new JTable();

		//======== this ========
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		//======== scrollPane ========
		{
			scrollPane.setViewportView(clientsTable);
		}
		add(scrollPane);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JScrollPane scrollPane;
	private JTable clientsTable;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
