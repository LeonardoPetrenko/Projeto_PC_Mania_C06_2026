package pcmania.main;

import pcmania.model.Cliente;
import pcmania.model.Computador;
import pcmania.model.MemoriaUSB;
import pcmania.util.ProcessarPedido;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){

        float matricula = 1051f; //Indica o preço do computador a ser comprado
        Computador[] computadores = new Computador[100];  //Esse vetor só será usado para o metodo static na classe ProcessarPedido.
                                                          //Provavelmente eu deveria usá-lo no programa, mas só fui perceber que tinha
                                                          //que fazer uma outra classe com um metodo static quando terminei tudo

        Scanner entrada = new Scanner(System.in);

        //Um menu onde o cliente informa seu nome e cpf
        System.out.println("=======================PC Mania================================");
        System.out.println("Bem-vindo(a)!\nPara continuar, precisamos de algumas informações");

        System.out.print("Nome: ");
        String nomeUser = entrada.nextLine();

        System.out.print("CPF: ");
        String cpfUser = entrada.nextLine();
        System.out.println("---------------------------------------------------------------");

        //Instanciando o cliente com as informações informadas
        Cliente novoCliente = new Cliente(nomeUser, cpfUser);

        int itens = 0;                //Conta quantos computadores o cliente escolheu
        boolean verificacao = true;   //Variável que escolhi para usar no loop onde os pc's serão escolhidos para parar o loop

        //Menu de opções da promoção
        System.out.println("1 - Comprar um MacBook (promoção 1)");
        System.out.println("2 - Comprar um Samsung (promoção 2)");
        System.out.println("3 - Comprar um Dell (promoção 3)");
        System.out.println("0 - Finalizar a compra");
        System.out.println("\nDigite o(s) código(s) da(s) opção(ões) desejada(s)");

        //Loop onde o cliente escolhe os computadores desejados (0 encerra o loop)
        while(verificacao){

            System.out.print("c: ");
            int opcao = entrada.nextInt();  //Variável para o código da promoção (1, 2 ou 3) e para parar o loop (=0)

            if(opcao == 1){
                //Instanciando o computador da primeira promoção junto com seu armazenamento externo
                Computador pc1 = new Computador("Apple", matricula, 1);
                MemoriaUSB memoriaPromocao1 = new MemoriaUSB("Pen-drive", 16);
                pc1.addMemoriaUSB(memoriaPromocao1);

                //Adicionando esse computador ao vetor do tipo Computadores na classe pcmania.model.pcmania.model.Cliente
                novoCliente.adicionarComputador(pc1);

                //Serve para passar o parâmetro para o metodo static em ProcessarPedido
                computadores[itens] = pc1;

                //Incrementa, pois há mais um computador no "carrinho"
                itens++;
            }
            else if(opcao == 2){
                //O mesmo feito no if anterior é feito aqui, mas para a promoção 2
                Computador pc2 = new Computador("Samsung", (matricula + 1), 2);
                MemoriaUSB memoriaPromocao2 = new MemoriaUSB("Pen-drive", 32);
                pc2.addMemoriaUSB(memoriaPromocao2);

                novoCliente.adicionarComputador(pc2);

                computadores[itens] = pc2;

                itens++;
            }
            else if(opcao == 3){
                //E aqui para a promoção 3
                Computador pc3 = new Computador("Dell", (matricula + 2), 3);
                MemoriaUSB memoriaPromocao3 = new MemoriaUSB("HDD Externo", 1000);
                pc3.addMemoriaUSB(memoriaPromocao3);

                novoCliente.adicionarComputador(pc3);

                computadores[itens] = pc3;

                itens++;
            }
            else if(opcao == 0){
                //Saindo do loop
                System.out.println("Seleção finalizada");
                verificacao = false;
            }
            else{
                //Caso digite algo fora das opções disponíveis
                System.out.println("Valor inválido");
            }
        }

        //Exibindo as informações do cliente junto ao seu pedido
        System.out.println("---------------------------------------------------------------");
        System.out.println("Comprador(a): " + novoCliente.getNome());
        System.out.println("CPF: " + novoCliente.getCpf());

        System.out.println("Você selecionou " + itens + " computadores!");

        System.out.println("\nComputadores Escolhidos:\n");
        novoCliente.mostrarComputadoresSelecionados();

        float total = novoCliente.calculaTotalCompra();
        System.out.println("Total: " + total);

        //O vetor computadores não tem utilidade aqui, mas tem que ter de acordo com a UML
        ProcessarPedido.helper(computadores);

        entrada.close();
    }
}