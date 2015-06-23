package br.edu.ifg.tads.mtp.eventif.model;

public abstract class PessoaModel {

	private int idPessoa;
	private String nomePessoa;
	private String cpf;
	private String rg;
	private int idEncereco;

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public int getIdEncereco() {
		return idEncereco;
	}

	public void setIdEncereco(int idEncereco) {
		this.idEncereco = idEncereco;
	}
}
