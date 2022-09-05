
public class Cliente {

	private int id_cliente;
	private String nome;
	private String email;
	private String cidade;
	private int cep;
	private String senha;
	private String sobre_nome;
	private String estado;
	

	public int getid_cliente() {
		return id_cliente;
	}

	public void setid(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getnome() {
		return nome;
	}

	public void setnome(String nome) {
		this.nome = nome;
	}

	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}
	
	public String getcidade() {
		return cidade;
	}

	public void setcidade(String cidade) {
		this.cidade = cidade;
	}
	
	public int getcep() {
		return cep;
	}

	public void setcep(int cep) {
		this.cep = cep;
	}
 
	
	public String getsenha() {
		return senha;
	}

	public void setsenha(String senha) {
		this.senha = senha;
	}
	
	
	public String getsobre_nome() {
		return sobre_nome;
	}

	public void setsobre_nome(String sobre_nome) {
		this.sobre_nome = sobre_nome;
	}
	
	
	public String getestado() {
		return estado;
	}

	public void setestado(String estado) {
		this.estado = estado;
	}
	


}
