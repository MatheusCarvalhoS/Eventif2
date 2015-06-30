package br.edu.ifg.tads.mtp.eventif.control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifg.tads.mtp.eventif.util.VerificaCamposLogin;
import br.edu.ifg.tads.mtp.eventif.view.AppView;
import br.edu.ifg.tads.mtp.eventif.view.LoginView;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LoginControl {
	private LoginView login;
	private JPanel painel;
	private AppView appView;
	
	public JPanel getLoginControl(AppView app){
		this.appView=app;
		login=new LoginView();
		painel=login.getPainelLogin();
		
		//Evento no botão OK que não faz nada 
		login.getBtnOk().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String text = (String) login.getCombo().getSelectedItem();
				if(new VerificaCamposLogin().getVerificaCamposCriarLogin(login)){
					if(text.equals("Gerente")){
						appView.getPainelEsquerda().removeAll();
						appView.getPainelEsquerda().add(new MenuPrincipalGerenteControl().getMenuPrincipalGerente(appView));
						appView.getPainelEsquerda().repaint();
						appView.getPainelDireita().removeAll();
						appView.getPainelDireita().add(new GerenteListarEventoControl().getGerenteListarEventoControl(appView));
						appView.getPainelDireita().repaint();
					}else if(text.equals("Monitor (a)")){
						
					}
				}else{
					JOptionPane.showMessageDialog(null, "Verifique os preenchimentos dos Campos.");
					login.getTfCpf().setText("");
					login.getTfSenha().setText("");
				}
				
			}
		});
		
		return painel;
	}
}
