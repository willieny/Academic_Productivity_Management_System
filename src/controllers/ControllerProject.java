package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import model.entities.Collaborator;
import model.entities.Project;
import model.entities.Publication;
import model.enums.StatusProject;

public class ControllerProject {
	
	Scanner sc = new Scanner(System.in);
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	protected ArrayList<Project> projects = new ArrayList<Project>();

	public void register() throws ParseException {
		System.out.print("Título: ");
		String title = sc.nextLine();
		if(checkTitle(title)) {
			System.out.println("Título já existente.");
		}else {
			System.out.print("Data de início (dd/MM/yyyy): ");
			Date start = sdf.parse(sc.nextLine());
			System.out.print("Data de término (dd/MM/yyyy): ");
			Date finish = sdf.parse(sc.nextLine());
			System.out.print("Agência financiadora: ");
			String agency = sc.nextLine();
			System.out.print("Valor financiado: ");
			double amount = sc.nextDouble();
			sc.nextLine();
			System.out.print("Objetivo: ");
			String objective = sc.nextLine();
			System.out.print("Descrição: ");
			String description = sc.nextLine();
			
			Project project = new Project(title, start, finish, agency, amount, objective, description, StatusProject.IN_PREPARATION);
			projects.add(project);
			
			System.out.println("\nStatus do projeto: " + project.getStatus().getStatusProject()+ "\n");
		}
	}
	
	public void allocationOfParticipants(ControllerCollaborator controllerCollaborator) {
		System.out.print("Título do projeto: ");
		String title = sc.nextLine();
		Project project = findProject(title);
		
		if(project.getStatus() == StatusProject.IN_PROCESS) {
			System.out.print("Nome do colaborador a ser alocado: ");
			String name = sc.nextLine();
			Collaborator collaborator = controllerCollaborator.findCollaborator(name);
			
			if(project.getCollaborators().isEmpty()) {
				if(controllerCollaborator.isTeacher(collaborator)) {
					project.addCollaborator(collaborator);
					//collaborator.addProject(project);
				}
				else {
					System.out.println("O projeto não possui professores alocados. Adicione pelo menos um.");
				}
			}
			else {
				project.addCollaborator(collaborator);
				//collaborator.addProject(project);
			}
		}
		else {
			System.out.println("Altere o status do projeto para \"Em andamento\"");
		}
	}
	
	public void statusChange() {
		System.out.print("Título do projeto: ");
		String title = sc.nextLine();
		Project project = findProject(title);
		System.out.println("\nStatus atual: " + project.getStatus().getStatusProject());
		
		System.out.print("Alterar status(s/n)? ");
		char c = sc.next().charAt(0);
		sc.nextLine();
		
		if(c == 's') {
			if(checkInformation(project)) {
				System.out.println("Informações básicas incompletas.");
			}
			else {
				if(project.getStatus() == StatusProject.IN_PREPARATION) {
					project.setStatus(StatusProject.IN_PROCESS);
				}
				else if(project.getStatus() == StatusProject.IN_PROCESS && project.getPublications().size() > 0) {
					project.setStatus(StatusProject.CONCLUDED);
				}
				System.out.println("\nNovo status: " + project.getStatus().getStatusProject());
			}
		}
		System.out.println(project);
	}
	
	public void associatePublication(ControllerAcademicProduction controllerAcademicProduction) {
		System.out.print("Título do projeto: ");
		String title = sc.nextLine();
		Project project = findProject(title);
		System.out.println("Título da publicação: ");
		String titlePublication = sc.nextLine();
		Publication publication = (Publication)controllerAcademicProduction.findAcademicProduction(titlePublication);
		project.addPublication(publication);	
	}
	
	public Project findProject(String title) {
		for(Project p : projects) {
	       if(p.getTitle().equals(title)) {
	           return p;
	       }
		}
		return null;
	}
	
	public boolean checkInformation(Project project) {
		if(project.getFundingAgency().equals("") || project.getObjective().equals("") || project.getDescription().equals("")) {
			return true;
		}
		return false;
	}
	
	public boolean checkTitle(String title) {
		for(Project p : projects) {
			if(p.getTitle().equals(title)) {
				return true;
		    }
		}
		return false;
	}
	
	public void print() {
		for(Project p : projects) {
			System.out.println(p);
		}
	}
}
