package br.edu.ifg.tads.mtp.eventif.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import br.edu.ifg.tads.mtp.eventif.bd.ConnectionFactory;
import br.edu.ifg.tads.mtp.eventif.model.*;

public class AlunoDAO {
	
	public void adiciona(AlunoModel aluno) {
	     String sql1 = "insert into pessoa " +
	             "(nomePessoa,cpf,rg)" +
	             " values (?,?,?)";
	     
		String sql2 = "insert into aluno " +
	             "(idPessoa,senha)" +
	             " values (?,?)";
	
	     Connection con = null;
	     try {
	         // prepared statement para inserção
	    	 con = new ConnectionFactory().getConnection();
	         PreparedStatement stmt1 = con.prepareStatement(sql1);
	         PreparedStatement stmt2 = con.prepareStatement(sql2);
	 
	         // seta os valores
	         stmt1.setString(1, aluno.getNomePessoa());
	         stmt1.setString(2,aluno.getCpf());
	         stmt1.setString(3,aluno.getRg());
	         stmt2.setInt(1, aluno.getIdPessoa());
	         stmt2.setString(2,aluno.getSenha());
	         /*
	         stmt1.setDate(3, new Date(
	                 aluno.getData().getTimeInMillis()));
	 		*/
	         // executa
	         stmt1.execute();
	         stmt2.execute();
	     } catch (Exception e) {
	         throw new RuntimeException("falha ao tentar executar um comando no BD. Verifique sua conexão");
	     }finally{
	    	 try {
				con.close();
			} catch (Exception e) {
				throw new RuntimeException("não foi possível fechar a conexão com o BD");
			}
	     }
	 }
	/*
	public EventoModel buscaevento(EventoModel c){
		System.out.println(c.getId());
		PreparedStatement stmt;
		EventoModel evento = new EventoModel();
		try {
			Connection con = new ConnectionFactory().getConnection();
			stmt = con.prepareStatement("select * from eventos where id = "+ c.getId());
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				// criando o objeto evento
				evento.setId(rs.getInt("id"));
	             evento.setNome(rs.getString("nome"));
	             // montando a data através do Calendar
	             Calendar data = Calendar.getInstance();
	             data.setTime(rs.getDate("dataNascimento"));
	             evento.setData(data);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return evento;
		
	}
	
	public Vector<Vector<String>> buscaeventos(){
		
		try {
			Vector<Vector<String>> eventos = new Vector<Vector<String>>();
	         PreparedStatement stmt = new ConnectionFactory().getConnection().
	                 prepareStatement("select * from eventos order by id");
	         ResultSet rs = stmt.executeQuery();
	 
	         while (rs.next()) {
	             // criando o objeto evento
	        	 EventoModel evento = new EventoModel();
	             evento.setId(rs.getInt("id"));
	             evento.setNome(rs.getString("nome"));
	 
	             // montando a data através do Calendar
	             Calendar data = Calendar.getInstance();
	             data.setTime(rs.getDate("dataNascimento"));
	             evento.setData(data);
	             
	             Vector<String> colunas = new Vector<String>();
	     		colunas.add(""+evento.getId());
	     		colunas.add(evento.getNome());
	     		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	     		colunas.add(sdf.format(evento.getData().getTime()));
	     		colunas.add("alterar");
	     		colunas.add("excluir");
	 
	             // adicionando o objeto à lista
	             eventos.add(colunas);
	         }
	         rs.close();
	         stmt.close();
	         return eventos;
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	}
	
	public Vector<Vector<String>> buscaEventosNome(EventoModel c){
		
		try {
			Vector<Vector<String>> eventos = new Vector<Vector<String>>();
	         PreparedStatement stmt = new ConnectionFactory().getConnection().
	                 prepareStatement("select * from eventos where nome like '%"+c.getNome()+"%'");
	         ResultSet rs = stmt.executeQuery();
	 
	         while (rs.next()) {
	             // criando o objeto evento
	        	 EventoModel evento = new EventoModel();
	             evento.setId(rs.getInt("id"));
	             evento.setNome(rs.getString("nome"));
	             // montando a data através do Calendar
	             Calendar data = Calendar.getInstance();
	             data.setTime(rs.getDate("dataNascimento"));
	             evento.setData(data);
	             
	             Vector<String> colunas = new Vector<String>();
	     		colunas.add(""+evento.getId());
	     		colunas.add(evento.getNome());
	     		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	     		colunas.add(sdf.format(evento.getData().getTime()));
	     		colunas.add("alterar");
	     		colunas.add("excluir");
	 
	             // adicionando o objeto à lista
	             eventos.add(colunas);
	         }
	         rs.close();
	         stmt.close();
	         return eventos;
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	}
	
	public void altera(EventoModel evento) {
	     String sql = "update eventos set nome=?, email=?, endereco=?," +
	             "datanascimento=? where id=?";
	     try {
	         PreparedStatement stmt = new ConnectionFactory().getConnection().prepareStatement(sql);
	         stmt.setString(1, evento.getNome());
	         stmt.setDate(4, new Date(evento.getData()
	                 .getTimeInMillis()));
	         stmt.setLong(5, evento.getId());
	         System.out.println(stmt.toString());
	         stmt.executeUpdate();
	         stmt.close();
	     } catch (SQLException e) {
	    	 System.out.println(e);
	         throw new RuntimeException(e);
	     }
	 }
	
	public void remove(EventoModel evento) {
	     try {
	         PreparedStatement stmt = new ConnectionFactory().getConnection().prepareStatement("delete from eventos where id=?");
	         stmt.setLong(1, evento.getId());
	         stmt.execute();
	         stmt.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
	*/
}
