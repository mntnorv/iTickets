/*
 * Created by JFormDesigner on Fri Apr 19 22:28:30 EEST 2013
 */

package kestar.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import kestar.DataManager;
import kestar.data.Client;
import kestar.data.Sex;
import kestar.data.SocialGroup;

import com.toedter.calendar.JDateChooser;

/**
 * @author Kestutis Taraskevicius
 */
public class ClientsPanel extends JPanel implements UIDataManager {
	private static final long serialVersionUID = 1L;

	private DataManager dataManager;
	private ClientsTableModel clientsTableModel;

	public ClientsPanel() {
		initComponents();
		
		dateChooser.setLocale(Locale.getDefault());
		//dateChooser.getDateEditor().getUiComponent().setEnabled(false);
	}
	
	public void setDataManager(DataManager dataManager) {
		this.dataManager = dataManager;
		initTable();
		updateData();
	}
	
	@Override
	public void addNewElement() {
		int oldCount = dataManager.getClients().size();
		dataManager.getClients().add(new Client());
		clientsTableModel.fireTableRowsInserted(oldCount - 1, oldCount);
	}

	@Override
	public void removeSelectedElements() {
		int selection[] = clientsTable.getSelectedRows();
		for (int i = selection.length - 1; i >= 0; i--) {
			dataManager.getClients().remove(selection[i]);
		}
		clientsTableModel.fireTableDataChanged();
	}
	
	@Override
	public void updateData() {
		if (dataManager != null) {
			updateColumnEditors();
			clientsTableModel.fireTableDataChanged();
		}
	}
	
	private void updateColumnEditors() {
		socialGroupCombo.removeAllItems();
		for (SocialGroup group: dataManager.getSocialGroups()) {
			socialGroupCombo.addItem(group.getName());
		}
	}

	private void clientsTableMouseReleased(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON3) {
			int clickedRow = clientsTable.rowAtPoint(e.getPoint());
	        if (clickedRow >= 0 && clickedRow < clientsTable.getRowCount()) {
	        	clientsTable.setRowSelectionInterval(clickedRow, clickedRow);
	        	rightClickMenu.show(clientsTable, e.getPoint().x, e.getPoint().y);
	        }
		}
	}
	
	private void clientsTableModelTableChanged(TableModelEvent e) {
		dataManager.writeData();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		ResourceBundle bundle = ResourceBundle.getBundle("kestar.strings");
		scrollPane = new JScrollPane();
		clientsTable = new JTable();
		rightClickMenu = new JPopupMenu();
		buyTicketItem = new JMenuItem();
		transferButton = new JMenuItem();
		removeButton = new JMenuItem();
		sexCombo = new JComboBox<>();
		socialGroupCombo = new JComboBox<>();
		dateChooser = new JDateChooser();
		dateLabel = new JLabel();

		//======== this ========
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		//======== scrollPane ========
		{

			//---- clientsTable ----
			clientsTable.setRowHeight(24);
			clientsTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					clientsTableMouseReleased(e);
				}
			});
			scrollPane.setViewportView(clientsTable);
		}
		add(scrollPane);

		//======== rightClickMenu ========
		{

			//---- buyTicketItem ----
			buyTicketItem.setText(bundle.getString("ClientsPanel.buyTicketItem.text"));
			rightClickMenu.add(buyTicketItem);

			//---- transferButton ----
			transferButton.setText(bundle.getString("ClientsPanel.transferButton.text"));
			rightClickMenu.add(transferButton);

			//---- removeButton ----
			removeButton.setText(bundle.getString("ClientsPanel.removeButton.text"));
			rightClickMenu.add(removeButton);
		}

		//---- sexCombo ----
		sexCombo.addItem(Sex.MALE);
		sexCombo.addItem(Sex.FEMALE);

		//---- dateLabel ----
		dateLabel.setText("Date");
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
		
		//---- socialGroupCombo ----
		socialGroupCombo = new JComboBox<String>();
	}
	
	private void initTable() {
		clientsTableModel = new ClientsTableModel(dataManager.getClients());
		clientsTable.setModel(clientsTableModel);
		
		clientsTableModel.addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				clientsTableModelTableChanged(e);
			}
		});
		
		clientsTable.getColumnModel()
		.getColumn(ClientsTableModel.SEX_COLUMN)
		.setCellEditor(new DefaultCellEditor(sexCombo));
		
		clientsTable.getColumnModel()
		.getColumn(ClientsTableModel.BIRTHDAY_COLUMN)
		.setCellEditor(new DateCellEditor(dateChooser));
		
		clientsTable.getColumnModel()
		.getColumn(ClientsTableModel.BIRTHDAY_COLUMN)
		.setCellRenderer(new DateCellRenderer(dateLabel));
		
		clientsTable.getColumnModel()
		.getColumn(ClientsTableModel.SOCIAL_GROUP_COLUMN)
		.setCellEditor(new DefaultCellEditor(socialGroupCombo));
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JScrollPane scrollPane;
	private JTable clientsTable;
	private JPopupMenu rightClickMenu;
	private JMenuItem buyTicketItem;
	private JMenuItem transferButton;
	private JMenuItem removeButton;
	private JComboBox<Sex> sexCombo;
	private JComboBox<String> socialGroupCombo;
	private JDateChooser dateChooser;
	private JLabel dateLabel;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
