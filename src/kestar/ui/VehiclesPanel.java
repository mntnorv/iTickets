/*
 * Created by JFormDesigner on Fri Apr 19 22:29:04 EEST 2013
 */

package kestar.ui;

import javax.swing.*;

/**
 * @author Kestutis Taraskevicius
 */
public class VehiclesPanel extends JPanel {
	public VehiclesPanel() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		scrollPane1 = new JScrollPane();
		table1 = new JTable();

		//======== this ========
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		//======== scrollPane1 ========
		{
			scrollPane1.setViewportView(table1);
		}
		add(scrollPane1);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JScrollPane scrollPane1;
	private JTable table1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
