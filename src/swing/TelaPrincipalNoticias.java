package swing;

import java.awt.EventQueue;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import fachada.Fachada;
import swing.TelaLogin;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;

public class TelaPrincipalNoticias {

	private JFrame frame;
	private JTextField txtTitulo;
	private JTextField txtSetor;
	private JTextField txtTipo;
	private JTextField txtDescricao;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipalNoticias window = new TelaPrincipalNoticias();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipalNoticias() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				Fachada.finalizar();
			}
			@Override
			public void windowOpened(WindowEvent e) {
				Fachada.inicializar();
			}
		});
		frame.setBounds(100, 100, 485, 410);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menuLogar = new JMenu("Logar");
		menuBar.add(menuLogar);
		
		JMenuItem btnLogar = new JMenuItem("Login");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaLogin telalogin = new TelaLogin();
				telalogin.setVisible(true);
			}
		});
		menuLogar.add(btnLogar);
		
		JMenuItem btnLogoff = new JMenuItem("Logoff");
		btnLogoff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Fachada.logoff();
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}

				JOptionPane.showMessageDialog(null,"Até breve");
			}
		});
		menuLogar.add(btnLogoff);
		
		JMenu mnCadastrar = new JMenu("Cadastrar");
		menuBar.add(mnCadastrar);
		
		JMenuItem mntmCadastrarnoticia = new JMenuItem("CadastrarNoticia");
		mntmCadastrarnoticia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaCadastroNoticia telacadastronoticia = new TelaCadastroNoticia();
					telacadastronoticia.setVisible(true);
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		mnCadastrar.add(mntmCadastrarnoticia);
		
		JMenuItem mntmCadastrarusuario = new JMenuItem("CadastrarUsuario");
		mntmCadastrarusuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaCadastroUsuario telacadastrousuario = new TelaCadastroUsuario();
					telacadastrousuario.setVisible(true);
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		
		mnCadastrar.add(mntmCadastrarusuario);
		
		JMenu mnAlterar = new JMenu("Alterar");
		menuBar.add(mnAlterar);
		
		JMenuItem mntmAlterarnoticia = new JMenuItem("AlterarNoticia");
		mntmAlterarnoticia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaAtualizarNoticia telaatualizarnoticia = new TelaAtualizarNoticia();
					telaatualizarnoticia.setVisible(true);
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		mnAlterar.add(mntmAlterarnoticia);
		frame.getContentPane().setLayout(null);
		
		txtTitulo = new JTextField();
		txtTitulo.setText("Titulo");
		txtTitulo.setColumns(10);
		txtTitulo.setBounds(22, 25, 115, 20);
		frame.getContentPane().add(txtTitulo);
		
		txtSetor = new JTextField();
		txtSetor.setText("Setor");
		txtSetor.setColumns(10);
		txtSetor.setBounds(22, 207, 115, 20);
		frame.getContentPane().add(txtSetor);
		
		txtTipo = new JTextField();
		txtTipo.setText("Tipo");
		txtTipo.setColumns(10);
		txtTipo.setBounds(22, 268, 115, 20);
		frame.getContentPane().add(txtTipo);
		
		txtDescricao = new JTextField();
		txtDescricao.setText("Descricao");
		txtDescricao.setBounds(22, 90, 115, 67);
		frame.getContentPane().add(txtDescricao);
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(230, 25, 229, 292);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnConsultar = new JButton("Consultar pelo Titulo");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String titulo = txtTitulo.getText();
					
					
					//Fachada.inicializar();
					String result = Fachada.consultarNoticiasPorParteTitulo(titulo);
					textArea.setText(result);
					//Fachada.finalizar();
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,e2.getMessage());
				}
			}
		});
		btnConsultar.setBounds(22, 56, 163, 23);
		frame.getContentPane().add(btnConsultar);
		
		JButton btnConsultarPelaDescricao = new JButton("Consultar pela Descricao");
		btnConsultarPelaDescricao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String descricao = txtDescricao.getText();
					
					Fachada.inicializar();
					String result = Fachada.consultarNoticiasPorParteConteudo(descricao);
					textArea.setText(result);
					//Fachada.finalizar();
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,e2.getMessage());
				}
			}
		});
		btnConsultarPelaDescricao.setBounds(10, 168, 195, 23);
		frame.getContentPane().add(btnConsultarPelaDescricao);
		
		JButton btnConsultarPeloSetor = new JButton("Consultar pelo Setor");
		btnConsultarPeloSetor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String setornoticia = txtSetor.getText();
					
					//Fachada.inicializar();
					String result = Fachada.consultarNoticiasPorNomeSetor(setornoticia);
					textArea.setText(result);
					//Fachada.finalizar();
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,e2.getMessage());
				}
			}
		});
		btnConsultarPeloSetor.setBounds(22, 234, 163, 23);
		frame.getContentPane().add(btnConsultarPeloSetor);
		
		JButton btnConsultarPeloTipo = new JButton("Consultar pelo Tipo");
		btnConsultarPeloTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String tiponoticia = txtTipo.getText();
					
					//Fachada.inicializar();
					String result = Fachada.consultarNoticiasPorNomeTipo(tiponoticia);
					textArea.setText(result);
					//Fachada.finalizar();
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,e2.getMessage());
				}
			}
		});
		btnConsultarPeloTipo.setBounds(22, 294, 163, 23);
		frame.getContentPane().add(btnConsultarPeloTipo);
		
		
	}
}
