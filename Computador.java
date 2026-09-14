package pcmania.model;

public class Computador{

    private String marca;
    private float preco;

    //Atributos necessários para a agregação de pcmania.model.pcmania.model.MemoriaUSB e as composições de pcmania.model.pcmania.model.HardwareBasico e pcmania.model.pcmania.model.SistemaOperacional
    private MemoriaUSB memoria;
    private HardwareBasico[] hardwares = new HardwareBasico[3];  //Tamanho 3, pois temos processador (1), RAM (2) e armazenamento (3)
    private SistemaOperacional sistema;

    //Construtor da classe. A partir do código da promoçao podemos instancias os itens certos do computador daquela promoção
    public Computador(String marcaRecebida, float precoRecebido, int tipoPromocao){
        this.marca = marcaRecebida;
        this.preco = precoRecebido;

        //Como pcmania.model.pcmania.model.HardwareBasico e pcmania.model.pcmania.model.SistemaOperacional têm relação de composição com pcmania.model.pcmania.model.Computador, devem ser instanciados aqui,
        //e não no Main. pcmania.model.pcmania.model.MemoriaUSB foi instanciado no Main, pois é agregação
        if(tipoPromocao == 1){
            hardwares[0] = new HardwareBasico("Pentium Core i5", 2200);
            hardwares[1] = new HardwareBasico("Memória RAM", 8);
            hardwares[2] = new HardwareBasico("HD", 500);
            this.sistema = new SistemaOperacional("macOS Sequoia", 64);
        }
        else if(tipoPromocao == 2){
            hardwares[0] = new HardwareBasico("Pentium Core i7", 3370);
            hardwares[1] = new HardwareBasico("Memória RAM", 16);
            hardwares[2] = new HardwareBasico("HD", 1000);
            this.sistema = new SistemaOperacional("Windows 8", 64);
        }
        else if(tipoPromocao == 3){
            hardwares[0] = new HardwareBasico("Pentium Core i7", 4500);
            hardwares[1] = new HardwareBasico("Memória RAM", 32);
            hardwares[2] = new HardwareBasico("HD", 2000);
            this.sistema = new SistemaOperacional("Windows 10", 64);
        }

    }

    //Metodo para exibir as especificações do respectivo computador
    public void mostraPCConfigs(){
        System.out.println("Marca: " + this.marca);
        System.out.println("Preço: R$" + this.preco);
        System.out.println("Processador: " + this.hardwares[0].getNome() + " de " + this.hardwares[0].getCapacidade() + "Mhz");
        System.out.println("Memória RAM: " + this.hardwares[1].getCapacidade() + "GB");
        System.out.println("Armazenamento: " + this.hardwares[2].getNome() + " de " + this.hardwares[2].getCapacidade() + "GB");
        System.out.println("sistema Operacional: " + this.sistema.getNome() + " de " + this.sistema.getTipo() + " bits");

        if(this.memoria == null){
            System.out.println("Armazenamento externo: Não incluido");
        }else{
            System.out.println("Armazenamento externo: " + this.memoria.getNome() + " de " + this.memoria.getCapacidade() + "GB");
        }
    }

    //Metodo para adicionar uma memória externa. Depois que instanciamos uma memoria em Main, usamos esse metodo
    //para adicioná-la ao computador
    public void addMemoriaUSB(MemoriaUSB musb){
        this.memoria = musb;
    }

    //metodos Getters
    public float getPreco(){
        return this.preco;  //Necessário para calcular o valor total na classe pcmania.model.pcmania.model.Cliente
    }
    public String getMarca(){
        return this.marca;  //Necessário para o metodo mostrarComputadoresSelecionados() na classe pcmania.model.pcmania.model.Cliente
    }

    //Não vi necessidade de metodos setters nessa classe
}