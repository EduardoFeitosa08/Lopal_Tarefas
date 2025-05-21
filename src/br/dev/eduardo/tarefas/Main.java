package br.dev.eduardo.tarefas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import br.dev.eduardo.tarefas.model.Tarefa;

public class Main {

	static String caminho = "/Users/25132675/tarefasDS1TA/tarefas";
	
	public static void main(String[] args) {
		
		Tarefa tarefa1 = new Tarefa("Lavar a louça");
		
		
		//escreverArquivo();
		//lerArquivo();
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
