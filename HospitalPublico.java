package Projeto1;

public class HospitalPublico extends Hospital {
	private Convenio convenioAtendido;
    
    // Construtor
    public HospitalPublico(String nome, int capacidadeLeitos, Regiao regiao, Convenio convenio) {
    	super(nome, capacidadeLeitos, regiao);
        this.convenioAtendido = convenio;
    }
    
    // Método toString
    @Override
    public String toString() {
        String out = super.toString();
        out += "Este hospital é público.\n";
        
        return out;
    }

    // Getter
    public Convenio getConvenioAtendido() {
    	return convenioAtendido;
    }
}
