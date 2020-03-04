import java.util.Scanner;
import java.util.Random;

public class jogo{

	public static void main(String[] args){

		String nome, parar;
		int fichas, aposta, qtd, sorteio1, sorteio2, result, partidas = 0, acertos = 0, ganhas = 0, perdidas = 0;
		Scanner ler;
		ler = new Scanner(System.in);

		//capturando o nome do usuario
		System.out.print("Digite seu nome: ");
		nome = ler.nextLine();

		//capturando quantidade de fichas inicias
		System.out.printf("Quantidade de fichas: ");
		fichas = ler.nextInt();

		do{

			//quantidade de fichas para aposta
			System.out.printf("Quantas fichas deseja apostar: ");
			qtd = ler.nextInt();

			//pede novamente para que o jogador coloque um numero positivo de fichas
			if(qtd <= 0){
				do{
					System.out.printf("\nDIGITE UM VALOR POSITIVO: ");
					qtd = ler.nextInt();

				}while(qtd < 1);
			}

			//pede novamente que digite um numero menor que a quantidade total de fichas
			if(qtd > fichas){
				do{
					System.out.printf("\nDIGITE UM VALOR MENOR QUE O TOTAL DE FICHAS: ");
					qtd = ler.nextInt();
				}while(qtd >= fichas);

			//pede novamente para que o jogador coloque um numero positivo de fichas
			if(qtd <= 0){
				do{
					System.out.printf("\nDIGITE UM VALOR POSITIVO: ");
					qtd = ler.nextInt();

				}while(qtd < 1);
			}

			}

			//quantidade de rodadas
			partidas = partidas + 1;

			//advinhar o valor da soma
			System.out.printf("Adivinhe o valor da soma: ");
			aposta = ler.nextInt();


			Random aleatorio = new Random();

			//variavel recebe um numero aleatorio para sortear
			sorteio1 = aleatorio.nextInt(6)+1;
			System.out.printf("Numero SORTEADO: %d ", sorteio1);

			//variavel recebe um numero aleatorio para sortear
			sorteio2 = aleatorio.nextInt(6)+1;
			System.out.printf("\nNumero SORTEADO: %d", sorteio2);

			//variavel recebe o valor dos dois sorteios
			result = sorteio1 + sorteio2;
			System.out.printf("\nValor SOMADO do sorteio: "+result);

			//verifica se o resultado é igual o apostado
			if(aposta == result){
				ganhas = ganhas + 1;
				qtd += qtd;
				System.out.println("\nFICHAS GANHAS: "+qtd);
				fichas = fichas + qtd;
				acertos = acertos + 1;
			}
			//verifica se o resultado é proximo do apostado
			else if(result - aposta == 1 || result + aposta == aposta + 1){
				ganhas = ganhas + 1;
				qtd = qtd / 2;
				System.out.println("\nFICHAS GANHAS: "+qtd);
				fichas = fichas + qtd;
			}
			//verifica se o resultado foi muito diferente
			else{
				perdidas = perdidas + 1;
				fichas = fichas - qtd;
				System.out.println("\nFICHAS PERDIDAS: "+qtd);
				qtd -= qtd;
			}

			System.out.println("FICHAS RESTANTES: "+fichas);

			//avalia se o jogador deseja continuar jogando
			System.out.println("DESEJA PARAR DE JOGAR: SIM / NAO");
			ler.nextLine();
			parar = ler.nextLine();

			//condição de parada do jogo
		} while(fichas > 0);

		//resultados
		System.out.println("\n----------RELATORIO-DA-PARTIDA---------");
		System.out.println("\n    numero de jogadas: "+partidas);
		System.out.println("\n    numero de acertos: "+acertos);
		System.out.printf("\n    quantidade de fichas ganhas: %d perdidas: %d",ganhas,perdidas);
		System.out.println("\n\n");

	}
}