package dao;

import java.util.List;

import com.db4o.query.Query;

import modelo.Noticia;
import modelo.SetorNoticia;

public class DAOSetorNoticia extends DAO<SetorNoticia>{

	//Busca POR descricao do setor 
		public SetorNoticia readByDescription (String descricao) {
			Query q = manager.query();
			q.constrain(SetorNoticia.class);
			q.descend("descricao").constrain(descricao);
			List<SetorNoticia> resultados = q.execute();
			if (resultados.size()>0)
				return resultados.get(0);
			else
				return null;
		}
	
		/**********************************************************
		 * 
		 * TODAS AS CONSULTAS DO SISTEMA
		 * 
		 **********************************************************/
		public  List<SetorNoticia> consultarNoticiasPorNomeSetor(String caracteres) {
			Query q = manager.query();
			q.constrain(SetorNoticia.class);
			q.descend("descricao").constrain(caracteres).contains();
			q.descend("data").orderAscending();
			List<SetorNoticia> resultados = q.execute();
			return resultados;
		}
		//Busca POR titulo da noticia 
		public SetorNoticia readByNoticeTitleInSetor(String titulo) {
			Query q = manager.query();
			q.constrain(SetorNoticia.class);
			q.descend("noticias").descend("titulo").constrain(titulo);
			List<SetorNoticia> resultados = q.execute();
			if (resultados.size()>0)
				return resultados.get(0);
			else
				return null;
		}
}
