import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class ContatoDAO {
	private static final Date Date = null;
	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Cliente cliente) {

		// os ? são os parâmetros que nós vamos adicionar na base de dados

		String sql = "INSERT INTO cliente(nome, email, cidade, cep, senha, sobre_nome, estado)" + " VALUES(?,?,?,?,?,?,?)";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, cliente.getnome());
			pstm.setString(2, cliente.getemail());
			pstm.setString(3, cliente.getcidade());
			pstm.setInt(4, cliente.getcep());
			pstm.setString(5, cliente.getsenha());
			pstm.setString(6, cliente.getsobre_nome());
			pstm.setString(7, cliente.getestado());

			// Executa a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			// Fecha as conexões

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public void removeById(int id) {

		String sql = "DELETE FROM cliente WHERE id_cliente = ?";

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public void update(Cliente cliente) {

		String sql = "UPDATE cliente SET nome = ?,email = ?, cidade = ?, cep = ?, senha = ?, sobre_nome = ?, estado = ?" + " WHERE id_cliente = ?";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
						
						pstm.setString(1, cliente.getnome());
						pstm.setString(2, cliente.getemail());
						pstm.setString(3, cliente.getcidade());
						pstm.setInt(4, cliente.getcep());
						pstm.setString(5, cliente.getsenha());
						pstm.setString(6, cliente.getsobre_nome());
						pstm.setString(7, cliente.getestado());
						pstm.setInt(8, cliente.getid_cliente());
			// Executa a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			// Fecha as conexões

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public List<Cliente> getClientes() {

		String sql = "SELECT * FROM cliente";

		List<Cliente> clientes = new ArrayList<Cliente>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				Cliente cliente = new Cliente();

				// Recupera o id do banco e atribui ele ao objeto
				cliente.setid(rset.getInt("id_cliente"));
				cliente.setnome(rset.getString("nome"));
				cliente.setemail(rset.getString("email"));
				cliente.setcidade(rset.getString("cidade"));
				cliente.setcep(rset.getInt("cep"));
				cliente.setsenha(rset.getString("senha"));
				cliente.setsobre_nome(rset.getString("sobre_nome"));
				cliente.setcidade(rset.getString("estado"));
				

				

				// Adiciono o contato recuperado, a lista de contatos
				clientes.add(cliente);
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {

				if (rset != null) {

					rset.close();
				}

				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		return clientes;
	}


	public Cliente getclienteByid(int id) {

		String sql = "SELECT * FROM cliente where id_cliente = ?";
		Cliente cliente = new Cliente();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();

			cliente.setid(rset.getInt("id_cliente"));
			cliente.setnome(rset.getString("nome"));
			cliente.setemail(rset.getString("email"));
			cliente.setcidade(rset.getString("cidade"));
			cliente.setcep(rset.getInt("cep"));
			cliente.setsenha(rset.getString("senha"));
			cliente.setsobre_nome(rset.getString("sobre_nome"));
			cliente.setcidade(rset.getString("estado"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cliente;
	}
	
	
	
	
	
	public void save(Hospedagem hospedagem) {

		// os ? são os parâmetros que nós vamos adicionar na base de dados

		String sql = "INSERT INTO hospedagem (nomeHosp, cidade, estado, rua)" + " VALUES(?,?,?,?)";

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, hospedagem.getnomeHosp());
			pstm.setString(2, hospedagem.getcidade());
			pstm.setString(3, hospedagem.getestado());
			pstm.setString(4, hospedagem.getrua());

			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			// Fecha as conexões

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public void removeById1(int id) {

		String sql = "DELETE FROM hospedagem WHERE id_hosp = ?";

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public void update(Hospedagem hospedagem) {

		String sql = "UPDATE hospedagem SET nomeHosp = ?,cidade = ?, estado = ?, rua = ?" + " WHERE id_hosp = ?";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
						
						pstm.setString(1, hospedagem.getnomeHosp());
						pstm.setString(2, hospedagem.getcidade());
						pstm.setString(3, hospedagem.getestado());
						pstm.setString(4, hospedagem.getrua());
						pstm.setInt(5, hospedagem.getid_hosp());
			// Executa a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			// Fecha as conexões

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public List<Hospedagem> getHospedagens() {

		String sql = "SELECT * FROM hospedagem";

		List<Hospedagem> hospedagens = new ArrayList<Hospedagem>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				Hospedagem hospedagem = new Hospedagem();

				// Recupera o id do banco e atribui ele ao objeto
				hospedagem.setid_hosp(rset.getInt("id_hosp"));
				hospedagem.setnomeHosp(rset.getString("nomeHosp"));
				hospedagem.setcidade(rset.getString("cidade"));
				hospedagem.setestado(rset.getString("estado"));
				hospedagem.setrua(rset.getString("rua"));
				

				

				// Adiciono o contato recuperado, a lista de contatos
				hospedagens.add(hospedagem);
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {

				if (rset != null) {

					rset.close();
				}

				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		return hospedagens;
	}


	public Hospedagem getHospedagemByid(int id) {

		String sql = "SELECT * FROM hospedagem where id_hosp = ?";
		Hospedagem hospedagem = new Hospedagem();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();

			hospedagem.setid_hosp(rset.getInt("id_hosp"));
			hospedagem.setnomeHosp(rset.getString("nomeHosp"));
			hospedagem.setcidade(rset.getString("cidade"));
			hospedagem.setestado(rset.getString("estado"));
			hospedagem.setrua(rset.getString("rua"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return hospedagem;
	}





public void save(Pct_viagem pct_viagem) {


	String sql = "INSERT INTO pct_viagem (preço, data_da_viagem, destino, condução, id_hosp)" + " VALUES(?,?,?,?,?)";

	try {
		conn = Conexao.createConnectionToMySQL();

		pstm = conn.prepareStatement(sql);

		pstm.setString(1, pct_viagem.getpreço());
		pstm.setString(2, pct_viagem.getdata_da_viagem());
		pstm.setString(3, pct_viagem.getdestino());
		pstm.setString(4, pct_viagem.getcondução());
		pstm.setInt(5, pct_viagem.id_hosp());
		
		pstm.execute();

	} catch (Exception e) {

		e.printStackTrace();
	} finally {

		// Fecha as conexões

		try {
			if (pstm != null) {

				pstm.close();
			}

			if (conn != null) {
				conn.close();
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}

public void removeById2(int id) {

	String sql = "DELETE FROM hospedagem WHERE id_hosp = ?";

	try {
		conn = Conexao.createConnectionToMySQL();

		pstm = conn.prepareStatement(sql);

		pstm.setInt(1, id);

		pstm.execute();

	} catch (Exception e) {

		e.printStackTrace();
	} finally {

		try {
			if (pstm != null) {

				pstm.close();
			}

			if (conn != null) {
				conn.close();
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}

public void update(Pct_viagem pct_viagem) {

	String sql = "UPDATE pct_viagem SET preço = ?,data_da_viagem = ?, destino = ?, condução = ?" + " WHERE id_destino = ?" + " WHERE id_hosp = ?";

	try {
		// Cria uma conexão com o banco
		conn = Conexao.createConnectionToMySQL();

		// Cria um PreparedStatment, classe usada para executar a query
		pstm = conn.prepareStatement(sql);

		// Adiciona o valor do primeiro parâmetro da sql
					
					pstm.setString(1, pct_viagem.getpreço());
					pstm.setString(2, pct_viagem.getdata_da_viagem());
					pstm.setString(3, pct_viagem.getdestino());
					pstm.setString(4, pct_viagem.getcondução());
		
		pstm.execute();

	} catch (Exception e) {

		e.printStackTrace();
	} finally {

		// Fecha as conexões

		try {
			if (pstm != null) {

				pstm.close();
			}

			if (conn != null) {
				conn.close();
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}

public List<Pct_viagem> getPct_viagens() {

	String sql = "SELECT * FROM pct_viagem";

	List<Pct_viagem> pct_viagens = new ArrayList<Pct_viagem>();

	// Classe que vai recuperar os dados do banco de dados
	ResultSet rset = null;

	try {
		conn = Conexao.createConnectionToMySQL();

		pstm = conn.prepareStatement(sql);

		rset = pstm.executeQuery();

		// Enquanto existir dados no banco de dados, faça
		while (rset.next()) {

			Pct_viagem pct_viagem = new Pct_viagem();

			// Recupera o id do banco e atribui ele ao objeto
			pct_viagem.setpreço(rset.getString("preço"));
			pct_viagem.setdata_da_viagem(rset.getString("data_da_viagem"));
			pct_viagem.setdestino(rset.getString("destino"));
			pct_viagem.setcondução(rset.getString("condução"));
            
			

			// Adiciono o contato recuperado, a lista de contatos
			pct_viagens.add(pct_viagem);
		}
	} catch (Exception e) {

		e.printStackTrace();
	} finally {

		try {

			if (rset != null) {

				rset.close();
			}

			if (pstm != null) {

				pstm.close();
			}

			if (conn != null) {
				conn.close();
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	return pct_viagens;
}


public Pct_viagem getPct_viagemByid(int id) {

	String sql = "SELECT * FROM pct_viagem where id_destino = ?";
	Pct_viagem pct_viagem = new Pct_viagem();

	ResultSet rset = null;

	try {
		conn = Conexao.createConnectionToMySQL();
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, id);
		rset = pstm.executeQuery();

		rset.next();

		pct_viagem.setpreço(rset.getString("preço"));
		pct_viagem.setdata_da_viagem(rset.getString("data_da_viagem"));
		pct_viagem.setdestino(rset.getString("destino"));
		pct_viagem.setcondução(rset.getString("condução"));

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if (rset != null) {
				rset.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	return pct_viagem;
}
}