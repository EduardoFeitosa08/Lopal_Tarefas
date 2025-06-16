package br.dev.eduardo.tarefas.model;

import java.awt.Toolkit;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Tarefa {

	private String nome;
	private String descricao;
	private LocalDate dataInicio;
	private int prazo;
	private LocalDate dataPrevisaoDeEntrega;
	private LocalDate dataEntrega;
	private Status status;
	private Toolkit responsavel;

	public Tarefa() {
		System.out.println("Criando uma tarefa...");
	}
	
	public Tarefa(String nome) {
		System.out.println("Criando a tarefa " + nome);
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataInicio2 = dataInicio.format(formato);

		this.dataInicio = dataInicio;
	}

	public int getPrazo() {
		return prazo;
	}

	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}

	public LocalDate getDataPrevisaoDeEntrega() {
		return dataPrevisaoDeEntrega;
	}

	public void setDataPrevisaoDeEntrega(LocalDate dataPrevisaoDeEntrega) {
		this.dataPrevisaoDeEntrega = dataPrevisaoDeEntrega;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Toolkit getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Toolkit toolkit) {
		this.responsavel = toolkit;
	}

}
