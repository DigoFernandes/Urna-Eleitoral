package domain;	

public class Presidente{
	
	@Override
	public String toString() {
		return "Presidente " + nome + " possui " + votos + " votos";
	}
	String nome;
	int votos=0;
}
