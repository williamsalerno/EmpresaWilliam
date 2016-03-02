package br.com.contmatic.empresawilliam;

import static com.google.common.base.Preconditions.*;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author William
 *
 */
public class Endereco {

	/**
	 * Define um tamanho mínimo para número de endereço.
	 */
	public final static int TAMANHO_NUMERO_DE_ENDERECO_MINIMO = 1;

	/**
	 * Define um tamanho máximo para número de endereço.
	 */
	public final static int TAMANHO_NUMERO_DE_ENDERECO_MAXIMO = 9999;

	/**
	 * Define um tamanho mínimo para tipo de logradouro.
	 */
	public final static int TAMANHO_TIPO_DE_LOGRADOURO_MINIMO = 3;

	/**
	 * Define um tamanho máximo para tipo de logradouro.
	 */
	public final static int TAMANHO_TIPO_DE_LOGRADOURO_MAXIMO = 10;

	/**
	 * Define um tamanho máximo para nome de logradouro.
	 */
	public final static int TAMANHO_NOME_DE_LOGRADOURO_MAXIMO = 30;

	/**
	 * Define um tamanho específico para CEP.
	 */
	public final static int TAMANHO_CEP = 8;

	/**
	 * Número de endereço.
	 */
	private int numeroEndereco;

	/**
	 * Tipo de logradouro.
	 */
	private String tipoLogradouro;

	/**
	 * Nome de logradouro.
	 */
	private String nomeLogradouro;

	/**
	 * CEP.
	 */
	private String cep;

	/**
	 * Tipo de endereço.
	 */
	private String tipoEndereco;

	// getters e setters
	/**
	 * Obtém tipo de logradouro.
	 * 
	 * @return
	 */
	public String getTipoLogradouro() {
		return tipoLogradouro;
	}

	/**
	 * Determina um valor para tipo de logradouro e chama um método de
	 * validação.
	 * 
	 * @param tipoLogradouro
	 */
	public void setTipoLogradouro(String tipoLogradouro) {
		this.validaTipoLogradouro(tipoLogradouro);
		this.tipoLogradouro = tipoLogradouro;
	}

	/**
	 * Obtém nome de logradouro.
	 * 
	 * @return
	 */
	public String getNomeLogradouro() {
		return nomeLogradouro;
	}

	/**
	 * Determina um valor para nome de logradouro e chama um método de
	 * validação.
	 * 
	 * @param nomeLogradouro
	 */
	public void setNomeLogradouro(String nomeLogradouro) {
		this.validaNomeLogradouro(nomeLogradouro);
		this.nomeLogradouro = nomeLogradouro;
	}

	/**
	 * Obtém número de endereço.
	 * 
	 * @return
	 */
	public int getNumeroEndereco() {
		return numeroEndereco;
	}

	/**
	 * Determina um valor para número de endereço e chama um método de
	 * validação.
	 * 
	 * @param numeroEndereco
	 */
	public void setNumeroEndereco(int numeroEndereco) {
		this.verificaSeNumeroEnderecoValido(numeroEndereco);
		this.numeroEndereco = numeroEndereco;
	}

	/**
	 * Obtém CEP.
	 * 
	 * @return
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * Determina um valor para CEP e chama um método de validação.
	 * 
	 * @param cep
	 */
	public void setCep(String cep) {
		this.validaCep(cep);
		this.cep = cep;
	}

	/**
	 * Obtém tipo de endereço.
	 * 
	 * @return
	 */
	public String getTipoEndereco() {
		return tipoEndereco;
	}

	/**
	 * Determina um valor para tipo de endereço e chama um método de validação.
	 * 
	 * @param tipoEndereco
	 */
	public void setTipoEndereco(String tipoEndereco) {
		this.validaTipoEndereco(tipoEndereco);
		this.tipoEndereco = tipoEndereco;
	}

	// validações
	/**
	 * Verifica se tipo de logradouro possui um valor válido.
	 * 
	 * @param tipoLogradouro
	 */
	public void validaTipoLogradouro(String tipoLogradouro) {
		this.verificaSeTipoLogradouroNulo(tipoLogradouro);
		this.verificaSeTipoLogradouroVazio(tipoLogradouro);
		this.verificaSeTipoLogradouroValido(tipoLogradouro);
		this.verificaTamanhoTipoLogradouro(tipoLogradouro);
	}

	/**
	 * Verifica se nome de logradouro possui um valor válido.
	 * 
	 * @param nomeLogradouro
	 */
	public void validaNomeLogradouro(String nomeLogradouro) {
		this.verificaSeNomeLogradouroNulo(nomeLogradouro);
		this.verificaTamanhoNomeLogradouro(nomeLogradouro);
	}

	/**
	 * Verifica se CEP possui um valor válido.
	 * 
	 * @param cep
	 */
	public void validaCep(String cep) {
		this.verificaSeCepNulo(cep);
		this.verificaSeCepVazio(cep);
		this.verificaSeCepValido(cep);
		this.verificaCepTamanho(cep);
	}

	/**
	 * Verifica se tipo de endereço possui um valor válido.
	 * 
	 * @param tipoEndereco
	 */
	public void validaTipoEndereco(String tipoEndereco) {
		this.verificaSeTipoEnderecoNulo(tipoEndereco);
		this.verificaSeTipoEnderecoVazio(tipoEndereco);
		this.verificaSeTipoEnderecoValido(tipoEndereco);
	}

