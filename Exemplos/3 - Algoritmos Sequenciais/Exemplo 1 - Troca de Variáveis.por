// Este exemplo troca os valores de duas vari�veis a e b entre si e os exibe ao final 
programa
{
	funcao inicio() 
	{
		inteiro a = 10, b = 20, c

		// exibi��o do valor inicial 
		escreva("O valor inicial de a �: ", a, "\n")
		escreva("O valor inicial de b �: ", b, "\n")

		// traca dos valores
		c = b // � utilizada a vari�vel c como vari�vel auxiliar para poder inverter os valores
		b = a
		a = c

		// exibi��o do resultado final
		escreva("\nO valor final de a: ", a, "\n")
		escreva("O valor final de b: ", b, "\n")
		
	}
}
