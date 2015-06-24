package br.edu.ifg.tads.mtp.eventif.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.edu.ifg.tads.mtp.eventif.model.EnderecoModel;
import br.edu.ifg.tads.mtp.eventif.model.EventoModel;
import br.edu.ifg.tads.mtp.eventif.view.PessoaInscricaoSistemaView;

public class PessoaInscricaoSistemaControl {
	private PessoaInscricaoSistemaView inscreverPessoa;
	private JPanel painel;
	
	public JPanel getPessoaInscricaoSistemaControl(){
		inscreverPessoa=new PessoaInscricaoSistemaView();
		painel=inscreverPessoa.getPessoaInscricaoSistemaView();
		
		inscreverPessoa.getBtInscrever().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				EnderecoModel endereco = new EnderecoModel();
				EventoModel evento = new EventoModel();
				JOptionPane.showMessageDialog(null, "Inscrevi");
				/*
				 * if(new VerificaCamposCriarEvento().verify(criarEvento)){
				 * JOptionPane.showMessageDialog(null, "Evento criado"); }else{
				 * JOptionPane.showMessageDialog(null,
				 * "Verifique o preenchimento dos campos"); }
				 */
			}
		});
		return painel;
	}
}
