package kestar.data;

public class VehicleType {
	private int id;
	private String name;
	
	public VehicleType() {
		id = 0;
		name = "";
	}

	public VehicleType(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
