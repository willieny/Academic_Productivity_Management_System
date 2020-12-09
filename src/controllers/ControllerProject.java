package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import model.entities.Collaborator;
import model.entities.Project;
import model.entities.Publication;
import model.entities.Student;
import model.enums.StatusProject;
import model.enums.TypeStudent;

public class ControllerProject {
	
	Scanner sc = new Scanner(System.in);
	Random rd = new Random();
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	protected ArrayList<Project> projects = new ArrayList<Project>();

	public void register() throws ParseException {
		System.out.print("Título: ");
		String title = sc.nextLine();
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
		int id = rd.nextInt(1000);
		while(checkId(id)) {
			id = rd.nextInt();
		}
		Project project = new Project(id, title, start, finish, agency, amount, objective, description, StatusProject.IN_PREPARATION);
		projects.add(project);
		System.out.println(project);
		System.out.println("\nProjeto foi cadastrado com sucesso!");
		System.out.println("Pressione ENTER para continuar.");
		sc.nextLine();
	}
	
	public void editProjectInformation() throws ParseException {
		System.out.print("Id do projeto: ");
		int id = sc.nextInt();
		sc.nextLine();
		Project project = findProject(id);
		if(checkId(id)) {
			System.out.print("Título: ");
			String title = sc.nextLine();
			project.setTitle(title);
			System.out.print("Data de início (dd/MM/yyyy): ");
			Date start = sdf.parse(sc.nextLine());
			project.setStart(start);
			System.out.print("Data de término (dd/MM/yyyy): ");
			Date finish = sdf.parse(sc.nextLine());
			project.setFinish(finish);
			System.out.print("Agência financiadora: ");
			String agency = sc.nextLine();
			project.setFundingAgency(agency);
			System.out.print("Valor financiado: ");
			double amount = sc.nextDouble();
			sc.nextLine();
			project.setAmount(amount);
			System.out.print("Objetivo: ");
			String objective = sc.nextLine();
			project.setObjective(objective);
			System.out.print("Descrição: ");
			String description = sc.nextLine();
			project.setDescription(description);
			System.out.println(project);
			System.out.println("\nProjeto foi atualizado com sucesso!");
		}else {
			System.out.println("\nId do projeto não encontrado.");
		}
		System.out.println("Pressione ENTER para continuar.");
		sc.nextLine();
	}
	
	public void allocationOfParticipants(ControllerCollaborator controllerCollaborator) {
		System.out.print("Id do projeto: ");
		int id = sc.nextInt();
		System.out.print("Id do colaborador a ser alocado: ");
		int idc = sc.nextInt();
		sc.nextLine();
		if(checkId(id) && controllerCollaborator.checkId(idc)) {
			Project project = findProject(id);
			if(project.getStatus() == StatusProject.IN_PREPARATION) {
				Collaborator collaborator = controllerCollaborator.findCollaborator(idc);
				if(haveCollarator(project, idc)) {
					System.out.println("\nColaborador já está alocado.");
				}else {
					if(project.getCollaborators().isEmpty()) {
						if(controllerCollaborator.isTeacher(collaborator)) {
							project.addCollaborator(collaborator);	
							collaborator.addProject(project);
							System.out.println("\nColaborador foi alocado no projeto.");
						}
						else {
							System.out.println("\nO projeto não possui professores alocados. Adicione pelo menos um.");
						}
					}
					else {
						project.addCollaborator(collaborator);
						collaborator.addProject(project);
						System.out.println("\nColaborador foi alocado no projeto.");
					}
				}
			}		
			else {
				System.out.println("\nAltere o status do projeto para \"Em andamento\"");
			}
		}else {
			System.out.println("\nId do projeto ou do colaborador não encontrado.");
		}
		System.out.println("Pressione ENTER para continuar.");
		sc.nextLine();
	}
	
	public void statusChange() {
		System.out.print("Id do projeto: ");
		int id = sc.nextInt();
		sc.nextLine();
		if(checkId(id)) {
			Project project = findProject(id);
			System.out.println("\nStatus atual: " + project.getStatus().getStatusProject());
			System.out.print("Alterar status(s/n)? ");
			char c = sc.next().charAt(0);
			sc.nextLine();
			if(c == 's') {
				if(checkInformation(project) && project.getCollaborators().size() > 0) {
					System.out.println("\nInformações básicas incompletas.");
				}
				else {
					if(project.getStatus() == StatusProject.IN_PREPARATION) {
						if(studentMore2InProgress(project)) {
							System.out.println("\nO estudante do Id:" + IdstudentMore2InProgress(project) + " possui mais de 2 projetos \"Em andamento\". "
									+ "\nPara alterar o status do projeto atual é necessário que remova o estudante especificado.");
						}else {
							project.setStatus(StatusProject.IN_PROCESS);
							System.out.println("\nNovo status: " + project.getStatus().getStatusProject());
						}
					}
					else if(project.getStatus() == StatusProject.IN_PROCESS && project.getPublications().size() > 0) {
						project.setStatus(StatusProject.CONCLUDED);
						System.out.println("\nNovo status: " + project.getStatus().getStatusProject());
					}	
				}
			}
		}else {
			System.out.println("\nId não encontrado.");
		}	
		System.out.println("Pressione ENTER para continuar.");
		sc.nextLine();
	}
	
