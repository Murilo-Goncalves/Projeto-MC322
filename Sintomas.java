import java.util.ArrayList;

public enum Sintomas {
	// Informações retiradas do site: https://coronavirus.saude.gov.br/sobre-a-doenca
	
		FEBRE("comum", "leve"),
		TOSSE_SECA("comum", "leve"),
		CANSACO("comum", "leve"),
		DOR_DE_GARGANTA("menos comum", "leve"),
		DIARREIA("menos comum", "leve"),
		CONJUNTIVITE("menos comum", "leve"),
		DOR_DE_CABECA("menos comum", "leve"),
		PERDA_PALADAR_OU_OLFATO("menos comum", "leve"),
		ERUPCAO_CUTANEA("menos comum", "leve"),
		FALTA_DE_AR("menos comum", "grave"),
		DOR_OU_PRESSAO_NO_PEITO("menos comum", "grave"),
		PERDA_DE_FALA_OU_MOVIMENTO("menos comum", "grave");
		
		private final String freq;
		private final String gravidade;
		
		Sintomas(String freq, String gravidade){
			this.freq = freq;
			this.gravidade = gravidade;
		}
		
		public String gravidade_sintoma() {
			return gravidade;
		}
		
		public String Frequencia_sintoma() {
			return freq;
		}
		
		public void isCovid(ArrayList<Sintomas> sintomas) {
			if(sintomas.isEmpty()) {System.out.println("Cidad�o n�o possui COVID");}
			
			else {System.out.println("Cidad�o est� com suspeita de COVID");}
		}

}
