
import java.util.Scanner;

public class Principal {
	
	public static void main(String args[]) {

		ContatoDAO contatoDAO = new ContatoDAO();
		Cliente cliente = new Cliente();
		Hospedagem hospedagem = new Hospedagem();
		Pct_viagem pct_viagem = new Pct_viagem();
		
		
		Scanner entrada = new Scanner(System.in);
		int opcao = 0;
		String nome = "";
		String email = "";
		String cidade = "";
		int cep = 0;
		String senha = "";
		String sobre_nome = "";
		String estado = "";
		int id_cliente = 0;
		
		int id_hosp = 0;
		String nomeHosp = "";
		String rua = "";
		
		
		int id_destino = 0;
		String preço = "";
		String data_da_viagem = "" ;
		String destino = "";
		String condução = "";
		
		
		do		
		{
		System.out.println("===== Cadastros =====");
		System.out.println("1 - Cadastro de cliente");
		System.out.println("2 - Cadastrar Hospedagem");
		System.out.println("3 - Cadastrar Pacote de Viagem");
		opcao = entrada.nextInt();

		switch (opcao) {
		
		case 1: {

			System.out.println("===== Cadastrar cliente =====");
			System.out.println("1 - Cadastro de cliente");
			System.out.println("2 - Exluir cliente");
			System.out.println("3 - Atualizar cliente");
			System.out.println("4 - Mostrar cliente");
			System.out.println("5 - Buscar por ID");
			System.out.println("6 - Sair");
			opcao = entrada.nextInt();

			switch (opcao) {
			case 1: {
				System.out.println("Digite o seu nome ");
				nome = entrada.next();
				cliente.setnome(nome);
				
				System.out.println("Digite o seu email ");
				email = entrada.next();
				cliente.setemail(email);
				
				System.out.println("Digite a sua cidade ");
				cidade = entrada.next();
				cliente.setcidade(cidade);
				
				System.out.println("Digite o CEP do usuario: ");
				cep = entrada.nextInt();
				cliente.setcep(cep);
				
				System.out.println("senha ");
				senha = entrada.next();
				cliente.setsenha(senha);
				
				System.out.println("Digite o seu sobre nome ");
				sobre_nome = entrada.next();
				cliente.setsobre_nome(sobre_nome);
				
				System.out.println("Digite seu estado ");
				estado = entrada.next();
				cliente.setsenha(estado);

				

				contatoDAO.save(cliente);
				break;
			}
			case 2: {
				System.out.println("Digite o codigo do contato para exclusao: ");
				try {
					id_cliente = entrada.nextInt();
					
					contatoDAO.removeById(id_cliente);
					
				} catch (Exception e) {
					// e.getMessage();
					 
					System.out.println(" Nenhum cliente para excluir ");
				}

				break;
			}
			
			case 3: {

				System.out.println("Digite o id do cliente para atualizar: ");
				id_cliente = entrada.nextInt();

				System.out.println("Digite o novo nome de cliente: ");
				nome = entrada.next();
				cliente.setnome(nome);

				System.out.println("Digite o email: ");
				email = entrada.next();
				cliente.setemail(email);

				System.out.println("Digite a cidade ");
				cidade = entrada.next();
				cliente.setcidade(cidade);
				
				System.out.println("Digite o CEP do usuario: ");
				cep = entrada.nextInt();
				cliente.setcep(cep);

				System.out.println("senha");
				senha = entrada.next();
				cliente.setsenha(senha);

				System.out.println("Digite o Sobre nome ");
				sobre_nome = entrada.next();
				cliente.setsobre_nome(sobre_nome);
				
				System.out.println("Digite o Estado ");
				estado = entrada.next();
				cliente.setestado(estado);
				

				cliente.setid(id_cliente);

				contatoDAO.update(cliente);
			}
			case 4: {
				for (Cliente c : contatoDAO.getClientes()) {

					System.out.println("NOME: " + c.getnome());
					System.out.println("email: " + c.getemail());
					System.out.println("cidade: " + c.getcidade());
					System.out.println("cep: " + c.getcep());
					System.out.println("senha: " + c.getsenha());
					System.out.println("Sobre nome: " + c.getsobre_nome());
					System.out.println("Estado: " + c.getestado());

					System.out.println("----------------------------------- ");
				}
				break;
			}
			case 5: {

				System.out.print("Digite o ID para buscar: ");
				int id1 = entrada.nextInt();
				
				Cliente c = new Cliente();

				c = contatoDAO.getclienteByid(id1);

				System.out.println("NOME: " + c.getnome());
				System.out.println("email: " + c.getemail());
				System.out.println("cidade: " + c.getcidade());
				System.out.println("cep: " + c.getcep());
				System.out.println("senha: " + c.getsenha());
				System.out.println("Sobre nome: " + c.getsobre_nome());
				System.out.println("Estado: " + c.getestado());

				System.out.println("----------------------------------- ");
			}
				break;

			case 6: {
				System.out.println(" === Obrigado por se cadastrar === ");
				break;
			}
			default:
				System.out.println("Opcao invalida: ");

			}
			;

		} 

	
	
	
	
	break;
	
	
		case 2 : {
		
		
		

		System.out.println("===== Cadastrar Viagens =====");
		System.out.println("1 - Cadastrar Hospedagem");
		System.out.println("2 - Exluir Hospedagem");
		System.out.println("3 - Atualizar Hospedagem");
		System.out.println("4 - Mostrar Hospedagem");
		System.out.println("5 - Buscar por ID");
		System.out.println("6 - Sair");
		opcao = entrada.nextInt();

		switch (opcao) {
		case 1: {
			System.out.println("Digite o  nome da Hospedagem");
			nomeHosp = entrada.next();
			hospedagem.setnomeHosp(nomeHosp);
						
			System.out.println("Digite a sua cidade ");
			cidade = entrada.next();
			hospedagem.setcidade(cidade);
			
			System.out.println("Digite o Estado da Hospedagem: ");
			estado = entrada.next();
			hospedagem.setestado(estado);
			
			System.out.println("Digite a rua ");
			rua = entrada.next();
			hospedagem.setrua(rua);
			
					

			contatoDAO.save(hospedagem);
			break;
		}
		case 2: {
			System.out.println("Digite o codigo da hospedagem para exclusao: ");
			try {
				id_hosp = entrada.nextInt();
				
				contatoDAO.removeById1(id_hosp);
				
			} catch (Exception e) {
				// e.getMessage();
				 
				System.out.println(" Nenhuma hospedagem para excluir ");
			}

			break;
		}
		
		case 3: {

			System.out.println("Digite o id da hospedagem para atualizar: ");
			id_hosp = entrada.nextInt();

			System.out.println("Digite o  nome da Hospedagem");
			nomeHosp = entrada.next();
			hospedagem.setnomeHosp(nomeHosp);
						
			System.out.println("Digite a sua cidade ");
			cidade = entrada.next();
			hospedagem.setcidade(cidade);
			
			System.out.println("Digite o Estado da Hospedagem: ");
			estado = entrada.next();
			hospedagem.setestado(estado);
			
			System.out.println("Digite a rua ");
			rua = entrada.next();
			hospedagem.setrua(rua);
			

			hospedagem.setid_hosp(id_hosp);

			contatoDAO.update(hospedagem);
		}
		case 4: {
			for (Hospedagem h : contatoDAO.getHospedagens()) {

				System.out.println("NOME: " + h.getnomeHosp());
				System.out.println("email: " + h.getcidade());
				System.out.println("cidade: " + h.getestado());
				System.out.println("cep: " + h.getrua());
				System.out.println("----------------------------------- ");
			}
			break;
		}
		case 5: {

			System.out.print("Digite o ID para buscar: ");
			int id2 = entrada.nextInt();
			
			Hospedagem h = new Hospedagem();

			h = contatoDAO.getHospedagemByid(id2);

			System.out.println("NOME: " + h.getnomeHosp());
			System.out.println("email: " + h.getcidade());
			System.out.println("cidade: " + h.getestado());
			System.out.println("cep: " + h.getrua());
			System.out.println("----------------------------------- ");
		}
			break;

		case 6: {
			System.out.println(" === Obrigado por se cadastrar === ");
			break;
		}
		default:
			System.out.println("Opcao invalida: ");

		}
		;

	}
		break;
		
		
		
		
		case 3:{
			
		System.out.println("===== Cadastro PAcote de Viagem =====");
		System.out.println("1 - Cadastro destino");
		System.out.println("2 - Excluir destino");
		System.out.println("3 - Atualizar destino");
		System.out.println("4 - Mostrar destinos");
		System.out.println("5 - Buscar por ID");
		System.out.println("6 - Sair");
		opcao = entrada.nextInt();

		switch (opcao) {
		case 1: {
			System.out.println("Digite o preço do destino: ");
			preço= entrada.next();
			pct_viagem.setpreço(preço);

			System.out.println("Digite a data da viagem");
			data_da_viagem = entrada.next();
			pct_viagem.setdata_da_viagem(data_da_viagem);

			System.out.println("Digite o destino");
			destino = entrada.next();
			pct_viagem.setdestino(destino);
			
			System.out.println("Digite o veiculo ");
			condução = entrada.next();
			pct_viagem.setcondução(condução);

			System.out.println("Digite o Id da Hospedagem: ");
			id_hosp = entrada.nextInt();
			pct_viagem.setid_hosp(id_hosp);

			contatoDAO.save(pct_viagem);
			break;
		}
		case 2: {
			System.out.println("Digite o codigo do contato para exclusao: ");
			try {
				id_destino = entrada.nextInt();
				
				contatoDAO.removeById2(id_destino);
				
			} catch (Exception e) {
				// e.getMessage();
				 
				System.out.println(" Nenhum contato para excluir ");
			}

			break;
		}
		case 3: {

			System.out.println("Digite o codigo do contato para atualizar: ");
			id_destino = entrada.nextInt();

			System.out.println("Digite o preço do destino: ");
			nome = entrada.next();
			pct_viagem.setpreço(preço);

			System.out.println("Digite a data da viagem");
			data_da_viagem = entrada.next();
			pct_viagem.setdata_da_viagem(data_da_viagem);

			System.out.println("Digite o destino");
			destino = entrada.next();
			pct_viagem.setdestino(destino);
			
			System.out.println("Digite o veiculo ");
			condução = entrada.next();
			pct_viagem.setcondução(condução);

			System.out.println("Digite o Id da Hospedagem: ");
			id_hosp = entrada.nextInt();
			pct_viagem.setid_hosp(id_hosp);

			pct_viagem.setid_destino(id_destino);

			contatoDAO.update(pct_viagem);
		}
		case 4: {
			for (Pct_viagem v : contatoDAO.getPct_viagens()) {

				System.out.println("PREÇO DA VIAGEM: " + v.getpreço());
				System.out.println("DATA DA VIAGEM: " + v.getdata_da_viagem());
				System.out.println("NOME DO PACOTE DE VIAGEM: " + v.getdestino());
				System.out.println("QUAL VEICULO?: " + v.getcondução());
				System.out.println("----------------------------------- ");
			}
			break;
		}
		case 5: {

			System.out.print("Digite o ID para buscar: ");
			int id2 = entrada.nextInt();
			
			Pct_viagem v = new Pct_viagem();

			v = contatoDAO.getPct_viagemByid(id2);

			System.out.println("PREÇO DA VIAGEM: " + v.getpreço());
			System.out.println("DATA DA VIAGEM: " + v.getdata_da_viagem());
			System.out.println("NOME DO PACOTE DE VIAGEM: " + v.getdestino());
			System.out.println("QUAL VEICULO?: " + v.getcondução());
			System.out.println("----------------------------------- ");
		}
			break;

		case 6: {
			System.out.println(" === Obrigado por usar nossa Agenda === ");
			break;
		}
		default:
			System.out.println("Opcao invalida: ");
			
		}

}
		
		}

		}while (opcao != 6);

		entrada.close();
		
		
		
		

		}
	
	
}