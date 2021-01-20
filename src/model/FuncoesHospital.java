package model;

public interface FuncoesHospital {
    public Paciente ficharPaciente(Cidadao cidadao, int massaCorporal, boolean hasDoencasCronicas, boolean isFumante, boolean hasCovid);
    public boolean removerPaciente(Paciente paciente);
    public boolean isLotado();
}
