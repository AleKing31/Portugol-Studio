// Este exemplo pede ao usu�rio que entre com um n�mero inteiro exibe se ele � positivo negativo ou zero.
programa
{
	funcao inicio()
	{
		inteiro num

		escreva("Digite um n�mero inteiro: ")
		leia(num)

		se(num > 0){ // verifica se o n�mero � positivo
			escreva("O n�mero � positivo.")
		}
		senao{ 
			se(num < 0) { // verifica se o n�mero � negativo
				escreva("O n�mero � negativo.")
			}
			senao { // se chegou aqui s� pode ser zero 
				escreva("O n�mero � zero.")	
			}
		}
		
	}
}
