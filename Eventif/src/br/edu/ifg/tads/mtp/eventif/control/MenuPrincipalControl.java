package br.edu.ifg.tads.mtp.eventif.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.edu.ifg.tads.mtp.eventif.view.MenuPrincipalView;

public class MenuPrincipalControl {
	private MenuPrincipalView menu;
	private JPanel painel;
	
	public JPanel getMenuPrincipalControl(){
		menu = new MenuPrincipalView();
		painel = menu.getMenuPrincipal();
	
		// botao de tela de Increver
		menu.getBtInscricao().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Cliquei em Inscrever");
			}
		});
		
		// botar de tela de Login
		menu.getBtLogin().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Cliquei em Login");
			}
		});
		
		
		return painel;
	}

}
