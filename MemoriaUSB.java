package pcmania.model;

public class MemoriaUSB {

    private String nome;
    private int capacidade;

    //Construtor da classe
    public MemoriaUSB(String nomeRecebido, int capacidadeRecebida){
        this.nome = nomeRecebido;
        this.capacidade = capacidadeRecebida;
    }

    //Metodos Getters
    public String getNome(){
        return this.nome;  //É útil para o metodo mostraPCConfigs() na classe pcmania.model.pcmania.model.Computador
    }
    public int getCapacidade(){
        return this.capacidade;  //É útil para o metodo mostraPCConfigs() na classe pcmania.model.pcmania.model.Computador
    }

    //Setters não são necessários aqui
}
