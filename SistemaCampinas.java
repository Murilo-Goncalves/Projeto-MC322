import java.util.ArrayList;
import java.util.Arrays;

public class SistemaCampinas {
	private static int nCidadaos = 0;
	private ArrayList<Cidadao> cidadaos;
	private ArrayList<Hospitais> hospitais;
	private final ArrayList<Sintomas> sintomasCovid = new ArrayList<Sintomas> (Arrays.asList(Sintomas.FEBRE,
																							 Sintomas.TOSSE_SECA,
																				             Sintomas.CANSACO ));
	
	public SistemaCampinas() {
		cidadaos = new ArrayList<Cidadao>();
		hospitais = new ArrayList<Hospitais>();
	}

	public boolean removerCidadao(Cidadao cidadao) {
		return cidadaos.remove(cidadao);
	}
	
	public boolean adicionarCidadao(Cidadao cidadao) {
		if (cidadao.isCampinas())
			return cidadaos.add(cidadao);
		
		else
			System.out.println("O cidadão não é campineiro e não pode ser adicionado ao Sistema.");
		
		return false;
	}
	
	@Override
	public String toString() {
		String out = "Informações sobre o Sistema Covid de Campinas:\n";


		return out;
	}
	
	public ArrayList<Cidadao> getCidadaos() {
		return cidadaos;
	}

	public ArrayList<Hospitais> getHospitais() {
		return hospitais;
	}

	public ArrayList<Sintomas> getSintomasCovid() {
		return sintomasCovid;
	}
	
}
