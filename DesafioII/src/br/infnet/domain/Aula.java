package br.infnet.domain;

import java.awt.List;
import java.util.ArrayList;
import java.util.Calendar;

public class Aula {

	private int id;
	private int turma;
	private String nome;
	private Calendar data;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTurma() {
		return turma;
	}
	public void setTurma(int turma) {
		this.turma = turma;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	
	public int AlunoEstaPresent(ArrayList<Aluno> presentes, String matAluno){
		for (Aluno aluno : presentes) {
			if(aluno.getMatricula().equalsIgnoreCase(matAluno)){
				return 1;
			}
		}
		
		return 0; 
	}
	
}
