package dao;

import java.util.List;

import com.db4o.query.Query;

import modelo.Noticia;

public class DAONoticia extends DAO<Noticia>{
	
	//Busca POR titulo 
	public Noticia readByTitle (String titulo) {
		Query q = manager.query();
		q.constrain(Noticia.class);
		q.descend("titulo").constrain(titulo);
		List<Noticia> resultados = q.execute();
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
	public  List<Noticia> consultarNoticiasPorParteTitulo(String caracteres) {
		Query q = manager.query();
		q.constrain(Noticia.class);
		q.descend("titulo").constrain(caracteres).like();
		q.descend("data").orderAscending();
		List<Noticia> result = q.execute(); 
		return result;
	}

	public  List<Noticia> consultarNoticiasPorParteConteudo(String caracteres) {
		Query q = manager.query();
		q.constrain(Noticia.class);
		q.descend("descricao").constrain(caracteres).like();
		q.descend("data").orderAscending();
		List<Noticia> result = q.execute(); 
		return result;
	}
	
}
