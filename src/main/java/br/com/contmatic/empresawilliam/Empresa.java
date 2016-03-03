package br.com.contmatic.empresawilliam;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * The Class Empresa.
 *
 * @author williansalerno
 */
public class Empresa {

    // Constantes
    /**
     * Define um tamanho mínimo e máximo para o CNPJ.
     */
    private final static int TAMANHO_CNPJ = 14;

    /**
     * Define um tamanho mínimo para razão social.
     */
    private final static int TAMANHO_MINIMO_RAZAOSOCIAL = 4;

    /** The Constant TAMANHO_MAXIMO_RAZAOSOCIAL. */
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
     * Define um tamanho mínimo para a lista de telefones.
     */
    private final static int TAMANHO_MINIMO_TELEFONE = 2;

    /**
     * Define um tamanho mínimo para o site.
     */
    private final static int TAMANHO_MINIMO_SITE = 6;

    /**
     * Define um tamanho máximo para o site.
     */
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
     * Site.
     */
    private String site;

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

    /**
     * Data de alteração.
     */
    private Date dataDeAlteracao;

    /**
     * Instantiates a new empresa.
     */
    public Empresa() {
        new Date();
    }

    // getters e setters
    /**
     * Obtém a razão social.
     *
     * @return the razao social
     */
    public String getRazaoSocial() {
        return razaoSocial;
    }

    /**
     * Determina um valor para a razão social e chama um método de validação.
     *
     * @param razaoSocial the new razao social
     */
    public void setRazaoSocial(String razaoSocial) {
        this.validaRazaoSocial(razaoSocial);
        this.razaoSocial = razaoSocial;
    }

    /**
     * Obtém o CNPJ.
     *
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * Determina um valor para o CNPJ e chama um método de validação.
     *
     * @param cnpj the new cnpj
     */
    public void setCnpj(String cnpj) {
        this.validaCnpj(cnpj);
        this.cnpj = cnpj;
    }

    /**
     * Gets the proprietario.
     *
     * @return the proprietario
     */
    public String getProprietario() {
        return proprietario;
    }

    /**
     * Determina um valor para proprietário e chama um método de validação.
     *
     * @param proprietario the new proprietario
     */
    public void setProprietario(String proprietario) {
        this.validaProprietario(proprietario);
        this.proprietario = proprietario;
    }

    /**
     * Obtém email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Determina um valor para email e chama um método de validação.
     *
     * @param email the new email
     */
    public void setEmail(String email) {
        this.validaEmail(email);
        this.email = email;
    }

    /**
     * Obtém uma lista de endereços.
     *
     * @return the enderecos
     */
    public Endereco[] getEnderecos() {
        return enderecos;
    }

    /**
     * Determina referências de Endereços e chama um método de validação.
     *
     * @param enderecos the new enderecos
     */
    public void setEnderecos(Endereco[] enderecos) {
        this.validaEnderecos(enderecos);
        this.enderecos = enderecos;
    }

    /**
     * Obtém uma lista de telefones.
     *
     * @return the telefones
     */
    public Telefone[] getTelefones() {
        return telefones;
    }

    /**
     * Determina referências de Telefones e chama um método de validação.
     *
     * @param telefones the new telefones
     */
    public void setTelefones(Telefone[] telefones) {
        this.validaTelefones(telefones);
        this.telefones = telefones;
    }

    /**
     * Obtém site.
     *
     * @return the site
     */
    public String getSite() {
        return site;
    }

    /**
     * Determina um valor para site e chama um método de validação.
     *
     * @param site the new site
     */
    public void setSite(String site) {
        this.validaSite(site);
        this.site = site;
    }

    /**
     * Obtém data de criação.
     *
     * @return the data de criacao
     */
    public Date getDataDeCriacao() {
        return dataDeCriacao;
    }

    /**
     * Determina um data de criação, chama um método de validação e depois um método de conversão de leitura da data ao usuário.
     *
     * @param dataDeCriacao the new data de criacao
     */
    public void setDataDeCriacao(Date dataDeCriacao) {
        this.validaDataDeCriacao(dataDeCriacao);
        this.converteDataDeCriacao(dataDeCriacao);
        this.dataDeCriacao = dataDeCriacao;
    }

