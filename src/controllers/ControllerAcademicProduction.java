package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import model.entities.Collaborator;
import model.entities.Orientation;
import model.entities.Publication;
import model.entities.Teacher;
import views.Menu;

public class ControllerAcademicProduction {
	
	Scanner sc = new Scanner(System.in);
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
	
	protected ArrayList<Publication> publications = new ArrayList<Publication>();
	protected ArrayList<Orientation> orientations = new ArrayList<Orientation>();
	
	public void register(ControllerCollaborator controllerCollaborator) throws ParseException {
		Menu.showMenuAcademicProduction();
		int type = sc.nextInt();
		sc.nextLine();
		System.out.print("Título: ");
		String title = sc.nextLine();
		switch(type) {
			case 1: 
				if(checkTitlePublication(title)) {
					System.out.println("Título já foi cadastrado.");	
				}else {
					System.out.print("Conferência onde foi publicada: ");
					String conference = sc.nextLine();
					System.out.print("Ano de publicação: ");
					Date year = sdf.parse(sc.nextLine());
					Publication publication = new Publication(title, conference, year);
					publications.add(publication);
					System.out.println("\nPublicação foi cadastrada com sucesso!");
				}
				break;
			case 2:
				if(checkTitleOrientation(title)) {
					System.out.println("Título já foi cadastrado.");
				}
				else {
					System.out.print("Id do professor: ");
					int id = sc.nextInt();
					sc.nextLine();
					if(controllerCollaborator.checkId(id)) {
						Teacher teacher = (Teacher)controllerCollaborator.findTeacher(id);
						Orientation orientation = new Orientation(title, teacher);
						orientations.add(orientation);
						teacher.addOrientation(orientation);
						System.out.println("\nOrientação foi cadastrada com sucesso!");
					}else {
						System.out.println("Id não encontrado.");
					}
				}
				break;
		}
		System.out.println("Pressione ENTER para continuar.");
		sc.nextLine();
	}
	
	public void allocationOfParticipants(ControllerCollaborator controllerCollaborator) {		
		Menu.showMenuAcademicProduction();
		int type = sc.nextInt();
		sc.nextLine(); 
		System.out.print("Título da produção acadêmica: ");
		String title = sc.nextLine();
		System.out.print("Id do colaborador a ser alocado: ");
		int id = sc.nextInt();
		sc.nextLine();
		if(controllerCollaborator.checkId(id)) {
			Collaborator collaborator = controllerCollaborator.findCollaborator(id);
			switch(type) {
			case 1:
				if(checkTitlePublication(title)) {
					Publication publication = findPublication(title);
					if(haveAuthorPublication(publication, id)) {
						System.out.println("\nAutor já está alocado.");
					}else {
						publication.addAuthor(collaborator);
						collaborator.addPublication(publication);
						System.out.println("\nAutor foi alocado na publicação.");
					}
				}else {
					System.out.println("\nTítulo não encontrado.");
				}	
				break;
			case 2:
				if(checkTitleOrientation(title)) {
					Orientation orientation = findOrientation(title);
					if(haveAuthorOrientation(orientation, id) || haveTeacher(orientation, id)) {
						System.out.println("\nAutor já está alocado.");
					}else {
						orientation.addAuthor(collaborator);
						System.out.println("\nAutor foi alocado na orientação.");
					}
				}else {
					System.out.println("\nTítulo não encontrado.");
				}
				break;
			}
		}else {
			System.out.println("\nId não encontrado.");
		}
		System.out.println("Pressione ENTER para continuar.");
		sc.nextLine();
	}
	
	public boolean haveAuthorPublication(Publication publication, int id) {
		for(Collaborator c : publication.getAuthors()) {
			if(c.getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	public boolean haveAuthorOrientation(Orientation orientation, int id) {
		for(Collaborator c : orientation.getAuthors()) {
			if(c.getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	public boolean haveTeacher(Orientation orientation, int id) {
		if(orientation.getTeacher().getId() == id) {
			return true;
		}
		return false;
	}
	
	public Publication findPublication(String title) {
		for(Publication p : publications) {
	       if(p.getTitle().equals(title)) {
	           return p;
	       }
		}
		return null;
	}
	
	public Orientation findOrientation(String title) {
		for(Orientation o : orientations) {
	       if(o.getTitle().equals(title)) {
	           return o;
	       }
		}
		return null;
	}
	
	public boolean checkTitlePublication(String title) {
		for(Publication p : publications) {
			if(p.getTitle().equals(title)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkTitleOrientation(String title) {
		for(Orientation o : orientations) {
			if(o.getTitle().equals(title)) {
				return true;
			}
		}
		return false;
	}
}
