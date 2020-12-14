package Projeto1;
// falta complementar toString (precisa dos m�todos dos hospitais prontos).
import java.util.ArrayList;

public class Cidade {
    private String nome;
    private ArrayList<Cidadao> cidadaos;
    private ArrayList<Hospital> hospitaisPublicos;
    private ArrayList<Hospital> hospitaisPrivados;
    private int nCidadaosComCovid = 0;
    
    // CRIAR METODO ADD HOSPITAL

    public Cidade(String nome)
    {
        this.nome = nome;
        cidadaos = new ArrayList<Cidadao>();
        hospitaisPublicos = new ArrayList<Hospital>();
        hospitaisPrivados = new ArrayList<Hospital>();
    }
    
    private void aumentaNCidadaosComCovid(boolean isCovidado) {
    	if(isCovidado) nCidadaosComCovid += 1;
    	
    }

    public boolean isSuspeita(Cidadao cidadao) {
        if (cidadao.getSintomas().isEmpty()) {
            System.out.println("Cidad�o n�o possui suspeita de COVID.");
            return false;
        }

        else {
            System.out.println("Cidad�o est� com suspeita de COVID");
            return true;
        }
    }

	public Hospital procurarHospital (Cidadao cidadao) {
        if (!isSuspeita(cidadao)) {
            System.out.println("Nao � necess�rio procurar um hospital.");
            return null;
        }

		else {
            if (cidadao.hasConvenio()) {
                for (Hospital hospital : hospitaisPrivados)
                {
                    if (hospital.getRegiao().equals(cidadao.getRegiao()) && !hospital.isLotado()) {
                    	this.aumentaNCidadaosComCovid(hospital.testeCovid(cidadao));
                        System.out.println("Encontrado o hospital privado: " + hospital.getNome());
                        return hospital;
                    }
                }
            }   

            for (Hospital hospital : hospitaisPublicos)
            {
                if (hospital.getRegiao().equals(cidadao.getRegiao()) && !hospital.isLotado()) {
                    this.aumentaNCidadaosComCovid(hospital.testeCovid(cidadao));
                    System.out.println("Encontrado o hospital p�blico :" + hospital.getNome());
                    return hospital;
                }
            }

            System.out.println("N�o existem hospitais com leitos dispon�veis na regi�o.");
            return null;
        }
	}
	
	public void adicionaHospital(Hospital hospital, boolean isPrivado) {
		if (isPrivado) {
			hospitaisPrivados.add(hospital);
		} else {
			hospitaisPublicos.add(hospital);
		}
	}
	
	public int getnCidadaosComCovid() {
		return nCidadaosComCovid;
	}
	
	@Override
    public String toString() {
        String out = "";
        out += "Cidade " + nome;
        out += "\n  * N�mero de cidadaos: " + Integer.toString(cidadaos.size());
        out += "\n  * N�mero de hospitais privados: " + Integer.toString(hospitaisPrivados.size());
        out += "\n  * N�mero de hospitais p�blicos: " + Integer.toString(hospitaisPublicos.size());
        out += "\n  * N�mero de cidadaos com COVID: ";
        out += "\n  * N�mero de leitos dispon�veis: ";
        return out;
    }
}
