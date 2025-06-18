package br.dev.eduardo.tarefas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import br.dev.eduardo.tarefas.dao.FuncionarioDAO;
import br.dev.eduardo.tarefas.model.Funcionario;
import br.dev.eduardo.tarefas.model.Tarefa;
import br.dev.eduardo.tarefas.ui.FuncionarioFrame;
import br.dev.eduardo.tarefas.ui.FuncionariosListaFrame;
import br.dev.eduardo.tarefas.ui.GerenciadorFrame;
import br.dev.eduardo.tarefas.ui.TarefaFrame;
import br.dev.eduardo.tarefas.ui.TarefaListaFrame;

public class Main {

	static String caminho = "/Users/25132675/tarefasDS1TA/tarefas";
	
	public static void main(String[] args) {
				
		//FuncionarioDAO dao = new FuncionarioDAO(null);
		//dao.getFuncionarios();
		
		//new TarefaFrame();
		
		new GerenciadorFrame();
		
		//new FuncionariosListaFrame();
		
		//new FuncionarioFrame();
		
		
//		UUID uuid = UUID.randomUUID();
//		System.out.println(uuid);
//		
//		String escola = "Senai Jandira";
//		String cidade = escola.substring(6, 13);
//		System.out.println(cidade);
//		
//		String uuid8 = uuid.toString().substring(0, 8);
//		System.out.println(uuid8);
//		
//		Funcionario f = new Funcionario("Alex", "Programador");
//		f.setSetor("TI");
//		
//		Funcionario f2 = new Funcionario();
//		f2.setNome("Peter Griffin");
//		f2.setCargo("Analista de Sistemas");
//		f2.setSetor("TI");
//		
//		FuncionarioDAO dao = new FuncionarioDAO(f2);
//		dao.salvar();
	}

	
	private static void escreverArquivo() {
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			fw = new FileWriter(caminho, true);
			bw = new BufferedWriter(fw);
			
			//Adicionando conteudo ao arquivo
//			bw.append("Senai Jandira ");
//			bw.append("Eduardo");/
			bw.append("Batatinha\n");
			bw.append("Senai Jandira\n");
			bw.append("Programação de computadores\n");
			
			//Mandando escrever no arquivo
			bw.flush();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private static void lerArquivo() {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(caminho);
			br = new BufferedReader(fr);
			
			String retorno = br.readLine();
			
			while(retorno != null) {
				
				System.out.println(retorno);
				retorno = br.readLine();
			}
			
		} catch (FileNotFoundException erro) {
			System.out.println("Arquivo não foi encontrado!");
		} catch (Exception e) {
			System.out.println("Ocorreu um erro!");
		}
		
		System.out.println("Fim");
	}

}
