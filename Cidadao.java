package Projeto1;

import java.util.ArrayList;

public class Cidadao {
    private String nome;
    private String cpf;
    private String login;
    private String senha;
    private int idade;
    private String telefone;
    private String email;
    private String sexo;

    private ArrayList<Sintomas> sintomas;
    private boolean isCampinas;
    private Regiao regiao;
    private Convenio convenio;

    public Cidadao(String nome, String cpf, String login, String senha,
    		int idade, String telefone, String email, String sexo, ArrayList<Sintomas> sintomas, 
    		boolean isCampinas, Regiao regiao, Convenio convenio) {
        this.nome = nome;
        this.cpf = cpf;
        this.login = login;
        this.senha = senha;
        this.idade = idade;
        this.telefone = telefone;
        this.email = email;
        this.sexo = sexo;
        this.sintomas = sintomas;
        this.isCampinas = isCampinas;
        this.regiao = regiao;
        this.convenio = convenio;
    }

    public String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    private void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLogin() {
        return login;
    }

    private void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    private void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdade() {
        return idade;
    }

    private void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    private void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    private void setSexo(String sexo) {
        this.sexo = sexo;
    }


    public boolean isCampinas() {
        return isCampinas;
    }

    private void setCampinas(boolean campinas) {
        isCampinas = campinas;
    }

    public ArrayList<Sintomas> getSintomas() {
        return sintomas;
    }

    private void setSintomas(ArrayList<Sintomas> sintomas) {
        this.sintomas = sintomas;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    private void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }

    public boolean hasConvenio() {
        return !Convenio.SEM_CONVENIO.equals(convenio);
    }
    
    public Convenio getConvenio() {
    	return convenio;
    }

    private void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    @Override
        public String toString() {
        String out = "";
        out += "Informacoes do Cidadao " + getNome();
        out += "\n  * cpf: " + getCpf();
        out += "\n  * idade: " + Integer.toString(getIdade());
        out += "\n  * login: " + getLogin();
        out += "\n  * telefone: " + getTelefone();
        out += "\n  * email: " + getEmail();
        out += "\n  * sexo: " + getSexo();
        out += "\n  * Mora em Campinas? " + (isCampinas() ? "Sim." : "Nao.");
        out += "\n  * Regiao em que mora: " + getRegiao().toString();
        out += "\n  * Possui convênio privado? " + (hasConvenio() ? "Sim." : "Nao.");
        return out;
    }
}
