package br.com.projetoGastos.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3894297862438700832L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idusuario")
	private Integer idUsuario;
	@Column(name="nome", length=50, nullable=false)
	private String nome;
	@Column(name="login", length=50, nullable=false)
	private String login;
	@Column(name="senha", length=50, nullable=false)
	private String senha;
	@Column(name="nome", length=50, nullable=false)
	private String foto;
	@OneToMany(mappedBy="gasto")
	private Collection<Gastos> gastos;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(Integer idUsuario, String nome, String login, String senha,
			String foto) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.foto = foto;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Collection<Gastos> getGastos() {
		return gastos;
	}

	public void setGastos(Collection<Gastos> gastos) {
		this.gastos = gastos;
	}

}
