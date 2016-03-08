package br.com.contmatic.empresawilliam;

import static br.com.contmatic.empresawilliam.util.ValidationUtil.hasErrors;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

import org.joda.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmpresaTeste {

    private Empresa empresa, empresaInvalida;
    private LocalDate dataTesteOntem;


    @Rule
    public ExpectedException thrown = ExpectedException.none();
    public Timeout globalTimeout = Timeout.seconds(1);

    @BeforeClass
    public static void setUpBeforeClass() {
        FixtureFactoryLoader.loadTemplates("br.com.contmatic.empresawilliam.templates");
    }

    @Before
    public void setUp() {
        this.empresa = Fixture.from(Empresa.class).gimme("empresa_valida");
        this.empresaInvalida = Fixture.from(Empresa.class).gimme("empresa_invalida");
        this.dataTesteOntem = LocalDate.now().minusDays(1);
    }

    @After
    public void tearDown() {
        empresa = null;
    }

    @AfterClass
    public static void tearDownAfterClass() {
       System.out.println("Teste terminado.");
    }

    @Test
    public void deve_aceitar_cnpj_valido() {
        assertThat(hasErrors(empresa, null), is(false));
    }

    @Test
    public void nao_deve_aceitar_cnpj_nulo() {
        empresa.setCnpj(null);
        assertTrue(hasErrors(empresa, "O cnpj deve ser preenchido."));
    }

    @Test
    public void nao_deve_aceitar_cnpj_vazio() {
        empresa.setCnpj("");
        assertTrue(hasErrors(empresa, "O cnpj não pode ficar vazio."));
    }

    @Test
    public void nao_deve_aceitar_cnpj_maior_que_limite() {
        assertTrue(hasErrors(empresaInvalida, "CNPJ inválido. Deve conter 14 dígitos numéricos."));
    }

    @Test
    public void nao_deve_aceitar_cnpj_menor_que_limite() {
        assertTrue(hasErrors(empresaInvalida, "CNPJ inválido. Deve conter 14 dígitos numéricos."));
    }

    @Test(timeout = 1000)
    public void deve_aceitar_cnpj_so_com_numeros() {
        assertTrue(hasErrors(empresaInvalida, "CNPJ inválido. Deve conter 14 dígitos numéricos."));
    }

    @Test
    public void deve_aceitar_proprietario_valido() {
        assertThat(hasErrors(empresa, null), is(false));
    }

    @Test
    public void nao_deve_aceitar_proprietario_nulo() {
        empresa.setProprietario(null);
        assertTrue(hasErrors(empresa, "O nome de proprietário deve ser preenchido."));
    }

    @Test
    public void nao_deve_aceitar_proprietario_vazio() {
        empresa.setProprietario("");
        assertTrue(hasErrors(empresa, "O nome de proprietário não pode ficar vazio."));
    }

    @Test
    public void nao_deve_aceitar_proprietario_menor_que_limite() {
        empresa.setProprietario("a");
        assertTrue(hasErrors(empresa, "O nome de proprietário deve conter entre 2 e 50 caracteres."));
    }

    @Test
    public void nao_deve_aceitar_proprietario_maior_que_limite() {
        empresa.setProprietario("123456789112345678921234567893123456789412345678951");
        assertTrue(hasErrors(empresa, "O nome de proprietário deve conter entre 2 e 50 caracteres."));
    }

    @Test
    public void deve_aceitar_razaoSocial_valido() {
        assertThat(hasErrors(empresa, null), is(false));
    }

    @Test
    public void nao_deve_aceitar_razaoSocial_nulo() {
        empresa.setRazaoSocial(null);
        assertTrue(hasErrors(empresa, "A razão social deve ser preenchida."));
    }

    @Test
    public void nao_deve_aceitar_razaoSocial_vazio() {
        empresa.setRazaoSocial("");
        assertTrue(hasErrors(empresa, "A razão social não pode ficar vazia."));
    }

    @Test
    public void nao_deve_aceitar_razaoSocial_menor_que_limite() {
        empresa.setRazaoSocial("ex");
        assertTrue(hasErrors(empresa, "A razão social deve conter entre 4 e 40 caracteres."));
    }

    @Test
    public void nao_deve_aceitar_razaoSocial_maior_que_limite() {
        empresa.setRazaoSocial("12345678911234567892123456789312345678941");
        assertTrue(hasErrors(empresa, "A razão social deve conter entre 4 e 40 caracteres."));
    }

    @Test
    public void deve_aceitar_email_valido() {
        assertThat(hasErrors(empresa, null), is(false));
    }

    @Test
    public void nao_deve_aceitar_email_nulo() {
        empresa.setEmail(null);
        assertTrue(hasErrors(empresa, "O email deve ser preenchido."));
    }

    @Test
    public void nao_deve_aceitar_email_vazio() {
        empresa.setEmail("");
        assertTrue(hasErrors(empresa, "O email não pode ficar vazio."));
    }

    @Test
    public void nao_deve_aceitar_email_email_menor_que_limite() {
        empresa.setEmail("a@a.co");
        assertTrue(hasErrors(empresa, "O email deve conter entre 7 e 50 caracteres."));
    }

    @Test
    public void nao_deve_aceitar_email_maior_que_limite() {
        empresa.setEmail("123456789112345678921234567893123456789412345678951@");
        assertTrue(hasErrors(empresa, "O email deve conter entre 7 e 50 caracteres."));
    }

    @Test
    public void nao_deve_aceitar_email_invalido() {
        assertTrue(hasErrors(empresaInvalida, "O email informado é inválido."));
    }

    @Test
    public void deve_aceitar_endereco_valido() {
        assertThat(hasErrors(empresa, null), is(false));
    }

    @Test
    public void nao_deve_aceitar_endereco_nulo() {
        empresa.setEnderecos(null);
        assertTrue(hasErrors(empresa, "O endereço deve ser preenchido."));
    }

    @Test
    public void nao_deve_aceitar_endereco_vazio() {
        empresaInvalida.setEnderecos(null);
        assertTrue(hasErrors(empresaInvalida, "A empresa deve conter no mínimo 2 endereços."));
    }

    @Test
    public void nao_deve_aceitar_endereco_invalido() {
        assertTrue(hasErrors(empresaInvalida, "A empresa deve conter no mínimo 2 endereços."));
    }

    @Test
    public void deve_aceitar_telefone_valido() {
        assertThat(hasErrors(empresa, null), is(false));
    }

    @Test
    public void nao_deve_aceitar_telefone_nulo() {
        empresa.setTelefones(null);
        assertTrue(hasErrors(empresa, "O telefone deve ser preenchido."));
    }

    @Test
    public void nao_deve_aceitar_telefone_vazio() {
        empresa.setTelefones(null);
        assertTrue(hasErrors(empresaInvalida, "A empresa deve conter no mínimo 2 telefones."));
    }

    @Test
    public void nao_deve_aceitar_telefone_invalido() {
        assertTrue(hasErrors(empresaInvalida, "A empresa deve conter no mínimo 2 telefones."));
    }

    @Test
    public void deve_aceitar_site_valido() {
        assertThat(hasErrors(empresa, null), is(false));
    }

    @Test
    public void nao_deve_aceitar_site_nulo() {
        empresa.setSite(null);
        assertTrue(hasErrors(empresa, "O site deve ser preenchido."));
    }

    @Test
    public void nao_deve_aceitar_site_vazio() {
        empresa.setSite("");
        assertTrue(hasErrors(empresa, "O site não pode ficar vazio."));
    }

    @Test
    public void nao_deve_aceitar_site_invalido() {
        assertTrue(hasErrors(empresaInvalida, "Site inválido."));
    }

    @Test
    public void nao_deve_aceitar_site_menor_que_limite() {
        empresa.setSite("a.com");
        assertTrue(hasErrors(empresa, "O site deve conter entre 6 e 50 caracteres."));
    }

    @Test
    public void nao_deve_aceitar_site_maior_que_limite() {
        empresa.setSite("exemplotesteexemplotesteexemplotesteexemploteste.com");
        assertTrue(hasErrors(empresa, "O site deve conter entre 6 e 50 caracteres."));
    }

    @Test
    public void deve_aceitar_dataCriacao_valido() {
        assertThat(hasErrors(empresa, null), is(false));
    }

    @Test
    public void nao_deve_aceitar_dataCriacao_nulo() {
        empresa.setDataDeCriacao(null);
        assertTrue(hasErrors(empresa, "A data de criação deve ser preenchida."));
    }

    @Test
    public void nao_deve_aceitar_dataCriacao_posterior() {
        assertTrue(hasErrors(empresa, "Data de criação informada não pode ser posterior."));
    }

    @Test
    public void nao_deve_aceitar_dataCriacao_anterior() {
        empresa.setDataDeCriacao(dataTesteOntem);
        assertThat(hasErrors(empresa, "Data de criação informada não pode ser anterior."), is(false));
    }

    @Test
    public void nao_deve_aceitar_dataAlteracao_nulo() {
        empresa.setDataDeAlteracao(null);
        assertTrue(hasErrors(empresa, "A data de alteração deve ser preenchida."));
    }

    @Test
    public void deve_aceitar_dataAlteracao_posterior_a_criacao() {
        assertThat(hasErrors(empresa, null), is(false));
    }

    @Test
    public void nao_deve_aceitar_dataAlteracao_anterior_a_criacao() {
        empresa.setDataDeAlteracao(dataTesteOntem);
        assertThat(hasErrors(empresa, "A data de alteração deve ser posterior à data de criação."), is(false));
    }

    @Test
    public void deve_imprimir_empresa_nulo() {
        empresa = null;
        System.out.println(this.empresa);
    }

    @Test
    public void nao_deve_aceitar_empresa_nulo() {
        System.out.println(empresa);
    }
}
