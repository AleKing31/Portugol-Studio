// O exemplo pede a altura de 3 pessoas, calcula e exibe a media da altura.
programa
{
//	inclua biblioteca Matematica --> mat  // tire o comentario desta linha e da linha 16 para usar a vers�o formatada da saida de dados
	funcao inicio()
	{
		real altura1, altura2, altura3, mediaAltura

		escreva("Digite a Altura de tr�s pessoas: \n")
		leia(altura1, altura2, altura3) // l� os valores passados pelo usu�rio

		mediaAltura = (altura1 + altura2 + altura3)/3 //calculo da m�dia

		escreva("\nA m�dia da altura das tr�s pessoas �:  ", mediaAltura, " m") // exibe o resultado final
		
//		escreva("\nA m�dia da altura das tr�s pessoas �:  ", mat.arredondar(mediaAltura, 4), " m") // exibe o resultado final formatado
	}
}
