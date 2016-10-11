package br.edu.ifpi.sgp.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.ifpi.sgp.model.dao.UsuarioDAO;
import br.edu.ifpi.sgp.model.dao.UsuarioDAOImpl;
import br.edu.ifpi.sgp.model.entity.Usuario;

@ManagedBean(name = "usuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = -5077573585589611427L;

	private String login, siape, nome;
	private UsuarioDAO usuarioDAOImpl;
	private Usuario usuario = new Usuario();

	@PostConstruct
	public void inicializaDAO() {
		this.usuarioDAOImpl = new UsuarioDAOImpl();
	}

	// metodos

	public String adicionarUsuario() {
		try {
			if (nome.isEmpty() || login.isEmpty() || siape.isEmpty()) {
				FacesContext.getCurrentInstance().addMessage("usuarioForm",
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Campos Inválidos", ""));
			} else {
				Usuario usuario = new Usuario();
				usuario.setNome(nome);
				usuario.setLogin(login);
				usuario.setSiape(siape);
				usuario.setStatus(true);
				// bucar por Siape antes de cadastrar novo
				this.usuarioDAOImpl.adicionarUsuario(usuario);
				FacesContext.getCurrentInstance().addMessage("usuarioForm",
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário cadastrado com sucesso!", ""));
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("usuarioForm",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro ao cadastrar usuario", e.getMessage()));
			return "erro";
		} finally {
			return "cadastrarUsuario";
		}
	}

	/**
	 * Método faz login do usuário
	 */
	public String fazerLogin() {
		usuario = usuarioDAOImpl.buscarUsuarioNomeSenha(login, siape);
		if (usuario == null) {
			usuario = new Usuario();
            FacesContext.getCurrentInstance().addMessage("usuarioForm",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário não encontrado!", "Login Inválido"));
            return null;
		}else{
			System.out.println("Usuario encontrado -> " + usuario.toString());
			return "paginaPrincipal";
		}
	}

	/**
	 * Método faz logout do usuário
	 */
	public String fazerLogout() {
		return "fazerLogout";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSiape() {
		return siape;
	}

	public void setSiape(String siape) {
		this.siape = siape;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
