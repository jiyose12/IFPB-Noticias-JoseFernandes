package daojpa;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import daojpa.DAO;
import modelo.BackupNoticia;

public class DAOBackupNoticia extends DAO<BackupNoticia>{
	
	public BackupNoticia readByTitle (String titulo) {
		
		try{
			Query q = manager.createQuery("select p from Noticia p where p.titulo= '" + titulo +"'");
			return (BackupNoticia) q.getSingleResult();

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
	public  List<BackupNoticia> consultarNoticiasPorParteTitulo(String caracteres) {
		Query q = manager.createQuery(
				"select p from Noticia p where p.titulo like :y order by p.data ASC");
		q.setParameter("y", "%"+caracteres+"%");
		return q.getResultList();
	}
	@SuppressWarnings("unchecked")
	public  List<BackupNoticia> consultarNoticiasPorParteConteudo(String caracteres) {
		Query q = manager.createQuery(
				"select p from Noticia p where p.descricao like :x order by p.data ASC");
		q.setParameter("x", "%"+caracteres+"%");
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public  List<BackupNoticia> consultarNoticiasPorSetor(String caracteres) {
		Query q = manager.createQuery(
				"select p from Noticia p join p.setor s where s.descricao = :z order by p.data ASC");
		q.setParameter("z", caracteres);
		return q.getResultList();
	}
	

}
