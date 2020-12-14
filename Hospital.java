package Projeto1;

import java.util.ArrayList;
import java.util.Scanner;

public class Hospital {
    private String nome;
    private int capacidadeLeitos;
    private Regiao regiao;
    private ArrayList<Paciente> pacientes;

    Hospital(String nome, int capacidadeLeitos, Regiao regiao) {
    	this.nome = nome;
        this.capacidadeLeitos = capacidadeLeitos;
        this.regiao = regiao;
        this.pacientes = new ArrayList();
    }

    // TODO CONSTRUTORES
    // TODO TOSTRING
    // TODO ADD PACIENTE
    // TODO REMOVER PACIENTE

    public boolean testeCovid(Cidadao cidadao)
    {
        int numeroDeSintomas = cidadao.getSintomas().size();
        
        if (numeroDeSintomas >= Paciente.RISCO_MEDIO || cidadao.getSintomas().stream().anyMatch(sintoma -> "grave".equals(sintoma.getGravidade()))) {
        	System.out.println("Nos diga sua massa corporal: \n");
        	Scanner var = new Scanner(System.in);
        	double massaCorporal = var.nextDouble();
        	System.out.println("Você possui doenças Crônicas? (responda com true ou false) \n");
        	boolean hasDoencasCronicas = var.nextBoolean();
        	System.out.println("É fumante? (responda com true ou false)");
        	boolean isFumante = var.nextBoolean();
        	
        	Paciente paciente = new Paciente(cidadao, massaCorporal, hasDoencasCronicas, isFumante, true);
        	pacientes.add(paciente);
        	
        	var.close();
        	return true;
        }
    	
        return false;
    }

    public boolean isLotado() {
        if (pacientes.size() == capacidadeLeitos)
        {
            System.out.println("O hospital está sem leitos de COVID disponíveis.");
            return true;
        }

        System.out.println("O hospital possui leitos de COVID disponíveis.");
        return false;
    }

    public String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    public int getCapacidadeLeitos() {
        return capacidadeLeitos;
    }

    private void setCapacidadeLeitos(int capacidadeLeitos) {
        this.capacidadeLeitos = capacidadeLeitos;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    private void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }
    
}
