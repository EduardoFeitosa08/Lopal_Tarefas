package br.dev.eduardo.tarefas.ui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.event.ChangeListener;

import br.dev.eduardo.tarefas.dao.FuncionarioDAO;
import br.dev.eduardo.tarefas.dao.TarefaDAO;
import br.dev.eduardo.tarefas.model.Funcionario;
import br.dev.eduardo.tarefas.model.Status;
import br.dev.eduardo.tarefas.model.Tarefa;

public class TarefaFrame {

	private JLabel labelNome;
	private JTextField textNome;
	private JLabel labelDescricao;
	private JTextField textDescricao;
	private JLabel labelResponsavel;
	private JComboBox<Funcionario> comboResponsavel;
	private JLabel labelDataInicio;
	private JTextField textDataInicio;
	private JLabel labelPrazo;
	private JTextField textPrazo;
	private JLabel labelDataPrevEntrega;
	private JTextField textDataPrevEntrega;
	private JLabel labelStatus;
	private JComboBox<Status> comboStatus;
	private JLabel labelDataConclusao;
	private JTextField textDataConclusao;
	private JButton btnSalvar;
	private JButton btnSair;
	
	
	public TarefaFrame(JDialog tela) {
		criarTela(tela);
	}
	
	private void criarTela(JDialog parent4) {
		
		JDialog tela = new JDialog(parent4, true);
		tela.setSize(300, 480);
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
		textNome.setBounds(10, 40, 200, 25);
		
		labelDescricao = new JLabel("Descrição:");
		labelDescricao.setBounds(10, 70, 100, 20);
		labelDescricao.setFont(new Font("Arial", Font.BOLD, 14));
		
		textDescricao = new JTextField();
		textDescricao.setBounds(10, 90, 200, 25);
	
		labelDataInicio = new JLabel("Data de Inicio:");
		labelDataInicio.setBounds(10, 130, 100, 20);
		labelDataInicio.setFont(new Font("Arial", Font.BOLD, 14));
		
		textDataInicio = new JTextField();
		textDataInicio.setBounds(10, 150, 150, 25);
		
		labelPrazo = new JLabel("Prazo:");
		labelPrazo.setBounds(10, 180, 100, 20);
		labelPrazo.setFont(new Font("Arial", Font.BOLD, 14));
		
		textPrazo = new JTextField();
		textPrazo.setBounds(10, 200, 150, 25);
		
		labelDataPrevEntrega =  new JLabel("Data de Previsão de Entrega:");
		labelDataPrevEntrega.setBounds(10, 280, 300, 20);
		labelDataPrevEntrega.setFont(new Font("Arial", Font.BOLD, 14));
		
		textDataPrevEntrega = new JTextField();
		textDataPrevEntrega.setBounds(10, 300, 150, 25);
		
		labelDataConclusao = new JLabel("Data de conclusão");
		labelDataConclusao.setBounds(10, 230, 200, 20);
		labelDataConclusao.setFont(new Font("Arial", Font.BOLD, 14));
		
		textDataConclusao = new JTextField();
		textDataConclusao.setBounds(10, 250, 200, 25);
		
		labelStatus = new JLabel("Status:");		
		labelStatus.setBounds(10, 280, 100, 20);
		labelStatus.setFont(new Font("Arial", Font.BOLD, 14));
		
		comboStatus = new JComboBox<Status>(Status.values());
		comboStatus.setBounds(10, 300, 200, 25);
		
		labelResponsavel = new JLabel("Responsavel");
		labelResponsavel.setBounds(10, 330, 200, 20);
		labelResponsavel.setFont(new Font("Arial", Font.BOLD, 14));
		
		List<Funcionario> funcionario = new FuncionarioDAO(null).getFuncionarios();
		comboResponsavel = new JComboBox<>(funcionario.toArray(new Funcionario[0]));
		comboResponsavel.setBounds(10, 350, 200, 25);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 390, 130, 50);
		btnSalvar.setFont(new Font("Arial", Font.BOLD, 14));
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(150, 390, 130, 50);
		btnSair.setFont(new Font("Arial", Font.BOLD, 14));
		
		
		painel.add(labelNome);
		painel.add(textNome);
		
		painel.add(labelDescricao);
		painel.add(textDescricao);
		
		painel.add(labelDataInicio);
		painel.add(textDataInicio);
		
		painel.add(labelPrazo);
		painel.add(textPrazo);
		
		painel.add(labelDataConclusao);
		painel.add(textDataConclusao);
		
		painel.add(labelStatus);
		painel.add(comboStatus);
		
		painel.add(labelResponsavel);
		painel.add(comboResponsavel);
		
		painel.add(btnSalvar);
		painel.add(btnSair);
		
//		painel.add(labelDataPrevEntrega);
//		painel.add(textDataPrevEntrega);
		
		
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Tarefa t = new Tarefa();
				t.setNome(textNome.getText());
				t.setDescricao(textDescricao.getText());
				t.setResponsavel(comboResponsavel.getSelectedItem().toString());
				t.setDataInicio(textDataInicio.getText());
				t.setPrazo(Integer.parseInt(textPrazo.getText()));
				t.setDataPrevisaoDeEntrega(null);
				t.setStatus(comboStatus.getSelectedItem().toString());
				t.setDataEntrega(null);
				
				TarefaDAO dao = new TarefaDAO(t);
				dao.salvar();
				
				JOptionPane.showMessageDialog(tela, "Tarefa gravada com sucesso!");
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
