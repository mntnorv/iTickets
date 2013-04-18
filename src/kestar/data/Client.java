package kestar.data;

public class Client {
	private String firstName;
	private String lastName;
	private char sex;
	private String socialGroup;
	
	public Client() {
		firstName = "";
		lastName = "";
		sex = ' ';
		socialGroup = "";
	}

	public Client(String firstName, String lastName, char sex,
			String socialGroup) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.sex = sex;
		this.socialGroup = socialGroup;
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

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public String getSocialGroup() {
		return socialGroup;
	}

	public void setSocialGroup(String socialGroup) {
		this.socialGroup = socialGroup;
	}
}
