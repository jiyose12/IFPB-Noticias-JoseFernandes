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

public class TelaPrincipalNoticias {

	private JFrame frame;

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
		frame.setBounds(100, 100, 450, 300);
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
	}

}
