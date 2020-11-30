package views;

public class Menu {
	
	public static void showMenu() {
		System.out.println("#-------- Sistema de Gestão de Produtividade Acadêmica --------#\n");
		System.out.print("Selecione uma opção: \n"
				+ "[1] Cadastrar colaborador\n"
				+ "[2] Cadastrar projeto\n"
				+ "[3] Cadastrar produção acadêmica\n"
				+ "[4] Alocar participantes a um projeto\n"
				+ "[5] Alocar autores a uma produção acadêmica\n"
				+ "[6] Alterar status do projeto\n"
				+ "[7] Associar produção acadêmica a um projeto\n"
				+ "[8] Consultar colaborador\n"
				+ "[9] Consultar projeto\n"
				+ "[10] Relatório de produção acadêmica\n"
				+ "[0] Sair\n"
				+ "==> ");
	}
	
	public static void showMenuCollaborator() {
		System.out.print("\nSelecione o tipo de colaborador:\n"
				+ "[1] - professor\n"
				+ "[2] - aluno de gradução\n"
				+ "[3] - aluno de mestrado\n"
				+ "[4] - aluno de doutorado\n"
				+ "[5] - pesquisador\n"
				+ "==> ");
	}
	
	public static void showMenuAcademicProduction() {
		System.out.print("Selecione o tipo de produção acadêmica: \n"
				+ "[1] Publicação\n"
				+ "[2] Orientação\n"
				+ "==> ");
	}
}