	// verificações
	/**
	 * Checa se tipo de logradouro é nulo.
	 * 
	 * @param tipoLogradouro
	 */
	public void verificaSeTipoLogradouroNulo(String tipoLogradouro) {
		checkNotNull(tipoLogradouro, "O tipo de logradouro deve ser preenchido.");
	}

	/**
	 * Checa se tipo de logradouro está vazio.
	 * 
	 * @param tipoLogradouro
	 */
	public void verificaSeTipoLogradouroVazio(String tipoLogradouro) {
		checkArgument(!tipoLogradouro.equals(""), "O tipo de logradouro não pode ficar vazio.");
	}

	/**
	 * Checa se tipo de logradouro está dentro dos limites de caracteres.
	 * 
	 * @param tipoLogradouro
	 */
	public void verificaTamanhoTipoLogradouro(String tipoLogradouro) {
		checkArgument(
				!(tipoLogradouro.length() < TAMANHO_TIPO_DE_LOGRADOURO_MINIMO
						|| tipoLogradouro.length() > TAMANHO_TIPO_DE_LOGRADOURO_MAXIMO),
				"O tipo de logradouro deve ter no mínimo 3 caracteres e no máximo 10 caracteres.");
	}

	/**
	 * Checa se tipo de logradouro só possui letras.
	 * 
	 * @param tipoLogradouro
	 */
	public void verificaSeTipoLogradouroValido(String tipoLogradouro) {
		for (int i = 0; i < tipoLogradouro.length(); i++) {
			checkArgument(!Character.isDigit(tipoLogradouro.charAt(i)), "O tipo de logradouro deve ser válido.");
		}
	}

	/**
	 * Checa se nome de logradouro é nulo.
	 * 
	 * @param nomeLogradouro
	 */
	public void verificaSeNomeLogradouroNulo(String nomeLogradouro) {
		checkNotNull(nomeLogradouro, "O nome de logradouro deve ser preenchido.");
	}

	/**
	 * Checa se nome de logradouro está dentro dos limites de caracteres.
	 * 
	 * @param nomeLogradouro
	 */
	public void verificaTamanhoNomeLogradouro(String nomeLogradouro) {
		checkArgument(!(nomeLogradouro.equals("") || nomeLogradouro.length() > TAMANHO_NOME_DE_LOGRADOURO_MAXIMO),
				"O nome de logradouro deve ter no mínimo 1 caracter e no máximo 30 caracteres.");
	}

	/**
	 * Checa se número de endereço tem o valor dentro dos limites.
	 * 
	 * @param numeroEndereco
	 */
	public void verificaSeNumeroEnderecoValido(int numeroEndereco) {
		checkArgument(!(numeroEndereco < TAMANHO_NUMERO_DE_ENDERECO_MINIMO
				|| numeroEndereco > TAMANHO_NUMERO_DE_ENDERECO_MAXIMO), "O número de endereço é inválido.");
	}

	/**
	 * Checa se CEP é nulo.
	 * 
	 * @param cep
	 */
	public void verificaSeCepNulo(String cep) {
		checkNotNull(cep, "O CEP deve ser preenchido.");
	}

	/**
	 * Checa se CEP está vazio.
	 * 
	 * @param cep
	 */
	public void verificaSeCepVazio(String cep) {
		checkArgument(!cep.equals(""), "O CEP não pode ficar vazio.");
	}

	/**
	 * Checa se CEP tem o tamanho de caracteres de acordo com o especificado.
	 * 
	 * @param cep
	 */
	public void verificaCepTamanho(String cep) {
		checkArgument(cep.length() == TAMANHO_CEP, "O CEP deve ter 8 dígitos.");
	}

	/**
	 * Checa se CEP só contém números.
	 * 
	 * @param cep
	 */
	public void verificaSeCepValido(String cep) {
		for (int i = 0; i < cep.length(); i++) {
			checkArgument(!Character.isLetter(cep.charAt(i)), "O CEP só pode conter números.");
		}
	}

	/**
	 * Checa se tipo de endereço é nulo.
	 * 
	 * @param tipoEndereco
	 */
	public void verificaSeTipoEnderecoNulo(String tipoEndereco) {
		checkNotNull(tipoEndereco, "O tipo de endereço deve ser preenchido.");
	}

	/**
	 * Checa se tipo de endereço está vazio.
	 * 
	 * @param tipoEndereco
	 */
	public void verificaSeTipoEnderecoVazio(String tipoEndereco) {
		checkArgument(!tipoEndereco.equals(""), "O tipo de endereço não pode ficar vazio.");
	}

	/**
	 * Checa se tipo de endereço é "Residencial" ou "Comercial" para ser
	 * validado.
	 * 
	 * @param tipoEndereco
	 */
	public void verificaSeTipoEnderecoValido(String tipoEndereco) {
		checkArgument(tipoEndereco.equals("Residencial") || tipoEndereco.equals("Comercial"),
				"O tipo de endereço deve ser ou residencial, ou comercial.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.cep).append(this.numeroEndereco).toHashCode();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Endereco)) {
			return false;
		}
		Endereco outro = (Endereco) obj;
		return new EqualsBuilder().append(this.cep, outro.cep).append(this.numeroEndereco, outro.numeroEndereco)
				.isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("tipo de logradouro: ", this.tipoLogradouro)
				.append("nome de logradouro: ", this.nomeLogradouro).append("número de endereço: ", this.numeroEndereco)
				.append("CEP: ", this.cep).append("Tipo de endereço: ", this.tipoEndereco).build();
	}

}