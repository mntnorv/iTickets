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
import kestar.data.Client;
import kestar.data.Sex;
import kestar.data.SocialGroup;

/**
 * @author Kestutis Taraskevicius
 */
public class ClientsPanel extends JPanel implements DataManager {
	private static final long serialVersionUID = 1L;

	private DataHelper dataHelper;
	private JComboBox<String> socialGroupCombo;
	private JComboBox<Sex> sexCombo;
	private JTextField dateTextField;
	
	private ClientsTableModel clientsTableModel;

	public ClientsPanel() {
		initComponents();
		
		socialGroupCombo = new JComboBox<String>();
		sexCombo = new JComboBox<Sex>();
		sexCombo.addItem(Sex.MALE);
		sexCombo.addItem(Sex.FEMALE);
		
		MaskFormatter dateFormatter = null;
		try {
			dateFormatter = new MaskFormatter("####-##-##");
			dateTextField = new JFormattedTextField(dateFormatter);
		} catch (ParseException e) {
			/* do nothing */
		}
	}

	public void setDataHelper(DataHelper newDataHelper) {
		dataHelper = newDataHelper;
		
		clientsTableModel = new ClientsTableModel(dataHelper.getClients());
		clientsTable.setModel(clientsTableModel);
		
		clientsTableModel.addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				dataHelper.writeData();
			}
		});
		
		initColumnEditors();
		updateColumnEditors();
	}
	
	public void updateColumnEditors() {
		socialGroupCombo.removeAllItems();
		for (SocialGroup group: dataHelper.getSocialGroups()) {
			socialGroupCombo.addItem(group.getName());
		}
	}
	
	@Override
	public void addNewElement() {
		int oldCount = dataHelper.getClients().size();
		dataHelper.getClients().add(new Client());
		clientsTableModel.fireTableRowsInserted(oldCount - 1, oldCount);
	}

	@Override
	public void removeSelection() {
		int selection[] = clientsTable.getSelectedRows();
		for (int i = selection.length - 1; i >= 0; i--) {
			dataHelper.getClients().remove(selection[i]);
		}
		clientsTableModel.fireTableDataChanged();
	}
	
	private void initColumnEditors() {
		clientsTable.getColumnModel()
		.getColumn(ClientsTableModel.SEX_COLUMN)
		.setCellEditor(new DefaultCellEditor(sexCombo));
		
		clientsTable.getColumnModel()
		.getColumn(ClientsTableModel.BIRTHDAY_COLUMN)
		.setCellEditor(new DefaultCellEditor(dateTextField));
		
		clientsTable.getColumnModel()
		.getColumn(ClientsTableModel.SOCIAL_GROUP_COLUMN)
		.setCellEditor(new DefaultCellEditor(socialGroupCombo));
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
