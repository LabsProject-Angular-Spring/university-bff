package labsproject.bff.entity;

public class Lab{


	private Long id;
	
	private String name;
	
	private Long buildingid;
	
	public Lab(long id, String name, Long buildingid) {
		this.id = id;
		this.name = name;
		this.buildingid = buildingid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Long getBuildingId() {
		return buildingid;
	}

	public void setBuildingId(Long buildingid) {
		this.buildingid = buildingid;
	}
	
}
