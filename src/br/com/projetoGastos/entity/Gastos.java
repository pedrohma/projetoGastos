package br.com.projetoGastos.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "gasto")
public class Gastos {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idgasto")
	private Integer idGasto;
	@Column(name="titulo", length=50, nullable=false)
	private String titulo;
	@Column(name="valor", nullable=false)
	private Double valor;
	@Temporal(TemporalType.DATE)
	@Column(name="data", nullable=false)
	private Date dataGasto;
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;
	
	public Gastos() {
		// TODO Auto-generated constructor stub
	}

	public Gastos(Integer idGasto, String titulo, Double valor, Date dataGasto,
			Usuario usuario) {
		super();
		this.idGasto = idGasto;
		this.titulo = titulo;
		this.valor = valor;
		this.dataGasto = dataGasto;
		this.usuario = usuario;
	}

	public Integer getIdGasto() {
		return idGasto;
	}

	public void setIdGasto(Integer idGasto) {
		this.idGasto = idGasto;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getDataGasto() {
		return dataGasto;
	}

	public void setDataGasto(Date dataGasto) {
		this.dataGasto = dataGasto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
