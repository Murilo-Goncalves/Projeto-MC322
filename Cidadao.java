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
    private Contaminacao contaminacao;
    private boolean isGrupoDeRisco;
    private ArrayList<Sintomas> sintomas;
    private boolean isCampinas;
    private Regiao regiao;

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

    public boolean isGrupoDeRisco() {
        return isGrupoDeRisco;
    }

    public void setGrupoDeRisco(boolean grupoDeRisco) {
        isGrupoDeRisco = grupoDeRisco;
    }

    public boolean isCampinas() {
        return isCampinas;
    }

    public void setCampinas(boolean campinas) {
        isCampinas = campinas;
    }

    public Contaminacao getContaminacao() {
        return contaminacao;
    }

    public void setContaminacao(Contaminacao contaminacao) {
        this.contaminacao = contaminacao;
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
    // a ser altetado
    public boolean SuspeitaDeCovid() {
        return true;
    }
    // a ser alterado
    public ArrayList<Hospital> hospitaisNaregiao() {
        ArrayList<Hospital> hospitais = new ArrayList<Hospital>();
        return hospitais;
    }
}
