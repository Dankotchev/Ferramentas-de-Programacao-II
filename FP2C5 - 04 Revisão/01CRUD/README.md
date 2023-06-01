# Enunciado

## Atenção

* Seguir as convenções de programação.
* Inserir título nas páginas xhtml (browser).
* Páginas devem ser responsivas.

## Menu

* Deve possuir uma imagem para cada link e não deve ser a do exemplo do primefaces.
* Deve possuir dois itens: Calculadora e Funcionários. Os itens devem fazer o redirecionamento para as respectivas páginas.

## Mensagem

* Utilizar o componente para exibir as mensagens do sistema na forma de ‘balão”.
* O texto da mensagem não deve ser repetido.

## Calculadora

* Criar uma página com o nome index.xhtml que faça somente as operações básicas matemáticas: soma, subtração, multiplicação e divisão.
* O componente de entrada de dados deve receber o focus quando o label é clicado.
* Validar entrada de dados (campos obrigatórios).
* Validar divisão por zero.
* Permitir somente os operadores de soma, subtração, multiplicação e divisão.
* Se alguma operação lançar uma exception, ela deve ser tratada.

![![Captura de tela 2023-03-23 - 07.39.52.png](https://images2.imgbox.com/7b/69/nCUyPusc_o.png "![Captura de tela 2023-03-23 - 07.39.52.png")

## Funcionários

* Criar uma página com o nome List.xhmt dentro do diretório funcionario.
* A página deve listar o nome e o salário dos funcionários.
* Criar um método para gerar 50 funcionário e armazenar em uma lista dinâmica.
* Permitir filtrar por Nome.
* Permitir ordenar pela Nome.
* Permitir paginação dos dados.
* Exibir 5 linhas por página.
* Ser responsiva.
* Ter linhas "Zebradas" (tabela).

![Captura de tela 2023-03-23 - 07.43.50.png](https://images2.imgbox.com/2e/bd/aBvp9rv8_o.png)

![Captura de tela 2023-03-23 - 07.43.33.png](https://images2.imgbox.com/92/94/DEauWR9U_o.png)

>Feedback do professor: - Não validou os operadores. - O atributo resultado da classe CalculadoraController deveria estar na classe calculadora. - Não funcionou a implementação de validação por zero. - O escopo da classe CalculadoraController está errado. - Ao clicar no label Operador, o focus está sendo direcionado para o componente errado. - Nome de variável incorreto: Funcionario criar. - Não deveria existir o método setListaFuncionario na classe FuncionarioController. - Linhas 37 e 40, do arquivo List.xhtml, são desnecessárias
