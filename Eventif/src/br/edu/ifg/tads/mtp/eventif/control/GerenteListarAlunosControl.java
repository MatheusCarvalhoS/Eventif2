package br.edu.ifg.tads.mtp.eventif.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import br.edu.ifg.tads.mtp.eventif.dao.AlunoDao;
import br.edu.ifg.tads.mtp.eventif.dao.EventoDAO;
import br.edu.ifg.tads.mtp.eventif.model.EnderecoModel;
import br.edu.ifg.tads.mtp.eventif.model.EventoModel;
import br.edu.ifg.tads.mtp.eventif.util.VerificaCamposCriarEvento;
import br.edu.ifg.tads.mtp.eventif.view.GerenteCriarEventoView;
import br.edu.ifg.tads.mtp.eventif.view.GerenteListarAlunosView;
import br.edu.ifg.tads.mtp.eventif.view.GerenteListarEventoView;

public class GerenteListarAlunosControl {
	private GerenteListarAlunosView listarAluno;
	private JPanel painel;
	
	public JPanel getGerenteListarAlunosControl() throws SQLException{
		listarAluno = new GerenteListarAlunosView();
		painel=listarAluno.getGerenteListarAlunosView();
		preencheTabela();
		adicionaEventos();
		return painel;
	}
	
	public void preencheTabela() throws SQLException {
		Vector<Vector<String>> listaAlunos = new AlunoDao().buscaAlunos();
		preencheTabelaAluno(listaAlunos);
	}
	
	
	public void adicionaEventos(){
		
		listarAluno.getJbtnPesquisar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Pesquisar aqui"); 
			}
		});
	}
	
	public void preencheTabelaAluno(Vector<Vector<String>> listaAluno) {

		listarAluno.getTable().clearSelection();
		listarAluno.getTable().removeAll();

		Vector<String> colunas = new Vector<String>();
		colunas.add("idAluno");
		colunas.add("idPessoa");
		colunas.add("Nome");
		colunas.add("CPF");
		colunas.add("RG");

		DefaultTableModel model = new DefaultTableModel(listaAluno, colunas);
		listarAluno.getTable().setModel(model);
	}
	
}
