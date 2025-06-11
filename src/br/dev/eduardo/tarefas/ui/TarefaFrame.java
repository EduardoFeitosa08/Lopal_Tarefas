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
import javax.swing.JTextField;

import br.dev.eduardo.tarefas.model.Tarefa;

public class TarefaFrame {

	private JLabel labelNome;
	private JTextField textNome;
	private JLabel labelDescricao;
	private JTextField textDescricao;
	private JLabel labelResponsavel;
	private JTextField textResponsavel;
	private JLabel labelDataInicio;
	private JTextField textDataInicio;
	private JLabel labelPrazo;
	private JTextField textPrazo;
	private JLabel labelDataPrevEntrega;
	private JTextField textDataPrevEntrega;
	private JLabel labelStatus;
	private JTextField textStatus;
	private JButton btnSalvar;
	private JButton btnSair;
	
	
	public TarefaFrame(JDialog tela) {
		criarTela(tela);
	}
	
	private void criarTela(JDialog parent4) {
		
		JDialog tela = new JDialog(parent4, true);
		tela.setSize(300, 800);
		tela.setTitle("Nova Tarefa");
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		
		Container painel = tela.getContentPane();
		
		labelNome =  new JLabel("Nome:");
		labelNome.setBounds(10, 20, 50, 20);
		labelNome.setFont(new Font("Arial", Font.BOLD, 14));
		
		textNome = new JTextField();
		textNome.setBounds(10, 50, 200, 50);
		
		labelDescricao = new JLabel("Descrição:");
		labelDescricao.setBounds(10, 110, 100, 20);
		labelDescricao.setFont(new Font("Arial", Font.BOLD, 14));
		
		textDescricao = new JTextField();
		textDescricao.setBounds(10, 140, 200, 50);
		
		labelResponsavel = new JLabel("Responsavel:");
		labelResponsavel.setBounds(10, 200, 100, 20);
		labelResponsavel.setFont(new Font("Arial", Font.BOLD, 14));
		
		textResponsavel = new JTextField();
		textResponsavel.setBounds(10, 230, 200, 50);
		
		labelDataInicio = new JLabel("Data de Inicio:");
		labelDataInicio.setBounds(10, 290, 100, 20);
		labelDataInicio.setFont(new Font("Arial", Font.BOLD, 14));
		
		textDataInicio = new JTextField();
		textDataInicio.setBounds(10, 320, 150, 50);
		
		labelPrazo = new JLabel("Prazo:");
		labelPrazo.setBounds(10, 380, 100, 20);
		labelPrazo.setFont(new Font("Arial", Font.BOLD, 14));
		
		textPrazo = new JTextField();
		textPrazo.setBounds(10, 410, 100, 50);
		
		labelDataPrevEntrega =  new JLabel("Data de Previsão de Entrega:");
		labelDataPrevEntrega.setBounds(10, 470, 200, 20);
		labelDataPrevEntrega.setFont(new Font("Arial", Font.BOLD, 14));
		
		textDataPrevEntrega = new JTextField();
		textDataPrevEntrega.setBounds(10, 500, 150, 50);
		
		labelStatus = new JLabel("Status:");
		labelStatus.setBounds(10, 560, 100, 20);
		labelStatus.setFont(new Font("Arial", Font.BOLD, 14));
		
		textStatus = new JTextField();
		textStatus.setBounds(10, 590, 200, 50);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 660, 130, 50);
		btnSalvar.setFont(new Font("Arial", Font.BOLD, 14));
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(150, 660, 130, 50);
		btnSair.setFont(new Font("Arial", Font.BOLD, 14));
		
		
		painel.add(labelNome);
		painel.add(textNome);
		
		painel.add(labelDescricao);
		painel.add(textDescricao);
		
		painel.add(labelResponsavel);
		painel.add(textResponsavel);
		
		painel.add(labelDataInicio);
		painel.add(textDataInicio);
		
		painel.add(labelPrazo);
		painel.add(textPrazo);
		
		painel.add(labelDataPrevEntrega);
		painel.add(textDataPrevEntrega);
		
		painel.add(labelStatus);
		painel.add(textStatus);
		
		painel.add(btnSalvar);
		painel.add(btnSair);
		
		
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Tarefa t = new Tarefa();
				t.setNome(textNome.getText());
				t.setDescricao(textDescricao.getText());
				t.setResponsavel(textResponsavel.getText());
				//t.setDataInicio(textDataInicio.getText());
			}
		});
		
		
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
		
		
		
		tela.setVisible(true);
		
	}
	
	
	
	
	
}
