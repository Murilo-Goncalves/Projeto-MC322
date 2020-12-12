package Projeto1;
// falta complementar toString (precisa dos métodos dos hospitais prontos).
import java.util.ArrayList;

public class Cidade {
    private String nome;
    private ArrayList<Cidadao> cidadaos;
    private ArrayList<HospitalPublico> hospitaisPublicos;
    private ArrayList<HospitalPrivado> hospitaisPrivados;
    private static int nCidadaosComCovid = 0;

    public Cidade(String nome)
    {
        this.nome = nome;
        cidadaos = new ArrayList<Cidadao>();
        hospitaisPublicos = new ArrayList<HospitalPublico>();
        hospitaisPrivados = new ArrayList<HospitalPrivado>();
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

	public boolean procurarHospital (Cidadao cidadao) {
        if (!isSuspeita(cidadao)) {
            System.out.println("Nao é necessário procurar um hospital.");
            return false;
        }

		else {
            if (cidadao.hasConvenio()) {
                for (Hospital hospital : hospitaisPrivados)
                {
                    if (hospital.getRegiao() == cidadao.getRegiao() && !hospital.isLotado()) {
                        hospital.testeCovid(cidadao);
                        System.out.println("Encontrado um hospital privado para você.");
                        return true;
                    }
                }
            }   

            for (Hospital hospital : hospitaisPublicos)
            {
                if (hospital.getRegiao() == cidadao.getRegiao() && !hospital.isLotado()) {
                    hospital.testeCovid(cidadao);
                    System.out.println("Encontrado um hospital público para você.");
                    return true;
                }
            }

            System.out.println("Não existem hospitais com leitos disponíveis na região.");
            return true;
        }
	}

	@Override
    public String toString() {
        String out = "";
        out += "Cidade " + nome;
        out += "\n  * Número de cidadaos: " + Integer.toString(cidadaos.size());
        out += "\n  * Número de hospitais privados: " + Integer.toString(hospitaisPrivados.size());
        out += "\n  * Número de hospitais públicos: " + Integer.toString(hospitaisPublicos.size());
        out += "\n  * Número de cidadaos com COVID: ";
        out += "\n  * Número de leitos disponíveis: ";
        return out;
    }
}
