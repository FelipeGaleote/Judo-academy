package br.com.gui;

import br.com.ConexaoBD.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.List;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Dimension;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtPeso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
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
	public TelaCadastro() {
		setResizable(false);
		ConexaoMySQL.conectar();
		setTitle("Cadastro de alunos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblNome.setBounds(113, 41, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblSexo.setBounds(113, 150, 46, 14);
		contentPane.add(lblSexo);
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblPeso.setBounds(122, 81, 46, 14);
		contentPane.add(lblPeso);
		
		JLabel lblAnoDeNascimento = new JLabel("Ano de nascimento");
		lblAnoDeNascimento.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblAnoDeNascimento.setBounds(28, 117, 140, 14);
		contentPane.add(lblAnoDeNascimento);
		
		txtNome = new JTextField();
		txtNome.setBounds(187, 40, 134, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		JComboBox combo_ano = new JComboBox();
		rdbtnMasculino.setSelected(true);
		rdbtnMasculino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnFeminino.setSelected(false);
			}
		});
		rdbtnMasculino.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnMasculino.setBounds(165, 147, 88, 23);
		contentPane.add(rdbtnMasculino);
		
		
		rdbtnFeminino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnMasculino.setSelected(false);
			}
		});
		rdbtnFeminino.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnFeminino.setBounds(266, 147, 109, 23);
		contentPane.add(rdbtnFeminino);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(187, 80, 66, 20);
		contentPane.add(txtPeso);
		txtPeso.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nome = txtNome.getText();
					String ano1 = (String) combo_ano.getSelectedItem();
					int ano = Integer.parseInt(ano1);
					char sexo;
					if (rdbtnMasculino.isSelected()) {
						sexo = 'M';
					} else {
						sexo = 'F';
					}
					double peso =  Double.parseDouble(txtPeso.getText());
					ConexaoMySQL.cadastrarAluno(nome, ano, sexo, peso);
					txtNome.setText("");
					combo_ano.setSelectedIndex(0);
					txtPeso.setText("");
					rdbtnMasculino.setSelected(true);
					JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
					} catch(Exception e1) {
						System.out.println("Erro: " + e1.getMessage());
					}
			}
		});
		btnCadastrar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 22));
		btnCadastrar.setBounds(155, 197, 134, 36);
		contentPane.add(btnCadastrar);
		

		combo_ano.setModel(new DefaultComboBoxModel(new String[] {"2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010","2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1947", "1948", "1947", "1946", "1945", "1944", "1943", "1942","1941", "1940"}));
		combo_ano.setMaximumRowCount(5);
		combo_ano.setLocale(new Locale("pt", "BR"));
		combo_ano.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		combo_ano.setAutoscrolls(true);
		combo_ano.setSize(new Dimension(0, 6));
		combo_ano.setBounds(186, 116, 67, 20);
		contentPane.add(combo_ano);
	}
}
