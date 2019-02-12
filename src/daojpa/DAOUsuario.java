package daojpa;

import javax.persistence.NoResultException;
import javax.persistence.Query;

//import org.springframework.stereotype.Component;

import daojpa.DAO;
import modelo.Usuario;

//@Component("daousuario")
public class DAOUsuario extends DAO<Usuario>{
	//login
		public Usuario autenticar(String nome, String senha){
			try{
				Query q = manager.createQuery("select p from Usuario p where p.nome = '" + nome +"' and p.senha= '" + senha +"'");
				return (Usuario) q.getSingleResult();

			}catch(NoResultException e){			
				return null;
			}
		}
		
		public Usuario autenticarNomeUsuario(String nome)  {
			System.out.println("teste1.5");
			try{
				Query q = manager.createQuery("select p from Usuario p where p.nome = '" + nome +"'");
				return (Usuario) q.getSingleResult();

			}catch(NoResultException e){			
				return null;
			}

		}

}
