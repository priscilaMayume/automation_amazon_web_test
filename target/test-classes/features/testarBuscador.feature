#language: pt
Funcionalidade: testes de buscas

  Cenario: Abrir o Browser com sucesso
    Dado que abrir browser com sucesso
    Entao deve esta visivel title aws
    E fecho o browser

  Cenario: Clicar no menu dos mais vendidos
    Dado que abrir browser com sucesso
    Entao deve clicar no menu dos mais vendidos
    E fecho o browser

  Cenario: Pesquisar valores no Dropdown de Pesquisa
    Dado que abrir browser com sucesso
    Entao que verifique valores no dropdown pesquisa
    E encontro com sucesso a opcao de games
    E fecho o browser