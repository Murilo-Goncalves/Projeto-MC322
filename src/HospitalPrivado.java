public class HospitalPrivado extends Hospital implements FuncoesHospital {
	private Convenio convenioAtendido;
    
    // Construtor
    public HospitalPrivado(String nome, int capacidadeLeitos, Regiao regiao, Convenio convenio) {
    	super(nome, capacidadeLeitos, regiao);
        this.convenioAtendido = convenio;
    }

    public void Vacinar(){System.out.printf("Espere na fila do Hospital Público \n");}

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
