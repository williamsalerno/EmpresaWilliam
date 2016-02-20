package br.com.contmatic.empresawilliam;

public class Empresa {

	private final static int TAMANHO_CNPJ = 14;
	private String cnpj;

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
