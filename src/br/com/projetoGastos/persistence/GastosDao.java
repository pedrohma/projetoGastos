package br.com.projetoGastos.persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.projetoGastos.entity.Gastos;
import br.com.projetoGastos.hibernate.HibernateUtil;

public class GastosDao implements GastosInterface{
	
	private Session session;
	private Transaction transaction;
	private Query query;
	
	@Override
	public void salvar(Gastos gastos) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(gastos);
		transaction.commit();
		session.close();		
	}
	
	@Override
	public void editar(Gastos gastos) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(gastos);
		transaction.commit();
		session.close();		
	}
	
	@Override
	public void excluir(Gastos gastos) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(gastos);
		transaction.commit();
		session.close();
		
	}
	
	@Override
	public Gastos encontrar(Integer idGasto) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		return (Gastos) session.load(Gastos.class, idGasto);
	}
	
	@Override
	public List<Gastos> listarTodos() throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		List<Gastos> lista = session.createQuery("from Gastos").list();
		transaction.commit();
		return lista;
	}
	
	

}
