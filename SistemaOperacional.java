package pcmania.model;

public class SistemaOperacional {

    private String nome;
    private int tipo;

    //Construtor da classe
    public SistemaOperacional(String nomeRecebido, int tipoRecebido){
        this.nome = nomeRecebido;
        this.tipo = tipoRecebido;
    }

    //Métodos Getters
    public String getNome(){
        return this.nome;  //É útil para o metodo mostraPCConfigs() na classe pcmania.model.pcmania.model.Computador
    }
    public int getTipo(){
        return this.tipo;  //É útil para o metodo mostraPCConfigs() na classe pcmania.model.pcmania.model.Computador
    }

    //Setters não são necessários aqui
}
