package Projeto1;
// falta completar toString
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
    private boolean convenio;

    public Cidadao(String nome, String cpf, String login, String senha, int idade, String telefone, String email, String sexo, ArrayList<Sintomas> sintomas, boolean isCampinas, Regiao regiao, boolean convenio) {
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


    public boolean isCampinas() {
        return isCampinas;
    }

    public void setCampinas(boolean campinas) {
        isCampinas = campinas;
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
        return convenio;
    }

    public void setConvenio(boolean convenio) {
        this.convenio = convenio;
    }

    @Override
        public String toString() {
        String out = "";
        out += "Informacoes do Cidadao " + this.getNome();
        out += "\n  * cpf: ";
        out += "\n  * idade: ";
        out += "\n  * login: ";
        out += "\n  * telefone: ";
        out += "\n  * email: ";
        out += "\n  * sexo: ";
        out += "\n  * Mora em Campinas? ";
        out += "\n  * Regiao em que mora: ";
        out += "\n  * Possui convênio privado? ";
        return out;
    }
}