    /**
     * Obtém data de alteração.
     *
     * @return the data de alteracao
     */
    public Date getDataDeAlteracao() {
        return dataDeAlteracao;
    }

    /**
     * Determina um data de alteração, chama um método de validação e depois um método de conversão de leitura da data ao usuário.
     *
     * @param dataDeAlteracao the new data de alteracao
     */
    public void setDataDeAlteracao(Date dataDeAlteracao) {
        new Date();
        this.setDataDeCriacao(Date.from(Instant.now()));
        this.validaDataDeAlteracao(dataDeAlteracao);
        this.converteDataDeAlteracao(dataDeAlteracao);
        this.dataDeAlteracao = dataDeAlteracao;
    }

    // validações
    /**
     * Verifica se razão social possui um valor válido.
     *
     * @param razaoSocial the razao social
     */
    public void validaRazaoSocial(String razaoSocial) {
        this.verificaSeRazaoSocialNulo(razaoSocial);
        this.verificaSeRazaoSocialVazio(razaoSocial);
        this.verificaTamanhoRazaoSocial(razaoSocial);
    }

    /**
     * Verifica se CNPJ possui um valor válido.
     *
     * @param cnpj the cnpj
     */
    public void validaCnpj(String cnpj) {
        this.verificaSeCnpjNulo(cnpj);
        this.verificaSeCnpjVazio(cnpj);
        this.verificaSeCnpjSoNumeros(cnpj);
        this.verificaSeCnpjValido(cnpj);
    }

    /**
     * Verifica se proprietário possui um valor válido.
     *
     * @param proprietario the proprietario
     */
    public void validaProprietario(String proprietario) {
        this.verificaSeProprietarioNulo(proprietario);
        this.verificaSeProprietarioVazio(proprietario);
        this.verificaTamanhoProprietario(proprietario);
    }

    /**
     * Verifica se email possui um valor válido.
     *
     * @param email the email
     */
    public void validaEmail(String email) {
        this.verificaSeEmailNulo(email);
        this.verificaSeEmailVazio(email);
        this.verificaSeEmailValido(email);
        this.verificaTamanhoEmail(email);
    }

    /**
     * Verifica se site possui um valor válido.
     *
     * @param site the site
     */
    public void validaSite(String site) {
        this.verificaSeSiteNulo(site);
        this.verificaSeSiteVazio(site);
        this.verificaTamanhoSite(site);
        this.verificaSeSiteValido(site);
    }

    /**
     * Verifica se a lista de endereços possui referências válidas.
     *
     * @param enderecos the enderecos
     */
    public void validaEnderecos(Endereco[] enderecos) {
        this.verificaSeEnderecosNulo(enderecos);
        this.verificaSeEnderecosVazio(enderecos);
        this.verificaSeEnderecosValido(enderecos);
    }

    /**
     * Verifica se a lista de telefones possui referências válidas.
     *
     * @param telefones the telefones
     */
    public void validaTelefones(Telefone[] telefones) {
        this.verificaSeTelefonesNulo(telefones);
        this.verificaSeTelefonesVazio(telefones);
        this.verificaSeTelefonesValido(telefones);
    }

    /**
     * Verifica se data de criação possui um valor válido.
     *
     * @param dataDeCriacao the data de criacao
     */
    public void validaDataDeCriacao(Date dataDeCriacao) {
        this.verificaSeDataDeCriacaoNulo(dataDeCriacao);
        this.verificaSeDataDeCriacaoEAnterior(dataDeCriacao);
        this.verificaSeDataDeCriacaoEPosterior(dataDeCriacao);
    }

    /**
     * Verifica se data de alteração possui um valor válido.
     *
     * @param dataDeAlteracao the data de alteracao
     */
    public void validaDataDeAlteracao(Date dataDeAlteracao) {
        this.verificaSeDataDeAlteracaoNulo(dataDeAlteracao);
        this.verificaSeDataDeAlteracaoEAnteriorACriacao(dataDeAlteracao);
        this.verificaSeDataDeAlteracaoEPosteriorACriacao(dataDeAlteracao);
    }

