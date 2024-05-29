package dao;

import model.Cliente;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Date;

public class ClienteDAO {
    private Conexao conexao;
    public String query;
    private PreparedStatement ps;
    private ResultSet rs;

    public ClienteDAO() {
        conexao = Conexao.getConexao();
    }

    public void inserirCliente(Cliente c) {
        this.query = "INSERT INTO cliente (nome,sobrenome,datanascimento, telefone, cpf, cidade, estado, pais, endereco, numero, datacadastro, email, senha) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            this.ps = conexao.getConnection().prepareStatement(this.query);
            this.ps.setString(1, c.getNome());
            this.ps.setString(2, c.getSobrenome());
            this.ps.setDate(3, new Date(c.getDatanascimento().getTime()));
            this.ps.setString(4, c.getTelefone());
            this.ps.setString(5, c.getCpf());
            this.ps.setString(6, c.getCidade());
            this.ps.setString(7, c.getEstado());
            this.ps.setString(8, c.getPais());
            this.ps.setString(9, c.getEndereco());
            this.ps.setString(10, c.getNumero());
            this.ps.setDate(11, new Date(c.getDatacadastro().getTime()));
            this.ps.setString(12, c.getEmail());
            this.ps.setString(13, c.getSenha());
            this.ps.executeUpdate();
            this.ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ResultSet listarCliente(){
        this.query = "SELECT * FROM cliente";
        try {
            this.ps = conexao.getConnection().prepareStatement(this.query);
            return this.ps.executeQuery();
        } catch (SQLException ex){
            ex.printStackTrace();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return this.rs;
    }

    public void atualizarCliente(int id, String novoNome, String novaSenha) {
        this.query = "UPDATE cliente SET nome = ?, senha = ? WHERE id_cliente = ?";
        try {
            this.ps = conexao.getConnection().prepareStatement(this.query);
            this.ps.setString(1, novoNome);
            this.ps.setString(2, novaSenha);
            this.ps.setInt(3, id);

            int affectedRows = this.ps.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Cliente atualizado com sucesso!");
            } else {
                System.out.println("Nenhum cliente encontrado com o ID especificado.");
            }

            this.ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deletarCliente(int id) {
        this.query = "DELETE FROM cliente WHERE id_cliente = ?";
        try {
            this.ps = conexao.getConnection().prepareStatement(this.query);
            this.ps.setInt(1, id);
            int affectedRows = this.ps.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Cliente deletado com sucesso!");
            } else {
                System.out.println("Nenhum cliente encontrado com o nome especificado.");
            }
            this.ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
