package trabalhointerface.persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import trabalhointerface.modelo.VendaDTO;
import trabalhointerface.util.Mensagens;

public class VendaDAO {

    public void insereVendaBD(float total) {
        try {
            String str = "jdbc:mysql://localhost:3307/fat_truck?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "insert into venda (TOTAL_VENDA, DAT_VENDA) values (?, ?)";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setFloat(1, total);
            p.setDate(2, Date.valueOf(LocalDate.now()));
            p.execute();
            p.close();
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro ao inserir a venda no banco de dados. \n" + ex.getMessage());
        }
    }

    public float getTotalVendaDia() {
        float total = 0;
        try {
            String str = "jdbc:mysql://localhost:3307/fat_truck?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "select sum(total_venda) from venda "
                    + "where DATE(dat_venda) = curdate(); ";
            PreparedStatement p = conn.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                total = total + rs.getFloat(1);
            }
            rs.close();
            p.close();
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro ao calcular o total de vendas: \n" + ex.getMessage());
        }
        return total;
    }

    public ArrayList<VendaDTO> carregaVendasBD() {
        ArrayList<VendaDTO> listaVDTO = new ArrayList();
        String str = "jdbc:mysql://localhost:3307/fat_truck?"
                + "user=root&password=root";
        Connection conn;
        try {
            conn = DriverManager.getConnection(str);
            String sql = "SELECT dat_venda, total_venda FROM venda"
                    + " WHERE DATE(dat_venda) = curdate();";
            PreparedStatement p = conn.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                VendaDTO vv = new VendaDTO(rs.getString(1), rs.getFloat(2));
                listaVDTO.add(vv);
            }
            rs.close();
            p.close();
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro ao carregar as vendas do banco de dados: \n" + ex.getMessage());
        }
        return listaVDTO;
    }
}
