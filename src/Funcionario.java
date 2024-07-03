import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario extends Pessoa {
	
	String funcao;
	BigDecimal salario;
	
	public Funcionario() {
		super("",null);
		this.funcao = "";
		this.salario = null;
	}
	
	public Funcionario(String nome, LocalDate datanasc, String funcao, BigDecimal salario){
		super(nome,datanasc);
		this.funcao = funcao;
		this.salario = salario;
	}

    
}
