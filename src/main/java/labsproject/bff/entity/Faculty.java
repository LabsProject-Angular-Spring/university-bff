package labsproject.bff.entity;


public class Faculty {

	public Faculty(long id, String name) {
		this.id = id;
		this.name = name;
	}

	private Long id;
	
	private String name;		


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
	
}
