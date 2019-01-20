package daojpa;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import daojpa.DAO;
import modelo.SetorNoticia;

public class DAOSetorNoticia extends DAO<SetorNoticia>{
	
	//Busca POR descricao do setor 
			public SetorNoticia readByDescription (String descricao) {
				
				try{
					Query q = manager.createQuery("select p from SetorNoticia p where p.descricao= '" + descricao +"'");
					return (SetorNoticia) q.getSingleResult();

				}catch(NoResultException e){			
					return null;
				}
			}
			
			//Busca POR descricao do setor bool 
			public Boolean readByDescriptionBool (String descricao) {
				
				try{
					Query q = manager.createQuery("select p from SetorNoticia p where p.descricao= '" + descricao +"'");
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
			public  List<SetorNoticia> consultarNoticiasPorNomeSetor(String caracteres) {
				Query q = manager.createQuery(
						"select p from SetorNoticia p where p.descricao = :x");
				q.setParameter("x", caracteres);
				return q.getResultList();
			}
			
			//Busca POR titulo da noticia 
			public SetorNoticia readByNoticeTitleInSetor(String titulo) {
				Query q = manager.createQuery(
						"select p from SetorNoticia p where p.noticia in (select p.noticia from Noticia p where p.titulo=:x)");
				q.setParameter("x", titulo);
				return (SetorNoticia) q.getSingleResult();
			}

}
