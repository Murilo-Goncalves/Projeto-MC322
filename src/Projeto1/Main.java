package Projeto1;

import java.util.ArrayList;

import Projeto1.Hospital;

public class Main {
    public static void main (String[] args) {
    	//Criando Cidade
    	Cidade campinas = new Cidade("Campinas");    
    	
    	//Criando Cidadaos de Campinas
    	ArrayList<Sintomas> sintomasAirton = new ArrayList<Sintomas>();
    	sintomasAirton.add(Sintomas.CANSACO);
    	sintomasAirton.add(Sintomas.DOR_DE_CABECA);
    	sintomasAirton.add(Sintomas.PERDA_DE_FALA_OU_MOVIMENTO);
    	Cidadao airton = new Cidadao("Airton","123.456.678-42","airtoncl","1234",
    								20,"19999397960","airtoncl@hotmail.com","masculino",
    								sintomasAirton, Regiao.NORTE, Convenio.UNIMED);
    	
    	// Criando hospitais em Campinas
    	HospitalPublico hospitalPublic = new HospitalPublico("HC da UNICAMP", 30, Regiao.NORTE, Convenio.SEM_CONVENIO);
    	HospitalPrivado hospitalPriv = new HospitalPrivado("HUC - Hospital Unimed Campinas", 15, Regiao.SUL, Convenio.UNIMED);
    	HospitalPublico hospitalPublic2 = new HospitalPublico("Maternidade de Campinas", 5, Regiao.CENTRO, Convenio.SEM_CONVENIO);
    	
    	campinas.adicionaHospital(hospitalPublic);
    	campinas.adicionaHospital(hospitalPublic2);
    	campinas.adicionaHospital(hospitalPriv);
    	
    	if (campinas.isSuspeita(airton)) {
    		Hospital hospitalIndicado = campinas.procurarHospital(airton);

    		if (hospitalIndicado instanceof HospitalPublico) {
    				Hospital HospitalPublico = hospitalIndicado;
    				System.out.println(HospitalPublico.getPacientes().get(0).toString());
    				System.out.println("\nO hospital indicado para o paciente é o seguinte:");
    				System.out.println(hospitalIndicado.toString());
    		} 
    		
    		if (hospitalIndicado instanceof HospitalPrivado) {
    				Hospital HospitalPrivado = hospitalIndicado;
    				System.out.println(HospitalPrivado.getPacientes().get(0).toString());
    				System.out.println("\nO hospital indicado para o paciente é o seguinte:");
    				System.out.println(hospitalIndicado.toString());
			}
    	}
    	
    	System.out.println(campinas.toString());
    }
}
