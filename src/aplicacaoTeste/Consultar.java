package aplicacaoTeste;

import fachada.Fachada;

public class Consultar {
	public Consultar(){
		
		Fachada.inicializar();
		
		try {
			Fachada.login("pedro", "123456");
		} catch (Exception e) {System.out.println(e.getMessage());}

		System.out.println(Fachada.getLogada());
		
		try {
			System.out.println(Fachada.consultarNoticiasPorParteTitulo("var") );
			System.out.println(Fachada.consultarNoticiasPorParteConteudo("cao") );
			System.out.println(Fachada.consultarNoticiasPorNomeSetor("Cejusc") );
			System.out.println(Fachada.consultarNoticiasPorNomeTipo("internet") );

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		//-***************

		Fachada.finalizar();
		System.out.println("fim do programa");
	}

	//=================================================
	public static void main(String[] args) {
		new Consultar();

	}
}




