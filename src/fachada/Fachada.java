package fachada;

import java.security.MessageDigest;
import java.util.List;

import daojpa.*;

import javax.xml.bind.DatatypeConverter;

import modelo.IndPublicar;
import modelo.Noticia;
import modelo.SetorNoticia;
import modelo.TipoNoticia;
import modelo.Usuario;

public class Fachada {
	private static DAONoticia daonoticia = new DAONoticia();
	private static DAOSetorNoticia daosetornoticia = new DAOSetorNoticia();
	private static DAOTipoNoticia daotiponoticia = new DAOTipoNoticia();
	private static DAOUsuario daousuario = new DAOUsuario();
	public static Usuario logada=null;
	//...login
	public static void login(String nome, String senha) throws Exception{		
		if(logada!=null)
			throw new Exception ("ja existe uma pessoa logada");
		
		String hash = getHash(senha.getBytes(), "SHA-256");
		
		Usuario p = daousuario.autenticar(nome, hash);
		if(p==null)
			throw new Exception ("login nao foi possivel entrar: nome ou senha invalida: "+ nome);
		else
			logada = p;
	}

	public static void logoff() throws Exception {	
		if(logada==null)
			throw new Exception ("nao existe uma pessoa logada");
		logada = null;
	}
	/*Pega a pessoa Logada*/
	public static Usuario getLogada(){
		return logada;
	}
	
	public static void inicializar(){
		DAO.open();
	}
	public static void finalizar(){
		DAO.close();
	}
	
	/**********************************************************
	 * 
	 * CADASTROS 
	 * @throws Exception 
	 * 
	 **********************************************************/
	public static Usuario cadastrarUsuario(String nome, String senha) throws Exception {
		Usuario u = daousuario.autenticarNomeUsuario(nome);
	
		if (u != null) {
			DAO.rollback();
			throw new Exception("Usuário já cadastrado previamente: " + nome);
		}
		String hash = getHash(senha.getBytes(), "SHA-256");
		System.out.println(hash);
		
		DAO.begin();	
		u = new Usuario();
		u.setNome(nome);
		u.setSenha(hash);
		daousuario.create(u);
		DAO.commit();
		logada = u;
		return u;
	}

	//Cadastro do Obj refere te às Noticias Anteriores
//	public static Noticia cadastrarNoticiaAnterior(int id, String titulo, String descricao, String setor, String tipo) throws Exception{
//	Noticia n = new Noticia(id, titulo, descricao, null );
//	return n;
//	}
	public static Noticia cadastrarNoticia(String titulo, String descricao, String setor, String tipo, IndPublicar indpublicar, String datastr ) throws Exception{
//		if (logada ==null)
//			throw new Exception("Usuário precisa estar logado");
		DAO.begin();	
		
		Noticia n = daonoticia.readByTitle(titulo);
		
		if (n != null)
			throw new Exception("Noticia já cadastrada previamente: " + titulo);
		
		//SetorNoticia s = daosetornoticia.readByDescription(setor);
	Boolean	s = daosetornoticia.readByDescriptionBool(setor);
				//if(s == null)
			if(s == false)
			throw new Exception("Setor não cadastrado: " + setor);

		//TipoNoticia t = daotiponoticia.readByDescription(tipo);
			Boolean t = daotiponoticia.readByDescriptionBool(tipo);
				//if(t == null)
			if(t == false)
			throw new Exception("Tipo não cadastrado: " + tipo);
				
		SetorNoticia set = new SetorNoticia(setor);
		TipoNoticia tip = new TipoNoticia(tipo);
		n = new Noticia(titulo, descricao, indpublicar, datastr);
		
		set.cadastrarNoticia(n);
		tip.cadastrarNoticia(n);
		
		n.adicionarTipo(tip);
		n.adicionarSetor(set);
			
		daonoticia.create(n);
		DAO.commit();
		return n;
	}
	
	public static SetorNoticia cadastrarSetorNoticia(String descricao) throws Exception{
		if (logada ==null)
			throw new Exception("Usuário precisa estar logado");
		DAO.begin();	
		SetorNoticia s = daosetornoticia.readByDescription(descricao);
		
		if (s != null)
			throw new Exception("Setor já cadastrado previamente: " + descricao);
		
		s = new SetorNoticia(descricao);
		daosetornoticia.create(s);
		DAO.commit();
		return s;
	}
	
	public static TipoNoticia cadastrarTipoNoticia(String descricao) throws Exception{
		DAO.begin();	
		TipoNoticia t = daotiponoticia.readByDescription(descricao);
		
		if (t != null)
			throw new Exception("Tipo já cadastrado previamente: " + descricao);
		
		t = new TipoNoticia(descricao);
		daotiponoticia.create(t);
		DAO.commit();    
		return t;
	}
	
	/**********************************************************
	 * 
	 * CONSULTAS 
	 * @throws Exception 
	 * 
	 **********************************************************/
public static List<Noticia> consultarNoticiasPorSetor(String caracteres) throws Exception{
		
		if (logada ==null)
			throw new Exception("Usuário precisa estar logado");
//		
		List<Noticia> result = daonoticia.consultarNoticiasPorSetor(caracteres);
		
		if (result== null)
			throw new Exception("nenhum resultado");
		else 
		
		return result;
	}
	
