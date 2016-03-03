package br.com.contmatic.empresawilliam;

import static br.com.contmatic.empresawilliam.TelefoneType.CELULAR;
import static br.com.contmatic.empresawilliam.TelefoneType.FIXO;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

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
    private TelefoneType tipoTelefone;

    /**
     * DDD.
     */
    private int ddd;

    /**
     * Número de telefone.
     */
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
        this.validaTipoTelefone(tipoTelefone);
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
        this.verificaSeDddValido(ddd);
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
        this.validaNumeroTelefone(numeroTelefone);
        this.numeroTelefone = numeroTelefone;
    }

    // validações
    /**
     * Verifica se tipo de telefone tem valor válido.
     *
     * @param tipoTelefone the tipo telefone
     */
    public void validaTipoTelefone(TelefoneType tipoTelefone) {
        this.verificaSeTipoTelefoneNulo(tipoTelefone);
    }

    /**
     * Verifica se número de telefone tem valor válido.
     *
     * @param numeroTelefone the numero telefone
     */
    public void validaNumeroTelefone(String numeroTelefone) {
        this.verificaSeNumeroTelefoneNulo(numeroTelefone);
        this.verificaSeNumeroTelefoneVazio(numeroTelefone);
        this.verificaSeNumeroTelefoneValido(numeroTelefone);
    }

    // verificações
    /**
     * Checa se tipo de telefone é nulo.
     *
     * @param tipoTelefone the tipo telefone
     */
    public void verificaSeTipoTelefoneNulo(TelefoneType tipoTelefone) {
        checkNotNull(tipoTelefone, "O tipo de telefone deve ser preenchido.");
    }

    /**
     * Checa se tipo de telefone está vazio.
     *
     * @param tipoTelefone the tipo telefone
     */
    public void verificaSeTipoTelefoneVazio(TelefoneType tipoTelefone) {
        checkArgument(!tipoTelefone.equals(""), "O tipo de telefone não pode ficar vazio.");
    }

    /**
     * Checa se DDD está dentro dos limites de valores para ser validado.
     *
     * @param ddd the ddd
     */
    public void verificaSeDddValido(int ddd) {
        checkArgument(!(ddd < TAMANHO_MINIMO_DDD || ddd > TAMANHO_MAXIMO_DDD), "O número de DDD informado deve ser entre 11 e 99");
    }

    /**
     * Checa se número de telefone é nulo.
     *
     * @param numeroTelefone the numero telefone
     */
    public void verificaSeNumeroTelefoneNulo(String numeroTelefone) {
        checkNotNull(numeroTelefone, "O número de telefone deve ser informado");
    }

    /**
     * Checa se número de telefone está nulo.
     *
     * @param numeroTelefone the numero telefone
     */
    public void verificaSeNumeroTelefoneVazio(String numeroTelefone) {
        checkArgument(!numeroTelefone.equals(""), "O número de telefone deve ser informado.");
    }

    /**
     * Checa se tipo "Fixo" tem 8 dígitos ou tipo "Celular" tem 9 dígitos.
     *
     * @param numeroTelefone the numero telefone
     */
    public void verificaSeNumeroTelefoneValido(String numeroTelefone) {
        checkState((this.tipoTelefone.equals(CELULAR) && numeroTelefone.length() == CELULAR.getTamanho()) || (this.tipoTelefone.equals(FIXO) && numeroTelefone.length() == FIXO.getTamanho()),
            "Para telefone fixo, por favor informar 8 dígitos. Para telefone celular, por favor informar 9 dígitos.");
    }

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
