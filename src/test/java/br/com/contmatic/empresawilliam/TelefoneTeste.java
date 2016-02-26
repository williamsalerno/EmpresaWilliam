package br.com.contmatic.empresawilliam;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TelefoneTeste {

	private Telefone telefone;
	private final String TESTE_TIPO_CELULAR = "Celular";
	private final String TESTE_TIPO_FIXO = "Fixo";
	private final String TESTE_NUMERO_CELULAR = "123456789";
	private final String TESTE_NUMERO_FIXO = "12345678";
	private final int TESTE_DDD = 99;
	private static int contadorTeste = 0;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Teste de Telefone realizado.");
	}

	@Before
	public void gerarTelefone() {
		this.telefone = new Telefone();
	}

	@After
	public void proximoTeste() {
		telefone = null;
		contadorTeste += 1;
	}

	@AfterClass
	public static void resultado() {
		System.out.println("Total de testes: " + contadorTeste);
	}

	@Test
	public void deve_ter_tipo_celular_valido() {
		telefone.setTipoTelefone("Celular");
		assertThat(telefone.getTipoTelefone(), is(TESTE_TIPO_CELULAR));
	}

	@Test
	public void deve_ter_tipo_fixo_valido() {
		telefone.setTipoTelefone("Fixo");
		assertThat(telefone.getTipoTelefone(), is(TESTE_TIPO_FIXO));
	}

	@Test
	public void nao_deve_ter_tipoTelefone_nulo() {
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("O tipo de telefone deve ser preenchido.");
		telefone.setTipoTelefone(null);
	}

	@Test
	public void nao_deve_ter_tipoTelefone_vazio() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O tipo de telefone não pode ficar vazio.");
		telefone.setTipoTelefone("");
	}

	@Test
	public void nao_deve_ter_tipo_celular_valido() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O tipo de telefone precisa ser ou fixo, ou celular.");
		telefone.setTipoTelefone("exemplo");
	}

	@Test
	public void nao_deve_ter_tipo_fixo_valido() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O tipo de telefone precisa ser ou fixo, ou celular.");
		telefone.setTipoTelefone("exemplo");
	}

	@Test
	public void deve_ter_ddd_valido() {
		telefone.setDdd(99);
		assertThat(telefone.getDdd(), is(TESTE_DDD));
	}

	@Test
	public void nao_deve_ter_ddd_menor_que_limite() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O número de DDD informado deve ser entre 1 e 99");
		telefone.setDdd(0);
	}

	@Test
	public void nao_deve_ter_ddd_maior_que_limite() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O número de DDD informado deve ser entre 1 e 99");
		telefone.setDdd(100);
	}

	@Test
	public void nao_deve_ter_ddd_negativo() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O número de DDD informado deve ser entre 1 e 99");
		telefone.setDdd(-1);
	}

	@Test
	public void deve_ter_numeroTelefone_fixo_valido() {
		telefone.setTipoTelefone("Fixo");
		telefone.setNumeroTelefone("12345678");
		assertThat(telefone.getTipoTelefone(), is(TESTE_TIPO_FIXO));
		assertThat(telefone.getNumeroTelefone(), is(TESTE_NUMERO_FIXO));
	}

	@Test
	public void deve_ter_numeroTelefone_celular_valido() {
		telefone.setTipoTelefone("Celular");
		telefone.setNumeroTelefone("123456789");
		assertThat(telefone.getTipoTelefone(), is(TESTE_TIPO_CELULAR));
		assertThat(telefone.getNumeroTelefone(), is(TESTE_NUMERO_CELULAR));

	}

	@Test
	public void nao_deve_ter_numeroTelefone_nulo() {
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("O número de telefone deve ser informado");
		telefone.setNumeroTelefone(null);
	}

	@Test
	public void nao_deve_ter_numeroTelefone_vazio() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O número de telefone deve ser informado.");
		telefone.setNumeroTelefone("");
	}

	@Test
	public void nao_deve_ter_numeroTelefone_menor_que_limite_para_celular() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage(
				"Para telefone fixo, por favor informar 8 dígitos. Para telefone celular, por favor informar 9 dígitos.");
		telefone.setTipoTelefone("Celular");
		telefone.setNumeroTelefone("12345678");
	}

	@Test
	public void nao_deve_ter_numeroTelefone_maior_que_limite_para_celular() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage(
				"Para telefone fixo, por favor informar 8 dígitos. Para telefone celular, por favor informar 9 dígitos.");
		telefone.setTipoTelefone("Celular");
		telefone.setNumeroTelefone("1234567890");
	}

	@Test
	public void nao_deve_ter_numeroTelefone_menor_que_limite_para_fixo() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage(
				"Para telefone fixo, por favor informar 8 dígitos. Para telefone celular, por favor informar 9 dígitos.");
		telefone.setTipoTelefone("Fixo");
		telefone.setNumeroTelefone("1234567");
	}

	@Test
	public void nao_deve_ter_numeroTelefone_maior_que_limite_para_fixo() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage(
				"Para telefone fixo, por favor informar 8 dígitos. Para telefone celular, por favor informar 9 dígitos.");
		telefone.setTipoTelefone("Fixo");
		telefone.setNumeroTelefone("123456789");
	}

	@Test
	public void nao_deve_ter_numeroTelefone_celular_diferente_de_tipo_celular() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage(
				"Para telefone fixo, por favor informar 8 dígitos. Para telefone celular, por favor informar 9 dígitos.");
		telefone.setTipoTelefone("Fixo");
		telefone.setNumeroTelefone("123456789");
	}
}
