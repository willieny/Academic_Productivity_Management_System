package model.enums;

public enum StatusProject {

	IN_PREPARATION("Em elaboração"),
	IN_PROCESS("Em andamento"),
	CONCLUDED("Concluído");
	
	private String status;
	
	StatusProject(String status) {
		this.status = status;
	}
	
	public String getStatusProject() {
		return status;
	}
}
