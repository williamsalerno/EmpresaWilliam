package br.com.contmatic.empresawilliam;

public class Endereco {
	
	private final static int LIMITE_TAMANHO_NUMERO_DE_ENDERECO = 9999;
	private final static int TAMANHO_CEP = 8;
	private String tipoLogradouro;
	private String nomeLogradouro;
	private Integer numeroEndereco;
	private String cep;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getNumeroEndereco() {
		return numeroEndereco;
	}

	public void setNumeroEndereco(Integer numeroEndereco) {
		this.verificaSeNumeroEnderecoNulo(numeroEndereco);
		this.verificaSeNumeroEnderecoVazio(numeroEndereco);
		this.verificaNumeroEnderecoMaximo(numeroEndereco);
		this.numeroEndereco = numeroEndereco;
	}
	
	public void verificaSeNumeroEnderecoNulo(Integer numeroEndereco){
		if (numeroEndereco == null) {
			throw new NullPointerException("O número de endereço deve ser preenchido. Preencha com 0 se o seu endereço for s/n.");
		}
	}
	
	public void verificaSeNumeroEnderecoVazio(Integer numeroEndereco) {
		if (numeroEndereco.equals("")) {
			throw new NumberFormatException("O número de endereço não pode ficar vazio. Preencha com 0 se o seu endereço for s/n.");
		}
		if (numeroEndereco == 0) {
			this.setNomeLogradouro(this.nomeLogradouro + ", s/n");
		}
	}
	
	public boolean verificaNumeroEnderecoMaximo(Integer numeroEndereco){
		if (numeroEndereco > LIMITE_TAMANHO_NUMERO_DE_ENDERECO) {
			throw new IllegalArgumentException("O número de endereço excede o tamanho limite.");
		}
		else{
			return true;
		}
	}

	public String getNomeLogradouro() {
		return nomeLogradouro;
	}

	public void setNomeLogradouro(String nomeLogradouro) {
		this.verificaSeNomeLogradouroNulo(nomeLogradouro);
		this.nomeLogradouro = nomeLogradouro;
	}
	
	public void verificaSeNomeLogradouroNulo(String nomeLogradouro){
		if (nomeLogradouro == null) {
			throw new NullPointerException("O nome de logradouro deve ser preenchido.");
		}
	}
	
	public void verificaSeNomeLogradouroVazio(String nomeLogradouro) {
		if (nomeLogradouro == "") {
			throw new IllegalArgumentException("O nome de logradouro não pode ficar vazio.");
		}
	}

	public String getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(String tipoLogradouro) {
		this.verificaSeTipoLogradouroNulo(tipoLogradouro);
		this.verificaSeTipoLogradouroVazio(tipoLogradouro);
		this.verificaSeTipoLogradouroValido(tipoLogradouro);
		this.tipoLogradouro = tipoLogradouro;
	}
	
	public void verificaSeTipoLogradouroNulo(String tipoLogradouro){
		if (tipoLogradouro == null) {
			throw new NullPointerException("O tipo de logradouro deve ser preenchido.");
		}
	}
	
	public void verificaSeTipoLogradouroVazio(String tipoLogradouro) {
		if (tipoLogradouro == "") {
			throw new IllegalArgumentException("O tipo de logradouro não pode ficar vazio.");
		}
	}
	
	public boolean verificaSeTipoLogradouroValido(String tipoLogradouro) {
		for (int i = 0; i < tipoLogradouro.length();) {
			if (Character.isDigit(tipoLogradouro.charAt(i))) {
				throw new IllegalArgumentException("O tipo de logradouro deve ser válido.");
			} else
				i +=1;
		}
		return false;
	}

}
