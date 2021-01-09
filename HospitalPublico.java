public class HospitalPublico extends Hospital implements FuncoesHospital{
	private Convenio convenioAtendido;
    
    // Construtor
    public HospitalPublico(String nome, int capacidadeLeitos, Regiao regiao, Convenio convenio) {
    	super(nome, capacidadeLeitos, regiao);
        this.convenioAtendido = convenio;
    }

    public void Vacinar() {
        for(int i=0; i < getPacientes().size(); i++) {
            if (getPacientes().get(i).isGrupoDeRisco())
                getPacientes().remove(i);
        }
        for(int i= 0; i< getPacientes().size(); i++){
            if(getPacientes().get(i).getRegiao() == this.getRegiao())
                getPacientes().remove(i);
        }
        for(int i=0; i<getPacientes().size(); i++){
            getPacientes().remove(i);
        }
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
