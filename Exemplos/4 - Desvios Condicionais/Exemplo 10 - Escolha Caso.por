// este exemplo ilustra o uso da instru��o escolha caso
// o usu�rio escolhe uma op��o e visualiza uma frase correspondente

programa
{
	funcao inicio()
	{
		inteiro opc
			
		escreva("1) Elogio \n")
		escreva("2) Ofensa \n")
		escreva("3) Sair \n")
		escreva("Escolha uma op��o: ")
		leia(opc)

		escolha (opc)	{
			caso  1: 
		 		escreva ("\nVoce � lindo(a) !")
		 		pare   // necess�rio para ele executar apenas um caso
		 	caso  2: 
		 		escreva ("\nVoce � um monstro !")
		 		pare
		 	caso  3: 
		 		escreva ("\nTchau !")
		 		pare
		 	caso contrario: // se n�o caiu em caso nenhum entra nesse
		 		escreva ("\nOp��o Inv�lida !")
		}
	}
}
