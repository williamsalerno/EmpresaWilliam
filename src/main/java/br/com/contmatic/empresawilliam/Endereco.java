package br.com.contmatic.empresawilliam;

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
	private String[] tipoEndereco = { "Residencial", "Comercial" };

	// getters e setters
	public String getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(String tipoLogradouro) {
		this.verificaSeTipoLogradouroNulo(tipoLogradouro);
		this.verificaSeTipoLogradouroVazio(tipoLogradouro);
		this.verificaSeTipoLogradouroValido(tipoLogradouro);
		this.verificaTamanhoTipoLogradouro(tipoLogradouro);
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getNomeLogradouro() {
		return nomeLogradouro;
	}

	public void setNomeLogradouro(String nomeLogradouro) {
		this.verificaSeNomeLogradouroNulo(nomeLogradouro);
		this.verificaTamanhoNomeLogradouro(nomeLogradouro);
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
		this.verificaSeCepNulo(cep);
		this.verificaSeCepVazio(cep);
		this.verificaSeCepValido(cep);
		this.verificaCepTamanho(cep);
		this.cep = cep;
	}

	// verificações
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

	public void verificaTamanhoTipoLogradouro(String tipoLogradouro) {
		if (tipoLogradouro.length() < TAMANHO_TIPO_DE_LOGRADOURO_MINIMO
				|| tipoLogradouro.length() > TAMANHO_TIPO_DE_LOGRADOURO_MAXIMO) {
			throw new IllegalArgumentException(
					"O tipo de logradouro deve ter no mínimo 3 caracteres e no máximo 10 caracteres.");
		}
	}

	public boolean verificaSeTipoLogradouroValido(String tipoLogradouro) {
		for (int i = 0; i < tipoLogradouro.length();) {
			if (Character.isDigit(tipoLogradouro.charAt(i))) {
				throw new IllegalArgumentException("O tipo de logradouro deve ser válido.");
			} else
				i += 1;
			return true;

		}
		return false;

	}

	public void verificaSeNomeLogradouroNulo(String nomeLogradouro) {
		if (nomeLogradouro == null) {
			throw new NullPointerException("O nome de logradouro deve ser preenchido.");
		}
	}

	public void verificaTamanhoNomeLogradouro(String nomeLogradouro) {
		if (nomeLogradouro.equals("") || nomeLogradouro.length() > TAMANHO_NOME_DE_LOGRADOURO_MAXIMO) {
			throw new IllegalArgumentException(
					"O nome de logradouro deve ter no mínimo 1 caracter e no máximo 30 caracteres.");
		}
	}

	public boolean verificaSeNumeroEnderecoValido(int numeroEndereco) {
		if (numeroEndereco < TAMANHO_NUMERO_DE_ENDERECO_MINIMO || numeroEndereco > TAMANHO_NUMERO_DE_ENDERECO_MAXIMO) {
			throw new IllegalArgumentException("O número de endereço é inválido.");
		} else {
			return true;
		}
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

	public void verificaCepTamanho(String cep) {
		if (cep.length() != TAMANHO_CEP) {
			throw new IllegalArgumentException("O CEP deve ter 8 dígitos.");
		}
	}

	public boolean verificaSeCepValido(String cep) {
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