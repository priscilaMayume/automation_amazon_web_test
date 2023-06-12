#language: pt
Funcionalidade: testes de buscas

  Cenario: Abrir o Browser com sucesso
    Dado que abrir browser com sucesso
    Quando esperar abertura da Pg principal
    Entao deve esta visivel title aws
    E deve fechar o browser

  Cenario: Clicar no menu dos mais vendidos
    Dado que abrir browser com sucesso
    Quando esperar abertura da Pg principal
    Entao deve esta visivel title aws
    E deve clicar no menu dos mais vendidos
    E deve fechar o browser

  Cenario: Pesquisar valores no Dropdown de Pesquisa
    Dado que abrir browser com sucesso
    Quando esperar abertura da Pg principal
    Entao deve esta visivel title aws
    E que verifique valores no dropdown pesquisa
    E encontrar com sucesso a opcao de games
    E deve fechar o browser

  Cenario: Pesquisar pela barra de pesquisa
    Dado que abrir browser com sucesso
    Quando esperar abertura da Pg principal
    Entao deve esta visivel title aws
    E deve pesquisar com barra de pesquisa
    E encontrar com sucesso o resultado da pesquisa
    E deve fechar o browser

#  Cenario: Fechar todos os browser abertos
#    Entao deve fechar todos os browser