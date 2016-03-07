package br.com.contmatic.empresawilliam;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CNPJ;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * The Class Empresa.
 *
 * @author williansalerno
 */
public class Empresa {

    // Constantes

    /** The Constant TAMANHO_CNPJ. */
    private final static int TAMANHO_CNPJ = 14;

    /** The Constant TAMANHO_MINIMO_RAZAOSOCIAL. */
    private final static int TAMANHO_MINIMO_RAZAOSOCIAL = 4;

    /** The Constant TAMANHO_MAXIMO_RAZAOSOCIAL. */
    private final static int TAMANHO_MAXIMO_RAZAOSOCIAL = 40;

    /** The Constant TAMANHO_MINIMO_PROPRIETARIO. */
    private final static int TAMANHO_MINIMO_PROPRIETARIO = 2;

    /** The Constant TAMANHO_MAXIMO_PROPRIETARIO. */
    private final static int TAMANHO_MAXIMO_PROPRIETARIO = 50;

    /** The Constant TAMANHO_MINIMO_EMAIL. */
    private final static int TAMANHO_MINIMO_EMAIL = 7;

    /** The Constant TAMANHO_MAXIMO_EMAIL. */
    private final static int TAMANHO_MAXIMO_EMAIL = 50;

    /** The Constant TAMANHO_MINIMO_ENDERECOS. */
    private final static int TAMANHO_MINIMO_ENDERECOS = 2;

    /** The Constant TAMANHO_MINIMO_TELEFONE. */
    private final static int TAMANHO_MINIMO_TELEFONE = 2;

    /** The Constant TAMANHO_MINIMO_SITE. */
    private final static int TAMANHO_MINIMO_SITE = 6;

    /** The Constant TAMANHO_MAXIMO_SITE. */
    private final static int TAMANHO_MAXIMO_SITE = 50;

    // Variáveis

    /** The cnpj. */
    @NotNull(message = "O cnpj deve ser preenchido.")
    @NotEmpty(message = "O cnpj não pode ficar vazio.")
    @Size(min = TAMANHO_CNPJ, max = TAMANHO_CNPJ, message = "CNPJ inválido. Deve conter {min} dígitos.")
    @CNPJ(message = "CNPJ inválido. Só pode conter números.")
    private String cnpj;

    /** The razao social. */
    @NotNull(message = "A razão social deve ser preenchida.")
    @NotEmpty(message = "A razão social não pode ficar vazia.")
    @Size(min = TAMANHO_MINIMO_RAZAOSOCIAL, max = TAMANHO_MAXIMO_RAZAOSOCIAL, message = "A razão social deve conter entre {min} e {max} caracteres.")
    private String razaoSocial;

    /** The proprietario. */
    @NotNull(message = "O nome de proprietário deve ser preenchido.")
    @NotEmpty(message = "O nome de proprietário não pode ficar vazio.")
    @Size(min = TAMANHO_MINIMO_PROPRIETARIO, max = TAMANHO_MAXIMO_PROPRIETARIO, message = "O nome de proprietário deve conter entre {min} e {max} caracteres.")
    private String proprietario;

    /** The email. */
    @NotNull(message = "O email deve ser preenchido.")
    @NotEmpty(message = "O email não pode ficar vazio.")
    @Size(min = TAMANHO_MINIMO_EMAIL, max = TAMANHO_MAXIMO_EMAIL, message = "O email deve conter entre {min} e {max} caracteres.")
    @Email(regexp = "@", message = "O email informado é inválido.")
    private String email;

    /** The enderecos. */
    @NotNull(message = "O endereço deve ser preenchido.")
    @NotEmpty(message = "A empresa deve conter no mínimo 2 endereços.")
    @Size(min = TAMANHO_MINIMO_ENDERECOS, message = "A empresa deve conter no mínimo {min} endereços.")
    @Valid
    private List<Endereco> enderecos;

    /** The telefones. */
    @NotNull(message = "O telefone deve ser preenchido.")
    @NotEmpty(message = "A empresa deve conter no mínimo 2 telefones.")
    @Size(min = TAMANHO_MINIMO_TELEFONE, message = "A empresa deve conter no mínimo {min} telefones.")
    @Valid
    private List<Telefone> telefones;