	public void associatePublication(ControllerAcademicProduction controllerAcademicProduction) {
		System.out.print("Id do projeto: ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.print("Título da publicação: ");
		String title = sc.nextLine();
		if(checkId(id) && controllerAcademicProduction.checkTitlePublication(title)) {
			Project project = findProject(id);
			if(havePublication(project, title)) {
				System.out.println("\nA publicação já está associada ao projeto.");
			}else {
				Publication publication = controllerAcademicProduction.findPublication(title);
				project.addPublication(publication);
				publication.setProject(project);
				System.out.println("\nA publicação foi associada ao projeto.");
			}	
		}else {
			System.out.println("\nId ou título não encontrado.");
		}	
		System.out.println("Pressione ENTER para continuar.");
		sc.nextLine();
	}
	
	public void consultProject() {
		System.out.print("Id do projeto: ");
		int id = sc.nextInt();
		sc.nextLine();
		if(checkId(id)) {
			Project project = findProject(id);
			SortByDate.sortPublication(project.getPublications());
			System.out.println(project + "\n");
			if(project.getCollaborators().size()>0) {
				int k=1;
				System.out.println("-----------------------------");
				for(int i=0; i<project.getCollaborators().size(); i++) {
					System.out.print("Colaborador #" + k);
					System.out.println(project.getCollaborators().get(i) + "\n");
					k++;
				}
				System.out.println("-----------------------------");
			}else {
				System.out.println("-----------------------------");
				System.out.println("Sem colaboradores.");
				System.out.println("-----------------------------");
			}
			if(project.getPublications().size()>0) {
				int l=1;
				System.out.println("-----------------------------");
				for(int i=0; i<project.getPublications().size(); i++) {
					System.out.print("Publicação #" + l);
					System.out.println(project.getPublications().get(i) + "\n");
					l++;
				}
				System.out.println("-----------------------------");
			}else {
				System.out.println("-----------------------------");
				System.out.println("Sem publicações.");
				System.out.println("-----------------------------");
			}
		}else {
			System.out.println("\nId não encontrado.");
		}
		System.out.println("Pressione ENTER para continuar.");
		sc.nextLine();
	}
	
	public void removerCollaborator(ControllerCollaborator controllerCollaborator) {
		System.out.print("Id do projeto: ");
		int id = sc.nextInt();
		System.out.print("Id do colaborador a ser alocado: ");
		int idc = sc.nextInt();
		sc.nextLine();
		if(checkId(id) && controllerCollaborator.checkId(idc)) {
			Project project = findProject(id);
			Collaborator collaborator = controllerCollaborator.findCollaborator(idc);
			project.removeCollaborator(collaborator);
			collaborator.removeProject(project);
			System.out.println("\nColaborador foi removido.");
		}else {
			System.out.println("\nId não encontrado.");
		}
		System.out.println("Pressione ENTER para continuar.");
		sc.nextLine();
	}
	
	public boolean studentMore2InProgress(Project project) {
		for(Collaborator c : project.getCollaborators()) {
			if(c instanceof Student) {
				Student student = (Student)c;
				if(student.getTypeStudent() == TypeStudent.GRADUATE_STUDENT) {
					if(haveMore2(student) == 2) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public int IdstudentMore2InProgress(Project project) {
		for(Collaborator c : project.getCollaborators()) {
			if(c instanceof Student) {
				Student student = (Student)c;
				if(student.getTypeStudent() == TypeStudent.GRADUATE_STUDENT) {
					if(haveMore2(student) == 2) {
						return student.getId();
					}
				}

			}
		}
		return 0;
	}
	
	public int haveMore2(Student student) {
		int i=0;
		for(Project j : student.getProject()) {
			if(j.getStatus() == StatusProject.IN_PROCESS) {
				i++;	
			}
		}
		return i;
	}
	
	public boolean havePublication(Project project, String title) {
		for(Publication p : project.getPublications()) {
			if(p.getTitle().equals(title)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean haveCollarator(Project project, int id) {
		for(Collaborator c : project.getCollaborators()) {
			if(c.getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	public int numberOfInPreparation() {
		int in_preparation = 0;
		
		for(Project j : projects) {
			if(j.getStatus() == StatusProject.IN_PREPARATION) {
				in_preparation+=1;
			}
		}
		return in_preparation;
	}
	
	public int numberOfInProcess() {
		int in_process = 0;
		
		for(Project j : projects) {
			if(j.getStatus() == StatusProject.IN_PROCESS) {
				in_process+=1;
			}
		}
		return in_process;
	}
	
	public int numberOfConcluded() {
		int concluded = 0;
		
		for(Project j : projects) {
			if(j.getStatus() == StatusProject.CONCLUDED) {
				concluded+=1;
			}
		}
		return concluded;
	}
	
	public Project findProject(int id) {
		for(Project p : projects) {
	       if(p.getId() == id) {
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
	
	public boolean checkId(int id) {
		for(Project p : projects) {
			if(p.getId() == id) {
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
