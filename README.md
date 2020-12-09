# Sistema de Gestão de Produtividade Acadêmica

Projeto da disciplina de Projeto de Software (Projeto OO)

## Sobre

Esta aplicação trata-se de um sistema de gestão de produtividade acadêmica que objetiva o gerenciamento da produção acadêmica de um laboratório de pesquisa, incluindo informações sobre projetos de pesquisa e colaboradores. O administrador do sistema é o usuário responsável pela manutenção de todas as informações do sistema. Nesta aplicação, o administrador não precisa fazer cadastro para gerenciar o sistema.
  
  + Um laboratório de pesquisa é formado por colaboradores: alunos de graduação, alunos de mestrado, alunos de doutorado, professores e pesquisadores.
  
  + Os colaboradores de um laboratório podem ser alocados em projetos. Projetos possuem as seguintes informações básicas: título, data de início, data de término, agência financiadora, valor financiado, objetivo, descrição e participantes. Um projeto de pesquisa deve ter pelo menos um professor como participante.
  
  + Os colaboradores de um laboratório possuem dois tipos de produção acadêmica: publicações e orientações. Todos os colaboradores podem ter publicações, porém somente os professores podem ter orientações. Uma publicação é produzida por um ou mais autores. As orientações devem ser feitas por professores, os quais devem orientar alunos do laboratório.
  
  + O status inicial do projeto é "Em elaboração". Se constarem todas as informações básicas sobre o projeto, então o seu status poderá ser alterado para "Em andamento". Após isso, o status poderá ser alterado para "Concluído", porém somente se houver uma ou mais publicações associadas ao projeto.
  
  + Uma publicação só poderá ser associada a um projeto quando o status do projeto estiver “Em andamento”.
  
  + A alocação deve ser permitida apenas quando o projeto estiver “Em elaboração”. Para fazer a alocação de colaboradores é necessário que exista pelo menos um professor alocado no projeto. 
  
  + Um aluno de graduação não pode participar de mais de dois projetos "Em andamento”.
  
Operações que o administrador poderá realizar:

Operação | Nome da operação | Descrição da operação
------------- | ------------- | -------------------
1 | Cadastrar colaborador | Adiciona os dados de um colaborador
2 | Cadastrar projeto | Adiciona os dados de um projeto
3 | Cadastrar produção acadêmica | Adiciona os dados de uma produção acadêmica
4 | Editar as informações básicas de um projeto | Ajusta as informações presentes em um projeto
5 | Alterar status do projeto | Consiste em trocar o status do projeto
6 | Alocar participantes a um projeto | Adiciona um participante em um projeto 
7 | Alocar autores a uma produção acadêmica | Adiciona um autor em uma produção acadêmica
8 | Associar produção acadêmica a um projeto | Adiciona uma produção acadêmica em um projeto
9 | Remover colaborador de um projeto | Consiste em remover um participante de um projeto
10 | Consultar colaborador | Exibe todas as informações de um colaborador incluindo os projetos e as produções acadêmicas que faz parte
11 | Consultar projeto | Exibe todas as informações de um projeto incluindo os participantes e as produções acadêmicas associados
12 | Relatório de produções do laboratório | Exibe a quantidade de colaboradores, projetos e produções acadêmicas presentes no laboratório
0 | Sair | Sai da aplicação

## Diagrama UML

![Screenshot_2](https://user-images.githubusercontent.com/32077255/101590835-f1086100-39c9-11eb-84cc-1995be01bd19.png)

## Nota

Aplicação executada pelo terminal e testada no sistema operacional Linux (Ubuntu 18.04). Dessa forma, o seguinte método poderá apresentar inconsistências nos demais sistemas.
```
public static void clearScreen() {
	System.out.println("\033[H\033[2J");
	System.out.flush();
}

