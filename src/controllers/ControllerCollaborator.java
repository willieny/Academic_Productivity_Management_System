package controllers;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import model.entities.Collaborator;
import model.entities.Student;
import model.entities.Teacher;
import model.enums.TypeStudent;
import views.Menu;

public class ControllerCollaborator {
	
	Scanner sc = new Scanner(System.in);
	Random rd = new Random();
	
	protected ArrayList<Collaborator> collaborators = new ArrayList<Collaborator>();
	
	public void register() {
		Menu.showMenuCollaborator();
		int type = sc.nextInt();
		sc.nextLine();
		System.out.print("Nome: ");
		String name = sc.nextLine();
		System.out.print("e-mail: ");
		String email = sc.nextLine();
		int id = rd.nextInt(1000);
		while(checkId(id)) {
			id = rd.nextInt();
		}
		typeCollaborator(type, id, name, email);
		System.out.println(findCollaborator(id));
		System.out.println("\nColaborador foi cadastrado com sucesso!");
		System.out.println("Pressione ENTER para continuar.");
		sc.nextLine();
	}
	
	public boolean typeCollaborator(int type, int id, String name, String email) {
		Collaborator collaborator = null;
		switch(type) {
			case 1:
				collaborator = new Teacher(id, name, email);
				break;
			case 2:
				collaborator = new Student(id, name, email, TypeStudent.GRADUATE_STUDENT);
				break;
			case 3:
				collaborator = new Student(id, name, email, TypeStudent.MASTER_STUDENT);
				break;
			case 4:
				collaborator = new Student(id, name, email, TypeStudent.PHD_STUDENT);
				break;
			case 5:
				collaborator = new Student(id, name, email, TypeStudent.RESEARCHER);
				break;
		}
		collaborators.add(collaborator);
		return true;
	}

	public void consultCollaborator() {
		System.out.print("Id do colaborador: ");
		int id = sc.nextInt();
		sc.nextLine();
		if(checkId(id)) {
			Collaborator collaborator = findCollaborator(id);
			SortByDate.sortProject(collaborator.getProject());
			SortByDate.sortPublication(collaborator.getPublications());
			System.out.println(collaborator + "\n");
			if(collaborator.getProject().size() > 0) {
				int k=1;
				System.out.println("-----------------------------");
				for(int i=0; i<collaborator.getProject().size(); i++) {
					System.out.print("Projeto #" + k);
					System.out.println(collaborator.getProject().get(i) + "\n");
					k++;
				}
				System.out.println("-----------------------------");
			}else {
				System.out.println("-----------------------------");
				System.out.println("Sem projetos.");
				System.out.println("-----------------------------");
			}
			if(collaborator.getPublications().size() > 0) {
				int l=1;
				System.out.println("-----------------------------");
				for(int i=0; i<collaborator.getPublications().size(); i++) {
					System.out.print("Publicação #" + l);
					System.out.println(collaborator.getPublications().get(i) + "\n");
					l++;
				}
				System.out.println("-----------------------------");
			}else {
				System.out.println("-----------------------------");
				System.out.println("Sem publicações.");
				System.out.println("-----------------------------");
			}

			if(collaborator instanceof Teacher) {
				Teacher teacher = (Teacher)collaborator;
				if(teacher.getOrientations().size() > 0) {
					int m=1;
					System.out.println("-----------------------------");
					for(int i=0; i<teacher.getOrientations().size(); i++) {
						System.out.print("Orientação #" + m);
						System.out.println(teacher.getOrientations().get(i) + "\n");
						m++;
					}
					System.out.println("-----------------------------");
				}else {
					System.out.println("-----------------------------");
					System.out.println("Sem orientações.");
					System.out.println("-----------------------------");
				}
			}
		}else {
			System.out.println("\nId não encontrado.");
		}
		System.out.println("Pressione ENTER para continuar.");
		sc.nextLine();
	}
	
	public Collaborator findTeacher(int id) {
		for(Collaborator c : collaborators) {
			 if (c instanceof Teacher) {
				 if(c.getId() == id) {
		               return c;
				}
             }
		}
		return null;
	}
	
	public Collaborator findCollaborator(int id) {
		for(Collaborator c : collaborators) {
			if(c.getId() == id) {
               return c;
			}
		}
		return null;
	}
	public boolean isTeacher(Collaborator collaborator) {
		if(collaborator instanceof Teacher) {
			return true;
		}
		return false;
	}
	
	public boolean isStudent(Collaborator collaborator) {
		if(collaborator instanceof Student) {
			return true;
		}
		return false;
	}
	
	public boolean checkId(int id) {
		for(Collaborator c : collaborators) {
			if(c.getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	public void print() {
		if(collaborators.size() > 0) {
			System.out.println("------Colaboradores Cadastrados-----");
			for(Collaborator c : collaborators) {
				System.out.println("Id: " + c.getId() + "\nNome: " + c.getName());
				System.out.println("------------------------------------");	
			}
		}
	}
}
