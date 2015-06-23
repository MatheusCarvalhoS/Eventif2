package br.edu.ifg.tads.mtp.eventif.control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifg.tads.mtp.eventif.view.LoginView;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LoginControl {
	private LoginView login;
	private JPanel painel;
	
	public JPanel getLoginControl(){
		login=new LoginView();
		painel=login.getPainelLogin();
		
		// evento no botão OK que não faz nada 
		login.getBtnOk().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Cliquei em OK e não fiz nada");
			}
		});
		
		return painel;
	}
}
