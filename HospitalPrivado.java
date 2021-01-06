public class HospitalPrivado extends Hospital {
	private Convenio convenioAtendido;
    
    // Construtor
    public HospitalPrivado(String nome, int capacidadeLeitos, Regiao regiao, Convenio convenio) {
    	super(nome, capacidadeLeitos, regiao);
        this.convenioAtendido = convenio;
    }

    // Método toString
    @Override
    public String toString() {
        String out = super.toString();
    	out += "Este hospital é privado.\n";
    	
    	return out;
    }
    
    // Getter
    public Convenio getConvenioAtendido() {
        return convenioAtendido;
    }
}
