package br.com.contmatic.empresawilliam;

public class Empresa {

	private final static int TAMANHO_CNPJ = 14;
	private final static int TAMANHO_MINIMO_RAZAOSOCIAL = 4;
	private final static int TAMANHO_MAXIMO_RAZAOSOCIAL = 40;
	private final static int TAMANHO_MINIMO_ENDERECOS = 1;
	private final static int TAMANHO_MINIMO_PROPRIETARIO = 2;
	private final static int TAMANHO_MAXIMO_PROPRIETARIO = 50;
	private final static int TAMANHO_MINIMO_EMAIL = 7;
	private final static int TAMANHO_MAXIMO_EMAIL = 50;
	private final static int TAMANHO_MINIMO_TELEFONE = 1;
	private String razaoSocial;
	private String cnpj;
	private String proprietario;
	private String email;
	private Endereco[] enderecos;
	private Telefone[] telefones;

	// getters e setters
	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.verificaSeRazaoSocialNulo(razaoSocial);
		this.verificaSeRazaoSocialVazio(razaoSocial);
		this.verificaTamanhoRazaoSocial(razaoSocial);
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.verificaSeCnpjNulo(cnpj);
		this.verificaSeCnpjVazio(cnpj);
		this.verificaSeCnpjSoNumeros(cnpj);
		this.verificaSeCnpjValido(cnpj);
		this.cnpj = cnpj;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.verificaSeProprietarioNulo(proprietario);
		this.verificaSeProprietarioVazio(proprietario);
		this.verificaTamanhoProprietario(proprietario);
		this.proprietario = proprietario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.verificaSeEmailNulo(email);
		this.verificaSeEmailVazio(email);
		this.verificaTamanhoEmail(email);
		this.verificaSeEmailValido(email);
		this.email = email;
	}

	public Endereco[] getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Endereco[] enderecos) {
		this.enderecos = enderecos;
	}

	public Telefone[] getTelefones() {
		return telefones;
	}

	public void setTelefones(Telefone[] telefones) {
		this.telefones = telefones;
	}

	// verificações

	public void verificaSeRazaoSocialNulo(String razaoSocial) {
		if (razaoSocial == null) {
			throw new NullPointerException("A razão social deve ser preenchida.");
		}
	}

	public void verificaSeRazaoSocialVazio(String razaoSocial) {
		if (razaoSocial.equals("")) {
			throw new IllegalArgumentException("A razão social não pode ficar vazia.");
		}
	}
	
	public void verificaTamanhoRazaoSocial(String razaoSocial) {
		if (razaoSocial.length() < TAMANHO_MINIMO_RAZAOSOCIAL || razaoSocial.length() > TAMANHO_MAXIMO_RAZAOSOCIAL) {
			throw new IllegalArgumentException(
					"A razão social deve ter no mínimo 4 caracteres e no máximo 50 caracteres.");
		}
	}

	public void verificaSeCnpjNulo(String cnpj) {
		if (cnpj == null) {
			throw new NullPointerException("O cnpj deve ser preenchido.");
		}
	}

	public void verificaSeCnpjVazio(String cnpj) {
		if (cnpj.equals("")) {
			throw new IllegalArgumentException("O cnpj não pode ficar vazio.");
		}
	}

	public void verificaSeCnpjValido(String cnpj) {
		if (cnpj.length() != TAMANHO_CNPJ) {
			throw new IllegalArgumentException("Esse cnpj é inválido.");
		}
	}

	public boolean verificaSeCnpjSoNumeros(String cnpj) {
		for (int i = 0; i < cnpj.length();) {
			if (Character.isLetter(cnpj.charAt(i))) {
				throw new IllegalArgumentException("O cnpj só pode conter números.");
			} else
				i += 1;
		}
		return false;
	}

	public void verificaSeProprietarioNulo(String proprietario) {
		if (proprietario == null) {
			throw new NullPointerException("O nome de proprietário deve ser preenchido.");
		}
	}

	public void verificaSeProprietarioVazio(String proprietario) {
		if (proprietario.equals("")) {
			throw new IllegalArgumentException("O nome de proprietário não pode ficar vazio.");
		}
	}

	public void verificaTamanhoProprietario(String proprietario) {
		if (proprietario.length() < TAMANHO_MINIMO_PROPRIETARIO
				|| proprietario.length() > TAMANHO_MAXIMO_PROPRIETARIO) {
			throw new IllegalArgumentException(
					"O nome de proprietário deve ter no mínimo 2 caracteres e no máximo 50 caracteres.");
		}
	}

	public void verificaSeEmailNulo(String email) {
		if (email == null) {
			throw new NullPointerException("O email deve ser preenchido.");
		}
	}

	public void verificaSeEmailVazio(String email) {
		if (email.equals("")) {
			throw new IllegalArgumentException("O email não pode ficar vazio.");
		}
	}

	public void verificaTamanhoEmail(String email) {
		if (email.length() < TAMANHO_MINIMO_EMAIL || email.length() > TAMANHO_MAXIMO_EMAIL) {
			throw new IllegalArgumentException("O email deve ter no mínimo 7 caracteres e no máximo 50 caracteres.");
		}
	}

	public void verificaSeEmailValido(String email) {
		if (!proprietario.contains("@")) {
			throw new IllegalArgumentException("O email informado é inválido.");
		}
	}
}
