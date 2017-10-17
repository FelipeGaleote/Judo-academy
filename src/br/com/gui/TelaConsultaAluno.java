package br.com.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import br.com.ConexaoBD.ConexaoMySQL;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Cursor;

public class TelaConsultaAluno extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultaAluno frame = new TelaConsultaAluno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JTable table;
	/**
	 * Create the frame.
	 */
	public TelaConsultaAluno() {
		setOpacity(1);
		setResizable(false);
		ConexaoMySQL.conectar();
		setTitle("Consultar aluno");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 542, 259);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeDoAluno = new JLabel("Nome do aluno");
		lblNomeDoAluno.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lblNomeDoAluno.setBounds(25, 16, 126, 14);
		contentPane.add(lblNomeDoAluno);
		
		txtNome = new JTextField();
		txtNome.setBounds(161, 15, 131, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JButton btnConsultar = new JButton("Consultar aluno");
		btnConsultar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String nome = txtNome.getText();
					String query = "SELECT nome, ano_nascimento,peso, classe, categoria FROM aluno WHERE nome like '" + nome + "%'";
					PreparedStatement pst = ConexaoMySQL.getConnection().prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
				}
			}
		});
		btnConsultar.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		btnConsultar.setBounds(326, 12, 174, 23);
		contentPane.add(btnConsultar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 62, 503, 158);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(SystemColor.control);
		table.setBounds(10, 59, 516, 161);
		scrollPane.setViewportView(table);
	}
}
