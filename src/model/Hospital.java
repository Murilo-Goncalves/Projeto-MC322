package model;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Hospital implements FuncoesHospital, Serializable {
    private static final long serialVersionUID = 6L;

    private String nome;
    private int capacidadeLeitos;
    private Regiao regiao;
    private final ArrayList<Paciente> pacientes;

    // Constants
    public final static int RISCO_MEDIO = 3;
    public final static int RISCO_ALTO = 6;

    // Construtor
    public Hospital(String nome, int capacidadeLeitos, Regiao regiao) {
        this.nome = nome;
        this.capacidadeLeitos = capacidadeLeitos;
        this.regiao = regiao;
        this.pacientes = new ArrayList<Paciente>();
    }

    // Decide se o paciente será internado
    public boolean ficharPaciente(Cidadao cidadao, int massaCorporal, boolean hasDoencasCronicas, boolean isFumante, boolean hasCovid)
    {
        int numeroDeSintomas = cidadao.getSintomas().size();
        
        if (numeroDeSintomas >= RISCO_MEDIO || cidadao.getSintomas().stream().anyMatch(sintoma -> "grave".equals(sintoma.getGravidade()))) {

        	Paciente paciente = new Paciente(cidadao, massaCorporal, hasDoencasCronicas, isFumante, hasCovid);
        	pacientes.add(paciente);

        	return true;
        }
        
        else {
        	return false;
        }
    }
    
    public boolean removerPaciente(Paciente paciente) {
    	return pacientes.remove(paciente);
    }

    public boolean isLotado() {
        return pacientes.size() == capacidadeLeitos;
    }

    // Método toString
    @Override
    public String toString() {
    	String out = "Informações do hospital " + getNome() + "\n";
    	out += "  * Capacidade de leitos: " + getCapacidadeLeitos() + "\n";
    	out += "  * Região: " + getRegiao() + "\n";
    	out += "Nomes dos pacientes no hospital:\n";
    	for (Paciente paciente : pacientes) out += "  * " + paciente.getNome() + "\n";
    	
    	return out;
    }

    // Getters e setters
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
}
