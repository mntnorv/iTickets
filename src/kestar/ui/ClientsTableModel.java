package kestar.ui;

import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.table.AbstractTableModel;

import kestar.data.Client;
import kestar.data.Sex;

public class ClientsTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	
	public static final int FIRST_NAME_COLUMN = 0;
	public static final int LAST_NAME_COLUMN = 1;
	public static final int SEX_COLUMN = 2;
	public static final int BIRTHDAY_COLUMN = 3;
	public static final int SOCIAL_GROUP_COLUMN = 4;
	public static final int BALANCE_COLUMN = 5;
	
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
		String.class, String.class, Sex.class, Calendar.class, String.class, String.class
	};
	
	//================================================================================
	
	private ResourceBundle resBundle;
	private List<Client> data;
	
	//================================================================================
	
	public ClientsTableModel(List<Client> data) {
		this.data = data;
		
		resBundle = ResourceBundle.getBundle("kestar.strings");
	}
	
	//================================================================================
	// TableModel overrides
	//================================================================================

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
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		setColumnOfClient(data.get(rowIndex), columnIndex, aValue);
		fireTableCellUpdated(rowIndex, columnIndex);
	}
	
	//================================================================================
	// ClientsTableModel methods
	//================================================================================
	
	private Object getColumnFromClient(Client client, int columnIndex) {
		Object columnObject = null;
		
		switch (columnIndex) {
		case FIRST_NAME_COLUMN:
			columnObject = client.getFirstName();
			break;
		case LAST_NAME_COLUMN:
			columnObject = client.getLastName();
			break;
		case SEX_COLUMN:
			columnObject = Sex.MALE;
			if (client.getSex().equals(Sex.FEMALE.getId())) {
				columnObject = Sex.FEMALE;
			}
			break;
		case BIRTHDAY_COLUMN:
			columnObject = client.getBirthday();
			break;
		case SOCIAL_GROUP_COLUMN:
			columnObject = client.getSocialGroup();
			break;
		case BALANCE_COLUMN:
			columnObject = String.format("%.2f", client.getBalance());
			break;
		}
		
		return columnObject;	
	}

	private void setColumnOfClient(Client client, int columnIndex, Object value) {
		switch (columnIndex) {
		case FIRST_NAME_COLUMN:
			client.setFirstName((String) value);
			break;
		case LAST_NAME_COLUMN:
			client.setLastName((String) value);
			break;
		case SEX_COLUMN:
			client.setSex(((Sex)value).getId());
			break;
		case BIRTHDAY_COLUMN:
			client.setBirthday((Calendar) value);
			break;
		case SOCIAL_GROUP_COLUMN:
			client.setSocialGroup((String) value);
			break;
		}
	}
}
