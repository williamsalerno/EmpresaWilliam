package br.com.contmatic.empresawilliam.teste;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;

import br.com.contmatic.empresawilliam.Empresa;

@FixMethodOrder(MethodSorters.DEFAULT)
public class EmpresaTeste {
	
//	@BeforeClass
//	public static void beforeClass(){
//		System.out.println("Teste realizado.");
//	}

	private Empresa empresa;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void gerarEmpresa() {
		this.empresa = new Empresa();
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
		thrown.expect(StringIndexOutOfBoundsException.class);
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

}
