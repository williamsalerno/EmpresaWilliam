package br.com.contmatic.empresawilliam.teste;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;

import br.com.contmatic.empresawilliam.Empresa;

@FixMethodOrder(MethodSorters.DEFAULT)
public class EmpresaTeste {

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Teste realizado.");
	}

	private Empresa empresa;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void gerarEmpresa() {
		this.empresa = new Empresa();
	}
	
	@After
	public void zeraTeste() {
		empresa = null;
	}

	@Test
	public void deve_ter_cnpj_valido() {
		String testeCnpj = "12345678912345";
		empresa.setCnpj("12345678912345");
		assertThat(empresa.getCnpj(), is(testeCnpj));
	}

	@Test
	public void nao_deve_ter_cnpj_nulo() {
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("O cnpj deve ser preenchido.");
		empresa.setCnpj(null);
		assertTrue(empresa.getCnpj().equals(null));
	}

	@Test
	public void nao_deve_ter_cnpj_vazio() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O cnpj não pode ficar vazio.");
		empresa.setCnpj("");
		assertTrue(empresa.getCnpj().isEmpty());
	}

	@Test
	public void nao_deve_ter_cnpj_valido() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Esse cnpj é inválido.");
		String testeCnpj = "12345678912345";
		empresa.setCnpj("12345678");
		assertFalse(empresa.getCnpj().equals(testeCnpj));
	}

	@Test
	public void deve_ter_cnpj_so_com_numeros() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O cnpj só pode conter números.");
		empresa.setCnpj("abc");
		assertFalse("Deve ser falso", empresa.verificaSeCnpjSoNumeros(empresa.getCnpj()));
	}

	
	@Test
	public void nao_deve_ter_proprietario_nulo() {
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("O nome de proprietário deve ser preenchido.");
		empresa.setProprietario(null);
		assertTrue(empresa.getProprietario().equals(null));
	}
	
	@Test
	public void nao_deve_ter_proprietario_vazio() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O nome de proprietário não pode ficar vazio.");
		empresa.setProprietario("");
		assertTrue(empresa.getProprietario().isEmpty());
	}
	
	@Test
	public void nao_deve_ter_razaoSocial_nulo() {
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("A razão social deve ser preenchida.");
		empresa.setRazaoSocial(null);
		assertTrue(empresa.getRazaoSocial().equals(null));
	}
	
	@Test
	public void nao_deve_ter_razaoSocial_vazio() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("A razão social não pode ficar vazia.");
		empresa.setRazaoSocial("");
		assertTrue(empresa.getRazaoSocial().isEmpty());
	}

}
