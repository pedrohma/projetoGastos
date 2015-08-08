package br.com.projetoGastos.persistence;

import java.util.List;

import br.com.projetoGastos.entity.Gastos;

public interface GastosInterface {
	
	public void salvar(Gastos gastos) throws Exception;
	
	public void editar(Gastos gastos) throws Exception;
	
	public void excluir(Gastos gastos) throws Exception;
	
	public Gastos encontrar(Integer idGasto) throws Exception;
	
	public List<Gastos> listarTodos() throws Exception;

}
