package br.dev.eduardo.tarefas.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.dev.eduardo.tarefas.model.Funcionario;
import br.dev.eduardo.tarefas.model.Tarefa;

public class TarefaDAO {

	private Tarefa tarefa;
	private FileWriter fw;
	private BufferedWriter bw;
	private FileReader fr;
	private BufferedReader br;
	private String arquivo = "/Users/25132675/tarefasDS1TA/tarefas.csv";
	
	
	public TarefaDAO(Tarefa tarefa) {
		this.tarefa = tarefa;
		
		try {
			fw = new FileWriter(arquivo, true);
			bw = new BufferedWriter(fw);
			fr = new FileReader(arquivo);
			br = new BufferedReader(fr);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void salvar() {
		try {
			bw.write(tarefa.toString());
			bw.flush();
			System.out.println(tarefa.getNome() + " gravado com sucelso");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Tarefa> getFuncionarios() {
		
		List<Tarefa> funcionarios = new ArrayList<>();
		
		
		try {
			String linha = "";
			while(linha != null) {
				linha = br.readLine();
				if(linha != null) {
					String[] tarefaVetor = linha.split(",");
					Tarefa tarefa = new Tarefa();
					tarefa.setNome(tarefaVetor[0]);
					tarefa.setDescricao(tarefaVetor[1]);
//					tarefa.setResponsavel(tarefaVetor[3]);
					//tarefa.setDataInicio(tarefaVetor[4]);
					
					
					
					String[] funcionarioVetor = linha.split(",");
					Funcionario funcionario = new Funcionario();
					funcionario.setMatricula(funcionarioVetor[0]);
					funcionario.setNome(funcionarioVetor[1]);
					funcionario.setCargo(funcionarioVetor[2]);
					funcionario.setSetor(funcionarioVetor[3]);
					funcionarios.add(tarefa);
				}
				
			}
			return funcionarios;
			
		} catch (Exception e) {
			return null;
		}
		
	}
	
}
