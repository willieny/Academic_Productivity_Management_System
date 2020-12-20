package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import model.entities.Collaborator;
import model.entities.Orientation;
import model.entities.Publication;
import model.entities.Teacher;
import views.Menu;

public class ControllerAcademicProduction {
	
	Scanner sc = new Scanner(System.in);
	Random rd = new Random();
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
	
	protected ArrayList<Publication> publications = new ArrayList<Publication>();
	protected ArrayList<Orientation> orientations = new ArrayList<Orientation>();
	
	public void register(ControllerCollaborator controllerCollaborator) throws ParseException {
		Menu.showMenuAcademicProduction();
		int type = sc.nextInt();
		sc.nextLine();
		System.out.print("Título: ");
		String title = sc.nextLine();
		int id = rd.nextInt(1000);
		switch(type) {
			case 1: 
				while(checkIdPublication(id)) {
					id = rd.nextInt();
				}
				System.out.print("Conferência onde foi publicada: ");
				String conference = sc.nextLine();
				System.out.print("Ano de publicação: ");
				Date year = sdf.parse(sc.nextLine());
				Publication publication = new Publication(id, title, conference, year);
				publications.add(publication);
				System.out.println("\nPublicação foi cadastrada com sucesso!");
				break;
			case 2:
				while(checkIdPublication(id)) {
					id = rd.nextInt();
				}
				System.out.print("Id do professor: ");
				int idP = sc.nextInt();
				sc.nextLine();
				if(controllerCollaborator.checkId(idP)) {
					Teacher teacher = (Teacher)controllerCollaborator.findTeacher(idP);
					Orientation orientation = new Orientation(id, title, teacher);
					orientations.add(orientation);
					teacher.addOrientation(orientation);
					System.out.println("\nOrientação foi cadastrada com sucesso!");
				}else {
					System.out.println("Id não foi encontrado.");
				}
				break;
			default:
				System.out.println("Opção inválida.");
				break;
		}
		System.out.println("Pressione ENTER para continuar.");
		sc.nextLine();
	}
	
	public void allocationOfAuthors(ControllerCollaborator controllerCollaborator) {		
		Menu.showMenuAcademicProduction();
		int type = sc.nextInt();
		sc.nextLine(); 
		switch(type) {
			case 1:
				printPublications();
				break;
			case 2:
				printOrientations();
				break;
		}
		controllerCollaborator.print();
		System.out.print("Id da produção acadêmica: ");
		int id = sc.nextInt();
		System.out.print("Id do colaborador a ser alocado: ");
		int idC = sc.nextInt();
		sc.nextLine();
		if(controllerCollaborator.checkId(idC) && (checkIdPublication(id) || checkIdOrientation(id))) {
			Collaborator collaborator = controllerCollaborator.findCollaborator(idC);
			switch(type) {
			case 1:
				Publication publication = findPublication(id);
				if(haveAuthorPublication(publication, idC)) {
					System.out.println("\nAutor já está alocado.");
				}else {
					publication.addAuthor(collaborator);
					collaborator.addPublication(publication);
					System.out.println("\nAutor foi alocado na publicação.");
				}
				break;
			case 2:
				Orientation orientation = findOrientation(id);
				if(haveAuthorOrientation(orientation, idC) || haveTeacher(orientation, idC)) {
					System.out.println("\nAutor já está alocado.");
				}else {
					orientation.addAuthor(collaborator);
					System.out.println("\nAutor foi alocado na orientação.");
				}
				break;
			}
		}else {
			System.out.println("\nId da produção acadêmica ou do colaborador não foi encontrado.");
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
	
	public Publication findPublication(int id) {
		for(Publication p : publications) {
	       if(p.getId() == id) {
	           return p;
	       }
		}
		return null;
	}
	
	public Orientation findOrientation(int id) {
		for(Orientation o : orientations) {
	       if(o.getId() == id) {
	           return o;
	       }
		}
		return null;
	}
	
	public boolean checkIdPublication(int id) {
		for(Publication p : publications) {
			if(p.getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkIdOrientation(int id) {
		for(Orientation o : orientations) {
			if(o.getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	public void printPublications() {
		if(publications.size() > 0) {
			System.out.println("-------Publicações Cadastradas------");
			for(Publication p : publications) {
				System.out.println("Id: " + p.getId() + "\nTítulo: " + p.getTitle());
				System.out.println("------------------------------------");	
			}
		}
	}
	
	public void printOrientations() {
		if(orientations.size() > 0) {
			System.out.println("-------Orientações Cadastradas------");
			for(Orientation o : orientations) {
				System.out.println("Id: " + o.getId() + "\nTítulo: " + o.getTitle());
				System.out.println("------------------------------------");	
			}
		}
	}
	
}
