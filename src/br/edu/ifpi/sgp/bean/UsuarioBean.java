package br.edu.ifpi.sgp.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.ifpi.sgp.model.dao.UsuarioDAO;
import br.edu.ifpi.sgp.model.dao.UsuarioDAOImpl;
import br.edu.ifpi.sgp.model.entity.Usuario;

@ManagedBean(name = "usuarioBean")
@ViewScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
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
			if (getLogin().isEmpty() || getSiape().isEmpty()) {
				FacesContext.getCurrentInstance().addMessage("usuarioForm",
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Campos Inválidos", ""));
			} else {
				Usuario usuario = new Usuario();
				usuario.setNome(getNome());
				usuario.setLogin(getLogin());
				usuario.setSiape(getSiape());
				usuario.setStatus(true);
				// bucar por Siape antes de cadastrar novo
				this.usuarioDAOImpl.adicionarUsuario(usuario);
				FacesContext.getCurrentInstance().addMessage("usuarioForm",
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário cadastrado com sucesso!", ""));
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("usuarioForm",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro ao cadastrar usuario", e.getMessage()));
		} finally {
			return "cadastrarUsuario";
		}
	}

	/**
	 * Método faz login do usuário
	 */
	public String fazerLogin() {
		try {
			// verificando se é o primero usuario
			//verifica qnt de usuario do sistema, caso não tenha, é criado um aqui com dados da session
			System.out.println("blaaaaa");
			Long count = usuarioDAOImpl.contador(); // retorna o numero de linhas da coluna 
			if (count == 0) {
				adicionarUsuario();
				FacesContext.getCurrentInstance().addMessage("usuarioForm",
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Login com sucesso!", ""));
				return "paginaPrincipal";
			}else if(count > 0){
				usuario = usuarioDAOImpl.buscarUsuarioNomeSenha(getLogin(), getSiape());
				if (usuario == null) {
					FacesContext.getCurrentInstance().addMessage("usuarioForm",
							new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário não encontrado!", "Login Inválido"));
					return null;
				}else{
					FacesContext.getCurrentInstance().addMessage("usuarioForm",
							new FacesMessage(FacesMessage.SEVERITY_INFO, "Login com sucesso!", ""));
					return "paginaPrincipal";
				}
			}else{
				return null;
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("usuarioForm",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário não encontrado!", e.toString()));
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * faz logout do Usuário
	 */
	public String fazerLogout() {
		return "fazerLogout";
	}
	
	public String editarUsuario(){
		return "";
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
