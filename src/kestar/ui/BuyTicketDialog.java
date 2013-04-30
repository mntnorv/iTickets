/*
 * Created by JFormDesigner on Wed Apr 24 16:22:47 EEST 2013
 */

package kestar.ui;

import java.awt.Container;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import kestar.DataManager;
import kestar.data.Client;
import kestar.data.Discount;
import kestar.data.Time;
import kestar.data.Vehicle;

import com.jgoodies.forms.factories.CC;
import com.jgoodies.forms.layout.FormLayout;
import com.toedter.calendar.JDateChooser;

/**
 * @author Kestutis Taraskevicius
 */
public class BuyTicketDialog extends JDialog {
	
	private static final long serialVersionUID = 1L;
	
	private static final DateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");
	
	private boolean initialized;
	private DataManager dataManager;
	private Client client;
	
	public BuyTicketDialog(Frame owner, DataManager dataManager, Client client) {
		super(owner);
		this.dataManager = dataManager;
		this.client = client;
		initialized = false;
		initComponents();
	}

	public BuyTicketDialog(Dialog owner, DataManager dataManager, Client client) {
		super(owner);
		this.dataManager = dataManager;
		this.client = client;
		initialized = false;
		initComponents();
	}
	
	private void updateVehicleComboBox() {
		vehicleComboBox.removeAllItems();
		
		for (Vehicle vehicle: dataManager.getVehicles()) {
			if (vehicle.getType().equals(vehicleTypeComboBox.getSelectedItem())) {
				vehicleComboBox.addItem(vehicle);
			}
		}
	}
	
	private void updatePriceLabels() {
		if (initialized) {
			Calendar dateAndTime = dateChooser.getCalendar();
			Calendar time = GregorianCalendar.getInstance();
			try {
				time.setTime(TIME_FORMAT.parse(timeTextField.getText()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			dateAndTime.set(Calendar.HOUR, time.get(Calendar.HOUR));
			dateAndTime.set(Calendar.MINUTE, time.get(Calendar.MINUTE));
			dateAndTime.set(Calendar.SECOND, time.get(Calendar.SECOND));
			
			Vehicle selectedVehicle = (Vehicle) vehicleComboBox.getSelectedItem();
			double discount = getDiscount(selectedVehicle, dateAndTime, client);
			
			fullPriceLabel.setText(String.format("%.2f", selectedVehicle.getPrice()));
			discountLabel.setText(String.format("%.2f", getDiscount(selectedVehicle, dateAndTime, client)));
			finalPriceLabel.setText(String.format("%.2f", selectedVehicle.getPrice()*(1-discount/100)));
		}
	}
	
	private double getDiscount(Vehicle vehicle, Calendar dateAndTime, Client client) {
		double fullDiscount = 0;
		List<Discount> discounts = dataManager.getDiscounts().get(vehicle.getDiscountGroup());
		for (Discount discount: discounts) {
			if (discount.isApplicable(dateAndTime, client, vehicle)) {
				fullDiscount += discount.getDiscount();
			}
		}
		System.out.println(fullDiscount);
		return fullDiscount;
	}
	
	private boolean isTimeFormatCorrect(String timeStr) {
		boolean isCorrect = true;
		
		try {
			TIME_FORMAT.parse(timeTextField.getText());
		} catch (ParseException e) {
			isCorrect = false;
		}
		
		return isCorrect;
	}
	
	private void timeTextFieldValueChanged() {
		if (isTimeFormatCorrect(timeTextField.getText())) {
			updatePriceLabels();
		}
	}

	private void vehicleTypeComboBoxItemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			updateVehicleComboBox();
			updatePriceLabels();
		}
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - KÄstutis TaraskeviÄius
		ResourceBundle bundle = ResourceBundle.getBundle("kestar.strings");
		vehicleTypeComboBox = new JComboBox<>();
		vehicleComboBox = new JComboBox<>();
		dateChooser = new JDateChooser();
		timeTextField = new JFormattedTextField(TIME_FORMAT);
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
			"2dlu, 2*($lcgap, default:grow), $lcgap, default, $lcgap, 2dlu",
			"2dlu, 6*($lgap, default), $lgap, default:grow, $lgap, default, $lgap, 2dlu"));

