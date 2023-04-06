## Atenção

* Avaliação individual e com consulta a qualquer tipo de material (arquivos, site, livros, anotações etc.).
* Seguir as convenções de programação.
* Inserir título na página xhtml (browser).
* Página deve ser responsiva.

# Enunciado

Crie um projeto web, com as tecnologias utilizadas nas aulas, que permita validar o login de um usuário. Utilize o diagrama de classes a seguir. Caso necessário, métodos e atributos podem ser adicionados na implementação, porém as informações que estão no diagrama devem ser respeitadas, implementadas e utilizadas.
![Diagrama de Classe](https://images2.imgbox.com/75/ac/5KqhpeXV_o.png)


### Classe PessoaService

* Contém uma lista de pessoas.
* O método carregarPessoas adiciona 50 objetos do tipo Pessoa na lista de pessoas.
* O método login verifica se existe uma pessoa com o login e a senha, caso exista, o objeto do tipo Pessoa é retornado. Considere que todas as pessoas possuem login diferentes.

### Classe PessoaController

* O método login faz chamada ao método login da classe PessoaService.

### Classe Util

* Contém os métodos para exibir mensagem de Erro, Sucesso e Erro.

### Mensagem

* Utilizar o componente para exibir as mensagens do sistema na forma de “balão”.
* O texto da mensagem não deve ser repetido.

### Login

* Criar uma página com o nome index.xhtml como mostra a figura a seguir.
    
    ![Tela de login](https://images2.imgbox.com/8c/1c/tFnGvxc9_o.png "Tela de login")
    
* Utilizar o componente password para a senha.
* O componente de entrada de dados deve receber o focus quando o label é clicado.
* Validar entrada de dados (campos obrigatórios).
* Se alguma operação lançar uma exception, ela deve ser tratada.
* Caso o login e senha sejam válidos, apresentar uma mensagem como mostra a figura a seguir. Substituir `<nome-da-pessoa>` pelo nome real da pessoa.
        ![Mensagem de Bem vindo](https://images2.imgbox.com/d8/4e/lQty3vVz_o.png)
 * Caso o login ou senha sejam inválidos, apresentar uma mensagem como mostra a figura a seguir.
![Login e/ou senha inválidos](https://images2.imgbox.com/94/01/DuYABLeJ_o.png)

>Feedback do professor:

