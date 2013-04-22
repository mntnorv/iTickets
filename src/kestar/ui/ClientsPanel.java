/*
 * Created by JFormDesigner on Fri Apr 19 22:28:30 EEST 2013
 */

package kestar.ui;

import java.text.ParseException;

import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.text.MaskFormatter;

import kestar.DataHelper;
import kestar.data.SocialGroup;

/**
 * @author Kestutis Taraskevicius
 */
public class ClientsPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private DataHelper dataHelper;
	private JComboBox<String> socialGroupCombo;
	private JTextField dateTextField;

	public ClientsPanel() {
		initComponents();
		
		socialGroupCombo = new JComboBox<String>();
		
		MaskFormatter dateFormatter = null;
		try {
			dateFormatter = new MaskFormatter("####-##-##");
			dateTextField = new JFormattedTextField(dateFormatter);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setDataHelper(DataHelper newDataHelper) {
		dataHelper = newDataHelper;
		
		clientsTable.setModel(new ClientsTableModel(dataHelper.getClients()));
		
		clientsTable.getModel().addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				dataHelper.writeData();
			}
		});
		
		for (SocialGroup group: dataHelper.getSocialGroups()) {
			socialGroupCombo.addItem(group.getName());
		}
		
		clientsTable.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(dateTextField));
		clientsTable.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(socialGroupCombo));
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
