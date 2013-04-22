package kestar.data;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Client {
	private String firstName;
	private String lastName;
	private String sex;
	private String socialGroup;
	private Calendar birthday;
	private double balance;
	
	public Client() {
		firstName = "";
		lastName = "";
		sex = "";
		socialGroup = "";
		birthday = new GregorianCalendar();
	}

	public Client(String firstName, String lastName, String sex,
			String socialGroup, Calendar birthday, double balance) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.sex = sex;
		this.socialGroup = socialGroup;
		this.birthday = birthday;
		this.balance = balance;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSocialGroup() {
		return socialGroup;
	}

	public void setSocialGroup(String socialGroup) {
		this.socialGroup = socialGroup;
	}

	public Calendar getBirthday() {
		return birthday;
	}

	public void setBirthday(Calendar birthday) {
		this.birthday = birthday;
	}
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@JsonIgnore
	public int getAge() {
		Calendar now = GregorianCalendar.getInstance();
		int age = now.get(Calendar.YEAR) - birthday.get(Calendar.YEAR);
		
		now.set(Calendar.YEAR, birthday.get(Calendar.YEAR));
		if (now.compareTo(birthday) < 0) {
			age--;
		}
		
		return age;
	}
}
