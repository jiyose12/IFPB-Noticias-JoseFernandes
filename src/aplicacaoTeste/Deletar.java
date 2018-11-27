package aplicacaoTeste;

import fachada.Fachada;

public class Deletar {
	public Deletar(){
		Fachada.inicializar();
		try {
			System.out.println("Deletando...");
			Fachada.excluirNoticia("O bb nasceu");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		Fachada.finalizar();
		System.out.println("fim do programa");
	}

	//=================================================
	public static void main(String[] args) {
		new Deletar();
	}
}
