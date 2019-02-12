package aplicacaoTeste;

import daojpa.AccountDAO;
import fachada.Fachada;

public class TesteMain {

	public static void main(String[] args) {
		
		AccountDAO acc = new AccountDAO();
		
		acc.addAccount();

Fachada.inicializar();
		
		try {
			Fachada.logoff();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println(Fachada.getLogada());
		
		try {
			Fachada.login("pedro", "123456");
		} catch (Exception e) {System.out.println(e.getMessage());}

		System.out.println(Fachada.getLogada());
		
		Fachada.finalizar();

	}

}
