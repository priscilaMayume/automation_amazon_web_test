#language: pt
Funcionalidade: testes de login

  Cenario: Fazer login com sucesso
    Dado que abrir navegador com sucesso
    Quando clicar na pagina do login
    Entao deve esperar o elemente de email
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


