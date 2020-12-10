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
	
	Sintomas(String freq, String gravidade){
		this.freq = freq;
		this.gravidade = gravidade;
	}
	
	public String getGravidade() {
		return gravidade;
	}
	
	public String getFrequencia() {
		return freq;
	}
	
	public void isCovid(ArrayList<Sintomas> sintomas) {
		if(sintomas.isEmpty()) {System.out.println("Cidad�o n�o possui COVID");}
		
		else {System.out.println("Cidad�o est� com suspeita de COVID");}
	}

}
