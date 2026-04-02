import java.util.ArrayList;
import java.util.Scanner;

public class ListaDeFuncionarios{
    public static void main(String[] args){
        ArrayList<String> nome = new ArrayList<>();
        ArrayList<String> phone = new ArrayList<>();
        ArrayList<String> email = new ArrayList<>();
        ArrayList<String> cpf = new ArrayList<>();

        String resposta = new String("");
        String name = new String("");
        String numeroDeTelefone = new String("");
        String enderecoDeEmail = new String("");
        String numeroDoCPF = new String ("");
        String selecionar = new String("");
        int funcionarioSelecionado = 0;

        Scanner digitar = new Scanner(System.in);
        
        Metodos.limparConsole();
        

        do {

            Metodos.limparConsole();
            Metodos.montarLista(nome, phone, email, cpf);
            resposta = digitar.nextLine();
            Metodos.limparConsole();
            
        if (Metodos.verificarSeONumeroEInteiro(resposta)){
            switch (resposta) {
                case "1": //Caso digitado 1, o usuário pode adicionar um Funcionário e seus dados.
                    
                    //Estrutura para adicionar o NOME do Funcionário
                    name = Metodos.nomeFuncionario();
                    nome.add(name);

                    
                    //Estrutura para adicionar o TELEFONE do Funcionário+
                    numeroDeTelefone = Metodos.numeroFuncionario(name);
                    phone.add(numeroDeTelefone);


                    //Estrutura para adicionar o E-MAIL do Funcionário
                    enderecoDeEmail = Metodos.emailFuncionario(name);
                    email.add(enderecoDeEmail);


                    //Estrutura para adicionar o CPF do Funcionário    
                    numeroDoCPF = Metodos.cpfFuncionario(name);
                    cpf.add(numeroDoCPF);
                    
                    
                    break;


                case "2": //Caso for digitado 2, o usuário pode mudar os dados do funcionário a partir do CPF.          
                    
                    Metodos.casoDois(nome, phone, email, cpf);
                    
                    Metodos.limparConsole();
                    break;

                case "3": //Caso digitado 3, o usuário pode remover um Funcionário e todos os dados do Funcionário.
                    
                    Metodos.casoTres(nome, phone, email, cpf);

                    Metodos.limparConsole();
                    break;

                case "4": //Caso digitado 4, o usuário pode finalizar o programa e mostrar a lista de funcionários sem as opções de adicionar, editar ou remover.
                    
                    Metodos.limparConsole();
                    
                    Metodos.montarListaSemOpcoes(nome, phone, email, cpf);
                    
                    if (!nome.isEmpty()){
                        System.out.println("                                             FINALIZADA");
                    
                    }
                    break;

                default:
                    break;

            }
        }            
            
        } while((!resposta.equals("4")));
    }
}