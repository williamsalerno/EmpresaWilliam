package br.com.contmatic.empresawilliam;

import static br.com.contmatic.empresawilliam.util.ValidationUtil.hasErrors;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmpresaTeste {

    private Empresa empresa;
    private List<Endereco> enderecos, enderecoVazio, temUmEndereco;
    private List<Telefone> telefones, telefoneVazio, temUmTelefone;
    private LocalDate dataTesteOntem;
    private static int contadorTeste = 0;

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    public Timeout globalTimeout = Timeout.seconds(1);

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Teste de Empresa realizado.");
        FixtureFactoryLoader.loadTemplates("br.com.contmatic.empresawilliam.templates");
    }

    @Before
    public void gerarEmpresa() {
        empresa = new Empresa();
        this.empresa = Fixture.from(Empresa.class).gimme("empresa_valida");
        this.telefones = new ArrayList<>();
        this.enderecos = new ArrayList<>();
        this.enderecoVazio = new ArrayList<>();
        this.temUmEndereco = new ArrayList<>();
        this.telefoneVazio = new ArrayList<>();
        this.temUmTelefone = new ArrayList<>();

        Endereco end1 = new Endereco();
        end1 = Fixture.from(Endereco.class).gimme("endereco_valido");
        enderecos.add(end1);

        Endereco end2 = new Endereco();
        end2 = Fixture.from(Endereco.class).gimme("endereco_valido");
        enderecos.add(end2);

        Telefone tel1 = new Telefone();
        tel1 = Fixture.from(Telefone.class).gimme("fixo_valido");
        telefones.add(tel1);

        Telefone tel2 = new Telefone();
        tel2 = Fixture.from(Telefone.class).gimme("celular_valido");
        telefones.add(tel2);

        temUmEndereco.add(end1);
        temUmTelefone.add(tel1);

        empresa.setEnderecos(enderecos);
        empresa.setTelefones(telefones);

        this.dataTesteOntem = LocalDate.now().minusDays(1);
    }

    @After
    public void proximoTeste() {
        empresa = null;
        contadorTeste += 1;
    }

    @AfterClass
    public static void resultado() {
        System.out.println("Total de testes: " + contadorTeste);
    }

    @Test
    public void deve_ter_cnpj_valido() {
        assertThat(hasErrors(empresa, null), is(false));
    }

    @Test
    public void nao_deve_ter_cnpj_nulo() {
        empresa.setCnpj(null);
        assertTrue(hasErrors(empresa, "O cnpj deve ser preenchido."));
    }

    @Test
    public void nao_deve_ter_cnpj_vazio() {
        empresa.setCnpj("");
        assertTrue(hasErrors(empresa, "O cnpj não pode ficar vazio."));
    }

    @Test
    public void nao_deve_ter_cnpj_maior_que_limite() {
        empresa.setCnpj("12345678910123456");
        assertTrue(hasErrors(empresa, "CNPJ inválido. Deve conter 14 dígitos."));
    }

    @Test
    public void nao_deve_ter_cnpj_menor_que_limite() {
        empresa.setCnpj("1234567891123");
        assertTrue(hasErrors(empresa, "CNPJ inválido. Deve conter 14 dígitos."));
    }

    @Test(timeout = 1000)
    public void deve_ter_cnpj_so_com_numeros() {
        empresa.setCnpj("a");
        assertTrue(hasErrors(empresa, "CNPJ inválido. Só pode conter números."));
    }

    @Test
    public void deve_ter_proprietario_valido() {
        assertThat(hasErrors(empresa, null), is(false));
    }

    @Test
    public void nao_deve_ter_proprietario_nulo() {
        empresa.setProprietario(null);
        assertTrue(hasErrors(empresa, "O nome de proprietário deve ser preenchido."));
    }

    @Test
    public void nao_deve_ter_proprietario_vazio() {
        empresa.setProprietario("");
        assertTrue(hasErrors(empresa, "O nome de proprietário não pode ficar vazio."));
    }

    @Test
    public void nao_deve_ter_proprietario_menor_que_limite() {
        empresa.setProprietario("a");
        assertTrue(hasErrors(empresa, "O nome de proprietário deve conter entre 2 e 50 caracteres."));
    }

    @Test
    public void nao_deve_ter_proprietario_maior_que_limite() {
        empresa.setProprietario("123456789112345678921234567893123456789412345678951");
        assertTrue(hasErrors(empresa, "O nome de proprietário deve conter entre 2 e 50 caracteres."));
    }

    @Test
    public void deve_ter_razaoSocial_valido() {
        assertThat(hasErrors(empresa, null), is(false));
    }

    @Test
    public void nao_deve_ter_razaoSocial_nulo() {
        empresa.setRazaoSocial(null);
        assertTrue(hasErrors(empresa, "A razão social deve ser preenchida."));
    }

    @Test
    public void nao_deve_ter_razaoSocial_vazio() {
        empresa.setRazaoSocial("");
        assertTrue(hasErrors(empresa, "A razão social não pode ficar vazia."));
    }

    @Test
    public void nao_deve_ter_razaoSocial_menor_que_limite() {
        empresa.setRazaoSocial("ex");
        assertTrue(hasErrors(empresa, "A razão social deve conter entre 4 e 40 caracteres."));
    }

    @Test
    public void nao_deve_ter_razaoSocial_maior_que_limite() {
        empresa.setRazaoSocial("12345678911234567892123456789312345678941");
        assertTrue(hasErrors(empresa, "A razão social deve conter entre 4 e 40 caracteres."));
    }

    @Test
    public void deve_ter_email_valido() {
        assertThat(hasErrors(empresa, null), is(false));
    }

    @Test
    public void nao_deve_ter_email_nulo() {
        empresa.setEmail(null);
        assertTrue(hasErrors(empresa, "O email deve ser preenchido."));
    }

    @Test
    public void nao_deve_ter_email_vazio() {
        empresa.setEmail("");
        assertTrue(hasErrors(empresa, "O email não pode ficar vazio."));
    }

    @Test
    public void nao_deve_ter_email_email_menor_que_limite() {
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
        empresa.setEmail("_teste@teste.com.br");
        assertTrue(hasErrors(empresa, "O email informado é inválido."));
    }

    @Test
    public void deve_ter_endereco_valido() {
        assertThat(hasErrors(empresa, null), is(false));
    }

    @Test
    public void nao_deve_ter_endereco_nulo() {
        empresa.setEnderecos(null);
        assertTrue(hasErrors(empresa, "O endereço deve ser preenchido."));
    }

    @Test
    public void nao_deve_ter_endereco_vazio() {
        empresa.setEnderecos(enderecoVazio);
        assertTrue(hasErrors(empresa, "A empresa deve conter no mínimo 2 endereços."));
    }

    @Test
    public void nao_deve_ter_endereco_invalido() {
        empresa.setEnderecos(temUmEndereco);
        assertTrue(hasErrors(empresa, "A empresa deve conter no mínimo 2 endereços."));
    }

    @Test
    public void deve_ter_telefone_valido() {
        assertThat(hasErrors(empresa, null), is(false));
    }

    @Test
    public void nao_deve_ter_telefone_nulo() {
        empresa.setTelefones(null);
        assertTrue(hasErrors(empresa, "O telefone deve ser preenchido."));
    }

    @Test
    public void nao_deve_ter_telefone_vazio() {
        empresa.setTelefones(telefoneVazio);
        assertTrue(hasErrors(empresa, "A empresa deve conter no mínimo 2 telefones."));
    }

    @Test
    public void nao_deve_ter_telefone_invalido() {
        empresa.setTelefones(temUmTelefone);
        assertTrue(hasErrors(empresa, "A empresa deve conter no mínimo 2 telefones."));
    }

    @Test
    public void deve_ter_site_valido() {
        assertThat(hasErrors(empresa, null), is(false));
    }

    @Test
    public void nao_deve_ter_site_nulo() {
        empresa.setSite(null);
        assertTrue(hasErrors(empresa, "O site deve ser preenchido."));
    }

    @Test
    public void nao_deve_ter_site_vazio() {
        empresa.setSite("");
        assertTrue(hasErrors(empresa, "O site não pode ficar vazio."));
    }

    @Test
    public void nao_deve_ter_site_invalido() {
        empresa.setSite("exemplo");
        assertTrue(hasErrors(empresa, "Site inválido."));
    }

    @Test
    public void nao_deve_ter_site_menor_que_limite() {
        empresa.setSite("a.com");
        assertTrue(hasErrors(empresa, "O site deve conter entre 6 e 50 caracteres."));
    }

    @Test
    public void nao_deve_ter_site_maior_que_limite() {
        empresa.setSite("exemplotesteexemplotesteexemplotesteexemploteste.com");
        assertTrue(hasErrors(empresa, "O site deve conter entre 6 e 50 caracteres."));
    }

    @Test
    public void deve_ter_dataCriacao_valido() {
        assertThat(hasErrors(empresa, null), is(false));
    }

    @Test
    public void nao_deve_ter_dataCriacao_nulo() {
        empresa.setDataDeCriacao(null);
        assertTrue(hasErrors(empresa, "A data de criação deve ser preenchida."));
    }

    @Test
    public void nao_deve_ter_dataCriacao_posterior() {
        assertTrue(hasErrors(empresa, "Data de criação informada não pode ser posterior."));
    }

    @Test
    public void nao_deve_ter_dataCriacao_anterior() {
        empresa.setDataDeCriacao(dataTesteOntem);
        assertThat(hasErrors(empresa, "Data de criação informada não pode ser anterior."), is(false));
    }

    @Test
    public void nao_deve_ter_dataAlteracao_nulo() {
        empresa.setDataDeAlteracao(null);
        assertTrue(hasErrors(empresa, "A data de alteração deve ser preenchida."));
    }

    @Test
    public void deve_ter_dataAlteracao_posterior_a_criacao() {
        assertThat(hasErrors(empresa, null), is(false));
    }

    @Test
    public void nao_deve_ter_dataAlteracao_anterior_a_criacao() {
        empresa.setDataDeAlteracao(dataTesteOntem);
        assertThat(hasErrors(empresa, "A data de alteração deve ser posterior à data de criação."), is(false));
    }

    @Ignore
    @Test
    public void imprime_empresa_nulo() {
        System.out.println(this.empresa);
    }

    @Test
    public void nao_deve_aceitar_empresa_nulo() {
        System.out.println(empresa);
    }
}
