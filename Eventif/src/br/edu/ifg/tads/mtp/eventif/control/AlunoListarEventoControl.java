package br.edu.ifg.tads.mtp.eventif.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.edu.ifg.tads.mtp.eventif.view.AlunoListarEventoView;

public class AlunoListarEventoControl {
	private AlunoListarEventoView listarEvento;
	private JPanel painel;
	
	public JPanel getAlunoListarEventoControl(){
		listarEvento=new AlunoListarEventoView();
		painel=listarEvento.getAlunoListarEventoView();
		adicionaEventos();
		return painel;
	}
	
	public JPanel getAlunoListarAtividadeControl(){
		listarEvento=new AlunoListarEventoView();
		painel=listarEvento.getAlunoListarEventoView();
		adicionaEventos();
		return painel;
	}
	
	public void adicionaEventos(){
		listarEvento.getJbtnPesquisar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Pesquisar aqui");
				/*
				if(new VerificaCamposCriarEvento().verify(criarEvento)){
					JOptionPane.showMessageDialog(null, "Evento criado");
				}else{
					JOptionPane.showMessageDialog(null, "Verifique o preenchimento dos campos");
				}
				*/
			}
		});
	}
}
