package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAtualizarNoticia extends JFrame {

	private JPanel contentPane;
	private JTextField txtTituloAntigo;
	private JTextField txtTituloNovo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAtualizarNoticia frame = new TelaAtualizarNoticia();
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
	public TelaAtualizarNoticia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtTituloAntigo = new JTextField();
		txtTituloAntigo.setText("Titulo Antigo");
		txtTituloAntigo.setColumns(10);
		txtTituloAntigo.setBounds(36, 42, 172, 20);
		contentPane.add(txtTituloAntigo);
		
		JButton btnAlterarTitulo = new JButton("Alterar Titulo");
		btnAlterarTitulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String tituloantigo = txtTituloAntigo.getText();
					String titulonovo = txtTituloNovo.getText();
					
					//Fachada.inicializar();
					Fachada.alterarTituloNoticia(tituloantigo, titulonovo);
					
					JOptionPane.showMessageDialog(null,"Titulo Alterado com sucesso: "+
							titulonovo+"\n");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,e2.getMessage());
				}
			}
		});
		btnAlterarTitulo.setBounds(144, 85, 163, 23);
		contentPane.add(btnAlterarTitulo);
		
		txtTituloNovo = new JTextField();
		txtTituloNovo.setText("Titulo Novo");
		txtTituloNovo.setColumns(10);
		txtTituloNovo.setBounds(250, 42, 163, 20);
		contentPane.add(txtTituloNovo);
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(36, 139, 172, 132);
		contentPane.add(scrollPane);
		
		JTextArea txtrConteudoAntigo = new JTextArea();
		txtrConteudoAntigo.setText("Conteudo Antigo");
		scrollPane.setViewportView(txtrConteudoAntigo);
		
		JScrollPane scrollPane_1 = new JScrollPane((Component) null);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(250, 139, 172, 132);
		contentPane.add(scrollPane_1);
		
		JTextArea txtrConteudoNovo = new JTextArea();
		txtrConteudoNovo.setText("Conteudo Novo");
		scrollPane_1.setViewportView(txtrConteudoNovo);
		
		JButton btnAlterarConteudo = new JButton("Alterar Conteudo");
		btnAlterarConteudo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String conteudoantigo = txtrConteudoAntigo.getText();
					String conteudonovo = txtrConteudoNovo.getText();
					
					//Fachada.inicializar();
					Fachada.alterarConteudoNoticia(conteudoantigo, conteudonovo);
					
					JOptionPane.showMessageDialog(null,"Conteudo Alterado com sucesso: "+
							conteudonovo+"\n");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,e2.getMessage());
				}
			}
		});
		btnAlterarConteudo.setBounds(144, 298, 163, 23);
		contentPane.add(btnAlterarConteudo);
	}
}
