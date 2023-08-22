package controller;
import model.*;
import java.util.List;
import java.util.Scanner;

public class EstudanteController {
    private EstudanteDAO estudanteDAO;
    private Scanner scanner;

    public EstudanteController() {
        estudanteDAO = new EstudanteDAO();
        scanner = new Scanner(System.in);
    }

    public void adicionarEstudante() {
        System.out.println("Informe os dados do estudante:");

        System.out.print("Número de Matrícula: ");
        int nrMatricula = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Apelido: ");
        String apelido = scanner.nextLine();

        System.out.print("Contacto: ");
        String contacto = scanner.nextLine();

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        Estudante estudante = new Estudante(nrMatricula, nome, apelido, contacto, endereco);
        estudanteDAO.adicionar(estudante);

        System.out.println("Estudante adicionado com sucesso!");
    }

    public void buscarEstudante() {
        System.out.print("Digite o numero de Matricula: ");
        int nrMatricula = scanner.nextInt();
        System.out.println(estudanteDAO.buscar(nrMatricula));
    }

    public void  listarEstudantes() {
        //Usando o foreach
        /*
        for (Estudante estudante: estudanteDAO.listar()) {
            System.out.println(estudante.toString());
        }*/

        //Usando o Lambda

        estudanteDAO.listar().forEach(estudante -> System.out.println(estudante.toString()));
    }
    //Vou adicionar um comentario so para explicar o commit
// aumentar dois metodos actualizar e remover fazer o commit com o guit   por fim compactar a pasta e submeter
  
    public void atualizarEstudante(Estudante estudante) {
        estudante.setnrMatricula("digite o numero de matricula do estudante que deseja actualizar os dados ");
         estudante.setnome("digite o nome");
         estudante.setapelido("digite o apelido");
         estudante.setendereco("digite o endereco);
           estudante.setendereco("digite o contacto);
        
        estudanteDAO.atualizar(estudante);
        
             System.out.println("Estudante Actualizado com sucesso!");
    }

    public void removerEstudante(int nrMatricula) {
        
          estudanteDAO.remover(nrMatricula);
         estudanteDAO.remover( String nome);
         estudanteDAO.remover(String apelido);
         estudanteDAO.remover(String endereco);
           estudanteDAO.remover(String contactio);
      
             System.out.println("Estudante removido com sucesso!");
    }
}
