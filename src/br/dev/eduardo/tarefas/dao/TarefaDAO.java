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
	//private String arquivo = "C:\\Users\\25132675\\tarefasDS1TA\\tarefas.csv";
	
	
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
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Tarefa> getTarefa() {
		
		List<Tarefa> tarefas = new ArrayList<>();
		
		
		
		try {
			String linha = "";
			while(linha != null) {
				linha = br.readLine();
				if(linha != null) {
					String[] tarefaVetor = linha.split(",");
					Tarefa tarefa = new Tarefa();
					tarefa.setCodigo(tarefaVetor[0]);
					tarefa.setNome(tarefaVetor[1]);
					tarefa.setDescricao(tarefaVetor[2]);
					tarefa.setResponsavel(tarefaVetor[3]);
					tarefa.setDataInicio(tarefaVetor[4]);
//					tarefa.setPrazo(tarefaVetor[5]);
//					tarefa.setDataPrevisaoDeEntrega(tarefaVetor[6]);
					tarefa.setStatus(tarefaVetor[7]);
//					tarefa.setDataEntrega(tarefaVetor[8]);
					tarefas.add(tarefa);
					
				}
				
			}
			return tarefas;
			
		} catch (Exception e) {
			return null;
		}
		
	}
	
}
