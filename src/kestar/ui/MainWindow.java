/*
 * Created by JFormDesigner on Fri Apr 19 15:42:45 EEST 2013
 */

package kestar.ui;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/**
 * @author Kęstutis Taraskevičius
 */
public class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public MainWindow() {
		try {
			UIManager.setLookAndFeel(
			        UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.err.println("Error setting system look and feel");
		}
		
		initComponents();
	}

	private void dataTabbedPaneStateChanged(ChangeEvent e) {
		if (dataTabbedPane.getSelectedIndex() == 0) {
			buyButton.setEnabled(true);
			transferButton.setEnabled(true);
		} else {
			buyButton.setEnabled(false);
			transferButton.setEnabled(false);
		}
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		ResourceBundle bundle = ResourceBundle.getBundle("kestar.strings");
		mainToolBar = new JToolBar();
		addButton = new JButton();
		removeButton = new JButton();
		buyButton = new JButton();
		transferButton = new JButton();
		toolBarSpacer = new JPanel(null);
		helpButton = new JButton();
		dataTabbedPane = new JTabbedPane();
		clientsPanel1 = new ClientsPanel();
		vehiclesPanel1 = new VehiclesPanel();

		//======== this ========
		setTitle(bundle.getString("MainWindow.this.title"));
		Container contentPane = getContentPane();
		contentPane.setLayout(new FormLayout(
			"default:grow",
			"default, $lgap, fill:default:grow"));

		//======== mainToolBar ========
		{
			mainToolBar.setFloatable(false);

			//---- addButton ----
			addButton.setText(bundle.getString("MainWindow.addButton.text"));
			addButton.setIcon(new ImageIcon(getClass().getResource("/kestar/icons/add.png")));
			mainToolBar.add(addButton);

			//---- removeButton ----
			removeButton.setText(bundle.getString("MainWindow.removeButton.text"));
			removeButton.setIcon(new ImageIcon(getClass().getResource("/kestar/icons/delete.png")));
			mainToolBar.add(removeButton);

			//---- buyButton ----
			buyButton.setText(bundle.getString("MainWindow.buyButton.text"));
			buyButton.setIcon(new ImageIcon(getClass().getResource("/kestar/icons/money_dollar.png")));
			mainToolBar.add(buyButton);

			//---- transferButton ----
			transferButton.setText(bundle.getString("MainWindow.transferButton.text"));
			transferButton.setIcon(new ImageIcon(getClass().getResource("/kestar/icons/coins_add.png")));
			mainToolBar.add(transferButton);
			mainToolBar.add(toolBarSpacer);

			//---- helpButton ----
			helpButton.setIcon(new ImageIcon(getClass().getResource("/kestar/icons/help.png")));
			mainToolBar.add(helpButton);
		}
		contentPane.add(mainToolBar, CC.xy(1, 1));

		//======== dataTabbedPane ========
		{
			dataTabbedPane.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					dataTabbedPaneStateChanged(e);
				}
			});
			dataTabbedPane.addTab(bundle.getString("MainWindow.clientsPanel1.tab.title"), clientsPanel1);

			dataTabbedPane.addTab(bundle.getString("MainWindow.vehiclesPanel1.tab.title"), vehiclesPanel1);

		}
		contentPane.add(dataTabbedPane, CC.xy(1, 3));
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JToolBar mainToolBar;
	private JButton addButton;
	private JButton removeButton;
	private JButton buyButton;
	private JButton transferButton;
	private JPanel toolBarSpacer;
	private JButton helpButton;
	private JTabbedPane dataTabbedPane;
	private ClientsPanel clientsPanel1;
	private VehiclesPanel vehiclesPanel1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
