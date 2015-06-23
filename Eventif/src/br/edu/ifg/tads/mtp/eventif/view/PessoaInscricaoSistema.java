package br.edu.ifg.tads.mtp.eventif.view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PessoaInscricaoSistema {
	private JPanel painel;

	private JLabel nome;
	private JLabel cpf;
	private JLabel rg;
	private JLabel cidade;
	private JLabel bairro;
	private JLabel cep;
	private JLabel numero;
	private JLabel uf;

	private JTextField txNome;
	private JTextField txCpf;
	private JTextField txRg;
	private JTextField txCidade;
	private JTextField txBairro;
	private JTextField txCep;
	private JTextField txNumero;
	private JTextField txUf;

	public JPanel getAlunoInscricaoSistema() {
		painel = new JPanel();
		painel.setBounds(0, 0, 779, 624);
		painel.setLayout(null);

		// Criando JLabels
		nome = new JLabel("Nome:");
		cpf = new JLabel("CPF:");
		rg = new JLabel("RG:");
		cidade = new JLabel("Cidade:");
		bairro = new JLabel("Bairro:");
		cep = new JLabel("CEP:");
		numero = new JLabel("Numero:");
		uf = new JLabel("UF:");

		// Criando JTextFields
		txNome = new JTextField();
		txCpf = new JTextField();
		txRg = new JTextField();
		txCidade = new JTextField();
		txBairro = new JTextField();
		txCep = new JTextField();
		txNumero = new JTextField();
		txUf = new JTextField();

		// setando posições das Labels
		nome.setBounds(20, 10, 100, 25);
		cpf.setBounds(300, 10, 100, 25);
		rg.setBounds(35, 45, 100, 25);
		cep.setBounds(280, 45, 100, 25);
		cidade.setBounds(10, 80, 100, 25);
		bairro.setBounds(15, 115, 100, 25);
		numero.setBounds(200, 115, 100, 25);
		uf.setBounds(35, 150, 100, 25);

		// setando as posições das TextFields
		txNome.setBounds(75, 10, 200, 25);
		txCpf.setBounds(340, 10, 120, 25);
		txRg.setBounds(75, 45, 150, 25);
		txCep.setBounds(320, 45, 100, 25);
		txCidade.setBounds(75, 80, 100, 25);
		txBairro.setBounds(75, 115, 100, 25);
		txNumero.setBounds(270, 115, 100, 25);
		txUf.setBounds(75, 150, 100, 25);

		// adicionando ao painel
		painel.add(nome);
		painel.add(cpf);
		painel.add(rg);
		painel.add(cidade);
		painel.add(bairro);
		painel.add(cep);
		painel.add(numero);
		painel.add(uf);

		painel.add(txNome);
		painel.add(txCpf);
		painel.add(txRg);
		painel.add(txCidade);
		painel.add(txBairro);
		painel.add(txCep);
		painel.add(txNumero);
		painel.add(txUf);

		painel.setBackground(new Color(240, 240, 240));
		return painel;
	}

	public JPanel getPanel() {
		return painel;
	}

	public void setPanel(JPanel panel) {
		this.painel = panel;
	}

	public JLabel getNome() {
		return nome;
	}

	public void setNome(JLabel nome) {
		this.nome = nome;
	}

	public JLabel getCpf() {
		return cpf;
	}

	public void setCpf(JLabel cpf) {
		this.cpf = cpf;
	}

	public JLabel getRg() {
		return rg;
	}

	public void setRg(JLabel rg) {
		this.rg = rg;
	}

	public JLabel getCidade() {
		return cidade;
	}

	public void setCidade(JLabel cidade) {
		this.cidade = cidade;
	}

	public JLabel getBairro() {
		return bairro;
	}

	public void setBairro(JLabel bairro) {
		this.bairro = bairro;
	}

	public JLabel getCep() {
		return cep;
	}

	public void setCep(JLabel cep) {
		this.cep = cep;
	}

	public JLabel getNumero() {
		return numero;
	}

	public void setNumero(JLabel numero) {
		this.numero = numero;
	}

	public JLabel getUf() {
		return uf;
	}

	public void setUf(JLabel uf) {
		this.uf = uf;
	}

	public JTextField getTxNome() {
		return txNome;
	}

	public void setTxNome(JTextField txNome) {
		this.txNome = txNome;
	}

	public JTextField getTxCpf() {
		return txCpf;
	}

	public void setTxCpf(JTextField txCpf) {
		this.txCpf = txCpf;
	}

	public JTextField getTxRg() {
		return txRg;
	}

	public void setTxRg(JTextField txRg) {
		this.txRg = txRg;
	}

	public JTextField getTxCidade() {
		return txCidade;
	}

	public void setTxCidade(JTextField txCidade) {
		this.txCidade = txCidade;
	}

	public JTextField getTxBairro() {
		return txBairro;
	}

	public void setTxBairro(JTextField txBairro) {
		this.txBairro = txBairro;
	}

	public JTextField getTxCep() {
		return txCep;
	}

	public void setTxCep(JTextField txCep) {
		this.txCep = txCep;
	}

	public JTextField getTxNumero() {
		return txNumero;
	}

	public void setTxNumero(JTextField txNumero) {
		this.txNumero = txNumero;
	}

	public JTextField getTxUf() {
		return txUf;
	}

	public void setTxUf(JTextField txUf) {
		this.txUf = txUf;
	}

}
