package br.dev.eduardo.tarefas.ui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TarefaListaFrame {

	private JLabel labelTitulo;
	private JButton btnNovo;
	private JButton btnSair;
	
	private JTable tabelaFuncionarios; //Desenha a tabela
	private DefaultTableModel modelFuncionarios; //O que vai ter na tabela
	private JScrollPane scroll; //Deixa a tabela scrollavel se ela ser muito grande
	
	private String[] colunas = {"NOME DA TAREFA", "DESCRIÇÃO", "RESPONSAVEL", "DATA DE INICIO", "PRAZO", "STATUS", "DATA DE ENTREGA"};
	
	public TarefaListaFrame(JFrame tela) {
		criarTela(tela);
	}
	
	public void criarTela(JFrame parent3) {
		
		JDialog tela = new JDialog(parent3, true);
		tela.setSize(900, 500);
		tela.setTitle("Lista de Tarefas");
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		
		Container painel = tela.getContentPane();
		
		labelTitulo = new JLabel("Lista de Tarefas");
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 28));
		labelTitulo.setBounds(10, 10, 400, 40);
		
		
		modelFuncionarios = new DefaultTableModel(colunas, 1);
		//carregarDados();
		tabelaFuncionarios = new JTable(modelFuncionarios);
		scroll = new JScrollPane(tabelaFuncionarios);
		scroll.setBounds(10, 60, 880, 340);
		
		btnNovo = new JButton("Novo");
		btnNovo.setBounds(10, 410, 150, 40);
		
		btnNovo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TarefaFrame(tela);
				//carregarDados();
			}
		});
		
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(180, 410, 150, 40);
		
		btnSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//Caixa de dialogo de confirmaçao para se o usuario deseja sair do sistema
				int resposta = JOptionPane.showConfirmDialog(tela, "Sair do Sistema?");
				
				if(resposta == 0) {
					tela.dispose();
				}
				
				
				
			}
		});
		
		painel.add(labelTitulo);
		painel.add(scroll);
		painel.add(btnNovo);
		painel.add(btnSair);
		
		tela.setVisible(true);
		
	}
	
}
