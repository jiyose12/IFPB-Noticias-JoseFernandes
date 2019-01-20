package daojpa;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import daojpa.DAO;
import modelo.Noticia;

public class DAONoticia extends DAO<Noticia>{
	
	public Noticia readByTitle (String titulo) {
		
		try{
			Query q = manager.createQuery("select p from Noticia p where p.titulo= '" + titulo +"'");
			return (Noticia) q.getSingleResult();

		}catch(NoResultException e){			
			return null;
		}
		
	}
	/**********************************************************
	 * 
	 * TODAS AS CONSULTAS DO SISTEMA
	 * 
	 **********************************************************/
	@SuppressWarnings("unchecked")
	public  List<Noticia> consultarNoticiasPorParteTitulo(String caracteres) {
		Query q = manager.createQuery(
				"select p from Noticia p where p.titulo like '%:x%' order by p.data ASC");
		q.setParameter("x", caracteres);
		return q.getResultList();
	}
	@SuppressWarnings("unchecked")
	public  List<Noticia> consultarNoticiasPorParteConteudo(String caracteres) {
		Query q = manager.createQuery(
				"select p from Noticia p where p.descricao like '%:x%' order by p.data ASC");
		q.setParameter("x", caracteres);
		return q.getResultList();
	}
	

}
