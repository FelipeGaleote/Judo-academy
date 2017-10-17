package br.com.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import br.com.ConexaoBD.ConexaoMySQL;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class TelaPrincipal {

	private JFrame frmTelaPrincipal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frmTelaPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaPrincipal = new JFrame();
		frmTelaPrincipal.setResizable(false);
		frmTelaPrincipal.setTitle("Academia Senshi Pedro Santos");
		frmTelaPrincipal.setBounds(100, 100, 450, 300);
		frmTelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmTelaPrincipal.setJMenuBar(menuBar);
		
		JMenu mnCadastrar = new JMenu("Cadastrar");
		mnCadastrar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/imagens/irc-join.ico")));
		menuBar.add(mnCadastrar);
		
		JMenuItem mntmTelaCadastro = new JMenuItem("Cadastrar aluno");
		mntmTelaCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastro cadastro = new TelaCadastro();
				cadastro.setVisible(true);
			}
		});
		mnCadastrar.add(mntmTelaCadastro);
		
		JMenu mnAtualizar = new JMenu("Atualizar");
		menuBar.add(mnAtualizar);
		
		JMenuItem mntmAtualizarPeso = new JMenuItem("Atualizar dados do aluno");
		mntmAtualizarPeso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAtualizarAluno atualizarAluno = new TelaAtualizarAluno();
				atualizarAluno.setVisible(true);
			}
		});
		mnAtualizar.add(mntmAtualizarPeso);
		
		JMenuItem mntmExcluirAluno = new JMenuItem("Excluir aluno");
		mntmExcluirAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaExcluirAluno excluirAluno = new TelaExcluirAluno();
				excluirAluno.setVisible(true);
			}
		});
		mnAtualizar.add(mntmExcluirAluno);
		
		JMenu mnConsultar = new JMenu("Consultar");
		menuBar.add(mnConsultar);
		
		JMenuItem mntmConsultarAluno = new JMenuItem("Consultar aluno");
		mntmConsultarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultaAluno consultaAluno = new TelaConsultaAluno();
				consultaAluno.setVisible(true);
			}
		});
		mnConsultar.add(mntmConsultarAluno);
		
		JMenuItem mntmConsultarListaDe = new JMenuItem("Consultar lista de alunos");
		mntmConsultarListaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListaAlunos listaAlunos = new TelaListaAlunos();
				listaAlunos.setVisible(true);
			}
		});
		mnConsultar.add(mntmConsultarListaDe);
		
		JMenuItem mntmConsultarPorClasses = new JMenuItem("Consultar por classes");
		mntmConsultarPorClasses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaConsultaClasses consultaclasses = new TelaConsultaClasses();
				consultaclasses.setVisible(true);
			}
		});
		mnConsultar.add(mntmConsultarPorClasses);
		frmTelaPrincipal.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/imagens/Jud\u00F4.png")));
		label.setBounds(0, 0, 434, 241);
		frmTelaPrincipal.getContentPane().add(label);
	}

}
