package model.entities;

import java.util.ArrayList;

public abstract class Collaborator {

	private int id;
	private String name;
	private String email;
	
	private ArrayList<Project> projects = new ArrayList<Project>();
	
	private ArrayList<Publication> publications = new ArrayList<Publication>();

	public Collaborator(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
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

	public ArrayList<Publication> getPublications() {
		return publications;
	}

	public void addPublication(Publication publication) {
		publications.add(publication);
	}
	
	public void removePublication(Publication publication) {
		publications.remove(publication);
	}
	
	@Override
	public abstract String toString();
	
}
