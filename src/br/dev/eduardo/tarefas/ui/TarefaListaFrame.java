package br.dev.eduardo.tarefas.ui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.dev.eduardo.tarefas.dao.FuncionarioDAO;
import br.dev.eduardo.tarefas.dao.TarefaDAO;
import br.dev.eduardo.tarefas.model.Funcionario;
import br.dev.eduardo.tarefas.model.Tarefa;

public class TarefaListaFrame {

	private JLabel labelTitulo;
	private JButton btnNovo;
	private JButton btnSair;
	
	private JTable tabelaFuncionarios; //Desenha a tabela
	private DefaultTableModel modelTarefas; //O que vai ter na tabela
	private JScrollPane scroll; //Deixa a tabela scrollavel se ela ser muito grande
	
	private String[] colunas = {"CÓDIGO", "NOME", "RESPONSAVEL"};
	
	public TarefaListaFrame(JFrame tela) {
		criarTela(tela);
	}
	
	public void criarTela(JFrame parent3) {
		
		JDialog tela = new JDialog(parent3, true);
		tela.setSize(600, 500);
		tela.setTitle("Lista de Tarefas");
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		
		Container painel = tela.getContentPane();
		
		labelTitulo = new JLabel("Lista de Tarefas");
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 28));
		labelTitulo.setBounds(10, 10, 400, 40);
		
		
		modelTarefas = new DefaultTableModel(colunas, 1);
		carregarDados();
		tabelaFuncionarios = new JTable(modelTarefas);
		scroll = new JScrollPane(tabelaFuncionarios);
		scroll.setBounds(10, 60, 580, 340);
		
		btnNovo = new JButton("Novo");
		btnNovo.setBounds(10, 410, 150, 40);
		
		btnNovo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TarefaFrame(tela);
				carregarDados();
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
	
	private Object[][] carregarDados() {
		//Obter os dados que serão exibidos na Tabela
		TarefaDAO dao = new TarefaDAO(null);
		List<Tarefa> tarefa = dao.getTarefa();
		
		Object[][] dados = new Object[tarefa.size()][3];
		
		
		//Para cada tarefa na lista de tarefas
		int i = 0;
		for(Tarefa t : tarefa) {
			dados[i][0] = t.getCodigo();
			dados[i][1] = t.getNome();
			dados[i][2] = t.getResponsavel();
			i++;
			
			
		}
		modelTarefas.setDataVector(dados, colunas);
		return dados;
	}
	
}
