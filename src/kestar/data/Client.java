package kestar.data;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Client {
	private String firstName;
	private String lastName;
	private String sex;
	private String socialGroup;
	private Calendar birthday;
	
	public Client() {
		firstName = "";
		lastName = "";
		sex = "";
		socialGroup = "";
		birthday = new GregorianCalendar();
	}

	public Client(String firstName, String lastName, String sex,
			String socialGroup, Calendar birthday) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.sex = sex;
		this.socialGroup = socialGroup;
		this.birthday = birthday;
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
}
