package Projeto1;

public class HospitalPublico extends Hospital {
	private Convenio ConvenioAtendido;
	
    public HospitalPublico(String nome, int capacidadeLeitos, Regiao regiao, Convenio convenio) {
    	super(nome, capacidadeLeitos, regiao);
        this.ConvenioAtendido = convenio;
    }
    
    public Convenio getConvenioAtendido() {
    	return ConvenioAtendido;
    }
    
    @Override
    public String toString() {
    	String out = super.toString();
    	out += "  * Este hospital é público\n";
    	
    	return out;
    }
}
