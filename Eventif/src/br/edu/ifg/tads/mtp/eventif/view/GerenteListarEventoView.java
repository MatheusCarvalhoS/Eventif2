package br.edu.ifg.tads.mtp.eventif.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.edu.ifg.tads.mtp.eventif.control.GVizualizarEventoControl;
import br.edu.ifg.tads.mtp.eventif.model.EventoModel;

public class GerenteListarEventoView extends JPanel{
	
	private JTextField jtfPesquisar;
	private JTable table;
	private JButton jbtnPesquisar;
	private JButton jbtnNovoContato;

	/**
	 * Create the frame.
	 */
	public JPanel getPainelVisualizarEvento() {
		this.setSize(780, 625);
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		
		JLabel lblPesquisarPorNome = new JLabel("Pesquisar por nome");
		lblPesquisarPorNome.setForeground(new Color(0, 0, 128));
		lblPesquisarPorNome.setFont(new Font("HanziPen TC", Font.BOLD, 15));
		lblPesquisarPorNome.setBounds(16, 98, 124, 16);
		this.add(lblPesquisarPorNome);
		
		jtfPesquisar = new JTextField();
		jtfPesquisar.setForeground(new Color(0, 0, 128));
		jtfPesquisar.setFont(new Font("HanziPen TC", Font.BOLD, 15));
		jtfPesquisar.setBounds(152, 92, 513, 28);
		this.add(jtfPesquisar);
		jtfPesquisar.setColumns(10);
		
		jbtnPesquisar = new JButton("Pesquisar");
		jbtnPesquisar.setForeground(new Color(0, 0, 128));
		jbtnPesquisar.setFont(new Font("HanziPen TC", Font.BOLD, 15));
		jbtnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		jbtnPesquisar.setBounds(677, 93, 117, 29);
		this.add(jbtnPesquisar);
		
		JLabel lblSistemaContatosV = new JLabel("SISTEMA CONTATOS V1.0");
		lblSistemaContatosV.setForeground(new Color(0, 128, 128));
		lblSistemaContatosV.setFont(new Font("HanziPen TC", Font.BOLD, 24));
		lblSistemaContatosV.setBounds(263, 18, 357, 38);
		this.add(lblSistemaContatosV);
		
		jbtnNovoContato = new JButton("Novo Contato");
		jbtnNovoContato.setForeground(new Color(0, 0, 128));
		jbtnNovoContato.setFont(new Font("HanziPen TC", Font.BOLD, 15));
		jbtnNovoContato.setBounds(6, 501, 117, 29);
		this.add(jbtnNovoContato);
		
		
		table = new JTable ();
		table.setFont(new Font("HanziPen TC", Font.BOLD, 15));
		table.setBounds(16, 139, 778, 350);
		table.setBackground(UIManager.getColor("Button.background"));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
		JScrollPane jScrollPane = new JScrollPane(table);
		jScrollPane.setBounds(16, 139, 778, 350);
		this.add(jScrollPane);
		
		return this;
	}

	public JTextField getJtfPesquisar() {
		return jtfPesquisar;
	}

	public void setJtfPesquisar(JTextField jtfPesquisar) {
		this.jtfPesquisar = jtfPesquisar;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JButton getJbtnPesquisar() {
		return jbtnPesquisar;
	}

	public void setJbtnPesquisar(JButton jbtnPesquisar) {
		this.jbtnPesquisar = jbtnPesquisar;
	}

	public JButton getJbtnNovoContato() {
		return jbtnNovoContato;
	}

	public void setJbtnNovoContato(JButton jbtnNovoContato) {
		this.jbtnNovoContato = jbtnNovoContato;
	}
}
