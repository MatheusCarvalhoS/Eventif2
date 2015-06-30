package br.edu.ifg.tads.mtp.eventif.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import br.edu.ifg.tads.mtp.eventif.dao.AtividadeDAO;
import br.edu.ifg.tads.mtp.eventif.dao.EventoDAO;
import br.edu.ifg.tads.mtp.eventif.model.EnderecoModel;
import br.edu.ifg.tads.mtp.eventif.model.EventoModel;
import br.edu.ifg.tads.mtp.eventif.util.ButtonColumn;
import br.edu.ifg.tads.mtp.eventif.util.Dispatcher;
import br.edu.ifg.tads.mtp.eventif.util.Listener;
import br.edu.ifg.tads.mtp.eventif.util.VerificaCamposCriarEvento;
import br.edu.ifg.tads.mtp.eventif.view.AppView;
import br.edu.ifg.tads.mtp.eventif.view.GerenteCriarEventoView;
import br.edu.ifg.tads.mtp.eventif.view.GerenteListarAtividadeView;
import br.edu.ifg.tads.mtp.eventif.view.GerenteListarEventoView;

public class GerenteListarAtividadeControl {
	private GerenteListarAtividadeView listarAtividade;
	private JPanel painel;
	private Action alterar;
	private Action excluir;
	private Action addAtividade;
	private AppView appView;
	private int idEvento;

	public JPanel getGerenteListarAtividadeControl(AppView app, int idEvento) {
		this.appView = app;
		this.idEvento = idEvento;

		listarAtividade = new GerenteListarAtividadeView();
		painel = listarAtividade.getGerenteListarAtividadeView();
		
		preencheTabela();
		adicionaEventos();
		adicionaListenner();
		return painel;
	}

	public void adicionaListenner() {
		Dispatcher.getInstance().addListener(new Listener() {
			@Override
			public void receivedEvent(
					br.edu.ifg.tads.mtp.eventif.util.Event event) {
				if (event.getName().equals("excluir")
						|| event.getName().equals("alterar")
						|| event.getName().equals("nova atividade")) {
					preencheTabela();
				}
			}
		});
	}

	public void preencheTabela() {
		Vector<Vector<String>> listaAtividade = new AtividadeDAO().buscaAtividades(idEvento);
		preencheTabela(listaAtividade);
	}

	public void preencheTabela(Vector<Vector<String>> listaAtividade) {

		listarAtividade.getTable().clearSelection();
		listarAtividade.getTable().removeAll();

		Vector<String> colunas = new Vector<String>();
		colunas.add("id");
		colunas.add("nome");
		colunas.add("descrição");
		colunas.add("horaInicio");
		colunas.add("horaFim");
		colunas.add("Palestrante");
		colunas.add("Tipo");
		colunas.add("Carga Horaria");
		colunas.add("Numero de Vagas");
		colunas.add("Data");

		DefaultTableModel model = new DefaultTableModel(listaAtividade, colunas);
		listarAtividade.getTable().setModel(model);
		listarAtividade.getTable().getColumn("id").setMaxWidth(25);
	}

	public void adicionaEventos() {
		
		listarAtividade.getAddAtividade().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "add atividade");
				int id = Integer.parseInt(listarAtividade.getTable()
						.getValueAt(listarAtividade.getTable().getSelectedRow(), 0).toString());
				
				appView.getPainelDireita().removeAll();
				appView.getPainelDireita().add(
						new GerenteCriarAtividadeControl()
								.getGerenteCriarAtividadeControl(id));
				appView.getPainelDireita().repaint();
			}
		});
		
		listarAtividade.getAlterarAtividade().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "alterar");
				int id = Integer.parseInt(listarAtividade.getTable()
						.getValueAt(listarAtividade.getTable().getSelectedRow(), 0).toString());
				
				appView.getPainelDireita().removeAll();
				appView.getPainelDireita().add(
						new GerenteCriarEventoControl()
								.getGerenteAlterarEventoControl(id));
				appView.getPainelDireita().repaint();
			}
		});
		
		listarAtividade.getJbtnPesquisar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				EnderecoModel endereco = new EnderecoModel();
				EventoModel evento = new EventoModel();
				JOptionPane.showMessageDialog(null, "Pesquisar aqui");

			}
		});

		Action addAtividade = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("entreiiiii");
				int index = Integer.parseInt(e.getActionCommand());
				int id = Integer.parseInt(listarAtividade.getTable()
						.getValueAt(index, 0).toString());

				appView.getPainelDireita().removeAll();
				appView.getPainelDireita().add(
						new GerenteCriarAtividadeControl()
								.getGerenteCriarAtividadeControl(id));
				appView.getPainelDireita().repaint();
			}
		};
	}

	public Action getAlterar() {
		return alterar;
	}

	public void setAlterar(Action alterar) {
		this.alterar = alterar;
	}

	public Action getExcluir() {
		return excluir;
	}

	public void setExcluir(Action excluir) {
		this.excluir = excluir;
	}

	public Action getAddAtividade() {
		return addAtividade;
	}

	public void setAddAtividade(Action addAtividade) {
		this.addAtividade = addAtividade;
	}

}
