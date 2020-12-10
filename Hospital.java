import java.util.ArrayList;

public class Hospital {
    private String nome;
    private int capacidadeLeitos;
    private Regiao regiao;
    private ArrayList<Paciente> pacientes;

    // TODO CONSTRUTORES
    // TODO TOSTRING
    // TODO ADD PACIENTE
    // TODO REMOVER PACIENTE

    public boolean testeCovid(Cidadao cidadao)
    {
        // ta vazio porra
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
