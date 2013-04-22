package kestar.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import kestar.data.Client;

public class ClientsTableModel implements TableModel {
	
	private static final int COLUMN_COUNT = 6;
	
	private static final String COLUMN_RESOURCE_NAMES[] = new String[] {
		"ClientsTableModel.firstNameColumn.text",
		"ClientsTableModel.lastNameColumn.text",
		"ClientsTableModel.sexColumn.text",
		"ClientsTableModel.birthdayColumn.text",
		"ClientsTableModel.socialGroupColumn.text",
		"ClientsTableModel.balanceColumn.text"
	};
	
	private static final Class<?>[] COLUMN_CLASSES = new Class<?>[] {
		String.class, String.class, String.class, String.class, String.class, Double.class
	};
	
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
		"yyyy-MM-dd"
	);
	
	//================================================================================
	
	private ResourceBundle resBundle;
	private List<Client> data;
	private List<TableModelListener> listeners;
	
	//================================================================================
	
	public ClientsTableModel(List<Client> data) {
		this.data = data;
		
		listeners = new ArrayList<TableModelListener>();
		resBundle = ResourceBundle.getBundle("kestar.strings");
	}
	
	//================================================================================
	// TableModel overrides
	//================================================================================
	
	@Override
	public void addTableModelListener(TableModelListener l) {
		listeners.add(l);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return COLUMN_CLASSES[columnIndex];
	}

	@Override
	public int getColumnCount() {
		return COLUMN_COUNT;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return resBundle.getString(COLUMN_RESOURCE_NAMES[columnIndex]);
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return getColumnFromClient(data.get(rowIndex), columnIndex);
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex < 5;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		listeners.remove(l);
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		setColumnOfClient(data.get(rowIndex), columnIndex, aValue);
		
		TableModelEvent event = new TableModelEvent(this, rowIndex, rowIndex, columnIndex);
		for (TableModelListener listener: listeners) {
			listener.tableChanged(event);
		}
	}
	
	//================================================================================
	// ClientsTableModel methods
	//================================================================================
	
	private Object getColumnFromClient(Client client, int columnIndex) {
		Object columnObject = null;
		
		switch (columnIndex) {
		case 0:
			columnObject = client.getFirstName();
			break;
		case 1:
			columnObject = client.getLastName();
			break;
		case 2:
			columnObject = client.getSex();
			break;
		case 3:
			columnObject = DATE_FORMAT.format(client.getBirthday().getTime());
			break;
		case 4:
			columnObject = client.getSocialGroup();
			break;
		case 5:
			columnObject = client.getBalance();
			break;
		}
		
		return columnObject;	
	}

	private void setColumnOfClient(Client client, int columnIndex, Object value) {
		switch (columnIndex) {
		case 0:
			client.setFirstName((String) value);
			break;
		case 1:
			client.setLastName((String) value);
			break;
		case 2:
			client.setSex((String) value);
			break;
		case 3:
			Calendar newBirthday = GregorianCalendar.getInstance();
			try {
				newBirthday.setTime(DATE_FORMAT.parse((String) value));
				client.setBirthday(newBirthday);
			} catch (ParseException e) {
				/* do nothing */
			}
			break;
		case 4:
			client.setSocialGroup((String) value);
			break;
		}
	}
}
