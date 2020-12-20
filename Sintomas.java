package Projeto1;
import java.util.ArrayList;

public enum Sintomas {
	// Fonte: https://www.cecom.unicamp.br/covid-19-coronavirus-informacoes-e-esclarecimentos/#2
	CANSACO("comum", "leve"),
	FEBRE("comum", "leve"),
	TOSSE_SECA("comum", "leve"),
	DOR_DE_CABECA_OU_NO_CORPO("comum", "leve"),
	DOR_DE_GARGANTA("comum", "leve"),
	CONGESTAO_NASAL_OU_CORIZA ("comum", "leve"),
	PERDA_PALADAR_OU_OLFATO("comum", "leve"),
	DIARREIA("incomum", "leve"),
	CONJUNTIVITE("incomum","leve"),
	ERUPCOES_CUTANEAS("incomum","leve"),
	PERDA_DA_FALA("incomum","grave"),
	FALTA_DE_AR("incomum", "grave"),
	DOR_NO_PEITO("incomum", "grave");
	
	private final String freq;
	private final String gravidade;
	
	Sintomas(String freq, String gravidade) {
		this.freq = freq;
		this.gravidade = gravidade;
	}

	public String getGravidade() { return gravidade; }
	
	public String getFrequencia() { return freq; }

	// Retorna nota de gravidade, de 0 a 10
	public static int gravidadeCovid (ArrayList<Sintomas> sintomas) {
		double nota = 0.0;
		int nSintomas = sintomas.size();
		if (nSintomas == 0) return 0;	// se nao tiver sintomas
		for (int i = 0; i < nSintomas; i++) {
			if (sintomas.get(i).getGravidade().equals("leve")) nota += 0.7;
			else nota += 5;
		}
		nota = (10 > nota ? nota : 10);
		return (int) nota;
	}
}
