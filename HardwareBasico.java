package pcmania.model;

public class HardwareBasico {

    private String nome;
    private float capacidade;

    //Construtor da classe
    public HardwareBasico(String nome, float capacidade){
        this.nome = nome;
        this.capacidade = capacidade;
    }

    //Métodos Getters
    public String getNome(){
        return this.nome;  //É útil para o metodo mostraPCConfigs() na classe pcmania.model.pcmania.model.Computador
    }
    public float getCapacidade(){
        return this.capacidade;  //É útil para o metodo mostraPCConfigs() na classe pcmania.model.pcmania.model.Computador
    }

    //Setters não foram necessários
}
