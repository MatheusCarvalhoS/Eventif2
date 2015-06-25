package br.edu.ifg.tads.mtp.eventif.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.edu.ifg.tads.mtp.eventif.model.EnderecoModel;
import br.edu.ifg.tads.mtp.eventif.model.EventoModel;
import br.edu.ifg.tads.mtp.eventif.util.VerificaCamposCriarEvento;
import br.edu.ifg.tads.mtp.eventif.view.GerenteCriarEventoView;

public class GerenteCriarEventoControl {
	private GerenteCriarEventoView criarEvento;
	private JPanel painel;
	
	public JPanel getGerenteCriarEventoControl(){
		criarEvento=new GerenteCriarEventoView();
		painel=criarEvento.getGerenteCriarEventoView();
		adicionaEventos();
		return painel;
	}
	
	public void adicionaEventos(){
		criarEvento.getBtCriar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				EnderecoModel endereco = new EnderecoModel();
				EventoModel evento = new EventoModel();
				if(new VerificaCamposCriarEvento().getVerificaCamposCriarEvento(criarEvento)){
					JOptionPane.showMessageDialog(null, "Evento criado");
				}else{
					JOptionPane.showMessageDialog(null, "Verifique o preenchimento dos campos");
				}
			}
		});
	}
}
