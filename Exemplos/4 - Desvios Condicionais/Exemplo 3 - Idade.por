// Este exemplo pede ao usu�rio a sua idade e exibe se ele � maior ou menor de idade.
programa { 
	funcao inicio () { 
	
		inteiro menor, idade 
		/*${cursor}*/
		escreva("Digite sua idade: ") 
		leia(idade) 
	
		se (idade < 18) { // verifica se a idade � menor que 18 
			escreva("O usu�rio � menor de idade")
		} 
		senao{
			escreva("O usu�rio � maior de idade")
		}
	} 
}
