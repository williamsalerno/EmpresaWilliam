package br.com.contmatic.empresawilliam;

public class Endereco {

	private final static int TAMANHO_NUMERO_DE_ENDERECO_MAXIMO = 9999;
	private final static int TAMANHO_TIPO_DE_LOGRADOURO_MINIMO = 3;
	private final static int TAMANHO_CEP = 8;
	private String tipoLogradouro;
	private String nomeLogradouro;
	private Integer numeroEndereco;
	private String cep;

	// tipoLogradouro
	public String getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(String tipoLogradouro) {
		this.verificaSeTipoLogradouroNulo(tipoLogradouro);
		this.verificaSeTipoLogradouroVazio(tipoLogradouro);
		this.verificaSeTipoLogradouroValido(tipoLogradouro);
		this.tipoLogradouro = tipoLogradouro;
	}

	public void verificaSeTipoLogradouroNulo(String tipoLogradouro) {
		if (tipoLogradouro == null) {
			throw new NullPointerException("O tipo de logradouro deve ser preenchido.");
		}
	}

	public void verificaSeTipoLogradouroVazio(String tipoLogradouro) {
		if (tipoLogradouro.equals("")) {
			throw new IllegalArgumentException("O tipo de logradouro não pode ficar vazio.");
		}
	}

	public boolean verificaSeTipoLogradouroValido(String tipoLogradouro) {
		for (int i = 0; i < tipoLogradouro.length();) {
			if (Character.isDigit(tipoLogradouro.charAt(i)) || tipoLogradouro.length() < TAMANHO_TIPO_DE_LOGRADOURO_MINIMO) {
				throw new IllegalArgumentException("O tipo de logradouro deve ser válido.");
			} else
				i += 1;
			return true;
		}
		return false;
	}

	// nomeLogradouro
	public String getNomeLogradouro() {
		return nomeLogradouro;
	}

	public void setNomeLogradouro(String nomeLogradouro) {
		this.verificaSeNomeLogradouroNulo(nomeLogradouro);
		this.verificaSeNomeLogradouroVazio(nomeLogradouro);
		this.nomeLogradouro = nomeLogradouro;
	}

	public void verificaSeNomeLogradouroNulo(String nomeLogradouro) {
		if (nomeLogradouro == null) {
			throw new NullPointerException("O nome de logradouro deve ser preenchido.");
		}
	}

	public void verificaSeNomeLogradouroVazio(String nomeLogradouro) {
		if (nomeLogradouro.equals("")) {
			throw new IllegalArgumentException("O nome de logradouro não pode ficar vazio.");
		}
	}

	// numeroEndereco
	public Integer getNumeroEndereco() {
		return numeroEndereco;
	}

	public void setNumeroEndereco(Integer numeroEndereco) {
		this.verificaSeNumeroEnderecoNulo(numeroEndereco);
		this.verificaSeNumeroEnderecoVazio(numeroEndereco);
		this.verificaNumeroEnderecoValido(numeroEndereco);
		this.numeroEndereco = numeroEndereco;
	}

	public void verificaSeNumeroEnderecoNulo(Integer numeroEndereco) {
		if (numeroEndereco == null) {
			throw new NullPointerException(
					"O número de endereço deve ser preenchido. Preencha com 0 se o seu endereço for s/n.");
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

	public boolean verificaNumeroEnderecoValido(Integer numeroEndereco) {
		if (numeroEndereco < 0 || numeroEndereco > TAMANHO_NUMERO_DE_ENDERECO_MAXIMO) {
			throw new IllegalArgumentException("O número de endereço é inválido.");
		} else {
			return true;
		}
	}

	// cep
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.verificaSeCepNulo(cep);
		this.verificaSeCepVazio(cep);
		this.verificaSeCepValido(cep);
		this.verificaSeCepContemLetras(cep);
		this.cep = cep;
	}

	public void verificaSeCepNulo(String cep) {
		if (cep == null) {
			throw new NullPointerException("O CEP deve ser preenchido.");
		}
	}
	
	public void verificaSeCepVazio(String cep) {
		if (cep.equals("")) {
			throw new IllegalArgumentException("O CEP não pode ficar vazio.");
		}
	}

	public void verificaSeCepValido(String cep) {
		if (cep.length() < TAMANHO_CEP || cep.length() > TAMANHO_CEP) {
			throw new IllegalArgumentException("O CEP deve ter 8 dígitos.");
		}
	}

	public boolean verificaSeCepContemLetras(String cep) {
		for (int i = 0; i < cep.length();) {
			if (Character.isLetter(cep.charAt(i))) {
				throw new IllegalArgumentException("O CEP só pode conter números.");
			} else
				i += 1;
			return false;
		}
		return true;
	}
}
