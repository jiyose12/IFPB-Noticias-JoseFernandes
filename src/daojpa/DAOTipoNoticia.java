package daojpa;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import daojpa.DAO;
import modelo.SetorNoticia;
import modelo.TipoNoticia;

public class DAOTipoNoticia extends DAO<TipoNoticia>{
	
	//Busca POR descricao do Tipo Noticia 
	public TipoNoticia readByDescription (String descricao) {
		
		try{
			Query q = manager.createQuery("select p from TipoNoticia p where p.descricao= '" + descricao +"'");
			return (TipoNoticia) q.getSingleResult();

		}catch(NoResultException e){			
			return null;
		}
	}
	//Busca POR descricao do Tipo Noticia 
		public Boolean readByDescriptionBool (String descricao) {
			
			try{
				Query q = manager.createQuery("select p from TipoNoticia p where p.descricao= '" + descricao +"'");
				return true;

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
	public  List<TipoNoticia> consultarNoticiasPorNomeTipo(String caracteres) {
		Query q = manager.createQuery(
				"select p from TipoNoticia p where p.descricao = :x");
		q.setParameter("x", caracteres);
		return q.getResultList();

	}
	//Busca POR titulo da noticia 
	public TipoNoticia readByNoticeTitleInTipo(String titulo) {
		Query q = manager.createQuery(
				"select p from TipoNoticia p where p.noticia in (select p.noticia from Noticia p where p.titulo=:x)");
		q.setParameter("x", titulo);
		return (TipoNoticia) q.getSingleResult();
	}

}
