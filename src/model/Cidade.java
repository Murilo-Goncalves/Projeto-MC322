package model;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Cidade implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String nome;
    private final ArrayList<Cidadao> cidadaos;
    private final ArrayList<HospitalPublico> hospitaisPublicos;
    private final ArrayList<HospitalPrivado> hospitaisPrivados;
    private int numeroCidadaos = 0;
    private int nCidadaosComCovidNorte = 0;
    private int nCidadaosComCovidSul = 0;
    private int nCidadaosComCovidLeste = 0;
    private int nCidadaosComCovidOeste = 0;
    private int nCidadaosComCovidCentro = 0;
    private static int nCidades = 0;

    // Construtor
    public Cidade(String nome) {
        this.nome = nome;
        cidadaos = new ArrayList<Cidadao>();
        hospitaisPublicos = new ArrayList<HospitalPublico>();
        hospitaisPrivados = new ArrayList<HospitalPrivado>();
        nCidades++;
    }

    public void aumentaNCidadaosComCovid(boolean temCovid, Regiao regiao) {
        if (temCovid)
            if (regiao == Regiao.NORTE)
                nCidadaosComCovidNorte += 1;
            else if (regiao == Regiao.SUL)
                nCidadaosComCovidSul += 1;
            else if (regiao == Regiao.LESTE)
                nCidadaosComCovidLeste += 1;
            else if (regiao == Regiao.OESTE)
                nCidadaosComCovidOeste += 1;
            else if (regiao == Regiao.CENTRO)
                nCidadaosComCovidCentro += 1;
    }

    public void adicionaCidadao(Cidadao novoCidadao) {
        cidadaos.add(novoCidadao);
        numeroCidadaos += 1;
    }

    public boolean isSuspeita(Cidadao cidadao) {
        return !cidadao.getSintomas().isEmpty();
    }

    // Busca por um hospital na região do cidadão
    public Hospital procurarHospital(Cidadao cidadao) {
        // Se o cidadão possui convênio, procuramos o hospital privado da mesma região que possua esse convênio
        if (cidadao.hasConvenio()) {
            for (HospitalPrivado hospital : hospitaisPrivados) {
                if (hospital.getRegiao().equals(cidadao.getRegiao()) && !hospital.isLotado()
                    && hospital.getConvenioAtendido().equals(cidadao.getConvenio())) {
                    return hospital;
                }
            }
        }

        // Se um hospital público não foi encontrado ou o cidadão não possui convênio, buscamos um hospital público
        for (HospitalPublico hospital : hospitaisPublicos) {
            if (hospital.getRegiao().equals(cidadao.getRegiao()) && !hospital.isLotado()) {
                return hospital;
            }
        }

        return null;
    }

    public void adicionaHospital(HospitalPublico hospital) {
        hospitaisPublicos.add(hospital);
    }

    public void adicionaHospital(HospitalPrivado hospital) {
        hospitaisPrivados.add(hospital);
    }

    // Remover hospitais
    public void removeHospital(HospitalPublico hospital){hospitaisPublicos.remove(hospital);}

    public void removeHospital(HospitalPrivado hospital){hospitaisPrivados.remove(hospital);}

    // Método toString
    @Override
    public String toString() {
        String out = "";
        out += "Cidade " + nome;
        out += "\n  * Número de Cidadaos cadastrados: " + Integer.toString(cidadaos.size());
        out += "\n  * Número de hospitais privados: " + hospitaisPrivados.size();
        out += "\n  * Número de hospitais públicos: " + hospitaisPublicos.size();
        out += "\n  * Número de cidadaos com COVID no Norte: " + getnCidadaosComCovidNorte();
        out += "\n  * Número de cidadaos com COVID no Sul: " + getnCidadaosComCovidSul();
        out += "\n  * Número de cidadaos com COVID no Leste: " + getnCidadaosComCovidLeste();
        out += "\n  * Número de cidadaos com COVID no Oeste: " + getnCidadaosComCovidOeste();
        out += "\n  * Número de cidadaos com COVID no Centro: " + getnCidadaosComCovidCentro();

        out += "\n\n Cidadãos da cidade:\n";
        for (Cidadao cidadao : cidadaos) {
            if (cidadao != null) out += "  * " + cidadao.getNome() + "\n";
        }

        out += "\n Hospitais públicos da cidade:\n";
        for (HospitalPublico hospital : hospitaisPublicos)
            out += "  * " + hospital.getNome() + "\n";
        out += "\n Hospitais privados da cidade:\n";
        for (HospitalPrivado hospital : hospitaisPrivados)
            out += "  * " + hospital.getNome() + "\n";

        return out;
    }

    // Getters
    public int getnCidadaosComCovidNorte() {
        return nCidadaosComCovidNorte;
    }
    public int getnCidadaosComCovidLeste() {
        return nCidadaosComCovidLeste;
    }
    public int getnCidadaosComCovidOeste() {
        return nCidadaosComCovidOeste;
    }
    public int getnCidadaosComCovidSul() {
        return nCidadaosComCovidSul;
    }
    public int getnCidadaosComCovidCentro() {
        return nCidadaosComCovidCentro;
    }

    public Cidadao getCidadao(int index) {
        return cidadaos.get(index);
    }

    public int getNumeroCidadaos() {
        return numeroCidadaos;
    }

    public int getNCidades() {
        return nCidades;
    }

    public ArrayList<Cidadao> getCidadaos() { return cidadaos; }

    public ArrayList<HospitalPublico> getHospitaisPublicos() {
        return hospitaisPublicos;
    }

    public ArrayList<HospitalPrivado> getHospitaisPrivados() {
        return hospitaisPrivados;
    }

    public String getNome()
    {
        return nome;
    }
}