    /**
     * Converte a data de alteração para uma leitura apropriada ao usuário.
     *
     * @param dataDeAlteracao the data de alteracao
     * @return the string
     */
    public String converteDataDeAlteracao(Date dataDeAlteracao) {
        this.verificaSeDataDeAlteracaoNulo(dataDeAlteracao);
        this.capturaDataDeAlteracao(dataDeAlteracao);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sdf.format(dataDeAlteracao);
    }

    /**
     * Converte a data de criação para uma leitura apropriada ao usuário.
     *
     * @param dataDeCriacao the data de criacao
     * @return the string
     */
    public String converteDataDeCriacao(Date dataDeCriacao) {
        this.verificaSeDataDeCriacaoNulo(dataDeCriacao);
        this.capturaDataDeCriacao(dataDeCriacao);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sdf.format(dataDeCriacao);
    }

    /**
     * Determina o dia, mês e ano atuais para a data de criação.
     *
     * @param dataDeCriacao the data de criacao
     * @return the date
     */
    @SuppressWarnings("deprecation")
    public Date capturaDataDeCriacao(Date dataDeCriacao) {
        dataDeCriacao.getDate();
        dataDeCriacao.getMonth();
        dataDeCriacao.getYear();
        Date data = dataDeCriacao;
        return data;
    }

    /**
     * Determina o dia, mês e ano atuais para a data de alteração.
     *
     * @param dataDeAlteracao the data de alteracao
     * @return the date
     */
    @SuppressWarnings("deprecation")
    public Date capturaDataDeAlteracao(Date dataDeAlteracao) {
        dataDeAlteracao.getDate();
        dataDeAlteracao.getMonth();
        dataDeAlteracao.getYear();
        Date data = dataDeAlteracao;
        return data;
    }

    // verificações
    /**
     * Checa se razão social é nulo.
     *
     * @param razaoSocial the razao social
     */
    public void verificaSeRazaoSocialNulo(String razaoSocial) {
        checkNotNull(razaoSocial, "A razão social deve ser preenchida.");
    }

    /**
     * Checa se razão social está vazio.
     *
     * @param razaoSocial the razao social
     */
    public void verificaSeRazaoSocialVazio(String razaoSocial) {
        checkArgument(!razaoSocial.equals(""), "A razão social não pode ficar vazia.");
    }

    /**
     * Checa se razão social está dentro do limite máximo e/ou mínimo de caracteres.
     *
     * @param razaoSocial the razao social
     */
    public void verificaTamanhoRazaoSocial(String razaoSocial) {
        checkArgument(!(razaoSocial.length() < TAMANHO_MINIMO_RAZAOSOCIAL || razaoSocial.length() > TAMANHO_MAXIMO_RAZAOSOCIAL),
            "A razão social deve ter no mínimo 4 caracteres e no máximo 50 caracteres.");
    }

    /**
     * Checa se CNPJ é nulo.
     *
     * @param cnpj the cnpj
     */
    public void verificaSeCnpjNulo(String cnpj) {
        checkNotNull(cnpj, "O cnpj deve ser preenchido.");
    }

    /**
     * Checa se CNPJ está vazio.
     *
     * @param cnpj the cnpj
     */
    public void verificaSeCnpjVazio(String cnpj) {
        checkArgument(!cnpj.equals(""), "O cnpj não pode ficar vazio.");
    }

    /**
     * Checa se CNPJ possui o número de caracteres determinado pela regra.
     *
     * @param cnpj the cnpj
     */
    public void verificaSeCnpjValido(String cnpj) {
        checkArgument(cnpj.length() == TAMANHO_CNPJ, "Esse cnpj é inválido.");
    }

    /**
     * Utiliza um laço para checar cada caracter do CNPJ para assegurar que só há números.
     *
     * @param cnpj the cnpj
     */
    public void verificaSeCnpjSoNumeros(String cnpj) {
        for(int i = 0 ; i < cnpj.length() ; i++) {
            checkArgument(!Character.isLetter(cnpj.charAt(i)), "O cnpj só pode conter números.");
        }
    }

    /**
     * Checa se proprietário é nulo.
     *
     * @param proprietario the proprietario
     */
    public void verificaSeProprietarioNulo(String proprietario) {
        checkNotNull(proprietario, "O nome de proprietário deve ser preenchido.");
    }

