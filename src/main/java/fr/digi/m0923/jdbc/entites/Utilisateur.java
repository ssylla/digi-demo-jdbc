package fr.digi.m0923.jdbc.entites;

public class Utilisateur {

    private int id;
    private String login;
    private String mdp;

    public Utilisateur(int id, String login, String mdp) {
        this.id = id;
        this.login = login;
        this.mdp = mdp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Utilisateur{");
        sb.append("id=").append(id);
        sb.append(", login='").append(login).append('\'');
        sb.append(", mdp='").append(mdp).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
