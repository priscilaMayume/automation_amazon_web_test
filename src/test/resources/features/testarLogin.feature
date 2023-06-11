#language: pt
Funcionalidade: testes de login

  Cenario: Fazer login com sucesso
    Dado que abrir navegador com sucesso
    Quando esperar a abertura da Pg principal
    Entao deve esperar o elemento de title
    E clicar na pagina do login
    E deve esperar o elemento de email
    E deve escrever login valido
    E deve clicar em continuar
    E deve esperar elemento de PSW
    E deve escrever psw valida
    E deve clicar em submeter
    E deve esperar elemento de saudacao personalizada
    E deve verificar a saudacao personalizada
    E deve mover ponteiro para o menu conta
    E deve fazer logout
    E deve fechar o navegador

  Cenario: Fazer login com email errado
    Dado que abrir navegador com sucesso
    Quando esperar a abertura da Pg principal
    Entao deve esperar o elemento de title
    E clicar na pagina do login
    E deve esperar o elemento de email
    E deve escrever login invalido
    E deve clicar em continuar
    E deve esperar o elemento de msg de email errado
    E deve verificar erro na msg de email errada
    E deve fechar o navegador

  Cenario: Fazer login com psw errado
    Dado que abrir navegador com sucesso
    Quando esperar a abertura da Pg principal
    Entao deve esperar o elemento de title
    E clicar na pagina do login
    E deve esperar o elemento de email
    E deve escrever login valido
    E deve clicar em continuar
    E deve esperar elemento de PSW
    E deve escrever psw invalida
    E deve clicar em submeter
    E deve esperar o elemento de msg de psw errado
    E deve verificar erro na msg de psw errado
    E deve fechar o navegador