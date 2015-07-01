package br.edu.ifg.tads.mtp.eventif.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;

import br.edu.ifg.tads.mtp.eventif.bd.ConnectionFactory;
import br.edu.ifg.tads.mtp.eventif.model.AlunoModel;

public class AlunoDao {
	public boolean adiconaAluno(AlunoModel aluno) {
		boolean retorno = true;
		String sql = "insert into aluno (idPessoa, senha) values(?,?)";
		Connection con = null;
		try {
			con = new ConnectionFactory().getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, aluno.getIdPessoa());
			stmt.setString(2, aluno.getSenha());

			stmt.execute();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Não deu pra inserir " + e.getMessage());
			retorno = false;
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Deu merda, não deu pra fechar");
				retorno = false;
			}
		}
		return retorno;
	}
	
	
	public Vector<Vector<String>> buscaAlunos() throws SQLException{
		try{
			Vector<Vector<String>> listaAlunos = new Vector<Vector<String>>();
			PreparedStatement stmt = new ConnectionFactory()
					.getConnection()
					.prepareStatement(
							"select * from aluno order by idAluno as a inner join pessoa as p where(a.idPessoa = p.idPessoa);");
			
			ResultSet result = stmt.executeQuery();
			while(result.next()){
				AlunoModel aluno = new AlunoModel();
				aluno.setIdAluno(result.getInt("idAluno"));
				aluno.setIdPessoa(result.getInt("idPessoa"));
				aluno.setCpf(result.getString("cpf"));
				aluno.setNomePessoa(result.getString("nomePessoa"));
				aluno.setRg(result.getString("rg"));
				
				
				Vector<String> colunas = new Vector<String>();
				colunas.add(""+aluno.getIdAluno());
				colunas.add(""+aluno.getIdPessoa());
				colunas.add(aluno.getNomePessoa());
				colunas.add(aluno.getRg());
				colunas.add(aluno.getCpf());
				
				listaAlunos.add(colunas);
			}
			result.close();
			stmt.close();
			return listaAlunos;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Erro ao listar tabelas de Alunos!  erro: " +e.getMessage());
			throw new RuntimeException(e);
		}
	}

}
