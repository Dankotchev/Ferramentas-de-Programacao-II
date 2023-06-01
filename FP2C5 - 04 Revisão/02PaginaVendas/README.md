# Enunciado

## Venda

Implemente a página de venda conforme a figura abaixo.
![Venda](https://images2.imgbox.com/71/29/8t9NPzy5_o.png)

* ComboBox (select) Produto
    * Deve listar todos os produtos armazenados na base de dados.
* Preço
    * Deve exibir o preço atual do produto.
    * Não deve permitir alterar o preço do produto.
* Quantidade
    * Deve permitir o usuário informar a quantidade comprada.
    * Não deve permitir informar um valor menor do que 1.
* Botão Adicionar
    * Deve inserir um registro na tabela (Data Table).
    * Deve verificar se os campos de entrada foram preenchidos.
    * Caso o produto seja adicionado duas vezes, deve somar a quantidade e ficar somente um registro no itens da venda (tabela).
* Tabela
    * Deve listar a descrição, o preço, a quantidade e o preço parcial do produto.
    * No fim da tabela deve exibir o preço total da venda.
* Botão Pagamento
    * Deve encaminhar para a página de pagamento somente se pelo menos um produto foi adicionado.

## Pagamento

Implemente a página de pagamento conforme a figura abaixo.
![Pagamento](https://images2.imgbox.com/ec/6b/DY6I09EC_o.png)

* Deve listar os produtos escolhidos na página de venda.
* Botão Cancelar Venda
    * Deve cancelar a venda a atual e redirecionar para a página de venda.
* Botão Continuar Comprando
    * Deve redirecionar para a página de venda e permitir o usuário comprar mais produtos.
* Botão Finalizar Venda
    * Deve validar se os produtos contém quantidade suficiente em estoque. Se não possuir, não pode deixar finalizar a venda, se possuir, diminuir do estoque.
    * Atribuir a data da venda.

