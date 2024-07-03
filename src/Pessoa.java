import java.time.LocalDate;

public class Pessoa {
	public String nome;
	public LocalDate datanasc;
	
	public Pessoa(){
		this.nome = "";
		this.datanasc = null;
	}
	
	public Pessoa(String nome, LocalDate datanasc){
		this.nome = nome;
		this.datanasc = datanasc;
	}
}
