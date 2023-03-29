package exercicio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import exercicio.dados.*;

public class Programa {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		float valorInicial, valorFinal;
		TratamentoDados a = new TratamentoDados();
		do {
			System.out.println("Atenção o valor inicial deve ser maior que o final!!!");
			System.out.print("Digite o valor inicial: ");
			valorInicial = sc.nextFloat();
			System.out.print("Digite o valor final: ");
			valorFinal = sc.nextFloat();
		}while(valorFinal < valorInicial);
		
		String valor = valorInicial + "a" + valorFinal;
		
		Cliente[] clientes = a.leituraDados();
		Cliente[] filtrados = a.filtragemDados(clientes, valorInicial, valorFinal);
		try {
			a.criacaoArquivo(valor, filtrados);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sc.close();
	}
}