    /**
     * Checa se proprietário está vazio.
     *
     * @param proprietario the proprietario
     */
    public void verificaSeProprietarioVazio(String proprietario) {
        checkArgument(!proprietario.equals(""), "O nome de proprietário não pode ficar vazio.");
    }

    /**
     * Checa se proprietário está dentro do limite mínimo e/ou máximo de caracteres.
     *
     * @param proprietario the proprietario
     */
    public void verificaTamanhoProprietario(String proprietario) {
        checkArgument(!(proprietario.length() < TAMANHO_MINIMO_PROPRIETARIO || proprietario.length() > TAMANHO_MAXIMO_PROPRIETARIO),
            "O nome de proprietário deve ter no mínimo 2 caracteres e no máximo 50 caracteres.");
    }

    /**
     * Checa se email é nulo.
     *
     * @param email the email
     */
    public void verificaSeEmailNulo(String email) {
        checkNotNull(email, "O email deve ser preenchido.");
    }

    /**
     * Checa se email está vazio.
     *
     * @param email the email
     */
    public void verificaSeEmailVazio(String email) {
        checkArgument(!email.equals(""), "O email não pode ficar vazio.");
    }

    /**
     * Checa se email está dentro do limite mínimo e/ou máximo de caracteres.
     *
     * @param email the email
     */
    public void verificaTamanhoEmail(String email) {
        checkArgument(!(email.length() < TAMANHO_MINIMO_EMAIL || email.length() > TAMANHO_MAXIMO_EMAIL), "O email deve ter no mínimo 7 caracteres e no máximo 50 caracteres.");
    }

    /**
     * Checa se email possui um "@".
     *
     * @param email the email
     */
    public void verificaSeEmailValido(String email) {
        checkArgument(email.contains("@"), "O email informado é inválido.");
    }

    /**
     * Checa se site possui pelo menos um ponto.
     *
     * @param site the site
     */
    public void verificaSeSiteValido(String site) {
        checkArgument(site.contains("."), "Site inválido.");
    }

    /**
     * Checa se site é nulo.
     *
     * @param site the site
     */
    public void verificaSeSiteNulo(String site) {
        checkNotNull(site, "O site deve ser preenchido.");
    }

    /**
     * Checa se site é vazio.
     *
     * @param site the site
     */
    public void verificaSeSiteVazio(String site) {
        checkArgument(!site.equals(""), "O site não pode ficar vazio.");
    }

    /**
     * Checa se site contém caracteres dentro dos limites mínimo e máximo.
     *
     * @param site the site
     */
    public void verificaTamanhoSite(String site) {
        checkArgument(site.length() >= TAMANHO_MINIMO_SITE && site.length() <= TAMANHO_MAXIMO_SITE, "O site deve ter entre 6 e 50 caracteres.");
    }

    /**
     * Veirifica se a lista de endereços é nula.
     *
     * @param enderecos the enderecos
     */
    public void verificaSeEnderecosNulo(Endereco[] enderecos) {
        checkNotNull(enderecos, "O endereço deve ser preenchido.");
    }

    /**
     * Verifica se a lista de endereços está vazia.
     *
     * @param enderecos the enderecos
     */
    public void verificaSeEnderecosVazio(Endereco[] enderecos) {
        boolean naoVazio = false;
        for(int i = 0 ; i < enderecos.length ; i++) {
            if (enderecos[i] != null) {
                naoVazio = true;
            }
        }
        checkArgument(naoVazio, "A empresa deve ter no mínimo 2 endereços.");
    }

    /**
     * Verifica se a empresa tem o número mínimo de endereços para ser validada.
     *
     * @param enderecos the enderecos
     */
    public void verificaSeEnderecosValido(Endereco[] enderecos) {
        checkArgument(enderecos.length >= TAMANHO_MINIMO_ENDERECOS, "A empresa deve ter no mínimo 2 endereços.");
    }

    /**
     * Verifica se a lista de telefones é nula.
     *
     * @param telefones the telefones
     */
    public void verificaSeTelefonesNulo(Telefone[] telefones) {
        checkNotNull(telefones, "O telefone deve ser preenchido.");
    }

