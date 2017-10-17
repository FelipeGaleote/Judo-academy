package br.com.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.ConexaoBD.ConexaoMySQL;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Cursor;

public class TelaListaAlunos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListaAlunos frame = new TelaListaAlunos();
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
	public TelaListaAlunos() {
		setResizable(false);
		setTitle("Consultar lista de alunos");
		ConexaoMySQL.conectar();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 539, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnConsultarLista = new JButton("Consultar lista de alunos");
		btnConsultarLista.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConsultarLista.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnConsultarLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT nome, classe, categoria FROM aluno";
					PreparedStatement pst = ConexaoMySQL.getConnection().prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnConsultarLista.setBounds(135, 11, 251, 40);
		contentPane.add(btnConsultarLista);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 62, 533, 322);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
