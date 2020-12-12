package Projeto1;
import java.util.ArrayList;

public enum Sintomas {
	// Informações retiradas do site: https://coronavirus.saude.gov.br/sobre-a-doenca
	FEBRE("comum", "leve"),
	TOSSE_SECA("comum", "leve"),
	CANSACO("comum", "leve"),
	DOR_DE_GARGANTA("incomum", "leve"),
	DIARREIA("incomum", "leve"),
	CONJUNTIVITE("incomum", "leve"),
	DOR_DE_CABECA("incomum", "leve"),
	PERDA_PALADAR_OU_OLFATO("incomum", "leve"),
	ERUPCAO_CUTANEA("incomum", "leve"),
	FALTA_DE_AR("incomum", "grave"),
	DOR_OU_PRESSAO_NO_PEITO("incomum", "grave"),
	PERDA_DE_FALA_OU_MOVIMENTO("incomum", "grave");
	
	private final String freq;
	private final String gravidade;
	
	Sintomas(String freq, String gravidade) {
		this.freq = freq;
		this.gravidade = gravidade;
	}

	public String getGravidade() { return gravidade; }
	
	public String getFrequencia() {
		return freq;
	}

	// retorna nota de gravidade, de 0 a 10..
	public static int GravidadeCovid (ArrayList<Sintomas> sintomas) {
		double nota = 0;
		int nSintomas = sintomas.size();
		if (nSintomas == 0) return 0;	// se nao tiver sintomas.
		for (int i =0; i < nSintomas; i++) {
			if (sintomas.get(i).getGravidade().equals("leve")) nota += 0.7;
			else nota += 5;
		}
		nota = (10 > nota? nota : 10);
		return (int) nota;
	}

	// Retiraria esse método
	public static void isSuspeitaCovid(ArrayList<Sintomas> sintomas) {
		if(sintomas.isEmpty())
		{System.out.println("Cidadao nao possui COVID");}
		else {System.out.println("Cidadao está com suspeita de COVID");}
	}

}
