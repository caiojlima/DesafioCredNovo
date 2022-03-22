# Desafio Analista de Sistemas Java

## Introdução:

Como parte do processo seletivo, gostaríamos que você fizesse uma pequena tarefa. O problema proposto é uma situação fictícia e você não estará desenvolvendo uma solução para nossa empresa neste teste.

Durante o desenvolvimento da aplicação você deverá usar a linguagem Java (utilizando a versão 8 para cima) e o framework Spring Boot. Para armazenamento dos dados usar o banco de dados MySQL onde deverá ser disponibilizado um arquivo `script.sql` contendo o script para criação do database e das tabelas.

Deverá ser disponibilizado um arquivo README com instruções para a execução de seu projeto.

Crie um projeto no seu Github para que vejamos os passos feitos através dos commits para resolver a tarefa.

## Desafio:

Para este desafio você deverá desenvolver uma API (Rest) simples para gerenciar os alunos, professores e matérias lecionadas de uma escola. Atendendo as seguintes condições:

1. Sua estrutura no banco de dados deverá ser capaz de:
    - Armazenar o id, nome e idade de cada aluno;
    - Armazenar o id, nome e idade de cada professor;
    - Armazenar o id e nome de cada matéria;
    - Fazer com que cada professor possa lecionar N matérias;
    - Fazer com que cada aluno possa estar inscrito em N matérias;

2. Utilizando a nomenclatura, o verbo HTTP e o Status Code adequado para cada situação de acordo com o padrão REST, você deverá disponibilizar recursos para:

- Gerenciar as matérias:
    - Salvar os dados de uma matéria;
    - Listar todos as matérias;

- Gerenciar os alunos:
    - Salvar os dados de um aluno;
    - Listar todos os alunos;
    - Inscrever o aluno em uma matéria;
    - Exibir um único aluno com a lista de matérias em que está inscrito;

- Gerenciar os professores:
    - Salvar os dados de um professor;
    - Listar todos os professores;
    - Cadastrar o professor em uma matéria;
    - Exibir um único professor com a lista de matérias em que leciona;
    - Remover o professor de uma matéria;

**Obs:** Todos os retornos das APIs deverão estar no formato JSON. Exemplo:
```json
{
  "id": 1,
  "nome": "Mr. Robot",
  "idade": 0,
  "materias": [
      {
        "id": 1,
        "nome": "Introdução a Orientação de Objetos"
      }
  ]
}
```

## Diferenciais:
- Fazer os testes unitários para cada API usando JUnit;
