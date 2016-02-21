package br.com.contmatic.empresawilliam;

public class Empresa {

	private final static int TAMANHO_CNPJ = 14;
	private String cnpj;
	private String proprietario;
	private String razaoSocial;
	private Endereco endereco;

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.verificaSeRazaoSocialNulo(razaoSocial);
		this.verificaSeRazaoSocialVazio(razaoSocial);
		this.razaoSocial = razaoSocial;
	}
	
	public void verificaSeRazaoSocialNulo(String razaoSocial) {
		if (razaoSocial == null) {
			throw new NullPointerException("A razão social deve ser preenchida.");
		}
	}
	
	public void verificaSeRazaoSocialVazio(String razaoSocial) {
		if (razaoSocial == "") {
			throw new IllegalArgumentException("A razão social não pode ficar vazia.");
		}
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.verificaSeProprietarioNulo(proprietario);
		this.verificaSeProprietarioVazio(proprietario);
		this.proprietario = proprietario;
	}

	
	public void verificaSeProprietarioNulo(String proprietario) {
		if (proprietario == null) {
			throw new NullPointerException("O nome de proprietário deve ser preenchido.");
		}
	}
	
	public void verificaSeProprietarioVazio(String proprietario) {
		if (proprietario == "") {
			throw new IllegalArgumentException("O nome de proprietário não pode ficar vazio.");
		}
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
				i +=1;
		}
		return false;
	}

	public void verificaSeCnpjNulo(String cnpj) {
		if (cnpj == null) {
			throw new NullPointerException("O cnpj deve ser preenchido.");
		}
	}

	public void verificaSeCnpjVazio(String cnpj) {
		if (cnpj == "") {
			throw new IllegalArgumentException("O cnpj não pode ficar vazio.");
		}
	}

}
