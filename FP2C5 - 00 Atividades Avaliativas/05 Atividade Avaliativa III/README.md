# Enunciado

Desenvolva um sistema que permita cadastrar, excluir e listar Tarefas. Uma Tarefa possui código, descrição, data de cadastro, data de modificação e status. O status pode ser '`Cadastrada`', '`Cancelada`' ou '`Finalizada`'.

Uma Tarefa sempre inicia com o status '`Cadastrada`'. O Status pode ser alterado para '`Cancelada`' ou '`Finalizada`'. Após alterado o Status, não deve ser possível modificar o status novamente.

Os dados do sistema devem ser armazenados no banco de dados.

O sistema deve ter pelo menos duas páginas, uma página para o cadastro de Tarefas e outra página para listar, excluir e alterar o status da tarefa.

## Cadastro

A página de cadastro de tarefas deve:

* Ser responsiva;
* Ter validação dos campos do formulário (campos obrigatórios);
* Utilizar mensagens (growl).

## Listar

A página de listagem de tarefas deve:

* Permitir excluir uma tarefa. Somente pode excluir uma tarefa com o status '`Cancelada`';
* Permitir cancelar uma tarefa. Somente pode cancelar uma tarefa com o status '`Cadastrada`'. Ao cancelar uma tarefa, registrar a data de modificação;
* Permitir finalizar uma tarefa. Somente pode finalizar uma tarefa com o status '`Cadastrada`'. Ao finalizar uma tarefa, registrar a data de modificação;
* Permitir filtrar por Status
* Permitir ordenar pela descrição;
* Permitir paginação dos dados;
* Ser responsiva;
* Ter linhas "Zebradas" (tabela).