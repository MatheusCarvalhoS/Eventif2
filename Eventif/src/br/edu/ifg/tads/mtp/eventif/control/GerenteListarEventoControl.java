package br.edu.ifg.tads.mtp.eventif.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.edu.ifg.tads.mtp.eventif.model.EnderecoModel;
import br.edu.ifg.tads.mtp.eventif.model.EventoModel;
import br.edu.ifg.tads.mtp.eventif.util.VerificaCamposCriarEvento;
import br.edu.ifg.tads.mtp.eventif.view.GerenteCriarEventoView;
import br.edu.ifg.tads.mtp.eventif.view.GerenteListarEventoView;

public class GerenteListarEventoControl {
	private GerenteListarEventoView listarEvento;
	private JPanel painel;
	
	public JPanel getGerenteListarEventoControl(){
		listarEvento=new GerenteListarEventoView();
		painel=listarEvento.getGerenteListarEventoView();
		adicionaEventos();
		return painel;
	}
	
	public void adicionaEventos(){
		listarEvento.getJbtnPesquisar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				EnderecoModel endereco = new EnderecoModel();
				EventoModel evento = new EventoModel();
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
