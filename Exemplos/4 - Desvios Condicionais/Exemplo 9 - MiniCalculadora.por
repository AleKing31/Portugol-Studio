// Este exemplo demonstra uma mini calculadora.
// O usu�rio dever� digitar dois n�meros reais e a opera��o 
// Ao fim � exibido o valor resultante da opera��o entre os dois n�meros. 
programa
{
	funcao inicio()
	{
		real resultado, oper1, oper2	
		caracter op

		escreva("Digite dois n�meros: \n")
		leia(oper1, oper2)

		escreva("Agora digite uma das opera��es ( + - * / ): \n")
		leia(op)

		// Abaixo � verificado qual foi a opera��o selecionada
		se(op == '+')
		{
			resultado = oper1 + oper2
			
		} senao {
			se(op == '-')
			{
				resultado = oper1 - oper2
				
			} senao {
				se(op == '/')
				{
					resultado = oper1 / oper2
					
				} senao {
					se(op == '*')
					{
						resultado = oper1 * oper2
					}	
				}
			}
		}
		escreva("O resultado da opera��o: ", resultado)
	}
}
