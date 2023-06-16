# Exercício - Investimento Financeiro

Crie um projeto para cadastrar e calcular o rendimento de aplicações financeiras do tipo CDB ou LCI. As informações para o cadastro de um investimento são: **tipo (CDB ou LCI), valor investido, porcentagem (ao ano), tempo (em dias)**. Deve ser apresentado **o desconto do Imposto de Renda (IR), o rendimento bruto e o rendimento líquido.** Sabe-se que uma aplicação do tipo LCI é isenta de imposto de renda e uma aplicação do tipo CDB é descontado o imposto de renda sobre o rendimento de acordo com a tabela abaixo:

| Dias | Porcentagem |
| --- | --- |
| Até 180 | 22,5% |
| 181 a 360 | 20% |
| 361 a 720 | 17,5% |
| Acima de 720 | 15% |
## Cálculos

* Encontrar a porcentagem de juros por dia.
* Calcular o rendimento com base no valor aplicado, na porcentagem de juros por dia e na quantidade de dias que o dinheiro ficou aplicado.
* O imposto de renda é calculado sobre o rendimento da aplicação. Utilizar a tabela acima para cálculo do imposto de renda.
* O valor líquido é o valor aplicado somado com o rendimento e subtraído o imposto de renda.