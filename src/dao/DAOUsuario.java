package dao;

import java.util.List;

import com.db4o.query.Query;

import modelo.Usuario;

public class DAOUsuario extends DAO<Usuario>{
	//login
	public Usuario autenticar(String nome, String senha){

		Usuario a = autenticarNomeUsuario(nome);
		System.out.println(a);
		Usuario b = autenticarSenhaUsuario(senha);
		System.out.println(b);
		if(a != null && b != null) {
			return a;
		}
		return null;
	}
	public Usuario autenticarNomeUsuario(String nome)  {

		Query q = manager.query();
		q.constrain(Usuario.class);
		q.descend("nome").constrain(nome);
		List<Usuario> user =  q.execute(); 
		if (user.size()>0)
			return user.get(0);
		else
			return null;
	}
	public Usuario autenticarSenhaUsuario(String senha)  {

		Query q = manager.query();
		q.constrain(Usuario.class);
		q.descend("senha").constrain(senha);
		List<Usuario> user = q.execute(); 
		if (user.size()>0)
			return user.get(0);
		else
			return null;
	}
}
