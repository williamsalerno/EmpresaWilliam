package br.com.contmatic.empresawilliam;

/**
 * The Enum TelefoneType.
 */
public enum TelefoneType {

    /** The celular. */
    CELULAR("Celular", 9),
    /** The fixo. */
    FIXO("Fixo", 8);
    
    private String descricao;
    private int tamanho;
    
    private TelefoneType (String descricao, int tamanho){
        this.descricao = descricao;
        this.tamanho = tamanho;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
    
    public int getTamanho(){
        return this.tamanho;
    }


}
