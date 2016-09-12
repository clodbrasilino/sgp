package br.edu.ifpi.sgp.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	private long idUsuario;
	private String nome;
	private String login;
	private String siape;
	private boolean status = true;
	@ManyToMany(mappedBy="listUsuario")
	private List<Categoria> listCategoria;
	
	public Usuario() {
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSiape() {
		return siape;
	}

	public void setSiape(String siape) {
		this.siape = siape;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public List<Categoria> getListCategoria() {
		return listCategoria;
	}

	public void setListCategoria(List<Categoria> listCategoria) {
		this.listCategoria = listCategoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idUsuario ^ (idUsuario >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (idUsuario != other.idUsuario)
			return false;
		return true;
	}
}
