// O exemplo a seguir pede ao usu�rio dois valores e exibe a soma.
programa
{
	funcao inicio()
	{
		real a, b, soma, sub, mult, div
		/*${cursor}*/
		escreva("Digite dois n�meros inteiros: ")
		leia(a,b) // l� os valores digitados pelo usu�rio  e armazena em a e b

		soma = a+b // soma os dois valores
		sub  = a-b // subtrai os dois valores
		mult = a*b // multiplica os dois valores
		div  = a/b // divide os dois valores
		
		escreva("A soma dos n�meros �: ",soma) // exibe o resultado
		escreva("A subtra��o dos n�meros �: ",sub) // exibe o resultado
		escreva("A multiplica��o dos n�meros �: ",mult) // exibe o resultado
		escreva("A divis�o dos n�meros �: ",div) // exibe o resultado
	
	}
}
