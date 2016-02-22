package br.com.contmatic.empresawilliam.teste;

import br.com.contmatic.empresawilliam.Endereco;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EnderecoTeste {
	
	private Endereco endereco;
	private final String testeTipoLogradouro = "rua";
	private final String testeCep = "12345678";
	private final int testeNumero = 9999;
	private static int contadorTeste = 0;

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	public Timeout globalTimeout = Timeout.seconds(1);

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Teste de Endereco realizado.");
	}

	@Before
	public void gerarEmpresa() {
		this.endereco = new Endereco();
	}

	@After
	public void proximoTeste() {
		endereco = null;
		contadorTeste += 1;
	}
	
	@AfterClass
	public static void resultado() {
		System.out.println("Total de testes: " + contadorTeste);
	}

	@Test
	public void deve_ter_cep_valido() {
		endereco.setCep("12345678");
		assertTrue(endereco.getCep().equals(testeCep));
	}

	@Test
	public void nao_deve_ter_cep_nulo() {
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("O CEP deve ser preenchido.");
		endereco.setCep(null);
		assertTrue(endereco.getCep().equals(null));
	}

	@Test
	public void nao_deve_ter_cep_vazio() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O CEP não pode ficar vazio.");
		endereco.setCep("");
		assertTrue(endereco.getCep().isEmpty());
	}
	
	@Test
	public void nao_deve_ter_cep_menor_que_oito() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O CEP deve ter 8 dígitos.");
		endereco.setCep("1234567");
		assertThat(endereco.getCep(), is(not(testeCep)));
	}
	
	@Test
	public void nao_deve_ter_cep_maior_que_oito() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O CEP deve ter 8 dígitos.");
		endereco.setCep("123456789");
		assertThat(endereco.getCep(), is(not(testeCep)));
	}

	@Test
	public void deve_ter_numeroEndereco_valido() {
		endereco.setNumeroEndereco(9999);
		assertThat(endereco.getNumeroEndereco(), is(testeNumero));
	}

	@Test
	public void nao_deve_ter_numeroEndereco_nulo() {
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("O número de endereço deve ser preenchido. Preencha com 0 se o seu endereço for s/n.");
		endereco.setNumeroEndereco(null);
		assertTrue(endereco.getNumeroEndereco().equals(null));
	}

	@Ignore
	@Test
	public void nao_deve_ter_numeroEndereco_vazio() {
		thrown.expect(NumberFormatException.class);
		thrown.expectMessage("O número de endereço não pode ficar vazio. Preencha com 0 se o seu endereço for s/n.");
		endereco.setNumeroEndereco(Integer.valueOf(""));
		assertTrue(endereco.getNomeLogradouro().isEmpty());
	}

	@Test
	public void deve_preencher_com_sn_se_numeroEndereco_for_zero() {
		endereco.setNumeroEndereco(0);
		assertThat(endereco.getNomeLogradouro(), both(containsString(", ")).and(containsString("s/n")));
	}

	@Test
	public void nao_deve_ter_numeroEndereco_maior_que_quatro_digitos() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O número de endereço é inválido.");
		endereco.setNumeroEndereco(10000);
		assertThat(endereco.getNumeroEndereco(), is(not((testeNumero))));
	}

	@Test
	public void nao_deve_ter_numeroEndereco_negativo() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O número de endereço é inválido.");
		endereco.setNumeroEndereco(-1);
		assertThat(endereco.getNumeroEndereco(), is(not((testeNumero))));
	}

	@Test
	public void nao_deve_ter_nomeLogradouro_nulo() {
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("O nome de logradouro deve ser preenchido.");
		endereco.setNomeLogradouro(null);
		assertTrue(endereco.getNomeLogradouro().equals(null));
	}

	@Test
	public void nao_deve_ter_nomeLogradouro_vazio() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O nome de logradouro não pode ficar vazio.");
		endereco.setNomeLogradouro("");
		assertTrue(endereco.getNomeLogradouro().isEmpty());
	}

	@Test
	public void deve_ter_tipoLogradouro_valido() {
		endereco.setTipoLogradouro("rua");
		assertThat(endereco.getTipoLogradouro(), is(testeTipoLogradouro));
	}

	@Test
	public void nao_deve_ter_tipoLogradouro_nulo() {
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("O tipo de logradouro deve ser preenchido.");
		endereco.setTipoLogradouro(null);
		assertTrue(endereco.getTipoLogradouro().equals(null));
	}

	@Test
	public void nao_deve_ter_tipoLogradouro_vazio() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O tipo de logradouro não pode ficar vazio.");
		endereco.setTipoLogradouro("");
		assertTrue(endereco.getTipoLogradouro().isEmpty());
	}
	
	@Test
	public void nao_deve_ter_tipoLogradouro_menor_que_minimo() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O tipo de logradouro deve ser válido.");
		endereco.setTipoLogradouro("ex");
		assertThat(endereco.getTipoLogradouro(), is(not(testeTipoLogradouro)));
	}
}
