// O exemplo a seguir pede ao usu�rio o seu nome e suas tr�s medias.
// Ao fim � exibido se o usu�rio foi aprovado ou reprovado

programa
{
	funcao inicio()
	{
		cadeia nomeAluno
		real media1,media2,media3, mediaFinal
		/*${cursor}*/
		escreva("Digite o nome do aluno\n")
		leia(nomeAluno)

		escreva("Digite as 3 m�dias do Aluno \n")
		leia(media1,media2,media3)

		mediaFinal = (media1+media2+media3)/3 // calculo da m�dia
		
		se(mediaFinal >= 6) // verifica se m�dia final � maior ou igual a 6
		{
			// caso a condi��o seja verdadeira esta parte � executada
		 	escreva(nomeAluno, " voc� foi aprovado com a m�dia: ", mediaFinal)
		}
		senao{
			// caso a condi��o seja falsa esta parte � executada
			escreva(nomeAluno, " voc� foi reprovado com a m�dia: ", mediaFinal)
		}

	}
}
