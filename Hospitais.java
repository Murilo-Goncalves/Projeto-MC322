public enum Hospitais {
    HOSPITAL1 ("Santana", 5, Regiao.Leste),
	HOSPITAL2 ("Mario Gatti", 10, Regiao.Centro),
	HOSPITAL3 ("Centro Médico de Campinas", 15, Regiao.Norte),
	HOSPITAL4 ("HC da UNICAMP", 30, Regiao.Norte),
	HOSPITAL5 ("Irm�os Penteado, Santa Casa", 15, Regiao.Centro),
	HOSPITAL6 ("Hospital do Coração de Campinas", 10, Regiao.Centro),
	HOSPITAL7 ("Vera Cruz", 4, Regiao.Sudoeste),
	HOSPITAL8 ("Sociedade Evangélica Beneficiente de Capinas", 5, Regiao.Sul),
	HOSPITAL9 ("Samaritano", 8, Regiao.Sul),
	HOSPITAL10 ("PUC-Campinas", 10, Regiao.Sudoeste),
	HOSPITAL11 ("Maternidade de Campinas", 5, Regiao.Centro),
	HOSPITAL12 ("HUC - Hospital Unimed Campinas", 15, Regiao.Sul),
	HOSPITAL13 ("Santa Sofia", 7, Regiao.Centro),
	HOSPITAL14 ("Renascença", 10, Regiao.Norte);
	
	
	/*
	Hospital Vera Cruz (Sudoeste)
	Hospital Sociedade Evang�lica Beneficente de Campinas (Sul)
	Hospital Samaritano Campinas (Sul)
	Hospital da PUC-Campinas (Sudoeste)
	Maternidade de Campinas (Centro)
	HUC - Hospital Unimed Campinas (Sul)
	Hospital Santa Sofia (Centro)
	Hospital Renascen�a Campinas (Norte)
	*/

    private String nome;
    private static int numeroLeitosCOVID = 5;
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
