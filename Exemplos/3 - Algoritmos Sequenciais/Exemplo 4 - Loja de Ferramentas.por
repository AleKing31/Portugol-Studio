// Este exemplo pede o nome do usu�rio e tr�s valores inteiros, sendo eles a quantidade de porcas, parafusos e aruelas compradas. 
// Ao fim � exibido o nome do usu�rio, a quantidade de cada item comprado e o valor total a ser pago.
programa  { 

	funcao inicio () { 
	
		// Os pre�os dos produtos s�o definidos nestas tres constantes
		const real precoParafuso=1.50
		const real precoAruelas=2.00
		const real precoPorcas=2.50 
		inteiro quantidadeParafuso, quantidadeAruelas, quantidadePorcas 
		
		real totalParafuso, totalAruelas, totalPorcas, totalPagar 
		cadeia nome 
		/*${cursor}*/
		escreva("Digite seu nome \n") 
		leia(nome) 
		
		escreva("Digite a quantidade de pecas de cada produto \n") 
		escreva("Porca/ Parafusos/ Aruelas \n")
		leia(quantidadeParafuso, quantidadeAruelas, quantidadePorcas) 

		//Atribui��o dos valores a serem pagos. Os valores s�o baseados na quantidade de items vendidos e o pre�o de cada item.
		totalPorcas = precoPorcas * quantidadePorcas  
		totalParafuso = precoParafuso * quantidadeParafuso 
		totalAruelas = precoAruelas * quantidadeAruelas 
		totalPagar = totalPorcas + totalParafuso + totalAruelas 
		
		escreva("Cliente: ",nome, "\n") 
		escreva("A quantidade de pe�as compradas: \n" ,"Parafuso: ", quantidadeParafuso, "\nAruelas: ", quantidadeAruelas, "\nPorcas: ", quantidadePorcas, "\n")
		escreva("O total a pagar:  R$ ",totalPagar)
		 
	} 
}