    /**
     * Verifica se a lista de telefones está vazia.
     *
     * @param telefones the telefones
     */
    public void verificaSeTelefonesVazio(Telefone[] telefones) {
        boolean naoVazio = false;
        for(int i = 0 ; i < telefones.length ; i++) {
            if (telefones[i] != null) {
                naoVazio = true;
            }
        }
        checkArgument(naoVazio, "A empresa deve ter no mínimo 2 telefones.");
    }

    /**
     * Verifica se a empresa tem o número mínimo de telefones para ser validada.
     *
     * @param telefones the telefones
     */
    public void verificaSeTelefonesValido(Telefone[] telefones) {
        checkArgument(telefones.length >= TAMANHO_MINIMO_TELEFONE, "A empresa deve ter no mínimo 2 telefones.");
    }

    /**
     * Checa se a data de criação da empresa é nula.
     *
     * @param dataDeCriacao the data de criacao
     */
    public void verificaSeDataDeCriacaoNulo(Date dataDeCriacao) {
        checkNotNull(dataDeCriacao, "Por gentileza informar uma data de criação.");
    }

    /**
     * Checa se a data de criação da empresa não é anterior à data atual.
     *
     * @param dataDeCriacao the data de criacao
     */
    public void verificaSeDataDeCriacaoEAnterior(Date dataDeCriacao) {
        checkArgument(!dataDeCriacao.before(Date.from(Instant.now())), "Data de criação informada não pode ser anterior.");
    }

    /**
     * Checa se a data de criação da empresa não é posterior à data atual.
     *
     * @param dataDeCriacao the data de criacao
     */
    public void verificaSeDataDeCriacaoEPosterior(Date dataDeCriacao) {
        new Date();
        checkArgument(!dataDeCriacao.after(Date.from(Instant.now())), "Data de criação informada não pode ser posterior.");
    }

    /**
     * Verifica se a data de alteração da empresa é nula.
     *
     * @param dataDeAlteracao the data de alteracao
     */
    public void verificaSeDataDeAlteracaoNulo(Date dataDeAlteracao) {
        checkNotNull(dataDeAlteracao, "A data de alteração deve ser preenchida.");
    }

    /**
     * Verifica se data de criação existe para uma data de alteração ser gerada.
     *
     * @param dataDeAlteracao the data de alteracao
     */
    public void verificaSeDataDeCriacaoExiste(Date dataDeAlteracao) {
        verificaSeDataDeCriacaoNulo(dataDeCriacao);
    }

    /**
     * Verifica se a data de alteração da empresa é não é anterior à data de criação dela.
     *
     * @param dataDeAlteracao the data de alteracao
     */
    public void verificaSeDataDeAlteracaoEAnteriorACriacao(Date dataDeAlteracao) {
        this.verificaSeDataDeCriacaoExiste(getDataDeCriacao());
        checkState(dataDeAlteracao.after(getDataDeCriacao()), "A data de alteração não pode ser anterior à data de criação.");
    }

    /**
     * Verifica se a data de alteração da empresa é posterior à data de criação dela. Precisa ser verdade para validar.
     *
     * @param dataDeAlteracao the data de alteracao
     */
    public void verificaSeDataDeAlteracaoEPosteriorACriacao(Date dataDeAlteracao) {
        checkState(dataDeAlteracao.after(getDataDeCriacao()), "A data de alteração deve ser posterior à data de criação.");
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.cnpj).toHashCode();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Empresa)) {
            return false;
        }
        Empresa outra = (Empresa) obj;
        return new EqualsBuilder().append(this.cnpj, outra.cnpj).isEquals();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("Razão social: ", razaoSocial).append("Proprietário: ", proprietario).append("\nCNPJ", cnpj)
                .append("Endereço: ", enderecos).append("Telefone: ", telefones).append("Email: ", this.telefones).append("\nSite: ", this.site)
                .append("Data de criação: ", (dataDeCriacao != null) ? converteDataDeCriacao(dataDeCriacao) : null)
                .append("Data de alteração: ", (dataDeAlteracao != null) ? converteDataDeAlteracao(dataDeAlteracao) : null).build();
    }

}
