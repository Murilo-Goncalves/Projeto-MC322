package project_one;

import java.util.ArrayList;

public enum Sintomas {
	// Informações retiradas do site: https://coronavirus.saude.gov.br/sobre-a-doenca
	
		febre("comum", "leve"),
		tosse_seca("comum", "leve"),
		cansaço("comum", "leve"),
		dor_de_garganta("menos comum", "leve"),
		diarreia("menos comum", "leve"),
		conjutivite("menos comum", "leve"),
		dor_de_cabeca("menos comum", "leve"),
		perda_paladar_olfato("menos comum", "leve"),
		erupcao_cutanea("menos comum", "leve"),
		falta_de_ar("menos comum", "grave"),
		dor_ou_pressao_no_peito("menos comum", "grave"),
		perda_de_fala_ou_movimento("menos comum", "grave");
		
		
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
			if(sintomas.isEmpty()) {System.out.println("Cidadão não possui COVID");}
			
			else {System.out.println("Cidadão está com suspeita de COVID");}
		}

}
