package br.com.contmatic.empresawilliam;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.builder.*;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

/**
 * The Class Telefone.
 *
 * @author williansalerno
 */
public class Telefone {

    /**
     * Define um tamanho mínimo para ddd.
     */
    private final static int TAMANHO_MINIMO_DDD = 11;

    /**
     * Define um tamanho máximo para ddd.
     */
    private final static int TAMANHO_MAXIMO_DDD = 99;

    /**
     * Tipo de telefone.
     */
    @NotNull(message = "O tipo de telefone deve ser preenchido.")
    private TelefoneType tipoTelefone;

    /**
     * DDD.
     */
    @Range(min = TAMANHO_MINIMO_DDD, max = TAMANHO_MAXIMO_DDD, message = "O número de DDD informado deve ser entre {min} e {max}.")
    private int ddd;

    /**
     * Número de telefone.
     */
    @NotNull(message = "O número de telefone deve ser informado.")
    @NotEmpty(message = "O número de telefone deve ser informado.")
    private String numeroTelefone;

    /**
     * Obtém tipo de telefone.
     *
     * @return the tipo telefone
     */
    public TelefoneType getTipoTelefone() {
        return tipoTelefone;
    }

    /**
     * Determina um valor para tipo de telefone e chama um método de verificação.
     *
     * @param tipoTelefone the new tipo telefone
     */
    public void setTipoTelefone(TelefoneType tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    /**
     * Obtém DDD.
     *
     * @return the ddd
     */
    public int getDdd() {
        return ddd;
    }

    /**
     * Determina um valor para DDD e chama um método de verificação.
     *
     * @param ddd the new ddd
     */
    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    /**
     * Obtém número de telefone.
     *
     * @return the numero telefone
     */
    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    /**
     * Determina um valor para número de telefone e chama um método de verificação.
     *
     * @param numeroTelefone the new numero telefone
     */
    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    // validações

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.ddd).append(this.tipoTelefone).append(this.numeroTelefone).toHashCode();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Telefone)) {
            return false;
        }
        Telefone outro = (Telefone) obj;
        return new EqualsBuilder().append(this.ddd, outro.ddd).append(this.tipoTelefone, outro.tipoTelefone).append(this.numeroTelefone, outro.numeroTelefone).isEquals();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("tipo de telefone: ", this.tipoTelefone).append("ddd: ", this.ddd).append("numero de telefone: ", this.numeroTelefone)
                .build();
    }

}
