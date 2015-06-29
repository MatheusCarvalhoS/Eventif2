package br.edu.ifg.tads.mtp.eventif.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import br.edu.ifg.tads.mtp.eventif.bd.ConnectionFactory;
import br.edu.ifg.tads.mtp.eventif.model.AlunoModel;
import br.edu.ifg.tads.mtp.eventif.model.PessoaModel;

public class PessoaDao {
	public boolean adiconaPessoa(PessoaModel aluno){
			boolean retorno=true;
			String sql = "insert into pessoa (nomePessoa, cpf, rg, idEndereco) values(?,?,?,?)";
			Connection con = null;
			try{
				con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);
				
				stmt.setString(1, aluno.getNomePessoa());
				stmt.setString(2, aluno.getCpf());
				stmt.setString(3, aluno.getRg());
				stmt.setInt(4, aluno.getIdEndereco());
				stmt.execute();
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Não deu pra inserir"+e.getMessage());
				retorno = false;
			} finally{
				try{
					con.close();
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Deu merda, não deu pra fechar");
					retorno=false;
				}
			}
			return retorno;
		}
	
	public int retornaMaxIdPessoa(){
		int retorno=0;
		String sql = "select max(idPessoa) from pessoa;";
		Connection con = null;
		try{
			con = new ConnectionFactory().getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				retorno = rs.getInt("idPessoa");
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Não deu pra retornar"+e.getMessage());
		} finally{
			try{
				con.close();
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Deu merda, não deu pra fechar");
			}
		}
		return retorno;
	}
}

