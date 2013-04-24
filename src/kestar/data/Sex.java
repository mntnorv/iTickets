package kestar.data;

import java.util.ResourceBundle;

public class Sex {
	private String id;
	private String name;
	
	private Sex(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	//================================================================================
	// Static
	//================================================================================
	
	public static final Sex MALE;
	public static final Sex FEMALE;
	
	static {
		ResourceBundle resBundle = ResourceBundle.getBundle("kestar.strings");
		MALE = new Sex("m", resBundle.getString("Sex.male.text"));
		FEMALE = new Sex("f", resBundle.getString("Sex.female.text"));
	}
}