		//---- vehicleTypeComboBox ----
		vehicleTypeComboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				vehicleTypeComboBoxItemStateChanged(e);
			}
		});
		for (String item: dataManager.getVehicleTypes()) {
			vehicleTypeComboBox.addItem(item);
		}
		contentPane.add(vehicleTypeComboBox, CC.xywh(3, 3, 5, 1));
		contentPane.add(vehicleComboBox, CC.xywh(3, 5, 5, 1));
		contentPane.add(dateChooser, CC.xy(3, 7));

		//---- timeTextField ----
		contentPane.add(timeTextField, CC.xywh(5, 7, 3, 1));

		//---- balanceNameLabel ----
		balanceNameLabel.setText(bundle.getString("BuyTicketDialog.balanceNameLabel.text"));
		contentPane.add(balanceNameLabel, CC.xy(3, 9));
		contentPane.add(balanceLabel, CC.xywh(5, 9, 2, 1, CC.RIGHT, CC.DEFAULT));

		//---- currencyLabel1 ----
		currencyLabel1.setText(bundle.getString("Currency.name"));
		contentPane.add(currencyLabel1, CC.xy(7, 9));

		//---- fullPriceNameLabel ----
		fullPriceNameLabel.setText(bundle.getString("BuyTicketDialog.fullPriceNameLabel.text"));
		contentPane.add(fullPriceNameLabel, CC.xy(3, 11));
		contentPane.add(fullPriceLabel, CC.xywh(5, 11, 2, 1, CC.RIGHT, CC.DEFAULT));

		//---- currencyLabel2 ----
		currencyLabel2.setText(bundle.getString("Currency.name"));
		contentPane.add(currencyLabel2, CC.xy(7, 11));

		//---- discountNameLabel ----
		discountNameLabel.setText(bundle.getString("BuyTicketDialog.discountNameLabel.text"));
		contentPane.add(discountNameLabel, CC.xy(3, 13));
		contentPane.add(discountLabel, CC.xywh(5, 13, 2, 1, CC.RIGHT, CC.DEFAULT));

		//---- currencyLabel3 ----
		currencyLabel3.setText(bundle.getString("BuyTicketDialog.currencyLabel3.text"));
		contentPane.add(currencyLabel3, CC.xy(7, 13));

		//---- finalPriceNameLabel ----
		finalPriceNameLabel.setText(bundle.getString("BuyTicketDialog.finalPriceNameLabel.text"));
		finalPriceNameLabel.setFont(finalPriceNameLabel.getFont().deriveFont(finalPriceNameLabel.getFont().getSize() + 6f));
		contentPane.add(finalPriceNameLabel, CC.xy(3, 15));
		contentPane.add(finalPriceLabel, CC.xywh(5, 15, 2, 1, CC.RIGHT, CC.DEFAULT));

		//---- currencyLabel4 ----
		currencyLabel4.setText(bundle.getString("Currency.name"));
		contentPane.add(currencyLabel4, CC.xy(7, 15));

		//---- buyButton ----
		buyButton.setText(bundle.getString("BuyTicketDialog.buyButton.text"));
		contentPane.add(buyButton, CC.xywh(3, 17, 5, 1));
		setSize(250, 265);
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
		
		//---- calendars ----
		Calendar now = GregorianCalendar.getInstance();
		dateChooser.setCalendar(now);
		timeTextField.setText((new Time(now)).toString());
		
		balanceLabel.setText(String.format("%.2f", client.getBalance()));
		
		//---- listeners ----
		timeTextField.getDocument().addDocumentListener(new DocumentListener() {		
			@Override
			public void removeUpdate(DocumentEvent e) {
				timeTextFieldValueChanged();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				timeTextFieldValueChanged();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				timeTextFieldValueChanged();
			}
		});
		
		//---- initialized ----
		initialized = true;
		
		updatePriceLabels();
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - KÄstutis TaraskeviÄius
	private JComboBox<String> vehicleTypeComboBox;
	private JComboBox<Vehicle> vehicleComboBox;
	private JDateChooser dateChooser;
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
