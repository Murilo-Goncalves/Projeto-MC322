package project_one;

public enum Hospitais {

	
    Hospital1 ("Santana", 5, Regiao.Leste),
	Hospital2 ("Mario Gatti", 10, Regiao.Centro),
	Hospital3 ("Centro Médico de Campinas", 15, Regiao.Norte),
	Hospital4 ("HC da UNICAMP", 30, Regiao.Norte),
	Hospital5 ("Irmãos Penteado, Santa Casa", 15, Regiao.Centro),
	Hospital6 ("Hospital do Coração de Campinas", 10, Regiao.Centro),
	Hospital7 ("Vera Cruz", 4, Regiao.Sudoeste),
	Hospital8 ("Sociedade Evangéliga Beneficiente de Capinas", 5, Regiao.Sul),
	Hospital9 ("Samaritano", 8, Regiao.Sul),
	Hospital10 ("PUC-Campinas", 10, Regiao.Sudoeste),
	Hospital11 ("Maternidade de Campinas", 5, Regiao.Centro),
	Hospital12 ("HUC - Hospital Unimed Campinas", 15, Regiao.Sul),
	Hospital13 ("Santa Sofia", 7, Regiao.Centro),
	Hospital14 ("Renascença", 10, Regiao.Norte);
	
	
	/*
Hospital Vera Cruz (Sudoeste)
Hospital Sociedade Evangélica Beneficente de Campinas (Sul)
Hospital Samaritano Campinas (Sul)
Hospital da PUC-Campinas (Sudoeste)
Maternidade de Campinas (Centro)
HUC - Hospital Unimed Campinas (Sul)
Hospital Santa Sofia (Centro)
Hospital Renascença Campinas (Norte)

	 */

    private String nome;
    static private int numeroLeitosCOVID = 5;
    private Regiao regiao;

    Hospitais(String nomeHospital, int numLeitos, Regiao regiao) {
        this.nome = nomeHospital;
        this.regiao = regiao;
    }

    public void aumentaNumeroLeitos(int leitos) {
        numeroLeitosCOVID += leitos;
    }
    
    public void diminuiNumeroLeitos(int leitos) {
    	numeroLeitosCOVID -= leitos;
    }

    public String getNome() { return nome; }
    public int getNumeroLeitosCOVID() { return numeroLeitosCOVID; }
}
