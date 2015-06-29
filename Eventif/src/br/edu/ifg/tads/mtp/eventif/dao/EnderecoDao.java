package br.edu.ifg.tads.mtp.eventif.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import br.edu.ifg.tads.mtp.eventif.bd.ConnectionFactory;
import br.edu.ifg.tads.mtp.eventif.model.EnderecoModel;

public class EnderecoDao {
	public boolean adiconaEndereco(EnderecoModel endereco){
		boolean retorno=true;
		String sql = "insert into endereco (numero, bairro, cep, cidade, uf) values(?,?,?,?,?)";
		Connection con = null;
		try{
			con = new ConnectionFactory().getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, endereco.getNumero());
			stmt.setString(2, endereco.getBairro());
			stmt.setString(3, endereco.getCep());
			stmt.setString(4, endereco.getCidade());
			stmt.setString(5, endereco.getUf());
			
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
	
	public int retornaMaxIdEndereco(){
		int retorno=0;
		String sql = "select max(idEndereco) from endereco;";
		Connection con = null;
		try{
			con = new ConnectionFactory().getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				retorno = rs.getInt("idEndereco");
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
