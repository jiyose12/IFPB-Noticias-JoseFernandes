package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 288, 204);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(117, 31, 86, 20);
		contentPane.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(117, 62, 86, 20);
		contentPane.add(passwordField);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(55, 65, 46, 14);
		contentPane.add(lblSenha);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(55, 34, 46, 14);
		contentPane.add(lblNome);
		
		JButton button = new JButton("Logar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String nome = textField.getText();
					String senha = new String(passwordField.getPassword());
					
					//Fachada.inicializar();
					Fachada.login(nome, senha);
					
					//Fachada.finalizar();
					System.out.println(Fachada.getLogada());
					
					String a = Fachada.getLogada().getNome();
					JOptionPane.showMessageDialog(null,"Pessoa logada no momento: "+
							a+"\n");
									
					dispose(); //fecha a janela
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
			}
		});
		button.setBounds(97, 106, 86, 23);
		contentPane.add(button);
	}
}
