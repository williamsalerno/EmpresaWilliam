package br.com.contmatic.empresawilliam.teste;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;

import br.com.contmatic.empresawilliam.Endereco;

@FixMethodOrder(MethodSorters.DEFAULT)
public class EnderecoTeste {

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Teste realizado.");
	}

	private Endereco endereco;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void gerarEmpresa() {
		this.endereco = new Endereco();
	}

	@After
	public void zeraTeste() {
		endereco = null;
	}

	@Test
	public void nao_deve_ter_numeroEndereco_nulo() {
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("O número de endereço deve ser preenchido. Preencha com 0 se o seu endereço for s/n.");
		endereco.setNumeroEndereco(null);
		assertTrue(endereco.getNumeroEndereco().equals(null));
	}

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
		thrown.expectMessage("O número de endereço excede o tamanho limite.");
		endereco.setNumeroEndereco(10000);
		assertFalse(endereco.verificaNumeroEnderecoMaximo(endereco.getNumeroEndereco()));
	}

	@Test
	public void nao_deve_ter_nomeLogradouro_nulo() {
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("O tipo de logradouro deve ser preenchido.");
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
	public void deve_ter_tipoLogradouro_valido() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O tipo de logradouro deve ser válido.");
		endereco.setTipoLogradouro("123");
		assertFalse("Deve ser falso", endereco.verificaSeTipoLogradouroValido(endereco.getTipoLogradouro()));
	}

}
