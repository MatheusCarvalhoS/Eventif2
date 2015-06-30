package br.edu.ifg.tads.mtp.eventif.view;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView {
	private JLabel modulo;
	private JPanel painel;
	private JComboBox<String> combo;
	private JLabel cpf;
	private JLabel senha;
	private JTextField tfCpf;
	private JPasswordField tfSenha;
	private JButton btnOk;
	
	public JPanel getPainelLogin() {
		painel = new JPanel();
		painel.setBounds(0, 0, 979, 624);
		painel.setLayout(null);
		
		String[] moduloStrings = { "Participante", "Monitor (a)", "Gerente" };
		modulo = new JLabel("Módulo:");
		combo = new JComboBox<String>(moduloStrings);		
		cpf = new JLabel("Cpf:");
		senha = new JLabel("Senha:");
		tfCpf = new JTextField();
		tfSenha = new JPasswordField();
		btnOk = new JButton("OK");
		
		modulo.setBounds(250, 210, 60, 25);
		combo.setBounds(310, 210, 200, 25);
		cpf.setBounds(250, 250, 50, 25);
		senha.setBounds(250, 285, 50, 25);
		tfCpf.setBounds(310, 250, 200, 25);
		tfSenha.setBounds(310, 285, 200, 25);
		btnOk.setBounds(435, 335, 75, 25);
		
		painel.add(modulo);
		painel.add(combo);
		painel.add(cpf);
		painel.add(senha);
		painel.add(tfCpf);
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

	public JComboBox<String> getCombo() {
		return combo;
	}

	public void setCombo(JComboBox<String> combo) {
		this.combo = combo;
	}

	public JTextField getTfCpf() {
		return tfCpf;
	}

	public void setTfCpf(JTextField tfCpf) {
		this.tfCpf = tfCpf;
	}

	public JTextField getTfSenha() {
		return tfSenha;
	}

	public void setTfSenha(JPasswordField tfSenha) {
		this.tfSenha = tfSenha;
	}

	public JButton getBtnOk() {
		return btnOk;
	}

	public void setBtnOk(JButton btnOk) {
		this.btnOk = btnOk;
	}
}