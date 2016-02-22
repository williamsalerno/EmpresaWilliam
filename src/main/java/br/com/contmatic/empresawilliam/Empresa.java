package br.com.contmatic.empresawilliam;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Arrays;

public class Empresa {

	//Constantes
	
	/**
	 * Define um valor mínimo e máximo para o CNPJ.
	 */
	private final static int TAMANHO_CNPJ = 14;
	
	/**
	 * Define um valor mínimo para razão social.
	 */
	private final static int TAMANHO_MINIMO_RAZAOSOCIAL = 4;
	
	/**
	 * Define um tamanho máximo para razão social.
	 */
	private final static int TAMANHO_MAXIMO_RAZAOSOCIAL = 40;
	
	/**
	 * Define um tamanho mínimo para os endereços.
	 */
	private final static int TAMANHO_MINIMO_ENDERECOS = 1;
	
	/**
	 * Define um tamanho mínimo para o nome de proprietário.
	 */
	private final static int TAMANHO_MINIMO_PROPRIETARIO = 2;
	
	/**
	 * Define um tamanho máximo para o nome de proprietário.
	 */
	private final static int TAMANHO_MAXIMO_PROPRIETARIO = 50;
	
	/**
	 * Define um tamanho mínimo para o email.
	 */
	private final static int TAMANHO_MINIMO_EMAIL = 7;
	
	/**
	 * Define um tamanho máximo para o email.
	 */
	private final static int TAMANHO_MAXIMO_EMAIL = 50;
	
	/**
	 * Define um tamanho mínimo para os telefones.
	 */
	private final static int TAMANHO_MINIMO_TELEFONE = 1;
	
	// Variáveis
	
	/**
	 * Razão social.
	 */
	private String razaoSocial;
	
	/**
	 * CNPJ.
	 */
	private String cnpj;
	
	/**
	 * Proprietario.
	 */
	private String proprietario;
	
	/**
	 * Email.
	 */
	private String email;
	
	/**
	 * Lista de endere;os.
	 */
	private Endereco[] enderecos;
	
	/**
	 * Lista de telefones.
	 */
	private Telefone[] telefones;
	

	// getters e setters
	/**
	 * Obtém a razão social.
	 *
	 * @return
	 */
	public String getRazaoSocial() {
		return razaoSocial;
	}

	/**
	 * Determina um valor para a razão social e executa validações de valor.
	 * @param razaoSocial
	 */
	public void setRazaoSocial(String razaoSocial) {
		this.validaRazaoSocial(razaoSocial);
		this.razaoSocial = razaoSocial;
	}

	/**
	 * Obtém o CNPJ.
	 * @return
	 */
	public String getCnpj() {
		return cnpj;
	}

	/**
	 * Determina um valor para o CNPJ e executa validações de valor.
	 * @param cnpj
	 */
	public void setCnpj(String cnpj) {
		this.validaCnpj(cnpj);
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
		this.verificaSeEmailValido(email);
		this.verificaTamanhoEmail(email);
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

	public void validaRazaoSocial(String razaoSocial){
		this.verificaSeRazaoSocialNulo(razaoSocial);
		this.verificaSeRazaoSocialVazio(razaoSocial);
		this.verificaTamanhoRazaoSocial(razaoSocial);
	}
	
	public void validaCnpj(String cnpj){
		this.verificaSeCnpjNulo(cnpj);
		this.verificaSeCnpjVazio(cnpj);
		this.verificaSeCnpjSoNumeros(cnpj);
		this.verificaSeCnpjValido(cnpj);
	}
	
	public void verificaSeRazaoSocialNulo(String razaoSocial) {
		checkNotNull(razaoSocial, "A razão social deve ser preenchida.");
	}

	/**
	 * 
	 * @param razaoSocial
	 */
	public void verificaSeRazaoSocialVazio(String razaoSocial) {
		checkArgument(!razaoSocial.equals(""), "A razão social não pode ficar vazia.");
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
		if (!email.contains("@")) {
			throw new IllegalArgumentException("O email informado é inválido.");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
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
		Empresa other = (Empresa) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Empresa1 [razaoSocial=" + razaoSocial + ", cnpj=" + cnpj
				+ ", proprietario=" + proprietario + ", email=" + email
				+ ", enderecos=" + Arrays.toString(enderecos) + ", telefones="
				+ Arrays.toString(telefones) + "]";
	}
	
	
}
