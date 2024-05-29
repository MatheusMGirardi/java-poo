package model;

import java.util.Date;

public class Cliente extends User{
    private String numero;

    public Cliente(String nome, String senha, String email, Date datacadastro, String endereco, String numero, String pais, String cidade, String estado, String cpf, String telefone, Date datanascimento, String sobrenome) {
        super(nome, senha, email, datacadastro, endereco, pais, cidade, estado, cpf, telefone, datanascimento, sobrenome);
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}

