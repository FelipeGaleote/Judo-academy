package br.com.ConexaoBD;


import java.sql.*;

import javax.swing.JOptionPane;

import br.com.aluno.Aluno;

public class ConexaoMySQL {
	private static Connection connection = null;
	private static Statement statement = null;
	
	public static Connection getConnection() {
		return connection;
	}
	public static Statement getStatement() {
		return statement;
	}
	public static void conectar() {
		String servidor = "jdbc:mysql://localhost:3306/academia";
		String usuario = "root";
		String senha =  "admin";
		String driver = "com.mysql.jdbc.Driver";
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(servidor, usuario, senha);
			statement = connection.createStatement();
			} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	public static boolean estaConectado() {
		if(connection != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void cadastrarAluno(String nome, int ano, char sexo, double peso) {
		try {
		Aluno aluno = new Aluno();
		String classe,categoria;
		classe = aluno.definirClasse(ano);
		categoria = aluno.definirCategoria(classe, sexo,peso);
		String query = "INSERT INTO aluno(nome,ano_nascimento,sexo,peso,classe,categoria) values('" + nome + "'," + ano + ",'" + sexo + "'," + peso + ",'"+ classe + "','" +categoria +"');" ;
		statement.executeUpdate(query);
		} catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	public static void alterarDadosAluno(String query) {
		try {
			statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Dados modificados com sucesso!");
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Foram encontrados 2 ou mais alunos com esse nome, seja mais especifico");
		}
	}
	public static void excluirAluno(String nome) {
		try {
			String query = "DELETE FROM aluno WHERE nome like '%"+nome+"%';";
		statement.executeUpdate(query);
			
		} catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	public static void desconectar() {
		try {
			connection.close();
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
}





















