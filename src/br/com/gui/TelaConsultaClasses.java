package br.com.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import br.com.ConexaoBD.ConexaoMySQL;
import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import java.awt.Scrollbar;
import java.awt.SystemColor;
import java.awt.ScrollPane;

public class TelaConsultaClasses extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultaClasses frame = new TelaConsultaClasses();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaConsultaClasses() {
		ConexaoMySQL.conectar();
		setTitle("Tela de consulta por classes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 581, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboClasse = new JComboBox();
		comboClasse.setModel(new DefaultComboBoxModel(new String[] {"SUB 9", "SUB 11", "SUB 15", "SUB 18", "ADULTO"}));
		comboClasse.setBounds(312, 45, 67, 20);
		contentPane.add(comboClasse);
		
		JLabel lblNewLabel = new JLabel("Selecione a classe que deseja buscar");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lblNewLabel.setBounds(20, 39, 293, 29);
		contentPane.add(lblNewLabel);
		
		JButton btnListaAlunos = new JButton("Listar alunos");
		btnListaAlunos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnListaAlunos.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		btnListaAlunos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				String classe = (String) comboClasse.getSelectedItem();
				String query = "SELECT nome, classe,categoria FROM aluno WHERE classe='" + classe + "';";
				PreparedStatement pst = ConexaoMySQL.getConnection().prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		btnListaAlunos.setBounds(398, 40, 157, 26);
		contentPane.add(btnListaAlunos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 102, 545, 269);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBounds(20, 90, 535, 281);
		table.setBackground(SystemColor.control);
		table.setBounds(10, 59, 516, 161);
		scrollPane.setViewportView(table);
	}
}
