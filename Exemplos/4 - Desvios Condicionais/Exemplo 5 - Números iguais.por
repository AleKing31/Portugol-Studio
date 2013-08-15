// O exemplo a seguir pede ao usu�rio um valor de 0 a 6 e sorteia um valor de 0 a 6.
// Ao fim � verificado se o valor digitado pelo usu�rio � igual ao valor sorteado pelo programa.

programa
{
	inclua biblioteca Util --> util
	
	funcao inicio()
	{
		inteiro numDigitado, numSorteado
		/*${cursor}*/
		escreva("Informe um numero de 0 a 6: ")
		leia(numDigitado)

		numSorteado= util.sorteia(0,6) // sorteia um valor de 0 a 6 e atribui a numSorteado
		se (numDigitado == numSorteado) // verifica se o valor sorteado � igual ao valor digitado pelo usu�rio 
		{
			//caso os valores sejam iguais esta parte � executada
			escreva("S�o iguais")
		}
		senao{
			// caso os valores sejam diferentes esta parte � executada
			escreva("S�o diferentes - Sorteado: ", numSorteado, " Digitado: ", numDigitado)
		}
	}
}
