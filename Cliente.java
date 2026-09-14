package pcmania.model;

public class Cliente {

    private String nome;
    private String cpf;

    //Atributos necessários
    private Computador[] computadores;  //Armazenará os computadores que o cliente escolher
    private int numeroDeComputadores;   //Armazenará o total de computadores que o cliente comprará
    private float totalCompra;          //Será usado para calcular o total que o cliente deverá pagar


    //Construtor da classe
    public Cliente(String nomeRecebido, String cpfRecebido){
        this.nome = nomeRecebido;
        this.cpf = cpfRecebido;

        this.computadores = new Computador[100]; //Inicializando o vetor do tipo pcmania.model.pcmania.model.Computador com um tamanho bom
        this.numeroDeComputadores = 0;           //Zero computadores adicionados até o instanciamento
        this.totalCompra = 0;                    //Zero pois o instanciamento acabou de ser feito
    }

    //Metodo para calcular o total. Só será usado no final
    public float calculaTotalCompra(){

        this.totalCompra = 0;  //Garantindo que está em zero e também caso esse metodo seja chamado mais de uma vez

        //Incremetando o total com o valor do respectivo computador até chegar no número de computadores que o cliente
        //selecionou
        for(int i=0 ; i<numeroDeComputadores ; i++){
            this.totalCompra += computadores[i].getPreco();
        }

        return this.totalCompra;  //Retornando o total lá para a Main (onde o metodo foi usado)
    }

    //Talvez não seja certo, pois não está de acordo com o UML, mas criei esse metodo para apenas mostrar os computadores
    //que o cliente escolheu depois de ter inserido 0 (saindo do loop)
    public void mostrarComputadoresSelecionados(){

        for(int i=0 ; i<numeroDeComputadores ; i++){

            //Acho que comparar pela marca é mais fácil para saber qual computador mostrar
            if(computadores[i].getMarca().equals("Apple")){
                computadores[i].mostraPCConfigs();
                System.out.println("\n");
            }

            else if(computadores[i].getMarca().equals("Samsung")){
                computadores[i].mostraPCConfigs();
                System.out.println("\n");
            }

            else{
                computadores[i].mostraPCConfigs();
                System.out.println("\n");
            }
        }
    }


    //Vi a necessidade de ter mais um metodo para adicionar os computadores ao vetor pcmania.model.pcmania.model.Computador[] computadores
    public void adicionarComputador(Computador comp){

        //O tamanho foi definido como 100 no construtor, então é difícil atingir o limite
        if(numeroDeComputadores < computadores.length){

            computadores[numeroDeComputadores] = comp; //Adiciona cada computador a uma pocição do vetor
            numeroDeComputadores++;                    //Incrementa para a próxima prosição do vetor. Também serve como tamanho
            //para os dois metodos acima, já que eles são usados por último
        }
        else{
            System.out.println("Você atingiu o limite de compras por pessoa física (100 unidades)!");
        }
    }


    //Metodos Getters
    public String getNome(){
        return this.nome;  //Para mostrar o nome do cliente depois do loop lá no Main
    }
    public String getCpf(){
        return this.cpf;  //Mostra o CPF do cliente no Main
    }

    //Não vi a necessidade de Setters nessa classe

}
