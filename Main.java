package Projeto1;
//teste
import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
    	//Criando Cidade
    	Cidade campinas = new Cidade("Campinas");    
    	
    	//Criando Cidadaos de Campinas
    	ArrayList<Sintomas> sintomasAirton = new ArrayList<Sintomas>();
    	sintomasAirton.add(Sintomas.CANSACO);
    	sintomasAirton.add(Sintomas.DOR_DE_CABECA_OU_NO_CORPO);
    	sintomasAirton.add(Sintomas.FALTA_DE_AR);
		ArrayList<Sintomas> sintomasIan = new ArrayList<Sintomas>();
		sintomasIan.add(Sintomas.CONJUNTIVITE);
		ArrayList<Sintomas> sintomasMurilo = new ArrayList<Sintomas>();
		sintomasMurilo.add(Sintomas.FALTA_DE_AR);
		ArrayList<Sintomas> sintomasCaio = new ArrayList<Sintomas>();
		sintomasCaio.add(Sintomas.FEBRE);
		sintomasCaio.add(Sintomas.ERUPCOES_CUTANEAS);
		sintomasCaio.add(Sintomas.DOR_NO_PEITO);

    	Cidadao airton = new Cidadao("Airton","123.456.678-42","airtoncl","1234",
    								20,"(19)999397-960","airtoncl@hotmail.com","masculino",
    								sintomasAirton, Regiao.NORTE, Convenio.UNIMED);
		Cidadao ian = new Cidadao("Ian","314.159.265-35","ianla","maga2020",
				63,"(19)3333-2222","ian@unicamp.br","feminino",
				sintomasIan, Regiao.SUL, Convenio.BRADESCO);
		Cidadao murilo = new Cidadao("Murilo","010.101.010-10","mumu","senha",
				10,"(19)2222-3333","murilo@google.com","nao-binário",
				sintomasMurilo, Regiao.NORTE, Convenio.SEM_CONVENIO);
		Cidadao caio = new Cidadao("Caio","000.000.000-00","jordan","23",
				59,"(19)99999-8888","ian@unicamp.br","masculino",
				sintomasCaio, Regiao.LESTE, Convenio.SEM_CONVENIO);
		campinas.adicionaCidadao(airton);
		campinas.adicionaCidadao(ian);
		campinas.adicionaCidadao(murilo);
		campinas.adicionaCidadao(caio);
    	// Criando hospitais em Campinas
    	HospitalPublico hospitalPublic = new HospitalPublico("HC da UNICAMP", 30, Regiao.NORTE, Convenio.SEM_CONVENIO);
    	HospitalPrivado hospitalPriv = new HospitalPrivado("HUC - Hospital Unimed Campinas", 15, Regiao.SUL, Convenio.UNIMED);
    	HospitalPublico hospitalPublic2 = new HospitalPublico("Maternidade de Campinas", 5, Regiao.CENTRO, Convenio.SEM_CONVENIO);
    	
    	campinas.adicionaHospital(hospitalPublic);
    	campinas.adicionaHospital(hospitalPublic2);
    	campinas.adicionaHospital(hospitalPriv);
    	/*
    	if (campinas.isSuspeita(airton)) {
			Hospital hospitalIndicado = campinas.procurarHospital(airton);

			if (hospitalIndicado instanceof HospitalPrivado) {
				Hospital hospitalPrivado = hospitalIndicado;
				System.out.println(hospitalPrivado.getPacientes().get(0).toString());
				System.out.println("\nO hospital (privado) indicado para o paciente é:");
				System.out.println(hospitalIndicado.toString());
			}

			if (hospitalIndicado instanceof HospitalPublico) {
				Hospital hospitalPublico = hospitalIndicado;
				System.out.println(hospitalPublico.getPacientes().get(0).toString());
				System.out.println("\nO hospital (público) indicado para o paciente é:");
				System.out.println(hospitalIndicado.toString());
			}
		}
    	 */
		for (int i = 0; i < campinas.getNumeroCidadaos(); i++) {
			Cidadao cidadao = campinas.getCidadao(i);
			if (campinas.isSuspeita(cidadao)) campinas.printHospitalIndicado(campinas.procurarHospital(cidadao));
			else System.out.printf("%s %s %s\n", "Cidadão ", cidadao.getNome()," não possui suspeita de COVID.");
		}
    	System.out.println(campinas.toString());
    }
}

/*
Cidadão Airton  está com suspeita de COVID
O hospital  HC da UNICAMP  possui leitos de COVID disponíveis.
Nos diga sua massa corporal (kg):
45
Você possui doenças crônicas? (responda com 'sim' se possuir)
n
É fumante? (responda com 'sim' se for)
n
Rebeceu teste para covid e teve resultado positivo? (responda com 'sim' se foi)
n
Informacoes do Cidadao Airton
  * cpf: 123.456.678-42
  * idade: 20
  * login: airtoncl
  * telefone: (19)999397-960
  * email: airtoncl@hotmail.com
  * sexo: masculino
  * Regiao em que mora: NORTE
  * Possui convênio privado? Sim.
Informacoes do Paciente Airton
  * Massa corporal (kg): 45,00
  * Possui doencas crônicas? Nao.
  * É fumante? Nao.
  * Faz parte de grupo de risco? Nao.
  * Recebeu teste positivo para COVID-19? Nao.
  * Riscos à saúde: potencialmente grave
  * Tempo de tratamento necessário: cerca de 30 dias, se confirmado que está com covid

O hospital indicado para o paciente é:
Informações do hospital HC da UNICAMP
  * Capacidade de leitos: 30
  * Região: NORTE
Nomes dos pacientes no hospital:
  * Airton
Este hospital é público.

Cidadão Ian  está com suspeita de COVID
O hospital  HUC - Hospital Unimed Campinas  possui leitos de COVID disponíveis.
Não existem hospitais com leitos disponíveis na região.
Nao há hospitais para indicar.
Cidadão Murilo  está com suspeita de COVID
O hospital  HC da UNICAMP  possui leitos de COVID disponíveis.
Nos diga sua massa corporal (kg):
Exception in thread "main" java.util.NoSuchElementException
	at java.base/java.util.Scanner.throwFor(Scanner.java:937)
	at java.base/java.util.Scanner.next(Scanner.java:1594)
	at java.base/java.util.Scanner.nextDouble(Scanner.java:2564)
	at Projeto1.Hospital.testeCovid(Hospital.java:26)
	at Projeto1.Cidade.procurarHospital(Cidade.java:66)
	at Projeto1.Main.main(Main.java:69)
 */
