/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

/**
 *
 * @author edils
 */
public class Sentencias {
    
    public static String LISTAR = "SELECT usuarios.* FROM usuarios;";
    
    public static String REGISTRAR = "INSERT INTO crud_java.usuarios \n" +
            "(nome, usuario, senha, sexo, endereco, bairro, cidade, cep, email, uf, idioma) \n" +
        "VALUES \n" +
            "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    
    public static String ATUALIZAR = "UPDATE \n" +
        "	crud_java.usuarios \n" +
        "SET\n" +
        "	nome = ?, \n" +
        "	usuario = ?, \n" +
        "	senha = ?, \n" +
        "	sexo = ?, \n" +
        "	endereco = ?, \n" +
        "	bairro = ?, \n" +
        "	cidade = ?, \n" +
        "	cep = ?, \n" +
        "	email = ?, \n" +
        "	uf = ?, \n" +
        "	idioma = ? \n" +
        "WHERE id = ?;";
    
    public static String ELIMINAR = "DELETE FROM crud_java.usuarios \n" +
        "WHERE id = ?;";
    
    public static String ELIMINAR_TODOS = "TRUNCATE TABLE crud_java.usuarios";
    
    private int id;
    private String nome;
    private String usuario;
    private String senha;
    private int sexo;
    private String endereco;
    private String bairro;
    private String cidade;
    private String cep;
    private String email;
    private int uf;
    private int idioma;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUf() {
        return uf;
    }

    public void setUf(int uf) {
        this.uf = uf;
    }

    public int getIdioma() {
        return idioma;
    }

    public void setIdioma(int idioma) {
        this.idioma = idioma;
    }
    
    
}
