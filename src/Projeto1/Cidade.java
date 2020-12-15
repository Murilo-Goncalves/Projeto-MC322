package Projeto1;

import java.util.ArrayList;

public class Cidade {
    private String nome;
    private ArrayList<Cidadao> cidadaos;
    private ArrayList<HospitalPublico> hospitaisPublicos;
    private ArrayList<HospitalPrivado> hospitaisPrivados;
    private int nCidadaosComCovid = 0;
    
    public Cidade(String nome)
    {
        this.nome = nome;
        cidadaos = new ArrayList<Cidadao>();
        hospitaisPublicos = new ArrayList<HospitalPublico>();
        hospitaisPrivados = new ArrayList<HospitalPrivado>();
    }
    
    private void aumentaNCidadaosComCovid(boolean isCovidado) {
    	if(isCovidado) nCidadaosComCovid += 1;
    	
    }

    public boolean isSuspeita(Cidadao cidadao) {
        if (cidadao.getSintomas().isEmpty()) {
            System.out.println("Cidadão não possui suspeita de COVID.");
            return false;
        }

        else {
            System.out.println("Cidadão está com suspeita de COVID");
            return true;
        }
    }

	public Hospital procurarHospital(Cidadao cidadao) {
        if (!isSuspeita(cidadao)) {
            System.out.println("Nao é necessário procurar um hospital.");
            return null;
        }

		else {
            if (cidadao.hasConvenio()) {
                for (HospitalPrivado hospital : hospitaisPrivados)
                {
                    if (hospital.getRegiao().equals(cidadao.getRegiao()) && !hospital.isLotado() && hospital.getConvenioAtendido().equals(cidadao.getConvenio())) {
                    	this.aumentaNCidadaosComCovid(hospital.testeCovid(cidadao));
                        System.out.println("Encontrado o hospital privado: " + hospital.getNome());
                        return hospital;
                    }
                }
            }   

            for (HospitalPublico hospital : hospitaisPublicos)
            {
                if (hospital.getRegiao().equals(cidadao.getRegiao()) && !hospital.isLotado()) {
                    this.aumentaNCidadaosComCovid(hospital.testeCovid(cidadao));
                    System.out.println("Encontrado o hospital público: " + hospital.getNome());
                    return hospital;
                }
            }

            System.out.println("Não existem hospitais com leitos disponíveis na região.");
            return null;
        }
	}
	
	public void adicionaHospital(HospitalPublico hospital) {
		hospitaisPublicos.add(hospital);
	}
	
	public void adicionaHospital(HospitalPrivado hospital) {
		hospitaisPrivados.add(hospital);
	}
	
	public int getNCidadaosComCovid() {
		return nCidadaosComCovid;
	}
	
	@Override
    public String toString() {
        String out = "";
        out += "Cidade " + nome;
        out += "\n  * Número de cidadaos: " + Integer.toString(cidadaos.size());
        out += "\n  * Número de hospitais privados: " + hospitaisPrivados.size();
        out += "\n  * Número de hospitais públicos: " + hospitaisPublicos.size();
        out += "\n  * Número de cidadaos com COVID: " + getNCidadaosComCovid();
        out += "\n Hospitais públicos da cidade:\n";
        for (HospitalPublico hospital : hospitaisPublicos) out += "  * " + hospital.getNome() + "\n";
        out += " Hospitais privados da cidade:\n";
        for (HospitalPrivado hospital : hospitaisPrivados) out += "  * " + hospital.getNome() + "\n";
        
        return out;
    }
}
