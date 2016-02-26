package br.com.contmatic.empresawilliam;

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
	private final String TESTE_TIPO_LOGRADOURO = "Rua";
	private final String TESTE_NOME_LOGRADOURO = "Exemplo";
	private final String TESTE_CEP = "12345678";
	private final int TESTE_NUMERO = 9999;
	private final String TESTE_ENDERECO_RESIDENCIAL = "Residencial";
	private final String TESTE_ENDERECO_COMERCIAL = "Comercial";
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
		assertTrue(endereco.getCep().equals(TESTE_CEP));
	}

	@Test
	public void nao_deve_ter_cep_nulo() {
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("O CEP deve ser preenchido.");
		endereco.setCep(null);
	}

	@Test
	public void nao_deve_ter_cep_vazio() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O CEP não pode ficar vazio.");
		endereco.setCep("");
	}

	@Test
	public void nao_deve_ter_cep_menor_que_limite() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O CEP deve ter 8 dígitos.");
		endereco.setCep("1234567");
	}

	@Test
	public void nao_deve_ter_cep_maior_que_limite() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O CEP deve ter 8 dígitos.");
		endereco.setCep("123456789");
	}

	@Test
	public void nao_deve_ter_cep_com_letras() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O CEP só pode conter números.");
		endereco.setCep("abc");
	}

	@Test
	public void deve_ter_numeroEndereco_valido() {
		endereco.setNumeroEndereco(9999);
		assertThat(endereco.getNumeroEndereco(), is(TESTE_NUMERO));
	}

	@Test
	public void nao_deve_ter_numeroEndereco_menor_que_limite() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O número de endereço é inválido.");
		endereco.setNumeroEndereco(0);
	}

	@Test
	public void nao_deve_ter_numeroEndereco_maior_que_limite() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O número de endereço é inválido.");
		endereco.setNumeroEndereco(10000);
	}

	@Test
	public void nao_deve_ter_numeroEndereco_negativo() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O número de endereço é inválido.");
		endereco.setNumeroEndereco(-1);
	}

	@Test
	public void deve_ter_nomeLogradouro_valido() {
		endereco.setNomeLogradouro("Exemplo");
		assertThat(endereco.getNomeLogradouro(), is(TESTE_NOME_LOGRADOURO));
	}

	@Test
	public void nao_deve_ter_nomeLogradouro_nulo() {
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("O nome de logradouro deve ser preenchido.");
		endereco.setNomeLogradouro(null);
	}

	@Test
	public void nao_deve_ter_nomeLogradouro_vazio() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O nome de logradouro deve ter no mínimo 1 caracter e no máximo 30 caracteres.");
		endereco.setNomeLogradouro("");
	}

	@Test
	public void nao_deve_ter_nomeLogradouro_maior_que_limite() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O nome de logradouro deve ter no mínimo 1 caracter e no máximo 30 caracteres.");
		endereco.setNomeLogradouro("1234567891123456789212345678931");
	}

	@Test
	public void deve_ter_tipoLogradouro_valido() {
		endereco.setTipoLogradouro("Rua");
		assertThat(endereco.getTipoLogradouro(), is(TESTE_TIPO_LOGRADOURO));
	}

	@Test
	public void nao_deve_ter_tipoLogradouro_nulo() {
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("O tipo de logradouro deve ser preenchido.");
		endereco.setTipoLogradouro(null);
	}

	@Test
	public void nao_deve_ter_tipoLogradouro_vazio() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O tipo de logradouro não pode ficar vazio.");
		endereco.setTipoLogradouro("");
	}

	@Test
	public void nao_deve_ter_tipoLogradouro_menor_que_minimo() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O tipo de logradouro deve ter no mínimo 3 caracteres e no máximo 10 caracteres.");
		endereco.setTipoLogradouro("ex");
	}

	@Test
	public void nao_deve_ter_tipoLogradouro_maior_que_maximo() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O tipo de logradouro deve ter no mínimo 3 caracteres e no máximo 10 caracteres.");
		endereco.setTipoLogradouro("exemploexemplo");
	}

	@Test
	public void nao_deve_ter_tipoLogradouro_invalido() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O tipo de logradouro deve ser válido.");
		endereco.setTipoLogradouro("Ru12");
	}

	@Test
	public void deve_ter_tipoEndereco_residencial_valido() {
		endereco.setTipoEndereco("Residencial");
		assertThat(endereco.getTipoEndereco(), is(TESTE_ENDERECO_RESIDENCIAL));
	}

	@Test
	public void deve_ter_tipoEndereco_comercial_valido() {
		endereco.setTipoEndereco("Comercial");
		assertThat(endereco.getTipoEndereco(), is(TESTE_ENDERECO_COMERCIAL));
	}

	@Test
	public void nao_deve_ter_tipoEndereco_nulo() {
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("O tipo de endereço deve ser preenchido.");
		endereco.setTipoEndereco(null);
	}

	@Test
	public void nao_deve_ter_tipoEndereco_vazio() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O tipo de endereço não pode ficar vazio.");
		endereco.setTipoEndereco("");
	}

	@Test
	public void nao_deve_ter_tipoEndereco_invalido() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O tipo de endereço deve ser ou residencial, ou comercial.");
		endereco.setTipoEndereco("exemplo");
	}
}