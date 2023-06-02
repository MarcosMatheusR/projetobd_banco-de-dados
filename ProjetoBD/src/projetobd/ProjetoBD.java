
package projetobd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjetoBD {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/crud_java";
        String usuario = "root";
        String senha = "#eCsL2212067@";

        try {
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            Statement statement = conexao.createStatement();

            // Inserir um novo usuário
            String inserirSQL = "INSERT INTO usuarios (nome, usuario, senha, sexo, endereco, bairro, cidade, cep, email, uf, idioma) VALUES ('João', 'joao123', 'senha123', 'Masculino', 'Rua A', 'Centro', 'Cidade A', '12345-678', 'joao@email.com', 'SP', 'Português')";
            statement.executeUpdate(inserirSQL);

            // Selecionar todos os usuários
            String selecionarSQL = "SELECT * FROM usuarios";
            ResultSet resultado = statement.executeQuery(selecionarSQL);

            // Iterar sobre os resultados
            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                String usuarioBD = resultado.getString("usuario");
                String senhaBD = resultado.getString("senha");
                String sexo = resultado.getString("sexo");
                String endereco = resultado.getString("endereco");
                String bairro = resultado.getString("bairro");
                String cidade = resultado.getString("cidade");
                String cep = resultado.getString("cep");
                String email = resultado.getString("email");
                String uf = resultado.getString("uf");
                String idioma = resultado.getString("idioma");

                System.out.println("ID: " + id);
                System.out.println("Nome: " + nome);
                System.out.println("Usuário: " + usuarioBD);
                System.out.println("Senha: " + senhaBD);
                System.out.println("Sexo: " + sexo);
                System.out.println("Endereço: " + endereco);
                System.out.println("Bairro: " + bairro);
                System.out.println("Cidade: " + cidade);
                System.out.println("CEP: " + cep);
                System.out.println("Email: " + email);
                System.out.println("UF: " + uf);
                System.out.println("Idioma: " + idioma);
                System.out.println("-------------------------------------");
            }

            // Fechar as conexões
            resultado.close();
            statement.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
