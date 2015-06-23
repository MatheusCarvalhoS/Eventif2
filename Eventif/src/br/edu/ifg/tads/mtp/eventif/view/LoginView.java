package br.edu.ifg.tads.mtp.eventif.view;

import java.awt.Color;
import java.awt.TextField;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class LoginView {
	private JLabel modulo;
	private JPanel painel;
	private JComboBox combo;
	private JLabel login;
	private JLabel senha;
	private JTextField tfLogin;
	private JTextField tfSenha;
	private JButton btnOk;
	
	public JPanel getPainelLogin() {
		painel = new JPanel();
		painel.setBounds(0, 0, 779, 624);
		painel.setLayout(null);
		
		String[] moduloStrings = { "Participante", "Monitor", "Gerente" };
		modulo = new JLabel("Módulo:");
		combo = new JComboBox(moduloStrings);		
		login = new JLabel("Login:");
		senha = new JLabel("Senha:");
		tfLogin = new JTextField();
		tfSenha = new JTextField();
		btnOk = new JButton("OK");
		
		modulo.setBounds(250, 210, 60, 25);
		combo.setBounds(310, 210, 200, 25);
		login.setBounds(250, 250, 50, 25);
		senha.setBounds(250, 285, 50, 25);
		tfLogin.setBounds(310, 250, 200, 25);
		tfSenha.setBounds(310, 285, 200, 25);
		btnOk.setBounds(435, 335, 75, 25);
		
		painel.add(modulo);
		painel.add(combo);
		painel.add(login);
		painel.add(senha);
		painel.add(tfLogin);
		painel.add(tfSenha);
		painel.add(btnOk);
		painel.setBackground(new Color(240, 240, 240));
		return painel;
	}

	public JLabel getModulo() {
		return modulo;
	}

	public void setModulo(JLabel modulo) {
		this.modulo = modulo;
	}

	public JPanel getPainel() {
		return painel;
	}

	public void setPainel(JPanel painel) {
		this.painel = painel;
	}

	public JComboBox getCombo() {
		return combo;
	}

	public void setCombo(JComboBox combo) {
		this.combo = combo;
	}

	public JLabel getLogin() {
		return login;
	}

	public void setLogin(JLabel login) {
		this.login = login;
	}

	public JLabel getSenha() {
		return senha;
	}

	public void setSenha(JLabel senha) {
		this.senha = senha;
	}

	public JTextField getTfLogin() {
		return tfLogin;
	}

	public void setTfLogin(JTextField tfLogin) {
		this.tfLogin = tfLogin;
	}

	public JTextField getTfSenha() {
		return tfSenha;
	}

	public void setTfSenha(JTextField tfSenha) {
		this.tfSenha = tfSenha;
	}

	public JButton getBtnOk() {
		return btnOk;
	}

	public void setBtnOk(JButton btnOk) {
		this.btnOk = btnOk;
	}
}