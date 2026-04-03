import java.util.ArrayList;
import java.util.Scanner;

public class Metodos {

    //Estrutura para verificar se o número é inteiro.
    public static boolean verificarSeONumeroEInteiro(String a){
        boolean retorno = false;
        if (a == null){
            retorno = false;
        } try {
            Long.parseLong(a);
            retorno = true;
        } catch (NumberFormatException nfe){
            retorno = false;
        }
        return retorno;
    }


    //Estrutura para limpara o Console, apenas dá um espaçamento de 50 linhas entre uma estrutura que foi mostrada no Console e a outra.
    public static void limparConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }



    //Estrutura para montar a lista. Caso a lista esteja vazia, aparece somente "Lista de Funcionários" e as opções, caso a lista tenha um ou mais Funcionários listados, aparece os Funcionários, os dados dos Funcionários e as opções da lista.
    public static void montarLista(ArrayList<String> nome, ArrayList<String> phone, ArrayList<String> email, ArrayList<String> cpf){

        if ((nome.isEmpty()) || (phone.isEmpty()) || (email.isEmpty()) || (cpf.isEmpty())){
           
            System.out.println("                                         Lista de Funcionários                                     ");
            System.out.println("------------------------------------------------------------------------------------------------------------");
            System.out.println("[1]Adicionar Funcionário");
            System.out.println("[2]Alterar dados de um Funcionário");
            System.out.println("[3]Remover Funcionário");
            System.out.println("[4]Finalizar lista de Funcionários");
            System.out.println("------------------------------------------------------------------------------------------------------------");
            System.out.println("Digite o número de uma opção para seleciona-la:");

        } else{

            System.out.println("                                         Lista de Funcionários                                     ");
            System.out.println("------------------------------------------------------------------------------------------------------------");


            for (int c = 0; c < nome.size(); c++){
                System.out.printf("| %-30s | %-20s | %-30s | %-15s | \n", nome.get(c), phone.get(c), email.get(c), cpf.get(c));
                System.out.println("------------------------------------------------------------------------------------------------------------");
            }


            System.out.println("[1]Adicionar Funcionário");
            System.out.println("[2]Alterar dados de um Funcionário");
            System.out.println("[3]Remover Funcionário");
            System.out.println("[4]Finalizar lista de Funcionários");
            System.out.println("------------------------------------------------------------------------------------------------------------");
            System.out.println("Digite o número de uma opção para seleciona-la:");
        }
    }
    

    //Estrutura para montar a Lista sem as opções.
    public static void montarListaSemOpcoes(ArrayList<String> nome, ArrayList<String> phone, ArrayList<String> email, ArrayList<String> cpf){
            System.out.println("                                         Lista de Funcionários                                     ");
            System.out.println("------------------------------------------------------------------------------------------------------------");
            
            
            if (nome.isEmpty()){
                System.out.println("                                              VAZIA");
            }


            for (int c = 0; c < nome.size(); c++){
                System.out.printf("| %-30s | %-20s | %-30s | %-15s | \n", nome.get(c), phone.get(c), email.get(c), cpf.get(c));
                System.out.println("------------------------------------------------------------------------------------------------------------");
            }
    }
    
    


    //Estrutura para adicionar o NOME do Funcionário, com verificação de erro.
    public static String erroNome(){
        Scanner digitar = new Scanner(System.in);
        String nome = new String();
        String name = new String();

        do {
            name = digitar.nextLine();
            limparConsole();

            if (!name.isEmpty()){ //Verificando se "name" não está vazio, se não estiver, "name" é adicionado na lista
                nome = name;
            } else { //Se "name" estiver vazio, retorna ERRO
                System.out.println("ERRO: o nome não pode estar vazio");
                System.out.println("---------------------------------------------------");
                System.out.println("Digite o nome do Funcionário:");
            }
        } while (name.isEmpty());
        return nome;
        
    }
        

    //Estrutura para adicionar o NOME do Funcionário.
    public static String nomeFuncionario(){
        String nome = new String();

        System.out.println("Digite o NOME do Funcionário:");

        nome = erroNome();

        return nome;
    }




    //Estrutura para verificar se o numero digitado contém apenas INTEIROS, caso não conter aparece a mensagem de ERRO e permite digitar novamente o número para ser adicionado.
    public static String erroPhone(String name){
        Scanner digitar = new Scanner(System.in);
        String numeroDeTelefone = new String();
        String telefone = new String();

        do {
            numeroDeTelefone = digitar.nextLine();
                limparConsole();

                //Estrutura para verificar se o TELEFONE digitado é composto apenas por números inteiros, caso seja composto apenas por números inteiros, o TELEFONE é adicionado na lista, caso contrário, o usuário é informado do erro e solicitado a digitar novamente o TELEFONE.
                if (verificarSeONumeroEInteiro(numeroDeTelefone)){
                    telefone = numeroDeTelefone;
                } else{
                    System.out.println("ERRO: o número digitado NÃO pode ter caracteres não inteiros");
                    System.out.println("---------------------------------------------------");
                    System.out.println("Digite novamento o TELEFONE de " + name + ":");
                }
        } while (verificarSeONumeroEInteiro(numeroDeTelefone)==false);
        return telefone;
    }


    //Estrutura para adicionar o NÚMERO do Funcionário.
    public static String numeroFuncionario(String name){
        String telefone = new String();

        System.out.println("Digite o TELEFONE de " + name + ":");

        telefone = erroPhone(name);

        return telefone;
    }




    //Estrutura para verificar se o EMAIL digitado contém @, caso conter adiciona-se o EMAIl, caso contrário aparece uma mensagem de ERRO e é requisitado para digitar novamente o EMAIL. 
    public static String erroEmail(String name){
        Scanner digitar = new Scanner(System.in);
        String enderecoDeEmail = new  String();
        String email = new String();

        do {
            enderecoDeEmail = digitar.nextLine();
            limparConsole();
            
            
            //Estrutura para verificar se o E-MAIL digitado contém @, caso ter o @, o E-MAIL é adicionado na lista, caso contrário, o usuário é informado do erro e solicitado a digitar novamente o E-MAIL
            if (enderecoDeEmail.contains("@")==true){ 
                email = enderecoDeEmail;
            } else {
                System.out.println("ERRO: o E-MAIL digitado NÃO contém @");
                System.out.println("---------------------------------------------------");
                System.out.println("Digite novamente o E-MAIL de " + name + ":");
            }
            
        } while (enderecoDeEmail.contains("@")==false);

        return email;
    }


    //Estrutura para adicionar o EMAIL do Funcionário.
    public static String emailFuncionario(String name){
        Scanner digitar = new Scanner(System.in);
        String enderecoDeEmail = new String();
        String email = new String();
        
        System.out.println("Digite o E-MAIL de " + name + ":");

        email = erroEmail(name);

        return email;
    }




    //Formata o número adicionado, sem caracteres especiais, para o formato de CPF.
    public static String formatarCPF(String cpf) {
        return cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }


    //Estrutura para verificar se é possível adicionar o CPF, se não for avisa o erro e permite adicionar.
    public static String erroCPF(String name){
        Scanner digitar = new Scanner(System.in);
        String numeroDoCPF = new String();
        String cpf = new String();
        
        do {
            
            numeroDoCPF = digitar.nextLine();
            numeroDoCPF = numeroDoCPF.replaceAll("[-.]", ""); //Estrutura para tirar "-" ou "." caso tenha.
            limparConsole();
            
            //Estrutura para verificar se o CPF digitado é composto apenas por números inteiros, caso seja composto apenas por números inteiros, o CPF é adicionado na lista, caso contrário, o usuário é informado do erro e solicitado a digitar novamente o CPF.
            if (verificarSeONumeroEInteiro(numeroDoCPF)==true){    
                cpf = formatarCPF(numeroDoCPF);
            } else {
                System.out.println("ERRO: NÃO inclua LETRAS ou CARACTERES ESPECIAIS");
                System.out.println("---------------------------------------------------");
                System.out.println("Digite novamente o CPF de " + name + ":");

            }
        } while (verificarSeONumeroEInteiro(numeroDoCPF)==false);
        return cpf;
    }
        

    //Estrutura para adicionar o CPF do Funcionário.
    public static String cpfFuncionario(String name){
        String cpf = new String();

        System.out.println("Digite o CPF de " + name + ":");

        cpf = erroCPF(name);

        return cpf;
    }




    //Estrutura para alterar os DADOS DOS FUNCIONÁRIOS.
    public static void alterandoALista(String selecionado, ArrayList<String> nome, ArrayList<String> phone, ArrayList<String> email,ArrayList<String> cpf, int numeroDaLista, String name){
        Scanner digitar = new Scanner(System.in);
        String resposta = new String();
        
        switch (selecionado) {
            case "1":
                System.out.println("Digite o novo NOME para subtituir o atual:");
                resposta = erroNome();

                nome.set(numeroDaLista, resposta);

                break;

            case "2":
                System.out.println("Digite o novo TELEFONE para subtituir o atual:");
                resposta = erroPhone(name);

                phone.set(numeroDaLista, resposta);

                break;

            case "3":
                System.out.println("Digite o novo E-MAIL para subtituir o atual:");
                resposta = erroEmail(name);

                email.set(numeroDaLista, resposta);

                break;

            case "4":
                System.out.println("Digite o novo CPF para subtituir o atual:");
                resposta = erroCPF(name);

                resposta = formatarCPF(resposta);

                cpf.set(numeroDaLista, resposta);

                break;

            default:
                System.out.println("ERRO: opção inválida");
                break;
        }
    }




    //Estrutura para caso for digitado 2, há a possibilidade de mudar os dados do funcionário a partir do CPF. O usuário é solicitado a digitar o CPF do funcionário que deseja alterar os dados, caso o CPF digitado seja igual ao CPF do funcionário da lista, mostra-se os dados do funcionário selecionado e as opções de dados para serem alterados, caso contrário, não acontece nada. Após selecionar o dado a ser alterado, o usuário é solicitado a digitar o novo dado para substituir o dado atual do funcionário.
    public static void casoDois(ArrayList<String> nome, ArrayList<String> phone, ArrayList<String> email, ArrayList<String> cpf){
        Scanner digitar = new Scanner(System.in);
        String resposta = new String();
        String selecionar = new String();
        String name = new String();
        int funcionarioSelecionado = 0;
        
        
        do {

                    //Enquanto a Lista esteja vazia, mostra-se uma mensagem de erro e para voltar para o início é  necessário deixar a resposta  vazia, ou seja, apenas apertar ENTER.
                    if ((nome.isEmpty())){ 
                        System.out.println("                           ERRO: a lista está VAZIA.");
                        System.out.println("------------------------------------------------------------------------------------");
                        System.out.println("Aperte ENTER para voltar para o início");
                        resposta = digitar.nextLine();
                        limparConsole();

                    } else { //Caso a lista não esteja vazia, mostra-se a lista de funcionários e pede-se para digitar o CPF do funcionário que se deseja alterar os dados.
                    
                        montarListaSemOpcoes(nome, phone, email, cpf);
                        System.out.println("Aperte ENTER para voltar para o início");
                        System.out.println("--------------------------------------------------------------");
                        System.out.println("Escreva o CPF do Funcionário que você quer ALTERAR os dados:");
                        resposta = digitar.nextLine();
                        resposta = resposta.replaceAll("[-.]", ""); //Estrutura para tirar "-" ou "." caso tenha.
                        limparConsole();
                        

                        for (int verif = 0; verif < nome.size(); verif++ ){
                            
                            //Estrutura para verificar se o CPF digitado é igual ao CPF do funcionário da lista, caso seja igual, mostra-se os dados do funcionário selecionado e as opções de dados para serem alterados, caso contrário, não acontece nada.
                            if (resposta.equals(cpf.get(verif).replaceAll("[-.]" ,  ""))){ 
                                System.out.println("                                       DADOS DO FUNCIONÁRIO SELECIONADO");
                                System.out.println("------------------------------------------------------------------------------------------------------------");
                                System.out.printf("| %-30s | %-20s | %-30s | %-15s | \n", nome.get(verif), phone.get(verif), email.get(verif), cpf.get(verif));
                                System.out.println("------------------------------------------------------------------------------------------------------------");
                                System.out.println("[1] NOME");
                                System.out.println("[2] TELEFONE");
                                System.out.println("[3] E-MAIL");
                                System.out.println("[4] CPF");
                                System.out.println("------------------------------------------------------------------------------------------------");
                                System.out.println("Digite o número do item para ser alterado: (Aperte ENTER para cancelar e voltar para o início)");
                                selecionar = digitar.nextLine();
                                funcionarioSelecionado = verif;
                            }
                        }
                            limparConsole();
                        

                            if (selecionar.isEmpty()){
                                break;
                            }
                            
                            name = nome.get(funcionarioSelecionado);

                            alterandoALista(selecionar, nome, phone, email, cpf, funcionarioSelecionado, name);
                            
                            selecionar = ""; 
                            limparConsole();

                    }

                    } while (!resposta.isEmpty());
    }




    //Estrura para caso for digitado 3, há a possibilidade de remover um Funcionário e todos os dados do Funcionário, a partir do CPF do funcionário, caso o CPF digitado seja igual ao CPF do funcionário da lista, é solicitado a confirmação para remover o funcionário, caso seja confirmado, o funcionário e os dados do funcionário são removidos da lista, caso contrário, não acontece nada.
    public static void casoTres(ArrayList<String> nome, ArrayList<String> phone, ArrayList<String> email, ArrayList<String> cpf){
        Scanner digitar = new Scanner(System.in);
        String resposta = new String();


        //Enquanto a Lista esteja vazia, mostra-se uma mensagem de erro e para voltar para o início é  necessário deixar a resposta  vazia, ou seja, apenas apertar ENTER.
        if (nome.isEmpty()){
                System.out.println("                           ERRO: a lista está VAZIA.");
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("Aperte ENTER para voltar para o início");
                resposta = digitar.nextLine();
                limparConsole();

        } else { //Caso a lista não esteja vazia, mostra-se a lista de funcionários e pede-se para digitar o CPF do funcionário que se deseja remover da lista.
                montarListaSemOpcoes(nome, phone, email, cpf);
                System.out.println("Aperte ENTER para voltar para o início");
                System.out.println("---------------------------------------");
                System.out.println("Escreva o CPF do Funcionário que você quer REMOVER:");
                resposta = digitar.nextLine();
                resposta = resposta.replaceAll("[-.]", "");
                limparConsole();

                for (int verif = 0; verif < cpf.size(); verif++){
                    if (resposta.equals(cpf.get(verif))){
                        System.out.println("Tem certeza que quer remover " + nome.get(verif) + " da lista? [S/N]");
                        resposta = digitar.nextLine();

                        if(resposta.equalsIgnoreCase("S")){
                            nome.remove(verif);
                            phone.remove(verif);
                            email.remove(verif);
                            cpf.remove(verif);
                        }
                    }
                }
        }
    }
}
    
