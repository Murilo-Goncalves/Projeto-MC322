package Projeto1;

import java.util.ArrayList;


public class Main {
    public static void main (String[] Args) {
    	//Criando Cidade
    	Cidade campinas = new Cidade("Campinas");    
    	
    	//Criando Cidadaos de Campinas
    	ArrayList<Sintomas> sintomasAirton = new ArrayList<Sintomas>();
    	sintomasAirton.add(Sintomas.CANSACO);
    	sintomasAirton.add(Sintomas.DOR_DE_CABECA);
    	sintomasAirton.add(Sintomas.PERDA_DE_FALA_OU_MOVIMENTO);
    	Cidadao airton = new Cidadao("Airton","123.456.678-42","airtoncl","1234",
    								20,"19999397960","airtoncl@hotmail.com","masculino",
    								sintomasAirton, true, Regiao.NORTE, Convenio.UNIMED);
    	
    	//Criando o diretor de hospital
    	
    	
    	// Criando hospitais em Campinas
    	Hospital hospitalPublic = new HospitalPublico("HC da UNICAMP", 30, Regiao.NORTE,
    													Convenio.SEM_CONVENIO);
    	Hospital hospitalPriv = new HospitalPrivado("HUC - Hospital Unimed Campinas", 15, Regiao.SUL,
    												Convenio.UNIMED);
    	Hospital hospitalPublic2 = new HospitalPublico("Maternidade de Campinas", 5, Regiao.CENTRO,
    												Convenio.BRADESCO);
    	
    	campinas.adicionaHospital(hospitalPublic, false);
    	campinas.adicionaHospital(hospitalPublic2, false);
    	campinas.adicionaHospital(hospitalPriv, true);
    	
    	if (campinas.isSuspeita(airton)) {
    		Hospital hospitalIndicado = campinas.procurarHospital(airton);

    		if (hospitalIndicado != null) {
    			System.out.println(campinas.getnCidadaosComCovid());
    			if (hospitalIndicado instanceof HospitalPublico) {
    				Hospital HospitalPublico = hospitalIndicado;
    				System.out.println(HospitalPublico.getPacientes().get(0).getSeveridade());
    				System.out.println(HospitalPublico.getPacientes().get(0).getTempoDeTratamento());
    			} else {
    				Hospital HospitalPrivado = hospitalIndicado;
    				System.out.println(HospitalPrivado.getPacientes().get(0).getSeveridade());
    				System.out.println(HospitalPrivado.getPacientes().get(0).getTempoDeTratamento());
    				
    			}
    		}
    	}
    	
    }
}






/* 	
Hospital hospital1 = new Hospital("Santana", 5, Regiao.LESTE);
Hospital hospital2 = new Hospital("Mario Gatti", 10, Regiao.CENTRO);
Hospital hospital3 = new Hospital("CENTRO Médico de Campinas", 15, Regiao.NORTE);

Hospital hospital5 = new Hospital("Irmãos Penteado, Santa Casa", 15, Regiao.CENTRO);
Hospital hospital6 = new Hospital("Hospital do Coração de Campinas", 10, Regiao.CENTRO);
Hospital hospital7 = new Hospital("Vera Cruz", 4, Regiao.OESTE);
Hospital hospital8 = new Hospital("Sociedade Evangélica Beneficiente de Capinas", 5, Regiao.SUL);
Hospital hospital9 = new Hospital("Samaritano", 8, Regiao.SUL);
Hospital hospital10 = new Hospital("PUC-Campinas", 10, Regiao.OESTE);


Hospital hospital13 = new Hospital("Santa Sofia", 7, Regiao.CENTRO);
Hospital hospital14 = new Hospital("Renascença", 10, Regiao.NORTE);*/