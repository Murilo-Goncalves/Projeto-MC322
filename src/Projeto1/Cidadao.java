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
    private Regiao regiao;
    private Convenio convenio;

    public Cidadao(String nome, String cpf, String login, String senha,
                   int idade, String telefone, String email, String sexo, ArrayList<Sintomas> sintomas,
                   Regiao regiao, Convenio convenio) {
        this.nome = nome;
        this.cpf = cpf;
        this.login = login;
        this.senha = senha;
        this.idade = idade;
        this.telefone = telefone;
        this.email = email;
        this.sexo = sexo;
        this.sintomas = sintomas;
        this.regiao = regiao;
        this.convenio = convenio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public ArrayList<Sintomas> getSintomas() {
        return sintomas;
    }

    public void setSintomas(ArrayList<Sintomas> sintomas) {
        this.sintomas = sintomas;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }

    public boolean hasConvenio() {
        return !Convenio.SEM_CONVENIO.equals(convenio);
    }
    
    public Convenio getConvenio() {
    	return convenio;
    }

    public void setConvenio(Convenio convenio) {
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
        out += "\n  * Regiao em que mora: " + getRegiao().toString();
        out += "\n  * Possui convênio privado? " + (hasConvenio() ? "Sim." : "Nao.");
        return out;
    }
}
