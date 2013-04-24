/*
 * Created by JFormDesigner on Wed Apr 24 16:22:47 EEST 2013
 */

package kestar.ui;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/**
 * @author Kestutis Taraskevicius
 */
public class BuyTicketDialog extends JDialog {
	
	private static final long serialVersionUID = 1L;
	
	public BuyTicketDialog(Frame owner) {
		super(owner);
		initComponents();
	}

	public BuyTicketDialog(Dialog owner) {
		super(owner);
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		ResourceBundle bundle = ResourceBundle.getBundle("kestar.strings");
		vehicleTypeComboBox = new JComboBox();
		vehicleComboBox = new JComboBox();
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
			"3*(default:grow, $lcgap), default",
			"6*(default, $lgap), default:grow, $lgap, default"));
		contentPane.add(vehicleTypeComboBox, CC.xywh(1, 1, 7, 1));
		contentPane.add(vehicleComboBox, CC.xywh(1, 3, 7, 1));

		//---- dateTextField ----
		dateTextField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		contentPane.add(dateTextField, CC.xywh(1, 5, 3, 1));
		contentPane.add(timeTextField, CC.xywh(5, 5, 3, 1));

		//---- balanceNameLabel ----
		balanceNameLabel.setText(bundle.getString("BuyTicketDialog.balanceNameLabel.text"));
		contentPane.add(balanceNameLabel, CC.xy(1, 7));
		contentPane.add(balanceLabel, CC.xywh(3, 7, 3, 1, CC.RIGHT, CC.DEFAULT));

		//---- currencyLabel1 ----
		currencyLabel1.setText(bundle.getString("Currency.name"));
		contentPane.add(currencyLabel1, CC.xy(7, 7));

		//---- fullPriceNameLabel ----
		fullPriceNameLabel.setText(bundle.getString("BuyTicketDialog.fullPriceNameLabel.text"));
		contentPane.add(fullPriceNameLabel, CC.xy(1, 9));
		contentPane.add(fullPriceLabel, CC.xywh(3, 9, 3, 1, CC.RIGHT, CC.DEFAULT));

		//---- currencyLabel2 ----
		currencyLabel2.setText(bundle.getString("Currency.name"));
		contentPane.add(currencyLabel2, CC.xy(7, 9));

		//---- discountNameLabel ----
		discountNameLabel.setText(bundle.getString("BuyTicketDialog.discountNameLabel.text"));
		contentPane.add(discountNameLabel, CC.xy(1, 11));
		contentPane.add(discountLabel, CC.xywh(3, 11, 3, 1, CC.RIGHT, CC.DEFAULT));

		//---- currencyLabel3 ----
		currencyLabel3.setText(bundle.getString("Currency.name"));
		contentPane.add(currencyLabel3, CC.xy(7, 11));

		//---- finalPriceNameLabel ----
		finalPriceNameLabel.setText(bundle.getString("BuyTicketDialog.finalPriceNameLabel.text"));
		finalPriceNameLabel.setFont(finalPriceNameLabel.getFont().deriveFont(finalPriceNameLabel.getFont().getSize() + 6f));
		contentPane.add(finalPriceNameLabel, CC.xy(1, 13));
		contentPane.add(finalPriceLabel, CC.xywh(3, 13, 3, 1, CC.RIGHT, CC.DEFAULT));

		//---- currencyLabel4 ----
		currencyLabel4.setText(bundle.getString("Currency.name"));
		contentPane.add(currencyLabel4, CC.xy(7, 13));

		//---- buyButton ----
		buyButton.setText(bundle.getString("BuyTicketDialog.buyButton.text"));
		contentPane.add(buyButton, CC.xywh(1, 15, 7, 1));
		setSize(260, 240);
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JComboBox vehicleTypeComboBox;
	private JComboBox vehicleComboBox;
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
