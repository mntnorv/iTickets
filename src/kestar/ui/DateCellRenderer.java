package kestar.ui;

import java.awt.Component;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class DateCellRenderer implements TableCellRenderer {

	private DateFormat dateFormat;
	private JLabel textField;
	
	public DateCellRenderer(JLabel textField) {
		this.textField = textField;
		this.dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault());
	}
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		textField.setText(dateFormat.format(((Calendar)value).getTime()));
		return textField;
	}

}
