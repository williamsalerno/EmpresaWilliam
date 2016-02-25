package br.com.contmatic.empresawilliam;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.text.*;
import java.util.Arrays;
import java.util.Date;

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
	private final static int TAMANHO_MINIMO_ENDERECOS = 2;
	
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
	private final static int TAMANHO_MINIMO_TELEFONE = 2;
	private final static int TAMANHO_MINIMO_SITE = 6;
	private final static int TAMANHO_MAXIMO_SITE = 50;
	
	
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
	 * Lista de endereços.
	 */
	private Endereco[] enderecos;
	
	/**
	 * Lista de telefones.
	 */
	private Telefone[] telefones;
	
	/**
	 * Data de criação.
	 */
	private Date dataDeCriacao;
	private Date dataDeAlteracao;
	private String site;
	
	private Date dataAtual = new Date();
	

	public Date getDataDeAlteracao() {
		return dataDeAlteracao;
	}

	public void setDataDeAlteracao(Date dataDeAlteracao) {
		this.dataDeAlteracao = dataDeAlteracao;
	}

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
	 * Determina um valor para a razão social e chama um método de validação.
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
	 * Determina um valor para o CNPJ e chama um método de validação.
	 * @param cnpj
	 */
	public void setCnpj(String cnpj) {
		this.validaCnpj(cnpj);
		this.cnpj = cnpj;
	}

	/**
	 * Obtém o proprietário.
	 * @return
	 */
	public String getProprietario() {
		return proprietario;
	}

	/**
	 * Determina um valor para proprietário e chama um método de validação.
	 * @param proprietario
	 */
	public void setProprietario(String proprietario) {
		this.validaProprietario(proprietario);
		this.proprietario = proprietario;
	}

	/**
	 * Obtém email.
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Determina um valor para email e chama um método de validação.
	 * @param email
	 */
	public void setEmail(String email) {
		this.validaEmail(email);
		this.email = email;
	}

	public Endereco[] getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Endereco[] enderecos) {
		this.validaEnderecos(enderecos);
		this.enderecos = enderecos;
	}

	public Telefone[] getTelefones() {
		return telefones;
	}

	public void setTelefones(Telefone[] telefones) {
		this.validaTelefones(telefones);
		this.telefones = telefones;
	}
	
	public String getSite(){
		return site;
	}
	
	public void setSite(String site){
		this.validaSite(site);
		this.site = site;
	}
	
	public Date getDataDeCriacao() {
		return dataDeCriacao;
	}

	public void setDataDeCriacao(Date dataDeCriacao) {
		this.validaData(dataDeCriacao);
		this.converteData(dataDeCriacao);
		this.dataDeCriacao = dataDeCriacao;
	}

	// validações
	/**
	 * Verifica se razão social possui um valor válido.
	 * @param razaoSocial
	 */
	public void validaRazaoSocial(String razaoSocial){
		this.verificaSeRazaoSocialNulo(razaoSocial);
		this.verificaSeRazaoSocialVazio(razaoSocial);
		this.verificaTamanhoRazaoSocial(razaoSocial);
	}
	
	/**
	 * Verifica se CNPJ possui um valor válido.
	 * @param cnpj
	 */
	public void validaCnpj(String cnpj){
		this.verificaSeCnpjNulo(cnpj);
		this.verificaSeCnpjVazio(cnpj);
		this.verificaSeCnpjSoNumeros(cnpj);
		this.verificaSeCnpjValido(cnpj);
	}
	
	/**
	 * Verifica se proprietário possui um valor válido.
	 * @param proprietario
	 */
	public void validaProprietario(String proprietario){
		this.verificaSeProprietarioNulo(proprietario);
		this.verificaSeProprietarioVazio(proprietario);
		this.verificaTamanhoProprietario(proprietario);
	}
	
	/**
	 * Verifica se email possui um valor válido.
	 * @param email
	 */
	public void validaEmail(String email){
		this.verificaSeEmailNulo(email);
		this.verificaSeEmailVazio(email);
		this.verificaSeEmailValido(email);
		this.verificaTamanhoEmail(email);
	}
	
	public void validaSite(String site){
		this.verificaSeSiteNulo(site);
		this.verificaSeSiteVazio(site);
		this.verificaTamanhoSite(site);
		this.verificaSeSiteValido(site);
	}
	
	public void validaData(Date dataDeCriacao){
		this.verificaSeDataDeCriacaoNulo(dataDeCriacao);
		this.verificaSeDataDeCriacaoEAnterior(dataDeCriacao);
		this.verificaSeDataDeCriacaoEPosterior(dataDeCriacao);
	}
	
	public String converteData(Date dataDeCriacao){
		this.capturaData(dataDeCriacao);
		String dataFormatada;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		dataFormatada = sdf.format(dataDeCriacao);
		return dataFormatada;
	}
	
	@SuppressWarnings("deprecation")
	public Date capturaData(Date dataDeCriacao){
		dataDeCriacao.getDate();
		dataDeCriacao.getMonth();
		dataDeCriacao.getYear();
		Date data = dataDeCriacao;
		return data;
	}
	
	public void validaEnderecos(Endereco[] enderecos){
		this.verificaSeEnderecosNulo(enderecos);
		this.verificaSeEnderecosVazio(enderecos);
		this.verificaSeEnderecosValido(enderecos);
	}
	
	public void validaTelefones(Telefone[] telefones){
		this.verificaSeTelefonesNulo(telefones);
		this.verificaSeTelefonesVazio(telefones);
		this.verificaSeTelefonesValido(telefones);
	}
	
	// verificações
	/**
	 * Checa se razão social é nulo.
	 * @param razaoSocial
	 */
	public void verificaSeRazaoSocialNulo(String razaoSocial) {
		checkNotNull(razaoSocial, "A razão social deve ser preenchida.");
	}

	/**
	 * Checa se razão social está vazio.
	 * @param razaoSocial
	 */
	public void verificaSeRazaoSocialVazio(String razaoSocial) {
		checkArgument(!razaoSocial.equals(""), "A razão social não pode ficar vazia.");
	}
	
	/**
	 * Checa se razão social está dentro do limite máximo e/ou mínimo de caracteres.
	 * @param razaoSocial
	 */
	public void verificaTamanhoRazaoSocial(String razaoSocial) {
		checkArgument(!(razaoSocial.length() < TAMANHO_MINIMO_RAZAOSOCIAL || razaoSocial.length() > TAMANHO_MAXIMO_RAZAOSOCIAL), "A razão social deve ter no mínimo 4 caracteres e no máximo 50 caracteres.");
	}

	/**
	 * Checa se CNPJ é nulo.
	 * @param cnpj
	 */
	public void verificaSeCnpjNulo(String cnpj) {
		checkNotNull(cnpj, "O cnpj deve ser preenchido.");
	}

	/**
	 * Checa se CNPJ está vazio.
	 * @param cnpj
	 */
	public void verificaSeCnpjVazio(String cnpj) {
		checkArgument(!cnpj.equals(""), "O cnpj não pode ficar vazio.");
	}
	
	/**
	 * Checa se CNPJ possui o número de caracteres determinado pela regra.
	 * @param cnpj
	 */
	public void verificaSeCnpjValido(String cnpj) {
		checkArgument(cnpj.length() == TAMANHO_CNPJ, "Esse cnpj é inválido.");
	}

	/**
	 * Utiliza um laço para checar cada caracter do CNPJ para assegurar que só há números.
	 * @param cnpj
	 */
	public void verificaSeCnpjSoNumeros(String cnpj) {
		for (int i = 0; i < cnpj.length(); i++) {
			checkArgument(!Character.isLetter(cnpj.charAt(i)), "O cnpj só pode conter números.");
		}
	}

	/**
	 * Checa se proprietário é nulo.
	 * @param proprietario
	 */
	public void verificaSeProprietarioNulo(String proprietario) {
		checkNotNull(proprietario, "O nome de proprietário deve ser preenchido.");
	}

	/**
	 * Checa se proprietário está vazio.
	 * @param proprietario
	 */
	public void verificaSeProprietarioVazio(String proprietario) {
		checkArgument(!proprietario.equals(""), "O nome de proprietário não pode ficar vazio.");
	}

	/**
	 * Checa se proprietário está dentro do limite mínimo e/ou máximo de caracteres.
	 * @param proprietario
	 */
	public void verificaTamanhoProprietario(String proprietario) {
		checkArgument(!(proprietario.length() < TAMANHO_MINIMO_PROPRIETARIO
				|| proprietario.length() > TAMANHO_MAXIMO_PROPRIETARIO), "O nome de proprietário deve ter no mínimo 2 caracteres e no máximo 50 caracteres.");
	}

	/**
	 * Checa se email é nulo.
	 * @param email
	 */
	public void verificaSeEmailNulo(String email) {
		checkNotNull(email, "O email deve ser preenchido.");
	}

	/**
	 * Checa se email está vazio.
	 * @param email
	 */
	public void verificaSeEmailVazio(String email) {
		checkArgument(!email.equals(""), "O email não pode ficar vazio.");
	}

	/**
	 * Checa se email está dentro do limite mínimo e/ou máximo de caracteres.
	 * @param email
	 */
	public void verificaTamanhoEmail(String email) {
		checkArgument(!(email.length() < TAMANHO_MINIMO_EMAIL || email.length() > TAMANHO_MAXIMO_EMAIL), "O email deve ter no mínimo 7 caracteres e no máximo 50 caracteres.");
	}

	/**
	 * Checa se email possui um "@".
	 * @param email
	 */
	public void verificaSeEmailValido(String email) {
		checkArgument(email.contains("@"), "O email informado é inválido.");
	}
	
	public void verificaSeSiteValido(String site){
		checkArgument(site.contains("."), "Site inválido.");
	}
	
	public void verificaSeSiteNulo(String site){
		checkNotNull(site, "O site deve ser preenchido.");
	}
	
	public void verificaSeSiteVazio(String site){
		checkArgument(!site.equals(""), "O site não pode ficar vazio.");
	}
	
	public void verificaTamanhoSite(String site){
		checkArgument(site.length() >= TAMANHO_MINIMO_SITE && site.length() <= TAMANHO_MAXIMO_SITE, "O site deve ter entre 6 e 50 caracteres.");
	}
	
	public void verificaSeDataDeCriacaoNulo(Date dataDeCriacao){
		checkNotNull(dataDeCriacao, "Por gentileza informar uma data.");
	}
	
	public void verificaSeDataDeCriacaoEAnterior(Date dataDeCriacao){
		checkArgument(!dataDeCriacao.before(dataAtual), "Data informada não pode ser anterior.");
	}
	
	public void verificaSeDataDeCriacaoEPosterior(Date dataDeCriacao){
		checkArgument(!dataDeCriacao.after(dataAtual), "Data informada não pode ser posterior.");
	}
	
	public void verificaSeEnderecosNulo(Endereco[] enderecos){
		checkNotNull(enderecos, "O endereço deve ser preenchido.");
	}
	
	public void verificaSeEnderecosVazio(Endereco[] enderecos){
		boolean naoVazio = false;
		for(int i = 0; i < enderecos.length; i++){
			if(enderecos[i] != null){
				naoVazio = true;
			}
		}
		checkArgument(naoVazio, "A empresa deve ter no mínimo 2 endereços.");
	}
	
	public void verificaSeEnderecosValido(Endereco[] enderecos){
		checkArgument(enderecos.length >= TAMANHO_MINIMO_ENDERECOS, "A empresa deve ter no mínimo 2 endereços.");
	}
	
	public void verificaSeTelefonesNulo(Telefone[] telefones){
		checkNotNull(telefones, "O telefone deve ser preenchido.");
	}
	
	public void verificaSeTelefonesVazio(Telefone[] telefones){
		boolean naoVazio = false;
		for(int i = 0; i < telefones.length; i++){
			if(telefones[i] != null){
				naoVazio = true;
			}
		}
		checkArgument(naoVazio, "A empresa deve ter no mínimo 2 telefones.");
	}
	
	public void verificaSeTelefonesValido(Telefone[] telefones){
		checkArgument(telefones.length >= TAMANHO_MINIMO_TELEFONE, "A empresa deve ter no mínimo 2 telefones.");
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
		return "Empresa [razaoSocial=" + razaoSocial + ", \ncnpj=" + cnpj + ", \nproprietario=" + proprietario + ", \nemail="
				+ email + ", \nenderecos=" + Arrays.toString(enderecos) + ", \ntelefones=" + Arrays.toString(telefones)
				+ ", \ndataDeCriacao=" + converteData(getDataDeCriacao()) + ", \ndataDeAlteracao=" + dataDeAlteracao + ", \nsite=" + site + "]";
	}
	
	
}
