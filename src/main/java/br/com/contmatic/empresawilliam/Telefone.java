package br.com.contmatic.empresawilliam;

import static com.google.common.base.Preconditions.*;

public class Telefone {

	/**
	 * Define um tamanho específico para celular.
	 */
	private final static int TAMANHO_CELULAR = 9;

	/**
	 * Define um tamanho específico para fixo.
	 */
	private final static int TAMANHO_FIXO = 8;

	/**
	 * Define um tamanho mínimo para ddd.
	 */
	private final static int TAMANHO_MINIMO_DDD = 1;

	/**
	 * Define um tamanho máximo para ddd.
	 */
	private final static int TAMANHO_MAXIMO_DDD = 99;

	/**
	 * Tipo de telefone.
	 */
	private String tipoTelefone;

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
	 * @return
	 */
	public String getTipoTelefone() {
		return tipoTelefone;
	}

	/**
	 * Determina um valor para tipo de telefone e chama um método de
	 * verificação.
	 * 
	 * @param tipoTelefone
	 */
	public void setTipoTelefone(String tipoTelefone) {
		this.validaTipoTelefone(tipoTelefone);
		this.tipoTelefone = tipoTelefone;
	}

	/**
	 * Obtém DDD.
	 * 
	 * @return
	 */
	public int getDdd() {
		return ddd;
	}

	/**
	 * Determina um valor para DDD e chama um método de verificação.
	 * 
	 * @param ddd
	 */
	public void setDdd(int ddd) {
		this.verificaSeDddValido(ddd);
		this.ddd = ddd;
	}

	/**
	 * Obtém número de telefone.
	 * 
	 * @return
	 */
	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	/**
	 * Determina um valor para número de telefone e chama um método de
	 * verificação.
	 * 
	 * @param numeroTelefone
	 */
	public void setNumeroTelefone(String numeroTelefone) {
		this.validaNumeroTelefone(numeroTelefone);
		this.numeroTelefone = numeroTelefone;
	}

	// validações
	/**
	 * Verifica se tipo de telefone tem valor válido.
	 * 
	 * @param tipoTelefone
	 */
	public void validaTipoTelefone(String tipoTelefone) {
		this.verificaSeTipoTelefoneNulo(tipoTelefone);
		this.verificaSeTipoTelefoneVazio(tipoTelefone);
		this.verificaSeTipoTelefoneValido(tipoTelefone);
	}

	/**
	 * Verifica se número de telefone tem valor válido.
	 * 
	 * @param numeroTelefone
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
	 * @param tipoTelefone
	 */
	public void verificaSeTipoTelefoneNulo(String tipoTelefone) {
		checkNotNull(tipoTelefone, "O tipo de telefone deve ser preenchido.");
	}

	/**
	 * Checa se tipo de telefone está vazio.
	 * 
	 * @param tipoTelefone
	 */
	public void verificaSeTipoTelefoneVazio(String tipoTelefone) {
		checkArgument(!tipoTelefone.equals(""), "O tipo de telefone não pode ficar vazio.");
	}

	/**
	 * Checa se tipo de telefone tem valor "Fixo" ou "Celular" para ser
	 * validado.
	 * 
	 * @param tipoTelefone
	 */
	public void verificaSeTipoTelefoneValido(String tipoTelefone) {
		checkArgument(tipoTelefone.equals("Fixo") || tipoTelefone.equals("Celular"),
				"O tipo de telefone precisa ser ou fixo, ou celular.");
	}

	/**
	 * Checa se DDD está dentro dos limites de valores para ser validado.
	 * 
	 * @param ddd
	 */
	public void verificaSeDddValido(int ddd) {
		checkArgument(!(ddd < TAMANHO_MINIMO_DDD || ddd > TAMANHO_MAXIMO_DDD),
				"O número de DDD informado deve ser entre 1 e 99");
	}

	/**
	 * Checa se número de telefone é nulo.
	 * 
	 * @param numeroTelefone
	 */
	public void verificaSeNumeroTelefoneNulo(String numeroTelefone) {
		checkNotNull(numeroTelefone, "O número de telefone deve ser informado");
	}

	/**
	 * Checa se número de telefone está nulo.
	 * 
	 * @param numeroTelefone
	 */
	public void verificaSeNumeroTelefoneVazio(String numeroTelefone) {
		checkArgument(!numeroTelefone.equals(""), "O número de telefone deve ser informado.");
	}

	/**
	 * Checa se tipo "Fixo" tem 8 dígitos ou tipo "Celular" tem 9 dígitos.
	 * 
	 * @param numeroTelefone
	 */
	public void verificaSeNumeroTelefoneValido(String numeroTelefone) {
		checkArgument(
				tipoTelefone.equals("Celular") && numeroTelefone.length() == TAMANHO_CELULAR
						|| (tipoTelefone.equals("Fixo") && numeroTelefone.length() == TAMANHO_FIXO),
				"Para telefone fixo, por favor informar 8 dígitos. Para telefone celular, por favor informar 9 dígitos.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroTelefone == null) ? 0 : numeroTelefone.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefone other = (Telefone) obj;
		if (numeroTelefone == null) {
			if (other.numeroTelefone != null)
				return false;
		} else if (!numeroTelefone.equals(other.numeroTelefone))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Telefone [tipoTelefone=" + tipoTelefone + ", ddd=" + ddd + ", numeroTelefone=" + numeroTelefone + "]";
	}

}
