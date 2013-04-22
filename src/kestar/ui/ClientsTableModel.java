package kestar.ui;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import kestar.data.Client;

public class ClientsTableModel implements TableModel {
	
	private static final int COLUMN_COUNT = 5;
	private static final String[] COLUMN_NAMES = new String[] {
		"Vardas", "Pavardë", "Lytis", "Gimimo data", "Socialinë grupë"
	};
	private static final Class<?>[] COLUMN_CLASSES = new Class<?>[] {
		String.class, String.class, String.class, Calendar.class, String.class
	};
	
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
		"yyyy-MM-dd"
	);
	
	//================================================================================
	
	private List<Client> data;
	private List<TableModelListener> listeners;
	
	//================================================================================
	
	public ClientsTableModel(List<Client> data) {
		this.data = data;
		
		listeners = new ArrayList<TableModelListener>();
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
		return COLUMN_NAMES[columnIndex];
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
		return true;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		listeners.remove(l);
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		setColumnOfClient(data.get(rowIndex), columnIndex, aValue);
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
			client.setBirthday((Calendar) value);
			break;
		case 4:
			client.setSocialGroup((String) value);
			break;
		}
	}
}