	public static Noticia consultarNoticiaPorTitulo(String caracteres) throws Exception{
		
		if (logada ==null)
			throw new Exception("Usuário precisa estar logado");
//		
		Noticia result = daonoticia.readByTitle(caracteres);
		
		if (result== null)
			throw new Exception("nenhum resultado");
		else 
		
		return result;
	}
	
	public static String consultarNoticiasPorParteTitulo(String caracteres) throws Exception {
		if (logada ==null)
			throw new Exception("Usuário precisa estar logado");
//		
		List<Noticia> result = daonoticia.consultarNoticiasPorParteTitulo(caracteres);
		

		String texto = "\nConsultar Noticias por parte do título: "+caracteres;
		if (result.isEmpty())  
			texto += " consulta vazia";
		else 
			for(Noticia p: result)texto += "\n" + p;
		return texto;
	}

	public static String consultarNoticiasPorParteConteudo(String caracteres) throws Exception {
//		if (logada ==null)
//			throw new Exception("Usuário precisa estar logado");
		List<Noticia> result = daonoticia.consultarNoticiasPorParteConteudo(caracteres);

		String texto = "\nConsultar Noticias por parte do Conteudo: "+caracteres;
		if (result.isEmpty())  
			texto += "consulta vazia";
		else 
			for(Noticia p: result)texto += "\n\n" + p;
		return texto;
	}

	public static String consultarNoticiasPorNomeSetor(String caracteres) throws Exception {
//		if (logada ==null)
//			throw new Exception("Usuário precisa estar logado");
		List<SetorNoticia> result = daosetornoticia.consultarNoticiasPorNomeSetor(caracteres);

		String texto = "\nConsultar Noticias por Setor: "+caracteres;
		if (result.isEmpty())  
			texto += " consulta vazia ";
		else 
			for(SetorNoticia p: result)texto += "\n\n" + p;
		return texto;
	}
	
	public static String consultarNoticiasPorNomeTipo(String caracteres) throws Exception {
//		if (logada ==null)
//			throw new Exception("Usuário precisa estar logado");
		List<TipoNoticia> result = daotiponoticia.consultarNoticiasPorNomeTipo(caracteres);

		String texto = "\nConsultar Noticias por Tipo: "+caracteres;
		if (result.isEmpty())  
			texto += " consulta vazia ";
		else 
			for(TipoNoticia p: result)texto += "\n\n" + p;
		return texto;
	}
	
	/**********************************************************
	 * 
	 * DELETES 
	 * 
	 **********************************************************/
	public static void excluirNoticia(String x) throws Exception {
		DAO.begin();
		Noticia n = daonoticia.readByTitle(x);
		Noticia noticiaanterior = daonoticia.readByTitle("noticiaanterior");
		if (n==null) 
			throw new Exception("excluir noticia - titulo inexistente: " + x);
		else
			
//			noticiaanterior.adicionarNoticiasAnteriores(n);
//			daonoticia.delete(n);
		
//		SetorNoticia s = daosetornoticia.readByNoticeTitleInSetor(x);
//		if (s==null) 
//			throw new Exception("excluir setor na noticia - setor inexistente ");
//		else
//		daosetornoticia.delete(s);
//		
//		TipoNoticia t = daotiponoticia.readByNoticeTitleInTipo(x);
//		if (t==null) 
//			throw new Exception("excluir tipo na noticia - tipo inexistente ");
//		else
//		daotiponoticia.delete(t);
		
		DAO.commit();
	}
	
	public static void excluirSetor(String n) throws Exception {
		DAO.begin();
		SetorNoticia s = daosetornoticia.readByDescription(n);
		if (s==null) 
			throw new Exception("excluir setor - setor inexistente:" + n);

		daosetornoticia.delete(s);
		DAO.commit();
	}
	
	public static void excluirTipo(String n) throws Exception {
		DAO.begin();
		TipoNoticia t = daotiponoticia.readByDescription(n);
		if (t==null) 
			throw new Exception("excluir setor - setor inexistente:" + n);

		daotiponoticia.delete(t);
		DAO.commit();
	}
	/**********************************************************
	 * 
	 * UPDATES 
	 * 
	 **********************************************************/
	public static void alterarTituloNoticia(String nome, String novonome) throws Exception{
		DAO.begin();		
		Noticia n = daonoticia.readByTitle(nome);	
		if (n==null)
			throw new Exception("alterar titulo noticia - titulo inexistente:" + nome);

		n.setTitulo(novonome);
		n=daonoticia.update(n);     	
		DAO.commit();	
	}
	public static void alterarConteudoNoticia(String titulo, String novoconteudo) throws Exception{
		DAO.begin();		
		Noticia n = daonoticia.readByTitle(titulo);	
		if (n==null)
			throw new Exception("alterar titulo noticia - titulo inexistente:" + titulo);

		n.setDescricao(novoconteudo); 			
		n=daonoticia.update(n);     	
		DAO.commit();	
	}
	/**********************************************************
	 * 
	 * Hash 
	 * 
	 **********************************************************/
	public static String getHash(byte[] inputBytes, String algorithm) {
		String hashValue = "";
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
			messageDigest.update(inputBytes);
			byte[] disgestedBytes = messageDigest.digest();
			hashValue = DatatypeConverter.printHexBinary(disgestedBytes).toLowerCase();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
			return hashValue;
	}
	
}




