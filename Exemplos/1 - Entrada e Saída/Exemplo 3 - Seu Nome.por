// O exemplo a seguir pede ao usu�rio o nome dele e exibe a mensagem: "Seu nome �: " seguido do nome digitado.
programa 
{ 
	funcao inicio ()
	{
		cadeia nome 
		
		escreva("Digite seu nome: ")
		leia(nome) // l� o nome digitado pelo usu�rio e armazena na vari�vel nome

		// usa barra ene para inserir uma nova linha antes de exibir a mensagem	
		escreva("\nSeu nome �: ",nome) // exibe a mensagem seguido do nome digitado
	} 
}
