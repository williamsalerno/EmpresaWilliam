package br.com.contmatic.empresawilliam;

import static com.google.common.base.Preconditions.*;

public class Endereco {

	private final static int TAMANHO_NUMERO_DE_ENDERECO_MINIMO = 1;
	private final static int TAMANHO_NUMERO_DE_ENDERECO_MAXIMO = 9999;
	private final static int TAMANHO_TIPO_DE_LOGRADOURO_MINIMO = 3;
	private final static int TAMANHO_TIPO_DE_LOGRADOURO_MAXIMO = 10;
	private final static int TAMANHO_NOME_DE_LOGRADOURO_MAXIMO = 30;
	private final static int TAMANHO_CEP = 8;
	private int numeroEndereco;
	private String tipoLogradouro;
	private String nomeLogradouro;
	private String cep;
	private String tipoEndereco;

	// getters e setters
	public String getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(String tipoLogradouro) {
		this.validaTipoLogradouro(tipoLogradouro);
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getNomeLogradouro() {
		return nomeLogradouro;
	}

	public void setNomeLogradouro(String nomeLogradouro) {
		this.validaNomeLogradouro(nomeLogradouro);
		this.nomeLogradouro = nomeLogradouro;
	}

	public int getNumeroEndereco() {
		return numeroEndereco;
	}

	public void setNumeroEndereco(int numeroEndereco) {
		this.verificaSeNumeroEnderecoValido(numeroEndereco);
		this.numeroEndereco = numeroEndereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.validaCep(cep);
		this.cep = cep;
	}

	public String getTipoEndereco() {
		return tipoEndereco;
	}

	public void setTipoEndereco(String tipoEndereco) {
		this.validaTipoEndereco(tipoEndereco);
		this.tipoEndereco = tipoEndereco;
	}
	
	// validações
	public void validaTipoLogradouro(String tipoLogradouro){
		this.verificaSeTipoLogradouroNulo(tipoLogradouro);
		this.verificaSeTipoLogradouroVazio(tipoLogradouro);
		this.verificaSeTipoLogradouroValido(tipoLogradouro);
		this.verificaTamanhoTipoLogradouro(tipoLogradouro);
	}
	
	public void validaNomeLogradouro(String nomeLogradouro){
		this.verificaSeNomeLogradouroNulo(nomeLogradouro);
		this.verificaTamanhoNomeLogradouro(nomeLogradouro);
	}
	
	public void validaCep(String cep){
		this.verificaSeCepNulo(cep);
		this.verificaSeCepVazio(cep);
		this.verificaSeCepValido(cep);
		this.verificaCepTamanho(cep);
	}
	
	public void validaTipoEndereco(String tipoEndereco){
		this.verificaSeTipoEnderecoNulo(tipoEndereco);
		this.verificaSeTipoEnderecoVazio(tipoEndereco);
		this.verificaSeTipoEnderecoValido(tipoEndereco);
	}

	// verificações
	public void verificaSeTipoLogradouroNulo(String tipoLogradouro) {
		checkNotNull(tipoLogradouro, "O tipo de logradouro deve ser preenchido.");
	}

	public void verificaSeTipoLogradouroVazio(String tipoLogradouro) {
		checkArgument(!tipoLogradouro.equals(""), "O tipo de logradouro não pode ficar vazio.");
	}

	public void verificaTamanhoTipoLogradouro(String tipoLogradouro) {
		checkArgument(
				!(tipoLogradouro.length() < TAMANHO_TIPO_DE_LOGRADOURO_MINIMO
						|| tipoLogradouro.length() > TAMANHO_TIPO_DE_LOGRADOURO_MAXIMO),
				"O tipo de logradouro deve ter no mínimo 3 caracteres e no máximo 10 caracteres.");
	}

	public void verificaSeTipoLogradouroValido(String tipoLogradouro) {
		for (int i = 0; i < tipoLogradouro.length(); i++) {
			checkArgument(!Character.isDigit(tipoLogradouro.charAt(i)), "O tipo de logradouro deve ser válido.");
		}
	}

	public void verificaSeNomeLogradouroNulo(String nomeLogradouro) {
		checkNotNull(nomeLogradouro, "O nome de logradouro deve ser preenchido.");
	}

	public void verificaTamanhoNomeLogradouro(String nomeLogradouro) {
		checkArgument(!(nomeLogradouro.equals("") || nomeLogradouro.length() > TAMANHO_NOME_DE_LOGRADOURO_MAXIMO),
				"O nome de logradouro deve ter no mínimo 1 caracter e no máximo 30 caracteres.");
	}

	public void verificaSeNumeroEnderecoValido(int numeroEndereco) {
		checkArgument(!(numeroEndereco < TAMANHO_NUMERO_DE_ENDERECO_MINIMO
				|| numeroEndereco > TAMANHO_NUMERO_DE_ENDERECO_MAXIMO), "O número de endereço é inválido.");
	}

	public void verificaSeCepNulo(String cep) {
		checkNotNull(cep, "O CEP deve ser preenchido.");
	}

	public void verificaSeCepVazio(String cep) {
		checkArgument(!cep.equals(""), "O CEP não pode ficar vazio.");
	}

	public void verificaCepTamanho(String cep) {
		checkArgument(cep.length() == TAMANHO_CEP, "O CEP deve ter 8 dígitos.");
	}

	public void verificaSeCepValido(String cep) {
		for (int i = 0; i < cep.length(); i++) {
			checkArgument(!Character.isLetter(cep.charAt(i)), "O CEP só pode conter números.");
		}
	}
	
	public void verificaSeTipoEnderecoNulo(String tipoEndereco){
		checkNotNull(tipoEndereco, "O tipo de endereço deve ser preenchido.");
	}
	
	public void verificaSeTipoEnderecoVazio(String tipoEndereco){
		checkArgument(!tipoEndereco.equals(""), "O tipo de endereço não pode ficar vazio.");
	}
	
	public void verificaSeTipoEnderecoValido(String tipoEndereco){
		checkArgument(tipoEndereco.equals("Residencial") || tipoEndereco.equals("Comercial"), "O tipo de endereço deve ser ou residencial, ou comercial.");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
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
		Endereco other = (Endereco) obj;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Endereco [numeroEndereco=" + numeroEndereco + ", tipoLogradouro=" + tipoLogradouro + ", nomeLogradouro="
				+ nomeLogradouro + ", cep=" + cep + ", tipoEndereco=" + tipoEndereco + "]";
	}
	
	
}