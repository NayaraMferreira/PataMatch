import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Usuario {
    private int id;
    private String nome;
    private int idade;
    private String localizacao;

    public Usuario(int id, String nome, int idade, String localizacao) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.localizacao = localizacao;
    }

    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public int getIdade() {
        return idade;
    }
    public String getLocalizacao() {
        return localizacao;
    }


    public String toString() {
        return "Usuario{id=" + id + ", nome='" + nome + '\'' + ", idade=" + idade + ", localizacao='" + localizacao + '\'' + '}';
    }
}

