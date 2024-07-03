import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SessaoAtual {

	Map<String,ArrayList<Funcionario>> funcionariosFuncao = new HashMap<String,ArrayList<Funcionario>>(); 
	ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
	
	SessaoAtual(){	
	}
	
	public void inserirFuncionario(Funcionario funcionario) {
		if(getFuncionario(funcionario.nome) == null) {
			funcionarios.add(funcionario);
		}
	}
	
	public void inserirFuncionariosPassados() {
		Funcionario f1 = new Funcionario();
		f1.nome = "Maria";
		f1.datanasc = LocalDate.of(2000, 10, 18);
		f1.funcao = "Operador";
		f1.salario = new BigDecimal("2009.44");
		
		Funcionario f2 = new Funcionario();
		f2.nome = "João";
		f2.datanasc = LocalDate.of(1990, 05, 12);
		f2.funcao = "Operador";
		f2.salario = new BigDecimal("2284.38");
		
		Funcionario f3 = new Funcionario();
		f3.nome = "Caio";
		f3.datanasc = LocalDate.of(1961, 05, 02);
		f3.funcao = "Coordenador";
		f3.salario = new BigDecimal("9836.14");
		
		Funcionario f4 = new Funcionario();
		f4.nome = "Miguel";
		f4.datanasc = LocalDate.of(1988, 10, 14);
		f4.funcao = "Diretor";
		f4.salario = new BigDecimal("19119.88");
		
		Funcionario f5 = new Funcionario();
        f5.nome = "Alice";
        f5.datanasc = LocalDate.of(1995, 01, 05);
        f5.funcao = "Recepcionista";
        f5.salario = new BigDecimal("2234.68");

        Funcionario f6 = new Funcionario();
        f6.nome = "Heitor";
        f6.datanasc = LocalDate.of(1999, 11, 19);
        f6.funcao = "Operador";
        f6.salario = new BigDecimal("1582.72");

        Funcionario f7 = new Funcionario();
        f7.nome = "Arthur";
        f7.datanasc = LocalDate.of(1993, 03, 31);
        f7.funcao = "Contador";
        f7.salario = new BigDecimal("4071.84");

        Funcionario f8 = new Funcionario();
        f8.nome = "Laura";
        f8.datanasc = LocalDate.of(1994, 7, 8);
        f8.funcao = "Gerente";
        f8.salario = new BigDecimal("3017.45");

        Funcionario f9 = new Funcionario();
        f9.nome = "Heloísa";
        f9.datanasc = LocalDate.of(2003, 5, 24);
        f9.funcao = "Eletricista";
        f9.salario = new BigDecimal("1606.85");

        Funcionario f10 = new Funcionario();
        f10.nome = "Helena";
        f10.datanasc = LocalDate.of(1996, 9, 2);
        f10.funcao = "Gerente";
        f10.salario = new BigDecimal("2799.93");
        
        this.inserirFuncionario(f1);
        this.inserirFuncionario(f2);
        this.inserirFuncionario(f3);
        this.inserirFuncionario(f4);
        this.inserirFuncionario(f5);
        this.inserirFuncionario(f6);
        this.inserirFuncionario(f7);
        this.inserirFuncionario(f8);
        this.inserirFuncionario(f9);
        this.inserirFuncionario(f10);
	}
	
	public void removerFuncionario(Funcionario funcionario) {
		funcionarios.remove(funcionario);
	}
	
	public int getFuncionarioIndex(String nome, ArrayList<Funcionario> funcionarios) {
		for(int i=0;i<funcionarios.size();i++) {
			Funcionario funcionario = funcionarios.get(i);
			if (funcionario.nome.equalsIgnoreCase(nome)) {
				return i;
			}
		}
		return -1;
	}
	
	Funcionario getFuncionario(String nome) {
		for(Funcionario funcionario: funcionarios) {
			if (funcionario.nome.equalsIgnoreCase(nome)) {
				return funcionario;
			}
		}
		return null;
	}
	
	String imprimirFuncionarios() {
		String relatorio = "Lista de Funcionários:\n";
		relatorio += "      Nome     |     Data de Nasc     |    Funcao     |     Salario     \n";
		
		for (Funcionario funcionario : funcionarios) {
			relatorio += funcionario.nome + "   |    " + funcionario.datanasc.getDayOfMonth() + "/" + funcionario.datanasc.getMonthValue() + "/" + funcionario.datanasc.getYear() + "   |   " + funcionario.funcao + "   |   " + NumberFormat.getCurrencyInstance().format(funcionario.salario) + "\n";
			
		}
		
		return relatorio;
		
	}
	
	String imprimirFuncionarios(int mes) {
		String relatorio = "Lista de Funcionários:\n";
		relatorio += "      Nome     |     Data de Nasc     |    Funcao     |     Salario     \n";
		
		for (Funcionario funcionario : funcionarios) {
			if (funcionario.datanasc.getMonthValue() == mes) {
				relatorio += funcionario.nome + "   |    " + funcionario.datanasc.getDayOfMonth() + "/" + funcionario.datanasc.getMonthValue() + "/" + funcionario.datanasc.getYear() + "   |   " + funcionario.funcao + "   |   " + NumberFormat.getCurrencyInstance().format(funcionario.salario) + "\n";
			}
			
		}
		
		return relatorio;
	}
	
	String imprimirFuncionarios(int mes, int mes2) {
		String relatorio = "Mês " + mes + ": \n";
		relatorio += this.imprimirFuncionarios(mes);
		relatorio += "\n";
		relatorio += "Mês " + mes2 + ": \n";
		relatorio += this.imprimirFuncionarios(mes2);
		
		return relatorio;
	}
	
	String imprimirSalarios() {
		BigDecimal salarios = new BigDecimal("0");
		for (Funcionario funcionario : funcionarios) {
			salarios = salarios.add(funcionario.salario);
		}
		
		return NumberFormat.getCurrencyInstance().format(salarios);
	}
	
	String imprimirSalariosMinimos() {
		String relatorio = "Salarios Minimos:\n";
		relatorio += "      Nome     |     Salarios Minimos     \n";
		BigDecimal salarioMin = new BigDecimal("1212.00"); 
		for (Funcionario funcionario : funcionarios) {
			relatorio += funcionario.nome + "   |    " + funcionario.salario.divideToIntegralValue(salarioMin) + "\n";
		}
		
		return relatorio;
	}
	
	public void ordenarFuncionariosPorNome() {
        Collections.sort(funcionarios, new Comparator<Funcionario>() {
            @Override
            public int compare(Funcionario f1, Funcionario f2) {
                return f1.nome.compareToIgnoreCase(f2.nome);
            }
        });
    }
	
	public void inserirAumento() {
		BigDecimal aumento = new BigDecimal("0.1");
		
		for (Funcionario func : funcionarios) {
			BigDecimal valorAumentar = func.salario.multiply(aumento);
			BigDecimal salarioNovo = func.salario.add(valorAumentar);
			func.salario = salarioNovo;
		}
	}
	
	public void inserirAumento(String x) {
		BigDecimal aumento = new BigDecimal(x);
		
		for (Funcionario func : funcionarios) {
			BigDecimal valorAumentar = func.salario.multiply(aumento);
			BigDecimal salarioNovo = func.salario.add(valorAumentar);
			func.salario = salarioNovo;
		}
	}
	
	public void agruparFuncao() {
		this.funcionariosFuncao.clear();
		ArrayList<Funcionario> func;
		int flag = 0;
		int i;
		ArrayList<String> funcoes = new ArrayList<String>();
		
		for (Funcionario funcionario : funcionarios) {
			i=0;
			flag=0;
			while(i < funcoes.size()) {
				if (funcionario.funcao.equals(funcoes.get(i))) {
					flag = 1;
					i = funcoes.size();
				}
				else {
					i++;
				}
			}
			
			if(flag == 0) {
				funcoes.add(funcionario.funcao);
			}

		}
		
		for (String funct : funcoes) {
			func = new ArrayList<Funcionario>();
			for (Funcionario funcionario : funcionarios) {
				if (funcionario.funcao.equals(funct)) {
					func.add(funcionario);
				}
			}
			
			this.funcionariosFuncao.put(funct, func);
		}
	}
	
	String imprimirAgrupados() {
		Set<String> keys = this.funcionariosFuncao.keySet();
		String relatorio = "";
		for (String key : keys) {
			relatorio += "Lista de Funcionários:" + key + "\n";
			relatorio += "      Nome     |     Data de Nasc     |     Salario     \n";
			for (Funcionario funcionario : funcionariosFuncao.get(key)) {
				relatorio += funcionario.nome + "   |    " + funcionario.datanasc.getDayOfMonth() + "/" + funcionario.datanasc.getMonthValue() + "/" + funcionario.datanasc.getYear() + "   |   " + NumberFormat.getCurrencyInstance().format(funcionario.salario) + "\n";
			}
			relatorio += "\n";
		}
		
		return relatorio;
	}

	String imprimirOlder() {
		String relatorio = "";
		
		Funcionario maisVelho = funcionarios.get(0);
		
		for (Funcionario funcionario : funcionarios) {
			if(funcionario.datanasc.isBefore(maisVelho.datanasc)) {
				maisVelho = funcionario;
			}
		}
		relatorio += "      Nome     |     Idade     \n";
		LocalDate idade = LocalDate.now();
		
		int years = idade.getYear() - maisVelho.datanasc.getYear();
		
		relatorio += maisVelho.nome + "   |   " + years + " anos de idade";
		return relatorio;
	}
}
