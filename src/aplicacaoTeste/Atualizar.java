package aplicacaoTeste;

import fachada.Fachada;

public class Atualizar {
	public Atualizar(){
		Fachada.inicializar();
		try {
			System.out.println("alterando...");
			Fachada.alterarTituloNoticia("O bb nasceu", "eita q eu alterei o titulo");
			Fachada.alterarConteudoNoticia("Servidor tomou posse", "Alterei a descricao");

		} catch (Exception e) {System.out.println(e.getMessage());}
		
		try {
			Fachada.alterarTituloNoticia("889999", "88883333"); //produz erro
		} catch (Exception e) {System.out.println(e.getMessage());}
		
		Fachada.finalizar();
		System.out.println("fim do programa");
	}

	
	

	//=================================================
	public static void main(String[] args) {
		new Atualizar();
	}

}
