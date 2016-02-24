package br.com.contmatic.empresawilliam;

import static com.google.common.base.Preconditions.*;

public class Telefone {

	private final static int TAMANHO_CELULAR = 9;
	private final static int TAMANHO_FIXO = 8;
	private final static int TAMANHO_MAXIMO_DDD = 99;
	private final static int TAMANHO_MINIMO_DDD = 1;

	private String tipoTelefone;
	private int ddd;
	private String numeroTelefone;

	public String getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(String tipoTelefone) {
		this.validaTipoTelefone(tipoTelefone);
		this.tipoTelefone = tipoTelefone;
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.verificaSeDddValido(ddd);
		this.ddd = ddd;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.validaNumeroTelefone(numeroTelefone);
		this.numeroTelefone = numeroTelefone;
	}

	// validações
	public void validaTipoTelefone(String tipoTelefone) {
		this.verificaSeTipoTelefoneNulo(tipoTelefone);
		this.verificaSeTipoTelefoneVazio(tipoTelefone);
		this.verificaSeTipoTelefoneValido(tipoTelefone);
	}

	public void validaNumeroTelefone(String numeroTelefone) {
		this.verificaSeNumeroTelefoneNulo(numeroTelefone);
		this.verificaSeNumeroTelefoneVazio(numeroTelefone);
		this.verificaSeNumeroTelefoneValido(numeroTelefone);
	}

	// verificações
	public void verificaSeTipoTelefoneNulo(String tipoTelefone) {
		checkNotNull(tipoTelefone, "O tipo de telefone deve ser preenchido.");
	}

	public void verificaSeTipoTelefoneVazio(String tipoTelefone) {
		checkArgument(!tipoTelefone.equals(""), "O tipo de telefone não pode ficar vazio.");
	}

	public void verificaSeTipoTelefoneValido(String tipoTelefone) {
		checkArgument(tipoTelefone.equals("Fixo") || tipoTelefone.equals("Celular"),
				"O tipo de telefone precisa ser ou fixo, ou celular.");
	}

	public void verificaSeDddValido(int ddd) {
		checkArgument(!(ddd < TAMANHO_MINIMO_DDD || ddd > TAMANHO_MAXIMO_DDD),
				"O número de DDD informado deve ser entre 1 e 99");
	}

	public void verificaSeNumeroTelefoneNulo(String numeroTelefone) {
		checkNotNull(numeroTelefone, "O número de telefone deve ser informado");
	}

	public void verificaSeNumeroTelefoneVazio(String numeroTelefone) {
		checkArgument(!numeroTelefone.equals(""), "O número de telefone deve ser informado.");
	}

	public void verificaSeNumeroTelefoneValido(String numeroTelefone) {
		checkArgument(tipoTelefone.equals("Celular") && numeroTelefone.length() == TAMANHO_CELULAR || (tipoTelefone.equals("Fixo") && numeroTelefone.length() == TAMANHO_FIXO),
				"Para telefone fixo, por favor informar 8 dígitos. Para telefone celular, por favor informar 9 dígitos.");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroTelefone == null) ? 0 : numeroTelefone.hashCode());
		return result;
	}

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

	@Override
	public String toString() {
		return "Telefone [tipoTelefone=" + tipoTelefone + ", ddd=" + ddd + ", numeroTelefone=" + numeroTelefone + "]";
	}
	
	
}
