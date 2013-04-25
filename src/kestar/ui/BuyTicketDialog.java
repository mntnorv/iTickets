/*
 * Created by JFormDesigner on Wed Apr 24 16:22:47 EEST 2013
 */

package kestar.ui;

import java.awt.*;
import java.text.ParseException;
import java.util.*;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

import kestar.DataManager;
import kestar.data.Vehicle;

import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/**
 * @author Kestutis Taraskevicius
 */
public class BuyTicketDialog extends JDialog {
	
	private static final long serialVersionUID = 1L;
	
	private DataManager dataManager;
	
	public BuyTicketDialog(Frame owner, DataManager dataManager) {
		super(owner);
		this.dataManager = dataManager;
		initComponents();
	}

	public BuyTicketDialog(Dialog owner, DataManager dataManager) {
		super(owner);
		this.dataManager = dataManager;
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		ResourceBundle bundle = ResourceBundle.getBundle("kestar.strings");
		vehicleTypeComboBox = new JComboBox<>();
		vehicleComboBox = new JComboBox<>();
		dateTextField = new JFormattedTextField();
		timeTextField = new JFormattedTextField();
		balanceNameLabel = new JLabel();
		balanceLabel = new JLabel();
		currencyLabel1 = new JLabel();
		fullPriceNameLabel = new JLabel();
		fullPriceLabel = new JLabel();
		currencyLabel2 = new JLabel();
		discountNameLabel = new JLabel();
		discountLabel = new JLabel();
		currencyLabel3 = new JLabel();
		finalPriceNameLabel = new JLabel();
		finalPriceLabel = new JLabel();
		currencyLabel4 = new JLabel();
		buyButton = new JButton();

		//======== this ========
		setTitle(bundle.getString("BuyTicketDialog.this.title"));
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setModal(true);
		setResizable(false);
		Container contentPane = getContentPane();
		contentPane.setLayout(new FormLayout(
			"2dlu, 3*($lcgap, default:grow), $lcgap, default, $lcgap, 2dlu",
			"2dlu, 6*($lgap, default), $lgap, default:grow, $lgap, default, $lgap, 2dlu"));

		//---- vehicleTypeComboBox ----
		for (String item: dataManager.getVehicleTypes()) {
			vehicleTypeComboBox.addItem(item);
		}
		contentPane.add(vehicleTypeComboBox, CC.xywh(3, 3, 7, 1));
		contentPane.add(vehicleComboBox, CC.xywh(3, 5, 7, 1));

		//---- dateTextField ----
		dateTextField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		contentPane.add(dateTextField, CC.xywh(3, 7, 3, 1));
		contentPane.add(timeTextField, CC.xywh(7, 7, 3, 1));

		//---- balanceNameLabel ----
		balanceNameLabel.setText(bundle.getString("BuyTicketDialog.balanceNameLabel.text"));
		contentPane.add(balanceNameLabel, CC.xy(3, 9));
		contentPane.add(balanceLabel, CC.xywh(5, 9, 3, 1, CC.RIGHT, CC.DEFAULT));

		//---- currencyLabel1 ----
		currencyLabel1.setText(bundle.getString("Currency.name"));
		contentPane.add(currencyLabel1, CC.xy(9, 9));

		//---- fullPriceNameLabel ----
		fullPriceNameLabel.setText(bundle.getString("BuyTicketDialog.fullPriceNameLabel.text"));
		contentPane.add(fullPriceNameLabel, CC.xy(3, 11));
		contentPane.add(fullPriceLabel, CC.xywh(5, 11, 3, 1, CC.RIGHT, CC.DEFAULT));

		//---- currencyLabel2 ----
		currencyLabel2.setText(bundle.getString("Currency.name"));
		contentPane.add(currencyLabel2, CC.xy(9, 11));

		//---- discountNameLabel ----
		discountNameLabel.setText(bundle.getString("BuyTicketDialog.discountNameLabel.text"));
		contentPane.add(discountNameLabel, CC.xy(3, 13));
		contentPane.add(discountLabel, CC.xywh(5, 13, 3, 1, CC.RIGHT, CC.DEFAULT));

		//---- currencyLabel3 ----
		currencyLabel3.setText(bundle.getString("Currency.name"));
		contentPane.add(currencyLabel3, CC.xy(9, 13));

		//---- finalPriceNameLabel ----
		finalPriceNameLabel.setText(bundle.getString("BuyTicketDialog.finalPriceNameLabel.text"));
		finalPriceNameLabel.setFont(finalPriceNameLabel.getFont().deriveFont(finalPriceNameLabel.getFont().getSize() + 6f));
		contentPane.add(finalPriceNameLabel, CC.xy(3, 15));
		contentPane.add(finalPriceLabel, CC.xywh(5, 15, 3, 1, CC.RIGHT, CC.DEFAULT));

		//---- currencyLabel4 ----
		currencyLabel4.setText(bundle.getString("Currency.name"));
		contentPane.add(currencyLabel4, CC.xy(9, 15));

		//---- buyButton ----
		buyButton.setText(bundle.getString("BuyTicketDialog.buyButton.text"));
		contentPane.add(buyButton, CC.xywh(3, 17, 7, 1));
		setSize(250, 265);
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
		
		//---- dateFormatter ----
		MaskFormatter dateFormatter = null;
		try {
			dateFormatter = new MaskFormatter("####-##-##");
		} catch (ParseException e) {
			/* do nothing */
		}
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JComboBox<String> vehicleTypeComboBox;
	private JComboBox<Vehicle> vehicleComboBox;
	private JFormattedTextField dateTextField;
	private JFormattedTextField timeTextField;
	private JLabel balanceNameLabel;
	private JLabel balanceLabel;
	private JLabel currencyLabel1;
	private JLabel fullPriceNameLabel;
	private JLabel fullPriceLabel;
	private JLabel currencyLabel2;
	private JLabel discountNameLabel;
	private JLabel discountLabel;
	private JLabel currencyLabel3;
	private JLabel finalPriceNameLabel;
	private JLabel finalPriceLabel;
	private JLabel currencyLabel4;
	private JButton buyButton;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
