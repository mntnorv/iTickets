package kestar.data;

public class SocialGroup {
	private String id;
	private String name;
	private double discount;
	
	public SocialGroup() {
		id = "";
		name = "";
		discount = 0;
	}

	public SocialGroup(String id, String name, double discount) {
		super();
		this.id = id;
		this.name = name;
		this.discount = discount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
}
