package br.dev.eduardo.tarefas.ui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GerenciadorFrame {

	private JButton btnFuncionarios;
	private JButton btnTarefas;
	
	
	public GerenciadorFrame() {
		criarTela();
	}
	
	private void criarTela() {
		
		JFrame tela = new JFrame("Nova Tarefa");
		tela.setSize(400, 200);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		
		Container painel = tela.getContentPane();
		
		btnFuncionarios = new JButton("Funcionarios");
		btnFuncionarios.setBounds(10, 50, 180, 100);
		btnFuncionarios.setFont(new Font("Arial", Font.BOLD, 20));
		
		btnTarefas = new JButton("Tarefas");
		btnTarefas.setBounds(200, 50, 180, 100);
		btnTarefas.setFont(new Font("Arial", Font.BOLD, 20));
		
		painel.add(btnFuncionarios);
		painel.add(btnTarefas);
		
		btnFuncionarios.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FuncionariosListaFrame(tela);
				
			}
		});
		
		btnTarefas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TarefaListaFrame(tela);
				
			}
		});
		
		tela.setVisible(true);
		
	}
	
	
}
