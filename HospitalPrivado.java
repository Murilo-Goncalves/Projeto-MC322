package Projeto1;
public class HospitalPrivado extends Hospital {
	
	private Convenio ConveniosAtendidos;
	
	
    HospitalPrivado(String nome, int capacidadeLeitos, Regiao regiao, Convenio convenios) {
    	super(nome, capacidadeLeitos, regiao);
    	this.ConveniosAtendidos = convenios;
    }
    
    public Convenio getConveniosAtendidos() {
    	return ConveniosAtendidos;
    }
    
}
