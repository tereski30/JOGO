import java.util.Scanner;
import java.util.Random;

public class jogo{

	public static void main(String[] args){

		String nome;
		char parar;
		int fichas, aposta, qtd, sorteio1, sorteio2, result, partidas = 0, acertos = 0, ganhas = 0, perdidas = 0;
		Scanner ler;
		ler = new Scanner(System.in);

		System.out.printf("\n--------------------------------------");
		System.out.printf("\n----------BEM-VINDO-AO-JOGO-----------");
		System.out.printf("\n--------------------------------------");

		//capturando o nome do usuario
		System.out.printf("\n       NOME DO JOGADOR: ");
		nome = ler.nextLine();

		//capturando quantidade de fichas inicias
		System.out.printf("       QUANTAS FICHAS DESEJA: ");
		fichas = ler.nextInt();

		do{

			//quantidade de fichas para aposta
			System.out.printf("       QUANTAS FICHAS PARA APOSTAR: ");
			qtd = ler.nextInt();

			//pede novamente para que o jogador coloque um numero positivo de fichas
			if(qtd <= 0){
				do{
					System.out.printf("\n       DIGITE UM VALOR POSITIVO: ");
					qtd = ler.nextInt();

				}while(qtd < 1);
			}

			//pede novamente que digite um numero menor que a quantidade total de fichas
			if(qtd > fichas){
				do{
					System.out.printf("\n       DIGITE UM VALOR MENOR QUE O TOTAL DE FICHAS: ");
					qtd = ler.nextInt();
				}while(qtd >= fichas);

				//pede novamente para que o jogador coloque um numero positivo de fichas
				if(qtd <= 0){
					do{
						System.out.printf("\n       DIGITE UM VALOR POSITIVO: ");
						qtd = ler.nextInt();

					}while(qtd < 1);
				}
			}

			//quantidade de rodadas
			partidas = partidas + 1;

			//advinhar o valor da soma
			System.out.printf("       ADIVINHE O VALOR DA SOMA: ");
			aposta = ler.nextInt();

			Random aleatorio = new Random();

			//variavel recebe um numero aleatorio para sortear
			sorteio1 = aleatorio.nextInt(6)+1;
			System.out.printf("       NUMERO SORTEADO: %d ", sorteio1);

			//variavel recebe um numero aleatorio para sortear
			sorteio2 = aleatorio.nextInt(6)+1;
			System.out.printf("\n       NUMERO SORTEADO: %d", sorteio2);

			//variavel recebe o valor dos dois sorteios
			result = sorteio1 + sorteio2;
			System.out.printf("\n       VALOR SOMADO DO SORTEIO: "+result);

			//verifica se o resultado é igual o apostado
			if(aposta == result){
				qtd += qtd;
				System.out.println("\n       FICHAS GANHAS: "+qtd);
				fichas = fichas + qtd;
				ganhas = ganhas + qtd;
				acertos = acertos + 1;
			}
			//verifica se o resultado é proximo do apostado
			else if(result - aposta == 1 || result + aposta == aposta + 1){
				qtd = qtd / 2;
				System.out.println("\n       FICHAS GANHAS: "+qtd);
				ganhas = ganhas + qtd;
				fichas = fichas + qtd;
			}
			//verifica se o resultado foi muito diferente
			else{
				fichas = fichas - qtd;
				System.out.println("\n       FICHAS PERDIDAS: "+qtd);
				perdidas = perdidas + qtd ;
				qtd -= qtd;
			}

			System.out.println("       FICHAS RESTANTES: "+fichas);

			if(fichas > 0){
				//avalia se o jogador deseja continuar jogando
				System.out.println("       DESEJA PARAR DE JOGAR: S / N");
				ler.nextLine();
				parar = ler.nextLine().charAt(0);

				//avalia o caracter
				if(parar == 'S'){
					fichas = 0;
				}
				else if(parar == 's'){
					fichas = 0;
				}
				else{
					fichas = fichas;
				}
			}

			//condição de parada do jogo
		} while(fichas > 0);

		//resultados
		System.out.printf("\n----------RELATORIO-DA-PARTIDA---------");
		System.out.printf("\n-                                     -");
		System.out.printf("\n-    NUMERO DE JOGADAS: %d             -",partidas);
		System.out.printf("\n-    NUMERO DE ACERTOS: %d             -",acertos);
		System.out.printf("\n-    FICHAS GANHAS: %d PERDIDAS: %d    -",ganhas,perdidas);
		System.out.printf("\n---------------------------------------");
		System.out.println("\n\n");

	}
}