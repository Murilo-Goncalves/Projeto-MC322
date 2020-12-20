package Projeto1;

public enum QuadroDeSaude {
	SAUDAVEL,
	SUSPEITA,
	DOENTE;
	
	@Override
	public String toString() {
		return this.name();
	}
}
