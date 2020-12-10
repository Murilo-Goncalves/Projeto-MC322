import java.util.ArrayList;

public class Cidade {
    private String nome;
    private ArrayList<Cidadao> cidadaos;
    private ArrayList<HospitalPublico> hospitaisPublicos;
    private ArrayList<HospitalPrivado> hospitaisPrivados;
    private static int nCovidados = 0;

    public Cidade(String nome)
    {
        this.nome = nome;
        cidadaos = new ArrayList<Cidadao>();
        hospitaisPublicos = new ArrayList<HospitalPublico>();
        hospitaisPrivados = new ArrayList<HospitalPrivado>();
    }
    	
	public boolean isSuspeita(Cidadao cidadao) {
        if (cidadao.getSintomas().isEmpty()) {
            System.out.println("Cidadão não possui suspeita de COVID");
            return false;
        }
		
		else {
            System.out.println("Cidadão está com suspeita de COVID");
            if (cidadao.hasConvenio()) {
                for (Hospital hospital : hospitaisPrivados)
                {
                    if (hospital.getRegiao() == cidadao.getRegiao() && !hospital.isLotado()) {
                        hospital.testeCovid(cidadao);
                        return true;
                    }
                }
            }   

            for (Hospital hospital : hospitaisPublicos)
            {
                if (hospital.getRegiao() == cidadao.getRegiao() && !hospital.isLotado()) {
                    hospital.testeCovid(cidadao);
                    return true;
                }
            }

            System.out.println("Não existem hospitais com leitos disponíveis na região.");
            return true;
        }
	}
}
