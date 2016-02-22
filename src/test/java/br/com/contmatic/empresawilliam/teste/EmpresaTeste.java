package br.com.contmatic.empresawilliam.teste;

import br.com.contmatic.empresawilliam.Empresa;

import static org.hamcrest.CoreMatchers.*;

import org.junit.*;
import static org.junit.Assert.*;
import org.junit.rules.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmpresaTeste {

	private Empresa empresa;
	private final String testeCnpj = "12345678912345";
	private final String testeRazaoSocial = "teste";
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

	@Test(timeout = 10)
	public void deve_ter_cnpj_valido() {
		empresa.setCnpj("12345678912345");
		assertThat(empresa.getCnpj(), is(testeCnpj));
	}

	@Test(timeout = 1)
	public void nao_deve_ter_cnpj_nulo() {
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("O cnpj deve ser preenchido.");
		empresa.setCnpj(null);
		assertTrue(empresa.getCnpj().equals(null));
	}

	@Test(timeout = 1)
	public void nao_deve_ter_cnpj_vazio() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O cnpj não pode ficar vazio.");
		empresa.setCnpj("");
		assertTrue(empresa.getCnpj().isEmpty());
	}

	@Test(timeout = 1)
	public void nao_deve_ter_cnpj_valido() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Esse cnpj é inválido.");
		empresa.setCnpj("12345678");
		assertFalse(empresa.getCnpj().equals(testeCnpj));
	}

	@Test(timeout = 100)
	public void deve_ter_cnpj_so_com_numeros() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O cnpj só pode conter números.");
		empresa.setCnpj("a");
		assertThat(empresa.getCnpj(), is(not(testeCnpj)));
	}

	@Test(timeout = 1)
	public void nao_deve_ter_proprietario_nulo() {
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("O nome de proprietário deve ser preenchido.");
		empresa.setProprietario(null);
		assertTrue(empresa.getProprietario().equals(null));
	}

	@Test(timeout = 1)
	public void nao_deve_ter_proprietario_vazio() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O nome de proprietário não pode ficar vazio.");
		empresa.setProprietario("");
		assertTrue(empresa.getProprietario().isEmpty());
	}

	@Test(timeout = 1)
	public void deve_ter_razaoSocial_valido() {
		empresa.setRazaoSocial("teste");
		assertThat(empresa.getRazaoSocial(), is(testeRazaoSocial));
	}

	@Test(timeout = 1)
	public void nao_deve_ter_razaoSocial_nulo() {
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("A razão social deve ser preenchida.");
		empresa.setRazaoSocial(null);
		assertTrue(empresa.getRazaoSocial().equals(null));
	}

	@Test(timeout = 1)
	public void nao_deve_ter_razaoSocial_vazio() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("A razão social não pode ficar vazia.");
		empresa.setRazaoSocial("");
		assertTrue(empresa.getRazaoSocial().isEmpty());
	}

	@Test(timeout = 1)
	public void nao_deve_ter_razaoSocial_valido() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("A razão social deve ter pelo menos 4 dígitos.");
		empresa.setRazaoSocial("ex");
		assertThat(empresa.getRazaoSocial(), is(not(testeRazaoSocial)));
	}

}
