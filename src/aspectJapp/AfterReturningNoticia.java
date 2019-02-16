package aspectJapp;

import fachada.Fachada;

public class AfterReturningNoticia {
		public AfterReturningNoticia(){
			
			Fachada.inicializar();
			
			try {
				Fachada.login("pedro", "123456");
			} catch (Exception e) {System.out.println(e.getMessage());}

			System.out.println(Fachada.getLogada());
			
			try {
				System.out.println(Fachada.consultarNoticiasPorSetor("Cejusc") );

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			//-***************

			Fachada.finalizar();
			System.out.println("fim do programa");
		}

		//=================================================
		public static void main(String[] args) {
			new AfterReturningNoticia();

		}
	}




