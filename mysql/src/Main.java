import java.util.Scanner;
import dao.ClienteDAO;
import model.Cliente;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ClienteDAO cDAO = new ClienteDAO();

        while (true) {
            System.out.print(" MENU DE OPÇÕES\n");
            System.out.print(" Opção 1 - Adicionar cadastro\n");
            System.out.print(" Opção 2 - Listar clientes\n");
            System.out.print(" Opção 3 - Atualizar clientes\n");
            System.out.print(" Opção 4 - Deletar cliente\n");
            System.out.print(" Opção 5 - Sair\n");
            System.out.print("Digite uma opção: ");
            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("\n ADICIONAR CADASTRO\n");
                    System.out.print("Digite o nome do cliente: ");
                    String nome = sc.nextLine();
                    System.out.print("Digite a senha do cliente: ");
                    String senha = sc.nextLine();

                   // Cliente c1 = new Cliente(nome, sobrenome, datanascimento, telefone, cpf, cidade, estado, pais, endereco, numero, datacadastro, email, senha);
                    // cDAO.inserirCliente(c1);
                    System.out.println("Cadastro adicionado com sucesso! \n");
                    break;
                case 2:
                    System.out.println("  CLIENTES  ");
                    ResultSet rs = cDAO.listarCliente();
                    try {
                        while (rs.next()) {
                            System.out.println("\nNome: " + rs.getString("nome") + "\nSenha: " + rs.getString("senha") + "\n\n");
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case 3:
                    System.out.print("\n Atualizar Cliente \n");
                    System.out.print("Digite o ID do cliente a ser atualizado: ");
                    int idAtualizar = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Digite o novo nome do cliente: ");
                    String novoNome = sc.nextLine();
                    System.out.print("Digite a nova senha do cliente: ");
                    String novaSenha = sc.nextLine();
                    cDAO.atualizarCliente(idAtualizar, novoNome, novaSenha);
                    break;
                case 4:
                    System.out.print("\n DELETAR CLIENTE\n");
                    System.out.print("Digite o ID do cliente a ser deletado: ");
                    int id = sc.nextInt();
                    cDAO.deletarCliente(id);
                    break;
                case 5:
                    System.out.println("\nAté logo!");
                    sc.close();
                    return;
                default:
                    System.out.println("\nOpção Inválida!");
                    break;
            }
        }
    }
}
