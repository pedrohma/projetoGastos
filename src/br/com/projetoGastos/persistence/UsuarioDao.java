package br.com.projetoGastos.persistence;

import java.io.Serializable;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.projetoGastos.entity.Usuario;
import br.com.projetoGastos.hibernate.HibernateUtil;

public class UsuarioDao implements UsuarioInterface, Serializable {

	private static final long serialVersionUID = -2418796191559534713L;
	
	private Session session;
	private Transaction transaction;
	private Query query;

	@Override
	public void salvar(Usuario usuario) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(usuario);
		transaction.commit();
		session.close();
	}

	@Override
	public Usuario logar(Usuario usuario) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session
				.createQuery("select u from Usuario as u where u.login = :login and u.senha = :senha");
		// executando a query mapeada
		query.setString("login", usuario.getLogin());
		// parametro -> :login
		query.setString("senha", usuario.getSenha());
		// parametro -> :senha
		Usuario u = (Usuario) query.uniqueResult();
		// retorna 1 unico registro ou null
		session.close();
		return u;
	}

}
