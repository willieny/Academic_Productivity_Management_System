package model.enums;

public enum TypeStudent {
	
	GRADUATE_STUDENT("Aluno de Graduação"),
	MASTER_STUDENT("Aluno de Mestrado"),
	PHD_STUDENT("Aluno de Doutorado"),
	RESEARCHER("Pesquisador");
	
	private String type;
	
	TypeStudent(String type) {
		this.type = type;
	}
	
	public String getTypeStudent() {
		return type;
	}
}
