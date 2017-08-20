package trabalhointerface.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import trabalhointerface.util.Mensagens;

public class UsuarioDAO {

    public boolean validaUsuario(
            String user,
            String senha) {
        boolean verifica = false;
        // definição da String de conexão
        String aux = "jdbc:mysql://localhost:3307/fat_truck?"
                + "user=root&password=root";
        // estabelecer a conexão...mysql-connector-java-5.1.42-bin.jar
        Connection conexao;
        try {
            conexao = DriverManager.getConnection(aux);
            String sql = "select user_adm, senha_adm from admin"
                    + " where user_adm = ? "
                    + " and senha_adm = ? ";
            // enviar o select para ser analisado pelo banco
            // de dados...
            PreparedStatement p = conexao.prepareStatement(sql);
            // definir o valor de cada um dos parâmetros...
            p.setString(1, user);
            p.setString(2, senha);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                verifica = true;
            }
            rs.close();
            p.close();
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro ao validar o usuário. \n " + ex.getMessage());
        }

        return verifica;
    }

    public void alteraLogin(
            String user,
            String senha) {
        String aux = "jdbc:mysql://localhost:3307/fat_truck?"
                + "user=root&password=root";
        Connection conexao;
        try {
            conexao = DriverManager.getConnection(aux);
            String sql = "update admin set user_adm = ?, senha_adm = ?";

            PreparedStatement p = conexao.prepareStatement(sql);
            // definir o valor de cada um dos parâmetros...
            p.setString(1, user);
            p.setString(2, senha);
            p.execute();
            p.close();
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro ao alterar o login. \n " + ex.getMessage());
        }

    }

}
