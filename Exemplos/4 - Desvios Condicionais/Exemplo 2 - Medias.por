// O programa a seguir pede que o usu�rio entre com tr�s m�dias, calcula e exibe a media final, al�m de verificar e exibir qual das m�dias parciais � menor que a final (caso exista).
programa
{
	funcao inicio ()
	{
		real m1, m2, m3, media 

		escreva("Digite suas medias: \n")
		escreva ("Informe a m�dia 1: " )
		leia (m1)
		escreva( "Informe a m�dia 2: ") 
		leia (m2)
		escreva ("Informe a m�dia 3: ") 
		leia (m3)
		
		media = (m1+m2+m3)/3 
		escreva ("M�dia: ", media,"\n") 


		se (m1 < media){ // verifica se a m1 � menor que a final
			escreva ("\nM�dia 1 � menor que a m�dia final") 
		}
		
		se (m2 < media) { // verifica se a m2 � menor que a final
			escreva ("\nM�dia 2 � menor que a m�dia final")
		}
		
		se (m3 < media) { // verifica se a m3 � menor que a final
			escreva ("\nM�dia 3 � menor que a m�dia final")
		}
		
	}
}
