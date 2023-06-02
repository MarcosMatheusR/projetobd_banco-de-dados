package principal;

import connection.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Funcoes {

    private static Connection connection = ConnectionManager.getConnection();
    private static PreparedStatement ps = null;

    public static boolean isRegistrar(Sentencias s) {
        String sql = Sentencias.REGISTRAR;

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, s.getNome());
            ps.setString(2, s.getUsuario());
            ps.setString(3, s.getSenha());
            ps.setInt(4, s.getSexo());
            ps.setString(5, s.getEndereco());
            ps.setString(6, s.getBairro());
            ps.setString(7, s.getCidade());
            ps.setString(8, s.getCep());
            ps.setString(9, s.getEmail());
            ps.setInt(10, s.getUf());
            ps.setInt(11, s.getIdioma());

            ps.executeUpdate();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(Funcoes.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static boolean isUpdate(Sentencias s) {
        String sql = Sentencias.ATUALIZAR;

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, s.getNome());
            ps.setString(2, s.getUsuario());
            ps.setString(3, s.getSenha());
            ps.setInt(4, s.getSexo());
            ps.setString(5, s.getEndereco());
            ps.setString(6, s.getBairro());
            ps.setString(7, s.getCidade());
            ps.setString(8, s.getCep());
            ps.setString(9, s.getEmail());
            ps.setInt(10, s.getUf());
            ps.setInt(11, s.getIdioma());
            ps.setInt(12, s.getId());

            ps.executeUpdate();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(Funcoes.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static boolean isDelete(Sentencias s) {
        String sql = Sentencias.ELIMINAR;

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, s.getId());
            ps.executeUpdate();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(Funcoes.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static boolean isTruncate() {
        String sql = Sentencias.ELIMINAR_TODOS;

        try {
            ps = connection.prepareStatement(sql);
            ps.executeUpdate();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(Funcoes.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static void setListar(String buscar) {
        DefaultTableModel modelo = (DefaultTableModel) Crud.tabela.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

        String sql = "";

        if (buscar.equals("")) {
            sql = Sentencias.LISTAR;
        } else {
            sql = "SELECT usuarios.* FROM usuarios WHERE ("
                    + "nome LIKE '%" + buscar + "%' OR "
                    + "usuario LIKE '%" + buscar + "%');";
        }

        String dados[] = new String[12];
        try {

            int uf, idioma;

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                dados[0] = rs.getString("id");
                dados[1] = rs.getString("nome");
                dados[2] = rs.getString("usuario");
                dados[3] = rs.getString("senha");
                if (Integer.parseInt(rs.getString("sexo")) == 0) {
                    dados[4] = "M";
                } else {
                    dados[4] = "F";
                }
                dados[5] = rs.getString("endereco");
                dados[6] = rs.getString("bairro");
                dados[7] = rs.getString("cidade");
                dados[8] = rs.getString("cep");
                dados[9] = rs.getString("email");
                uf = Integer.parseInt(rs.getString("uf"));
                switch (uf) {
                    case 0:
                        dados[10] = "MA";
                        break;
                    case 1:
                        dados[10] = "PI";
                        break;
                    case 2:
                        dados[10] = "PA";
                        break;
                    case 3:
                        dados[10] = "TO";
                        break;
                    default:
                        dados[10] = "MA";
                }
                idioma = Integer.parseInt(rs.getString("idioma"));
                switch (idioma) {
                    case 0:
                        dados[11] = "Inglês";
                        break;
                    case 1:
                        dados[11] = "Espanhol";
                        break;
                    case 2:
                        dados[11] = "Francês";
                        break;
                    case 3:
                        dados[11] = "Inglês e Espanhol";
                        break;
                    case 4:
                        dados[11] = "Inglês e Francês";
                        break;
                    case 5:
                        dados[11] = "Espanhol e Francês";
                        break;
                    case 6:
                        dados[11] = "Inglês, Espanhol e Francês";
                        break;
                    default:
                        System.out.println("Inglês");
                }

                modelo.addRow(dados);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Funcoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String extraerIDMax() {
        String sql = "SELECT MAX(id) as id FROM usuarios";
        int id = 0;
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                id = rs.getInt("id");
            }
            if (id == 0) {
                id = 1;
            } else {
                id = id + 1;
            }
            return String.valueOf(id);
        } catch (SQLException ex) {
            Logger.getLogger(Funcoes.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
