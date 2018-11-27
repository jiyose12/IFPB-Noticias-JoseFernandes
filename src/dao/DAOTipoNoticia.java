package dao;

import java.util.List;

import com.db4o.query.Query;

import modelo.SetorNoticia;
import modelo.TipoNoticia;

public class DAOTipoNoticia extends DAO<TipoNoticia>{
	
	//Busca POR descricao do Tipo Noticia 
			public TipoNoticia readByDescription (String descricao) {
				Query q = manager.query();
				q.constrain(TipoNoticia.class);
				q.descend("descricao").constrain(descricao);
				List<TipoNoticia> resultados = q.execute();
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
			public  List<TipoNoticia> consultarNoticiasPorNomeTipo(String caracteres) {
				Query q = manager.query();
				q.constrain(TipoNoticia.class);
				q.descend("descricao").constrain(caracteres).contains();
				q.descend("data").orderAscending();
				List<TipoNoticia> resultados = q.execute(); 
				return resultados;
			}
			//Busca POR titulo da noticia 
			public TipoNoticia readByNoticeTitleInTipo(String titulo) {
				Query q = manager.query();
				q.constrain(TipoNoticia.class);
				q.descend("noticias").descend("titulo").constrain(titulo);
				List<TipoNoticia> resultados = q.execute();
				if (resultados.size()>0)
					return resultados.get(0);
				else
					return null;
			}

}
