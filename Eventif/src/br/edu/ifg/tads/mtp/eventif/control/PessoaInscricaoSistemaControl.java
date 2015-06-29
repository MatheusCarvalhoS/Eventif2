package br.edu.ifg.tads.mtp.eventif.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.edu.ifg.tads.mtp.eventif.dao.AlunoDao;
import br.edu.ifg.tads.mtp.eventif.dao.EnderecoDao;
import br.edu.ifg.tads.mtp.eventif.dao.PessoaDao;
import br.edu.ifg.tads.mtp.eventif.model.AlunoModel;
import br.edu.ifg.tads.mtp.eventif.model.EnderecoModel;
import br.edu.ifg.tads.mtp.eventif.util.VerificaCamposPessoaInscricao;
import br.edu.ifg.tads.mtp.eventif.view.PessoaInscricaoSistemaView;

public class PessoaInscricaoSistemaControl {
	private PessoaInscricaoSistemaView inscreverPessoa;
	private JPanel painel;
	
	public void adicionaEventos(){
		inscreverPessoa.getBtInscrever().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(new VerificaCamposPessoaInscricao().getVerificaCamposPessoaInscricao(inscreverPessoa)){
					EnderecoModel endereco = new EnderecoModel();
					endereco.setCep(inscreverPessoa.getTxCep().getText());
					endereco.setUf(inscreverPessoa.getTxUf().getText());
					endereco.setCidade(inscreverPessoa.getTxCidade().getText());
					endereco.setBairro(inscreverPessoa.getTxBairro().getText());
					endereco.setNumero(inscreverPessoa.getTxNumero().getText());
					endereco.setComplemento(inscreverPessoa.getTxComplemento().getText());
					
					AlunoModel aluno = new AlunoModel();
					aluno.setNomePessoa(inscreverPessoa.getTxNome().getText());
					aluno.setCpf(inscreverPessoa.getTxCpf().getText());
					aluno.setRg(inscreverPessoa.getTxRg().getText());
					aluno.setSenha(inscreverPessoa.getTxSenha().getText());
					
					if(new EnderecoDao().adiconaEndereco(endereco)){
						aluno.setIdEndereco(new EnderecoDao().retornaMaxIdEndereco());
						if(new PessoaDao().adiconaPessoa(aluno)){
							aluno.setIdPessoa(new PessoaDao().retornaMaxIdPessoa());
							if(new AlunoDao().adiconaAluno(aluno)){
								JOptionPane.showMessageDialog(null, "Aluno inscrito com sucesso, CPF: "+aluno.getCpf());
							}
						}
					}
					//JOptionPane.showMessageDialog(null, "Inscrevi");
				}else{
					JOptionPane.showMessageDialog(null, "Verifique o preenchimento dos campos");
				}
				
			}
		});
	}
	
	public JPanel getPessoaInscricaoSistemaControl(){
		inscreverPessoa=new PessoaInscricaoSistemaView();
		painel=inscreverPessoa.getPessoaInscricaoSistemaView();
		adicionaEventos();
		return painel;
	}
}
