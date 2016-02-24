package br.com.contmatic.empresawilliam;

import static org.hamcrest.CoreMatchers.*;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.rules.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmpresaTeste {

	private Empresa empresa;
	private Endereco[] enderecos;
	private Telefone[] telefones;
	private final String TESTE_CNPJ = "12345678912345";
	private final String TESTE_RAZAO_SOCIAL = "Teste";
	private final String TESTE_PROPRIETARIO = "Exemplo";
	private final String TESTE_EMAIL = "a@b.com";
	private static int contadorTeste = 0;

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	public Timeout globalTimeout = Timeout.seconds(1);

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Teste de Empresa realizado.");
	}

	@Before
	public void gerarEmpresa() {
		this.empresa = new Empresa();
		this.enderecos = new Endereco[2];
		this.telefones = new Telefone[2];
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
		empresa.setCnpj("12345678912345");
		assertThat(empresa.getCnpj(), is(TESTE_CNPJ));
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
		empresa.setProprietario("Exemplo");
		assertThat(empresa.getProprietario(), is(TESTE_PROPRIETARIO));
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
	
	//razão social
	@Test
	public void deve_ter_razaoSocial_valido() {
		empresa.setRazaoSocial("Teste");
		assertThat(empresa.getRazaoSocial(), is(TESTE_RAZAO_SOCIAL));
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
		empresa.setEmail(TESTE_EMAIL);
		assertThat(empresa.getEmail(), containsString("@"));
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

}