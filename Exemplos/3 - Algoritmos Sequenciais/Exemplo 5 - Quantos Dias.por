// O exemplo pede um valor inteiro que representa o ano atual 
// Exibe a quantidade de dias que se passaram desde o dia 01/01/0001 (ano 1 dc) at� o dia 01/01 do ano atual.
programa 
{
	funcao inicio()
	{
		inteiro ano_atual, qtd_anos_bi, dias

		escreva("Digite ano atual: ")
		leia(ano_atual) // l� o ano atual digitado pelo usu�rio

		qtd_anos_bi = ano_atual / 4 // calcula a quantidade de anos bissextos que ocorreram at� o ano atual (divis�o inteira)
		
		dias = (ano_atual-1) * 365 +  qtd_anos_bi // calcula quantos dias ser�o ao total  
		
		escreva("Quantidade de dias: ", dias) // exibe o resultado 
	}
}
