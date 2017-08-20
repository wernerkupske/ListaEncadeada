package trabalhointerface.modelo;

public class UsuarioDTO {
    private String user, senha;

    public UsuarioDTO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public UsuarioDTO(String user, String senha) {
        this.user = user;
        this.senha = senha;
    }
}
