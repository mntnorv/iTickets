/*
 * Created by JFormDesigner on Fri Apr 19 15:42:45 EEST 2013
 */

package kestar.ui;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

import kestar.DataHelper;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/**
 * @author Kęstutis Taraskevičius
 */
public class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private static final int CLIENTS_TAB = 0;
	private static final int VEHICLES_TAB = 1;

	private DataHelper dataHelper;

	public MainWindow() {
		try {
			UIManager.setLookAndFeel(
					UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.err.println("Error setting system look and feel");
		}

		initComponents();
	}

	public void setDataHelper(DataHelper dataHelper) {
		this.dataHelper = dataHelper;

		clientsPanel.setDataHelper(this.dataHelper);
	}

	private void dataTabbedPaneStateChanged(ChangeEvent e) {
		if (dataTabbedPane.getSelectedIndex() == CLIENTS_TAB) {
			buyButton.setEnabled(true);
			transferButton.setEnabled(true);
		} else {
			buyButton.setEnabled(false);
			transferButton.setEnabled(false);
		}
	}

	private void addButtonActionPerformed(ActionEvent e) {
		switch (dataTabbedPane.getSelectedIndex()) {
		case CLIENTS_TAB:
			clientsPanel.addNewElement();
			break;
		case VEHICLES_TAB:
			break;
		}
	}

	private void removeButtonActionPerformed(ActionEvent e) {
		switch (dataTabbedPane.getSelectedIndex()) {
		case CLIENTS_TAB:
			clientsPanel.removeSelection();
			break;
		case VEHICLES_TAB:
			break;
		}
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - KÄstutis TaraskeviÄius
		ResourceBundle bundle = ResourceBundle.getBundle("kestar.strings");
		mainToolBar = new JToolBar();
		addButton = new JButton();
		removeButton = new JButton();
		buyButton = new JButton();
		transferButton = new JButton();
		toolBarSpacer = new JPanel(null);
		helpButton = new JButton();
		dataTabbedPane = new JTabbedPane();
		clientsPanel = new ClientsPanel();
		vehiclesPanel = new VehiclesPanel();

		//======== this ========
		setTitle(bundle.getString("MainWindow.this.title"));
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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
			addButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					addButtonActionPerformed(e);
				}
			});
			mainToolBar.add(addButton);

			//---- removeButton ----
			removeButton.setText(bundle.getString("MainWindow.removeButton.text"));
			removeButton.setIcon(new ImageIcon(getClass().getResource("/kestar/icons/delete.png")));
			removeButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					removeButtonActionPerformed(e);
				}
			});
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
			dataTabbedPane.addTab(bundle.getString("MainWindow.clientsPanel.tab.title"), clientsPanel);

			dataTabbedPane.addTab(bundle.getString("MainWindow.vehiclesPanel.tab.title"), vehiclesPanel);

		}
		contentPane.add(dataTabbedPane, CC.xy(1, 3));
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - KÄstutis TaraskeviÄius
	private JToolBar mainToolBar;
	private JButton addButton;
	private JButton removeButton;
	private JButton buyButton;
	private JButton transferButton;
	private JPanel toolBarSpacer;
	private JButton helpButton;
	private JTabbedPane dataTabbedPane;
	private ClientsPanel clientsPanel;
	private VehiclesPanel vehiclesPanel;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
