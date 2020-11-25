package model.entities;

import java.util.ArrayList;

public abstract class Collaborator {

	private String name;
	private String email;
	
	private ArrayList<Project> projects = new ArrayList<Project>();
	
	private ArrayList<AcademicProduction> academicProductions = new ArrayList<AcademicProduction>();

	public Collaborator(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public ArrayList<Project> getProject() {
		return projects;
	}

	public void addProject(Project project) {
		projects.add(project);
	}
	
	public void removeProject(Project project) {
		projects.remove(project);
	}

	public ArrayList<AcademicProduction> getAcademicProduction() {
		return academicProductions;
	}

	public void addAcademicProduction(AcademicProduction academicProduction) {
		academicProductions.add(academicProduction);
	}
	
	public void removeAcademicProduction(AcademicProduction academicProduction) {
		academicProductions.remove(academicProduction);
	}
	
	@Override
	public abstract String toString();
	
}
