package br.edu.ifg.tads.mtp.eventif.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuPrincipalGerenteView {
	private JPanel painelEsquerda;
	private JButton jbtnNovoEvento;
	private JButton eventos;
	private JButton gerarCertificados;
	
	public JPanel getMenuPrincipalGerenteView(){
		painelEsquerda = new JPanel();
		painelEsquerda.setBounds(0, 0, 220, 624);
		painelEsquerda.setLayout(null);
		painelEsquerda.setBackground(new Color(66, 105, 51));
		
		jbtnNovoEvento = new JButton("Novo Evento");
		eventos = new JButton("Eventos");
		gerarCertificados = new JButton("Gerar Certificados");
		
		eventos.setBounds(35, 150, 150, 25);
		jbtnNovoEvento.setBounds(35, 190, 150, 25);
		gerarCertificados.setBounds(35, 230, 150, 25);;
		
		painelEsquerda.add(jbtnNovoEvento);
		painelEsquerda.add(eventos);
		painelEsquerda.add(gerarCertificados);
		return painelEsquerda;
	}

	public JPanel getPainelEsquerda() {
		return painelEsquerda;
	}

	public void setPainelEsquerda(JPanel painelEsquerda) {
		this.painelEsquerda = painelEsquerda;
	}

	public JButton getJbtnNovoEvento() {
		return jbtnNovoEvento;
	}

	public void setJbtnNovoEvento(JButton jbtnNovoEvento) {
		this.jbtnNovoEvento = jbtnNovoEvento;
	}

	public JButton getEventos() {
		return eventos;
	}

	public void setEventos(JButton eventos) {
		this.eventos = eventos;
	}

	public JButton getGerarCertificados() {
		return gerarCertificados;
	}

	public void setGerarCertificados(JButton gerarCertificados) {
		this.gerarCertificados = gerarCertificados;
	}
}
