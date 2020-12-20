package Projeto1;

import java.util.ArrayList;

public class Cidade {
    private String nome;
    private ArrayList<Cidadao> cidadaos;
    private ArrayList<HospitalPublico> hospitaisPublicos;
    private ArrayList<HospitalPrivado> hospitaisPrivados;
    private int numeroCidadaos = 0;
    private int nCidadaosComCovid = 0;
    
    public Cidade(String nome)
    {
        this.nome = nome;
        cidadaos = new ArrayList<Cidadao>();
        hospitaisPublicos = new ArrayList<HospitalPublico>();
        hospitaisPrivados = new ArrayList<HospitalPrivado>();
    }
    public Cidadao getCidadao(int index) { return cidadaos.get(index); }
    public int getNumeroCidadaos() { return numeroCidadaos; }
    public void adicionaCidadao(Cidadao novoCidadao) {
        cidadaos.add(novoCidadao);
        numeroCidadaos += 1;
    }

    private void aumentaNCidadaosComCovid(boolean temCovid) {
    	if(temCovid) nCidadaosComCovid += 1;
    	
    }

    public boolean isSuspeita(Cidadao cidadao) {
        if (cidadao.getSintomas().isEmpty()) {
            // System.out.printf("%s %s %s\n", "Cidadão ", cidadao.getNome()," não possui suspeita de COVID.");
            return false;
        }

        else {
            // System.out.printf("%s %s %s\n","Cidadão", cidadao.getNome(), " está com suspeita de COVID");
            return true;
        }
    }

	public Hospital procurarHospital(Cidadao cidadao) {
        if (!isSuspeita(cidadao)) {
            System.out.println("Nao é necessário procurar um hospital.");
            return null;
        }

		else {
            System.out.printf("%s %s %s\n","Cidadão", cidadao.getNome(), " está com suspeita de COVID");
            if (cidadao.hasConvenio()) {
                for (HospitalPrivado hospital : hospitaisPrivados)
                {
                    if (hospital.getRegiao().equals(cidadao.getRegiao()) && !hospital.isLotado() && hospital.getConvenioAtendido().equals(cidadao.getConvenio())) {
                    	this.aumentaNCidadaosComCovid(hospital.testeCovid(cidadao));
                        // System.out.println("Encontrado o hospital privado: " + hospital.getNome());
                        return hospital;
                    }
                }
            }   

            for (HospitalPublico hospital : hospitaisPublicos)
            {
                if (hospital.getRegiao().equals(cidadao.getRegiao()) && !hospital.isLotado()) {
                    this.aumentaNCidadaosComCovid(hospital.testeCovid(cidadao));
                    // System.out.println("Encontrado o hospital público: " + hospital.getNome());
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

    public void printHospitalIndicado(Hospital hospitalIndicado) {
        if (hospitalIndicado == null) {
            System.out.println("Nao há hospitais para indicar.");
            return;
        }

        if (hospitalIndicado instanceof HospitalPrivado) {
            Hospital hospitalPrivado = hospitalIndicado;
            System.out.println(hospitalPrivado.getPacientes().get(0).toString());
            System.out.println("\nO hospital indicado para o paciente é:");
            System.out.println(hospitalIndicado.toString());
        }

        else if (hospitalIndicado instanceof HospitalPublico) {
            Hospital hospitalPublico = hospitalIndicado;
            System.out.println(hospitalPublico.getPacientes().get(0).toString());
            System.out.println("\nO hospital indicado para o paciente é:");
            System.out.println(hospitalIndicado.toString());
        }
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
