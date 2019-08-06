package model.actors;

public class Comentario {
    private int id, topicoId;
    private String comentario, login;

    public Comentario(int topicoId, String comentario, String login) {
        this.topicoId = topicoId;
        this.comentario = comentario;
        this.login = login;
    }

    public Comentario(int id, int topicoId, String comentario, String login) {
        this.id = id;
        this.topicoId = topicoId;
        this.comentario = comentario;
        this.login = login;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTopicoId() {
        return topicoId;
    }

    public void setTopicoId(int topicoId) {
        this.topicoId = topicoId;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    
}
