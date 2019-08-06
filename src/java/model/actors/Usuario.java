package model.actors;

public class Usuario {
    private String login, nome, email, senha;
    private int pontos;

    public Usuario(String login, String nome, String email, String senha) {
        this.login = login;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(String login, String nome, String email, String senha, int pontos) {
        this.login = login;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.pontos = pontos;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
    
    
}
