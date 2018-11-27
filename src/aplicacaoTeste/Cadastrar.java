package aplicacaoTeste;

import fachada.Fachada;
import modelo.Noticia;
import modelo.SetorNoticia;
import modelo.TipoNoticia;
import modelo.Usuario;

public class Cadastrar {

	public Cadastrar(){
		Fachada.inicializar();
		Noticia n;
		SetorNoticia s;
		TipoNoticia t;
		Usuario u;
		//Cadastro Usuarios
		
		try {
			System.out.println("cadastrando Usuarios...");
			u=Fachada.cadastrarUsuario("jose", "asd123");
			u=Fachada.cadastrarUsuario("pedro", "123456");
			
		} catch (Exception e) {System.out.println(e.getMessage());}
		
		//Logoff
				try {
					Fachada.logoff();
				} catch (Exception e) {System.out.println(e.getMessage());}
		//Login
		try {
			Fachada.login("pedro", "123456");
			System.out.println(Fachada.getLogada());
		} catch (Exception e) {System.out.println(e.getMessage());}
		//Cadastro Setores
		try {
			System.out.println("cadastrando setor...");
			s=Fachada.cadastrarSetorNoticia(null);
			s=Fachada.cadastrarSetorNoticia("Cejusc");
			s=Fachada.cadastrarSetorNoticia("1 Vara");
			s=Fachada.cadastrarSetorNoticia("2 Vara");
			s=Fachada.cadastrarSetorNoticia("3 Vara");
			s=Fachada.cadastrarSetorNoticia("4 Vara");
			s=Fachada.cadastrarSetorNoticia("5 Vara");
			s=Fachada.cadastrarSetorNoticia("6 Vara");
			s=Fachada.cadastrarSetorNoticia("7 Vara");
			
		} catch (Exception e) {System.out.println(e.getMessage());}
		//Cadastro Tipos
		try {
			System.out.println("cadastrando tipos...");
			t=Fachada.cadastrarTipoNoticia(null);
			t=Fachada.cadastrarTipoNoticia("internet");
			t=Fachada.cadastrarTipoNoticia("intranet");
			
		} catch (Exception e) {System.out.println(e.getMessage());}
		//Cadastro Noticias
		try {
			System.out.println("cadastrando noticia...");
			n=Fachada.cadastrarNoticia(999, "noticiaanterior", "este é o obj referente as noticias anteriores", null, null);
			n=Fachada.cadastrarNoticia(1,"O bb nasceu", "entao essa é a descricao do bb nascendo", "Cejusc", "intranet");
			n=Fachada.cadastrarNoticia(2,"Limpeza na 3 vara ", "vao limpar tudo aqui", "1 Vara" , "internet");
			n=Fachada.cadastrarNoticia(3,"Maior taxa de conciciação de todos os tempos", "No dia de hje foram registradas 4 conciliacoes", "Cejusc", "intranet");
			n=Fachada.cadastrarNoticia(4,"Revista Judiciaria foi lancada na vara", "A realizacao da cerimonia foi realizada", "2 Vara", "internet");
			n=Fachada.cadastrarNoticia(5,"Servidor tomou posse", "O servidor fulano tomou posse no setor de distribuicao em Sousa", "7 Vara", "internet");
			
		} catch (Exception e) {System.out.println(e.getMessage());}
		
		
		Fachada.finalizar();
		System.out.println("fim do programa");
		System.out.println("\n\naviso: feche sempre o plugin do banco eclipse antes de executar aplicação");
	}
	
	//=================================================
		public static void main(String[] args) {
			new Cadastrar();
		}
}
