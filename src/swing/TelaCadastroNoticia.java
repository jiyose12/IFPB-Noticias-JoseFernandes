package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.IndPublicar;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroNoticia extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtDescricao;
	private JTextField txtSetornoticia;
	private JTextField txtTiponoticia;
	private JTextField txtData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroNoticia frame = new TelaCadastroNoticia();
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
	public TelaCadastroNoticia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtTitulo = new JTextField();
		txtTitulo.setText("Titulo");
		txtTitulo.setColumns(10);
		txtTitulo.setBounds(106, 30, 261, 20);
		contentPane.add(txtTitulo);
		
		JButton btnCadastrarnoticia = new JButton("CadastrarNoticia");
		btnCadastrarnoticia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				String titulo = txtTitulo.getText();
				String descricao = txtDescricao.getText();
				String setornoticia = txtSetornoticia.getText();
				String tiponoticia = txtTiponoticia.getText();
				String data = txtData.getText();
				
				Fachada.inicializar();
				
				Fachada.cadastrarNoticia(titulo, descricao, setornoticia, tiponoticia, IndPublicar.PUBLICADO, data);
				
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,e2.getMessage());
			}
				
			}
		});
		btnCadastrarnoticia.setBounds(167, 311, 140, 23);
		contentPane.add(btnCadastrarnoticia);
		
		JLabel lblDescricao = new JLabel("Descricao");
		lblDescricao.setBounds(44, 64, 46, 14);
		contentPane.add(lblDescricao);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(44, 33, 46, 14);
		contentPane.add(lblTitulo);
		
		txtDescricao = new JTextField();
		txtDescricao.setText("Descricao");
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(106, 61, 261, 130);
		contentPane.add(txtDescricao);
		
		txtSetornoticia = new JTextField();
		txtSetornoticia.setText("SetorNoticia");
		txtSetornoticia.setColumns(10);
		txtSetornoticia.setBounds(106, 226, 113, 20);
		contentPane.add(txtSetornoticia);
		
		txtTiponoticia = new JTextField();
		txtTiponoticia.setText("TipoNoticia");
		txtTiponoticia.setColumns(10);
		txtTiponoticia.setBounds(106, 280, 113, 20);
		contentPane.add(txtTiponoticia);
		
		txtData = new JTextField();
		txtData.setText("Data");
		txtData.setColumns(10);
		txtData.setBounds(254, 226, 113, 20);
		contentPane.add(txtData);
		
		JLabel lblSetornoticia = new JLabel("SetorNoticia");
		lblSetornoticia.setBounds(106, 202, 74, 14);
		contentPane.add(lblSetornoticia);
		
		JLabel lblTiponoticia = new JLabel("TipoNoticia");
		lblTiponoticia.setBounds(106, 255, 74, 14);
		contentPane.add(lblTiponoticia);
		
		JLabel lblDatanoticia = new JLabel("DataNoticia");
		lblDatanoticia.setBounds(254, 202, 74, 14);
		contentPane.add(lblDatanoticia);
	}

}
