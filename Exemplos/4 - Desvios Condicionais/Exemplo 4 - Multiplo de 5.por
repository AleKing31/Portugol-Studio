// O exemplo a seguir pede ao usu�rio um valor inteiro e diz se ele � ou n�o multiplo de 5.
programa
{
	funcao inicio()
	{
		inteiro num, multiplo

		escreva("Digite um numero\n")
		leia(num)

		se(num % 5 == 0) // verifica se o valor � multiplo de 5
		{
			//caso o valor seja multiplo executa-se esta parte
			escreva(num, " � multiplo de 5  ")	
		}
		senao{ 
			// caso o valor n�o seja multiplo executa-se esta parte
			escreva(num, " n�o � multiplo de 5 ")
		}
	}
}
