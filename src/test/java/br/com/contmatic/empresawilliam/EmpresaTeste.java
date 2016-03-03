package br.com.contmatic.empresawilliam;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

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
	private Endereco[] enderecos, enderecoVazio, temUmEndereco;
	private Telefone[] telefones, telefoneVazio, temUmTelefone;
	private LocalDate dataTesteAtual;
	private LocalDate dataTesteAlteracao;
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
		this.enderecos = new Endereco[2];
		this.telefones = new Telefone[2];
		this.enderecoVazio = new Endereco[1];
		this.temUmEndereco = new Endereco[1];
		this.telefoneVazio = new Telefone[1];
		this.temUmTelefone = new Telefone[1];
		this.dataTesteAtual = LocalDate.now();
		this.dataTesteAlteracao = LocalDate.now().plusDays(300);
		this.dataTesteOntem = LocalDate.now().minusDays(1);

		Endereco end1 = new Endereco();
		end1 = Fixture.from(Endereco.class).gimme("valid");
		this.enderecos[0] = end1;

		Endereco end2 = new Endereco();
		end2 = Fixture.from(Endereco.class).gimme("valid");
		this.enderecos[1] = end2;

		Telefone tel1 = new Telefone();
		tel1 = Fixture.from(Telefone.class).gimme("fixo_valido");
		this.telefones[0] = tel1;

		Telefone tel2 = new Telefone();
		tel2 = Fixture.from(Telefone.class).gimme("celular_valido");
		this.telefones[1] = tel2;

		this.temUmEndereco[0] = end1;
		this.temUmTelefone[0] = tel1;
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
		empresa.validaCnpj(empresa.getCnpj());
	}

	@Test
	public void nao_deve_ter_cnpj_nulo() {
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("O cnpj deve ser preenchido.");
		empresa.setCnpj(null);
	}

	@Test
	public void nao_deve_ter_cnpj_vazio() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O cnpj não pode ficar vazio.");
		empresa.setCnpj("");
	}

	@Test
	public void nao_deve_ter_cnpj_maior_que_limite() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Esse cnpj é inválido.");
		empresa.setCnpj("12345678910123456");
	}

	@Test
	public void nao_deve_ter_cnpj_menor_que_limite() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Esse cnpj é inválido.");
		empresa.setCnpj("123456789101234");
	}

	@Test(timeout = 100)
	public void deve_ter_cnpj_so_com_numeros() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O cnpj só pode conter números.");
		empresa.setCnpj("a");
	}

	@Test
	public void deve_ter_proprietario_valido() {
		empresa.verificaTamanhoProprietario(empresa.getProprietario());
	}

	@Test
	public void nao_deve_ter_proprietario_nulo() {
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("O nome de proprietário deve ser preenchido.");
		empresa.setProprietario(null);
	}

	@Test
	public void nao_deve_ter_proprietario_vazio() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O nome de proprietário não pode ficar vazio.");
		empresa.setProprietario("");
	}

	@Test
	public void nao_deve_ter_proprietario_menor_que_limite() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O nome de proprietário deve ter no mínimo 2 caracteres e no máximo 50 caracteres.");
		empresa.setProprietario("a");
	}

	@Test
	public void nao_deve_ter_proprietario_maior_que_limite() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O nome de proprietário deve ter no mínimo 2 caracteres e no máximo 50 caracteres.");
		empresa.setProprietario("123456789112345678921234567893123456789412345678951");
	}

	// razão social
	@Test
	public void deve_ter_razaoSocial_valido() {
		empresa.verificaTamanhoRazaoSocial(empresa.getRazaoSocial());
	}

	@Test
	public void nao_deve_ter_razaoSocial_nulo() {
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("A razão social deve ser preenchida.");
		empresa.setRazaoSocial(null);
	}

	@Test
	public void nao_deve_ter_razaoSocial_vazio() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("A razão social não pode ficar vazia.");
		empresa.setRazaoSocial("");
	}

	@Test
	public void nao_deve_ter_razaoSocial_menor_que_limite() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("A razão social deve ter no mínimo 4 caracteres e no máximo 50 caracteres.");
		empresa.setRazaoSocial("ex");
	}

	@Test
	public void nao_deve_ter_razaoSocial_maior_que_limite() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("A razão social deve ter no mínimo 4 caracteres e no máximo 50 caracteres.");
		empresa.setRazaoSocial("123456789112345678921234567893123456789412345678951");
	}

	@Test
	public void deve_ter_email_valido() {
		empresa.verificaSeEmailValido(empresa.getEmail());
	}

	@Test
	public void nao_deve_ter_email_nulo() {
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("O email deve ser preenchido.");
		empresa.setEmail(null);
	}

	@Test
	public void nao_deve_ter_email_vazio() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O email não pode ficar vazio.");
		empresa.setEmail("");
	}

	@Test
	public void nao_deve_ter_email_email_menor_que_limite() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O email deve ter no mínimo 7 caracteres e no máximo 50 caracteres.");
		empresa.setEmail("a@a.co");
	}

	@Test
	public void nao_deve_ter_email_maior_que_limite() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O email deve ter no mínimo 7 caracteres e no máximo 50 caracteres.");
		empresa.setEmail("123456789112345678921234567893123456789412345678951@");
	}

	@Test
	public void nao_deve_ter_email_invalido() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O email informado é inválido.");
		empresa.setEmail("abcdefgh");
	}

	@Test
	public void deve_ter_endereco_valido() {
		empresa.setEnderecos(enderecos);
		assertThat(empresa.getEnderecos(), is(enderecos));
	}

	@Test
	public void nao_deve_ter_endereco_nulo() {
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("O endereço deve ser preenchido.");
		empresa.setEnderecos(null);
	}

	@Test
	public void nao_deve_ter_endereco_vazio() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("A empresa deve ter no mínimo 2 endereços.");
		empresa.setEnderecos(enderecoVazio);
	}

	@Test
	public void nao_deve_ter_endereco_invalido() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("A empresa deve ter no mínimo 2 endereços.");
		empresa.setEnderecos(temUmEndereco);
	}

	@Test
	public void deve_ter_telefone_valido() {
		empresa.setTelefones(telefones);
		assertThat(empresa.getTelefones(), is(telefones));
	}

	@Test
	public void nao_deve_ter_telefone_nulo() {
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("O telefone deve ser preenchido.");
		empresa.setTelefones(null);
	}

	@Test
	public void nao_deve_ter_telefone_vazio() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("A empresa deve ter no mínimo 2 telefones.");
		empresa.setTelefones(telefoneVazio);
	}

	@Test
	public void nao_deve_ter_telefone_invalido() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("A empresa deve ter no mínimo 2 telefones.");
		empresa.setTelefones(temUmTelefone);
	}

	@Test
	public void deve_ter_site_valido() {
		empresa.verificaSeSiteValido(empresa.getSite());
	}

	@Test
	public void nao_deve_ter_site_nulo() {
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("O site deve ser preenchido.");
		empresa.setSite(null);
	}

	@Test
	public void nao_deve_ter_site_vazio() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O site não pode ficar vazio.");
		empresa.setSite("");
	}

	@Test
	public void nao_deve_ter_site_invalido() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Site inválido.");
		empresa.setSite("exemplo");
	}

	@Test
	public void nao_deve_ter_site_menor_que_limite() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O site deve ter entre 6 e 50 caracteres.");
		empresa.setSite("a.com");
	}

	@Test
	public void nao_deve_ter_site_maior_que_limite() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O site deve ter entre 6 e 50 caracteres.");
		empresa.setSite("exemplotesteexemplotesteexemplotesteexemploteste.com");
	}

	@Test
	public void deve_ter_dataCriacao_valido() {
		empresa.setDataDeCriacao(dataTesteAtual);
		assertThat(empresa.getDataDeCriacao(), is(dataTesteAtual));
	}

	@Test
	public void nao_deve_ter_dataCriacao_nulo() {
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("Por gentileza informar uma data de criação.");
		empresa.setDataDeCriacao(null);
	}

	@Test
	public void nao_deve_ter_dataCriacao_posterior() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Data de criação informada não pode ser posterior.");
		empresa.setDataDeCriacao(dataTesteAlteracao);
	}

	@Test
	public void nao_deve_ter_dataCriacao_anterior() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Data de criação informada não pode ser anterior.");
		empresa.setDataDeCriacao(dataTesteOntem);
	}

	@Test
	public void nao_deve_ter_dataAlteracao_nulo() {
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("A data de alteração deve ser preenchida.");
		empresa.setDataDeAlteracao(null);
	}

	@Test
	public void deve_ter_dataAlteracao_posterior_a_criacao() {
		empresa.setDataDeAlteracao(dataTesteAlteracao);
		assertTrue(empresa.getDataDeAlteracao().isAfter(dataTesteAtual));
	}

	@Test
	public void nao_deve_ter_dataAlteracao_anterior_a_criacao() {
		thrown.expect(IllegalStateException.class);
		thrown.expectMessage("A data de alteração deve ser posterior à data de criação.");
		empresa.setDataDeAlteracao(dataTesteOntem);
	}

	@Ignore
	@Test
	public void imprime_empresa_nulo() {
		System.out.println(empresa);
	}

	@Test
	public void nao_deve_ter_empresa_nulo() {
		Empresa empresa = new Empresa();
		System.out.println(empresa.toString());
	}
}