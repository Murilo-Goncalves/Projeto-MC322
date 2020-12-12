package Projeto1;
public enum Regiao {
	NORTE,
	SUL,
	LESTE,
	OESTE,
	CENTRO;

	@Override
	public String toString() {
		return this.name();
	}
}
