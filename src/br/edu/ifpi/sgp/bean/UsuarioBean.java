package br.edu.ifpi.sgp.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.ifpi.sgp.model.dao.UsuarioDAO;
import br.edu.ifpi.sgp.model.dao.UsuarioDAOImpl;
import br.edu.ifpi.sgp.model.entity.Categoria;
import br.edu.ifpi.sgp.model.entity.Usuario;
import sun.net.httpserver.DefaultHttpServerProvider;
import sun.net.www.URLConnection;
import sun.net.www.http.HttpClient;

@ManagedBean(name="usuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = -5077573585589611427L;
	
	private String login, siape, nome;
	private List<Categoria> listCat;
	private UsuarioDAO usuarioDAOImpl;

	@PostConstruct
	public void inicializaDAO() {
		this.usuarioDAOImpl = new UsuarioDAOImpl();
	}

	public String adicionarUsuario() {
		try {
			if(nome.isEmpty() || login.isEmpty() || siape.isEmpty()){
				FacesContext.getCurrentInstance().addMessage("usuarioForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "Campos Inválidos", ""));
			}else{
				Usuario usuario = new Usuario();
				usuario.setNome(nome);
				usuario.setLogin(login);
				usuario.setSiape(siape);
				usuario.setListCategoria(listCat);
				//bucar por Siape antes de cadastrar novo
				this.usuarioDAOImpl.adicionarUsuario(usuario);
				FacesContext.getCurrentInstance().addMessage("usuarioForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário cadastrado com sucesso!", ""));
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("usuarioForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro ao cadastrar usuario", ""));
		} finally {
			return "cadastrarUsuario";
		}
	}

	/**
	 * Método faz login do usuário
	 */
	public String fazerLogin() {
		Usuario usuarioLook = new Usuario();
		usuarioLook = usuarioDAOImpl.buscarUsuario(usuarioLook);
		return "fazerLogin";
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

	public List<Categoria> getListCat() {
		return listCat;
	}

	public void setListCat(List<Categoria> listCat) {
		this.listCat = listCat;
	}
}
