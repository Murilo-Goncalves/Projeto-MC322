package Projeto1;
// falta completar toString
import java.util.ArrayList;

public class Paciente extends Cidadao {
    private double massaCorporal;
    private boolean hasDoencasCronicas;
    private boolean isFumante;
    private String severidade;
    private QuadroDeSaude saude;
    private boolean isGrupoDeRisco;
    private boolean testadoPositivamente;
    private String tempoDeTratamento = "0 dias.";

    public Paciente(String nome, String cpf, String login, String senha, int idade, String telefone, String email, String sexo, ArrayList<Sintomas> sintomas, boolean isCampinas, Regiao regiao, boolean convenio, double massaCorporal, boolean hasDoencasCronicas, boolean isFumante, boolean testadoPositivamente) {
        super(nome, cpf, login, senha, idade, telefone, email, sexo, sintomas, isCampinas, regiao, convenio);
        this.massaCorporal = massaCorporal;
        this.hasDoencasCronicas = hasDoencasCronicas;
        this.isFumante = isFumante;
        this.testadoPositivamente = testadoPositivamente;
        setGrupoDeRisco(massaCorporal, hasDoencasCronicas, isFumante);
        setSaude(this.testadoPositivamente, super.getSintomas());
        setSeveridade(getSaude(), super.getSintomas());
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

    public void setSeveridade(QuadroDeSaude saude, ArrayList<Sintomas> sintomas) {
        if (saude == QuadroDeSaude.SAUDAVEL) severidade = "nenhuma";
        int risco = Sintomas.GravidadeCovid(sintomas);
        if (risco < 4 && !this.isGrupoDeRisco) {
            if (saude == QuadroDeSaude.SUSPEITA) severidade = "potencialmente leve";
            else severidade = "leve";
        }
        else if (risco < 6 && !this.isGrupoDeRisco) {
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

    public void setSaude(boolean testadoPositivamente, ArrayList<Sintomas> sintomas) {
        if(testadoPositivamente) this.saude = QuadroDeSaude.DOENTE;
        else if (sintomas.isEmpty()) this.saude = QuadroDeSaude.SAUDAVEL;
        else this.saude = QuadroDeSaude.SUSPEITA;
    }

    public boolean isGrupoDeRisco() {
        return isGrupoDeRisco;
    }

    public void setGrupoDeRisco(double massaCorporal, boolean hasDoencasCronicas, boolean isFumante) {
        if (massaCorporal > 120 || super.getIdade() > 60 || super.getIdade() <= 5 || isFumante || hasDoencasCronicas)
            isGrupoDeRisco = true;
        else isGrupoDeRisco = false;
    }

    public String getTempoDeTratamento() {
        return tempoDeTratamento;
    }

    public void setTempoDeTratamento(String severidade, QuadroDeSaude saude) {
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
        out += "\nInformacoes do Paciente " + super.getNome() + " *";
        out += "\n  * Massa corporal: ";
        out += "\n  * Possui doencas crônicas? ";
        out += "\n  * É fumante? ";
        out += "\n  * É grupo de risco? ";
        out += "\n  * Riscos à saúde: ";
        out += "\n  * Tempo de tratamento necessário: ";
        return out;
    }
}
