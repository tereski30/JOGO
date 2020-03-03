import java.util.Scanner;
import java.util.Random;

public class jogo{

	public static void main(String[] args){

		String nome;
		int fichas, aposta, qtd, sorteio1, sorteio2, result;
		Scanner ler;
		ler = new Scanner(System.in);

		//capturando o nome do usuario
		System.out.print("Digite seu nome: ");
		nome = ler.nextLine();

		//capturando quantidade de fichas inicias
		System.out.printf("Quantidade de fichas: ");
		fichas = ler.nextInt();

		//quantidade de fichas para aposta
		System.out.printf("Quantas fichas deseja apostar: ");
		qtd = ler.nextInt();

		//advinhar o valor da soma
		System.out.printf("Adivinhe o valor da soma: ");
		aposta = ler.nextInt();


		Random aleatorio = new Random();

		//variavel recebe um numero aleatorio para sortear
		sorteio1 = aleatorio.nextInt(6);
		System.out.printf("Numero SORTEADO: %d ", sorteio1);

		//variavel recebe um numero aleatorio para sortear
		sorteio2 = aleatorio.nextInt(6);
		System.out.printf("\nNumero SORTEADO: %d", sorteio2);

		//variavel recebe o valor dos dois sorteios
		result = sorteio1 + sorteio2;
		System.out.printf("\nValor SOMADO do sorteio: "+result);

		//verifica se o resultado é igual o apostado
		if(aposta == result){
			qtd += qtd;
			System.out.println("\nFICHAS GANHAS: "+qtd);
			fichas = fichas + qtd;
		}
		//verifica se o resultado é proximo do apostado
		else if(result - aposta == 1 || result + aposta == aposta + 1){
			qtd = qtd / 2;
			System.out.println("\nFICHAS GANHAS: "+qtd);
			fichas = fichas + qtd;
		}
		//verifica se o resultado foi muito diferente
		else{
			fichas = fichas - qtd;
			System.out.println("\nFICHAS PERDIDAS: "+qtd);
			qtd -= qtd;
		}

		System.out.println("FICHAS RESTANTES: "+fichas);

	}


}