package Projeto1;

import java.util.ArrayList;
import java.util.Scanner;

public class Hospital {
    private String nome;
    private int capacidadeLeitos;
    private Regiao regiao;
    private ArrayList<Paciente> pacientes;

    public Hospital(String nome, int capacidadeLeitos, Regiao regiao) {
    	this.nome = nome;
        this.capacidadeLeitos = capacidadeLeitos;
        this.regiao = regiao;
        this.pacientes = new ArrayList<Paciente>();
    }

    public boolean testeCovid(Cidadao cidadao)
    {
        int numeroDeSintomas = cidadao.getSintomas().size();
        
        if (numeroDeSintomas >= Paciente.RISCO_MEDIO || cidadao.getSintomas().stream().anyMatch(sintoma -> "grave".equals(sintoma.getGravidade()))) {
        	System.out.println("Nos diga sua massa corporal: \n");
        	Scanner var = new Scanner(System.in);
        	double massaCorporal = var.nextDouble();
        	System.out.println("Você possui doenças crônicas? (responda com 'sim' se possuir) \n");
        	var.nextLine();
        	String hasDoencasCronicas = var.nextLine();
        	System.out.println("É fumante? (responda com 'sim' se for)");
        	String isFumante = var.nextLine();
        	Paciente paciente = new Paciente(cidadao, massaCorporal, hasDoencasCronicas == "sim" ? true : false, isFumante == "sim" ? true : false, true);
        	pacientes.add(paciente);
        	
        	var.close();
        	return true;
        }
        
        else {
        	System.out.println("Fique em casa!");
        	return false;
        }
    }
    
    public boolean removerPaciente(Paciente paciente) {
    	return pacientes.remove(paciente);
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCapacidadeLeitos() {
        return capacidadeLeitos;
    }

    public void setCapacidadeLeitos(int capacidadeLeitos) {
        this.capacidadeLeitos = capacidadeLeitos;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }
    
    @Override
    public String toString() {
    	String out = "Informações do hospital " + getNome() + "\n";
    	out += "  * Capacidade de leitos: " + getCapacidadeLeitos() + "\n";
    	out += "  * Região: " + getRegiao() + "\n";
    	out += "  * Nomes dos pacientes no hospital:\n";
    	for (Paciente paciente : pacientes) out += "  * " + paciente.getNome() + "\n";
    	
    	return out;
    }
}
