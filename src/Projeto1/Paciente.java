package Projeto1;

import java.util.ArrayList;

public class Paciente extends Cidadao {
    private double massaCorporal;
    private boolean hasDoencasCronicas;
    private boolean isFumante;
    private String severidade;
    private QuadroDeSaude saude;
    private boolean isGrupoDeRisco;
    private boolean testadoPositivamente;
    private String tempoDeTratamento;
    
    public final static int RISCO_MEDIO = 3;
    public final static int RISCO_ALTO = 6;

    public Paciente(Cidadao cidadao, double massaCorporal, 
    		boolean hasDoencasCronicas, boolean isFumante, boolean testadoPositivamente) {
        super(cidadao.getNome(), cidadao.getCpf(), cidadao.getLogin(), cidadao.getSenha(), cidadao.getIdade(),
        		cidadao.getTelefone(), cidadao.getEmail(), cidadao.getSexo(), cidadao.getSintomas(),
        		cidadao.getRegiao(), cidadao.getConvenio());
        this.massaCorporal = massaCorporal;
        this.hasDoencasCronicas = hasDoencasCronicas;
        this.isFumante = isFumante;
        this.testadoPositivamente = testadoPositivamente;
        setGrupoDeRisco(massaCorporal, hasDoencasCronicas, isFumante);
        setSaude(this.testadoPositivamente, super.getSintomas());
        setSeveridade(getSaude(), super.getSintomas());
        setTempoDeTratamento(severidade, saude);
    }

    public double getMassaCorporal() {
        return massaCorporal;
    }

    public void setMassaCorporal(double massaCorporal) {
        this.massaCorporal = massaCorporal;
    }

    public boolean hasDoencasCronicas() {
        return hasDoencasCronicas;
    }

    public void setHasDoencasCronicas(boolean hasDoencasCronicas) {
        this.hasDoencasCronicas = hasDoencasCronicas;
    }

    public boolean isFumante() {
        return isFumante;
    }

    public void setFumante(boolean fumante) {
        isFumante = fumante;
    }

    public String getSeveridade() {
        return severidade;
    }

    private void setSeveridade(QuadroDeSaude saude, ArrayList<Sintomas> sintomas) {
        if (saude == QuadroDeSaude.SAUDAVEL) severidade = "nenhuma";
        int risco = Sintomas.gravidadeCovid(sintomas);
        if (risco <= RISCO_MEDIO && !this.isGrupoDeRisco) {
            if (saude == QuadroDeSaude.SUSPEITA) severidade = "potencialmente leve";
            else severidade = "leve";
        }
        else if (risco < RISCO_ALTO && !this.isGrupoDeRisco) {
            if (saude == QuadroDeSaude.SUSPEITA) severidade = "potencialmente mediana";
            else severidade = "mediana";
        }
        else {
            if (saude == QuadroDeSaude.SUSPEITA) severidade = "potencialmente grave";
            else severidade = "grave";
        }
    }

    public QuadroDeSaude getSaude() {
        return saude;
    }

    private void setSaude(boolean testadoPositivamente, ArrayList<Sintomas> sintomas) {
        if(testadoPositivamente) this.saude = QuadroDeSaude.DOENTE;
        else if (sintomas.isEmpty()) this.saude = QuadroDeSaude.SAUDAVEL;
        else this.saude = QuadroDeSaude.SUSPEITA;
    }

    public boolean isGrupoDeRisco() {
        return isGrupoDeRisco;
    }

    private void setGrupoDeRisco(double massaCorporal, boolean hasDoencasCronicas, boolean isFumante) {
        if (massaCorporal > 120 || super.getIdade() > 60 || super.getIdade() <= 5 || isFumante || hasDoencasCronicas)
            isGrupoDeRisco = true;
        else isGrupoDeRisco = false;
    }

    public String getTempoDeTratamento() {
        return tempoDeTratamento;
    }

    private void setTempoDeTratamento(String severidade, QuadroDeSaude saude) {
        if (saude == QuadroDeSaude.DOENTE) {
            if (severidade == "leve") tempoDeTratamento = "cerca de 10 dias.";
            else if (severidade == "mediana") tempoDeTratamento = "cerca de 20 dias.";
            else tempoDeTratamento = "cerca de 30 dias.";
        }
    }

    @Override
    public String toString() {
        String out = "";
        out += super.toString();
        out += "\nInformacoes do Paciente " + super.getNome();
        out += "\n  * Massa corporal: " + String.format("%.2f", getMassaCorporal());
        out += "\n  * Possui doencas crônicas? " + (hasDoencasCronicas() ? "Sim." : "Nao.");
        out += "\n  * É fumante? " + (isFumante() ? "Sim." : "Nao.");
        out += "\n  * Faz parte de grupo de risco? " + (isGrupoDeRisco() ? "Sim." : "Nao.");
        out += "\n  * Riscos à saúde: " + getSeveridade();
        out += "\n  * Tempo de tratamento necessário: " + getTempoDeTratamento();
        return out;
    }
}
