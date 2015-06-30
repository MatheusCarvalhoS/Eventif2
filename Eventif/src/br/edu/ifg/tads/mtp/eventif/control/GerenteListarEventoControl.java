package br.edu.ifg.tads.mtp.eventif.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import br.edu.ifg.tads.mtp.eventif.dao.EventoDAO;
import br.edu.ifg.tads.mtp.eventif.model.EnderecoModel;
import br.edu.ifg.tads.mtp.eventif.model.EventoModel;
import br.edu.ifg.tads.mtp.eventif.util.ButtonColumn;
import br.edu.ifg.tads.mtp.eventif.util.Dispatcher;
import br.edu.ifg.tads.mtp.eventif.util.Listener;
import br.edu.ifg.tads.mtp.eventif.util.VerificaCamposCriarEvento;
import br.edu.ifg.tads.mtp.eventif.view.AppView;
import br.edu.ifg.tads.mtp.eventif.view.GerenteCriarEventoView;
import br.edu.ifg.tads.mtp.eventif.view.GerenteListarEventoView;

public class GerenteListarEventoControl {
	private GerenteListarEventoView listarEvento;
	private JPanel painel;
	private Action alterar;
	private Action excluir;
	private Action addAtividade;
	private AppView appView;

	public JPanel getGerenteListarEventoControl(AppView app) {
		this.appView = app;

		listarEvento = new GerenteListarEventoView();
		painel = listarEvento.getGerenteListarEventoView();
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
		Vector<Vector<String>> listaEventos = new EventoDAO().buscaEventos();
		preencheTabela(listaEventos);
	}

	public void preencheTabela(Vector<Vector<String>> listaEvento) {

		listarEvento.getTable().clearSelection();
		listarEvento.getTable().removeAll();

		Vector<String> colunas = new Vector<String>();
		colunas.add("id");
		colunas.add("nome");
		colunas.add("dataInicio");
		colunas.add("dataFim");
		colunas.add("");
		colunas.add("");
		colunas.add("");

		DefaultTableModel model = new DefaultTableModel(listaEvento, colunas);
		listarEvento.getTable().setModel(model);
		listarEvento.getTable().getColumn("id").setMaxWidth(25);
		new ButtonColumn(listarEvento.getTable(), alterar, 4);
		new ButtonColumn(listarEvento.getTable(), excluir, 5);
		new ButtonColumn(listarEvento.getTable(), addAtividade, 6);
	}

	public void adicionaEventos() {
		listarEvento.getJbtnPesquisar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				EnderecoModel endereco = new EnderecoModel();
				EventoModel evento = new EventoModel();
				JOptionPane.showMessageDialog(null, "Pesquisar aqui");

			}
		});

		addAtividade = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("entreiiiii");
				int index = Integer.parseInt(e.getActionCommand());
				int id = Integer.parseInt(listarEvento.getTable()
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
