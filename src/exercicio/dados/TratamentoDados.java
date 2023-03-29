package exercicio.dados;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TratamentoDados {
	public Cliente[] leituraDados() throws FileNotFoundException {
		String path = "C:\\Users\\Aluno\\Documents\\teste\\ExercicioAvaliativo\\clientes.csv";
		File arquivo = new File(path);
		Scanner sc = new Scanner(arquivo);
		Scanner sc1 = new Scanner(arquivo);
		int contador = 0, i=0;
		
		sc1.nextLine();
		
		while(sc1.hasNext()) {
			contador++;
			sc1.nextLine();
		}
		
		sc1.close();
		sc.nextLine();
		Cliente[] clientes = new Cliente[contador];
		
		while(sc.hasNext()) {
			String linha = sc.nextLine();
			String[] vetor = linha.split(";");
			Cliente cliente = new Cliente();
			
			cliente.cpf = Long.parseLong(vetor[0]);
			cliente.nome = vetor[1];
			cliente.codigo = Integer.parseInt(vetor[2]);
			vetor[3] = vetor[3].replace(",", ".");
			cliente.credito = Float.parseFloat(vetor[3]);
			
			clientes[i] = cliente;
			i++;
		}
		
		sc.close();
		
		return clientes;
	}
	
	public Cliente[] filtragemDados(Cliente[] clientes, float valorInicial, float valorFinal) {
		int i,contador=0,j;
		
		for(i = 0; i < clientes.length; i++) {
			if(clientes[i].credito >= valorInicial && clientes[i].credito <= valorFinal) {
				contador++;
			}
		}
		
		Cliente[] retorno = new Cliente[contador];
		
		for(i = 0, j = 0; i < clientes.length; i++) {
			if(clientes[i].credito >= valorInicial && clientes[i].credito <= valorFinal) {
				retorno[j] = clientes[i];
				j++;
			}
		}
		
		return retorno;
	}
	
	public void criacaoArquivo(String valor, Cliente[] clientes) throws IOException {
		String path = "C:\\Users\\Aluno\\Documents\\teste\\ExercicioAvaliativo\\clientes-" + valor + ".txt";
		FileWriter arquivo = new FileWriter(path);
		PrintWriter gravador = new PrintWriter(arquivo);
		int i;
		
		gravador.println("﻿CPF;NOME;CODIGO;CREDITO");
		
		for(i = 0; i < clientes.length; i++) {
			gravador.println(clientes[i].cpf + ";" + clientes[i].nome + ";" + clientes[i].codigo + ";" + clientes[i].credito);
		}
		
		System.out.println("Arquivo criado!");
		
		gravador.close();
	}
}
