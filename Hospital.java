import java.util.ArrayList;
import java.util.Scanner;

public abstract class Hospital implements FuncoesHospital{
    private String nome;
    private int capacidadeLeitos;
    private Regiao regiao;
    private ArrayList<Paciente> pacientes;

    // Constants
    public final static int RISCO_MEDIO = 3;
    public final static int RISCO_ALTO = 6;

    // Construtor
    public Hospital(String nome, int capacidadeLeitos, Regiao regiao) {
    	this.nome = nome;
        this.capacidadeLeitos = capacidadeLeitos;
        this.regiao = regiao;
        this.pacientes = new ArrayList<Paciente>();
    }

    // Questionário para o cidadão para decidir se será internado, 
    // além de retornar se este possui COVID ou não
    public boolean ficharPaciente(Cidadao cidadao)
    {
        int numeroDeSintomas = cidadao.getSintomas().size();
        
        if (numeroDeSintomas >= RISCO_MEDIO || cidadao.getSintomas().stream().anyMatch(sintoma -> "grave".equals(sintoma.getGravidade()))) {
        	Scanner var = new Scanner(System.in);
            
            System.out.println("Nos diga sua massa corporal (kg):");
            double massaCorporal = var.nextDouble();
            
            System.out.println("Você possui doenças crônicas? (responda com 'sim' se possuir)");
        	var.nextLine();
            String hasDoencasCronicas = var.nextLine();
            
            System.out.println("É fumante? (responda com 'sim' se for)");
        	String isFumante = var.nextLine();
            
            System.out.println("Rebeceu teste para covid e teve resultado positivo? (responda com 'sim' se foi)");
            String temCovid = var.nextLine();

        	Paciente paciente = new Paciente(cidadao, massaCorporal, hasDoencasCronicas.equals("sim") , isFumante.equals("sim"), temCovid.equals("sim"));
        	pacientes.add(paciente);
        	
        	return temCovid.equals("sim");
        }
        
        else {
        	System.out.println("Fique em casa!");
        	return false;
        }
    }
    
    public boolean removerPaciente(Paciente paciente) {
    	return pacientes.remove(paciente);
    }

    public boolean isLotado() {
        if (pacientes.size() == capacidadeLeitos) return true;
        return false;
    }

    // Método toString
    @Override
    public String toString() {
    	String out = "Informações do hospital " + getNome() + "\n";
    	out += "  * Capacidade de leitos: " + getCapacidadeLeitos() + "\n";
    	out += "  * Região: " + getRegiao() + "\n";
    	out += "Nomes dos pacientes no hospital:\n";
    	for (Paciente paciente : pacientes) out += "  * " + paciente.getNome() + "\n";
    	
    	return out;
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCapacidadeLeitos() {
        return capacidadeLeitos;
    }

    public void setCapacidadeLeitos(int capacidadeLeitos) {
        this.capacidadeLeitos = capacidadeLeitos;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }
}