    /** The site. */
    @NotNull(message = "O site deve ser preenchido.")
    @NotEmpty(message = "O site não pode ficar vazio.")
    @Size(min = TAMANHO_MINIMO_SITE, max = TAMANHO_MAXIMO_SITE, message = "O site deve conter entre {min} e {max} caracteres.")
    @Pattern(regexp = ".", message = "Site inválido.")
    private String site;

    /** The data de criacao. */
    @NotNull(message = "A data de criação deve ser preenchida.")
    @Past(message = "Data de criação informada não pode ser anterior.")
    @Future(message = "Data de criação informada não pode ser posterior.")
    private LocalDate dataDeCriacao;

    /** The data de alteracao. */
    @NotNull(message = "A data de alteração deve ser preenchida.")
    @Past(message = "Data de alteração informada não pode ser anterior.")
    private LocalDate dataDeAlteracao;

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
        this.email = email;
    }

    /**
     * Obtém uma lista de endereços.
     *
     * @return the enderecos
     */
    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    /**
     * Determina referências de Endereços e chama um método de validação.
     *
     * @param enderecos the new enderecos
     */
    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    /**
     * Obtém uma lista de telefones.
     *
     * @return the telefones
     */
    public List<Telefone> getTelefones() {
        return telefones;
    }

    /**
     * Determina referências de Telefones e chama um método de validação.
     *
     * @param telefones the new telefones
     */
    public void setTelefones(List<Telefone> telefones) {
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
        this.site = site;
    }

    /**
     * Obtém data de criação.
     *
     * @return the data de criacao
     */
    public LocalDate getDataDeCriacao() {
        return dataDeCriacao;
    }

    /**
     * Determina um data de criação, chama um método de validação e depois um método de conversão de leitura da data ao usuário.
     *
     * @param dataDeCriacao the new data de criacao
     */
    public void setDataDeCriacao(LocalDate dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }

    /**
     * Obtém data de alteração.
     *
     * @return the data de alteracao
     */
    public LocalDate getDataDeAlteracao() {
        return dataDeAlteracao;
    }

    /**
     * Determina um data de alteração, chama um método de validação e depois um método de conversão de leitura da data ao usuário.
     *
     * @param dataDeAlteracao the new data de alteracao
     */
    public void setDataDeAlteracao(LocalDate dataDeAlteracao) {
        this.dataDeAlteracao = dataDeAlteracao;
    }

    /**
     * Converte a data de criação para uma leitura apropriada ao usuário.
     *
     * @param dataDeCriacao the data de criacao
     * @return the string
     */
    public String converteDataDeCriacao(LocalDate dataDeCriacao) {
        checkNotNull(dataDeCriacao, "A data de criação deve ser preenchida.");
        DateTimeFormatter dtf = DateTimeFormat.forPattern("dd/MM/yyyy");
        return dataDeCriacao.toString(dtf);
    }

    /**
     * Converte a data de alteração para uma leitura apropriada ao usuário.
     *
     * @param dataDeAlteracao the data de alteracao
     * @return the string
     */
    public String converteDataDeAlteracao(LocalDate dataDeAlteracao) {
        checkNotNull(dataDeAlteracao, "A data de alteração deve ser preenchida.");
        DateTimeFormatter dtf = DateTimeFormat.forPattern("dd/MM/yyyy");
        return dataDeAlteracao.toString(dtf);
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.cnpj).toHashCode();
    }

    /**
     * Equals.
     *
     * @param obj the obj
     * @return true, if successful
     */
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

    /**
     * To string.
     *
     * @return the string
     */
    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("Razão social: ", razaoSocial).append("Proprietário: ", proprietario).append("CNPJ", cnpj)
                .append("Endereço: ", enderecos.toArray()).append("Telefone: ", telefones.toArray()).append("Email: ", email).append("Site: ", site)
                .append("Data de criação: ", (converteDataDeCriacao(dataDeCriacao) != null) ? converteDataDeCriacao(dataDeCriacao) : null)
                .append("Data de alteração: ", (converteDataDeAlteracao(dataDeAlteracao) != null) ? converteDataDeAlteracao(dataDeAlteracao) : null).build();
    }

}
