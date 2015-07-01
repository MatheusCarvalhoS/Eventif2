package br.edu.ifg.tads.mtp.eventif.control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifg.tads.mtp.eventif.model.AlunoModel;
import br.edu.ifg.tads.mtp.eventif.model.GerenteModel;
import br.edu.ifg.tads.mtp.eventif.model.MonitorModel;
import br.edu.ifg.tads.mtp.eventif.util.ConfirmaSenha;
import br.edu.ifg.tads.mtp.eventif.util.ValidacaoCPF;
import br.edu.ifg.tads.mtp.eventif.util.VerificaCamposLogin;
import br.edu.ifg.tads.mtp.eventif.view.AppView;
import br.edu.ifg.tads.mtp.eventif.view.LoginView;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LoginControl {
	private LoginView login;
	private JPanel painel;
	private AppView appView;
	private GerenteModel gerente;
	private MonitorModel monitor;
	private AlunoModel aluno;
	
	public JPanel getLoginControl(AppView app){
		this.appView=app;
		login=new LoginView();
		painel=login.getPainelLogin();
		adicionaEventos();
		return painel;
	}
	public void adicionaEventos() {
		// Evento no botão OK que não faz nada
		login.getBtnOk().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				boolean validacao = true;
				String text = (String) login.getCombo().getSelectedItem();
				if (new VerificaCamposLogin().getVerificaCamposCriarLogin(login)) {
					String cpf = login.getTxCpf().getText().replace(".","").replace("-","");
					String senha = login.getTfSenha().getText();
					if(!new ValidacaoCPF().validaCpf(cpf)){
						validacao = false;
						JOptionPane.showMessageDialog(null, "CPF inválido!");
					}
					
					if(!validacao){
						login.getTxCpf().setText("");
						login.getTfSenha().setText("");
					}
					
					if (text.equals("Gerente")) {
						gerente = new GerenteModel();
						gerente.setCpf(cpf);	
						gerente.setSenha(senha);
						
						/*
						 if(new GerenteDao().verificaLogin(gerente)){
						 	Faz as parada que tem q fazer q tá ali em baixo
						 }
						 * */
						
						appView.getPainelEsquerda().removeAll();
						appView.getPainelEsquerda().add(
								new MenuPrincipalGerenteControl()
										.getMenuPrincipalGerente(appView));
						
						appView.getPainelEsquerda().repaint();
						appView.getPainelDireita().removeAll();
						appView.getPainelDireita()
								.add(new GerenteListarEventoControl()
										.getGerenteListarEventoControl(appView));
						appView.getPainelDireita().repaint();
					} else if (text.equals("Monitor (a)")) {

					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Verifique os preenchimentos dos Campos.");
					login.getTxCpf().setText("");
					login.getTfSenha().setText("");
				}

			}
		});
	}
}
