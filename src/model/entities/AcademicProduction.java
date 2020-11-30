package model.entities;

import java.util.ArrayList;

public abstract class AcademicProduction {
	
	private String title;
	private Project project;
	private ArrayList<Collaborator> authors;
	
	public AcademicProduction(String title) {
		this.title = title;
		this.authors = new ArrayList<Collaborator>();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public ArrayList<Collaborator> getAuthors() {
		return authors;
	}

	public void addAuthor(Collaborator author) {
		authors.add(author);
	}
	
	public void removeAuthor(Collaborator author) {
		authors.remove(author);
	}
	
	@Override
	public abstract String toString();
}
