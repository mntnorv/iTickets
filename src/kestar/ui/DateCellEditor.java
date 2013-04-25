package kestar.ui;

import java.awt.Component;
import java.util.Calendar;

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import com.toedter.calendar.JDateChooser;

public class DateCellEditor extends AbstractCellEditor implements TableCellEditor {
	
	private static final long serialVersionUID = 1L;
	
	private JDateChooser dateChooser;
	private Calendar oldValue;
	
	public DateCellEditor (JDateChooser dateChooser) {
		super();
		this.dateChooser = dateChooser;
	}
	
	@Override
	public Object getCellEditorValue() {
		if (dateChooser.getCalendar() != null) {
			return dateChooser.getCalendar();
		} else {
			return oldValue;
		}
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		dateChooser.setCalendar((Calendar) value);
		oldValue = (Calendar) value;
		return dateChooser;
	}
}
