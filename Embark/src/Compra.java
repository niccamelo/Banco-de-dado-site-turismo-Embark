
public class Compra {
	private  int nota_fiscal;
	private  String  data_compra;
	private  String nome_cliente;
	private int quantidade_compra;
	private String destino ;
	private int cpf_cliente;

	public int getnota_fiscal() {
		return nota_fiscal;
	}

	public void setnota_fiscal(int nota_fiscal) {
		this.nota_fiscal = nota_fiscal;
	}

	
	public String getdata_compra() {
		return data_compra;
	}

	public void setdata_compra(String data_compra) {
		this.data_compra = data_compra;
	}
	
	
	public String getnome_cliente() {
		return nome_cliente;
	}

	public void setnome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}
	
	
	public int getquantidade_compra() {
		return quantidade_compra;
	}

	public void setquantidade_compra(int quantidade_compra) {
		this.quantidade_compra = quantidade_compra;
	}
	
	
	public int getcpf_cliente() {
		return cpf_cliente;
	}

	public void setcpf_cliente(int cpf_cliente) {
		this.cpf_cliente = cpf_cliente;
	}
	
	
	public String getdestino() {
		return destino;
	}

	public void setdestino(String destino) {
		this.destino = destino;
	}
}
