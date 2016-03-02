package br.com.contmatic.empresawilliam;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TelefoneTeste {

	private Telefone telefone, telefoneCelular;
	private static int contadorTeste = 0;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Teste de Telefone realizado.");
		FixtureFactoryLoader.loadTemplates("br.com.contmatic.empresawilliam.templates");
	}

	@Before
	public void gerarTelefone() {
		this.telefone = Fixture.from(Telefone.class).gimme("fixo_valido");
		this.telefoneCelular = Fixture.from(Telefone.class).gimme("celular_valido");
	}

	@After
	public void proximoTeste() {
		System.out.println(telefone);
		System.out.println(telefoneCelular);
		contadorTeste += 1;
	}

	@AfterClass
	public static void resultado() {
		System.out.println("Total de testes: " + contadorTeste);
	}
	

	@Test
	public void deve_aceitar_tipo_telefoneFixo_valido() {
		telefone.verificaSeTipoTelefoneValido(telefone.getTipoTelefone());
	}
	
	@Test
	public void deve_aceitar_tipo_telefoneCelular_valido() {
		telefoneCelular.verificaSeTipoTelefoneValido(telefoneCelular.getTipoTelefone());
	}


	@Test
	public void nao_deve_aceitar_tipoTelefoneFixo_nulo() {
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("O tipo de telefone deve ser preenchido.");
		telefone.setTipoTelefone(null);
	}

	@Test
	public void nao_deve_aceitar_tipoTelefone_vazio() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O tipo de telefone não pode ficar vazio.");
		telefoneCelular.setTipoTelefone("");
	}

	@Test
	public void nao_deve_aceitar_tipo_celular_valido() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O tipo de telefone precisa ser ou fixo, ou celular.");
		telefone.setTipoTelefone("exemplo");
	}

	@Test
	public void nao_deve_aceitar_tipo_fixo_valido() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O tipo de telefone precisa ser ou fixo, ou celular.");
		telefone.setTipoTelefone("exemplo");
	}

	@Test
	public void deve_aceitar_ddd_valido() {
		telefone.verificaSeDddValido(telefone.getDdd());
	}

	@Test
	public void nao_deve_aceitar_ddd_menor_que_limite() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O número de DDD informado deve ser entre 11 e 99");
		telefone.setDdd(0);
	}

	@Test
	public void nao_deve_aceitar_ddd_maior_que_limite() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O número de DDD informado deve ser entre 11 e 99");
		telefone.setDdd(100);
	}

	@Test
	public void nao_deve_aceitar_ddd_negativo() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O número de DDD informado deve ser entre 11 e 99");
		telefone.setDdd(-1);
	}

	@Test
	public void deve_aceitar_numeroTelefone_valido() {
		telefone.verificaSeNumeroTelefoneValido(telefone.getNumeroTelefone());
	}

	@Test
	public void nao_deve_aceitar_numeroTelefone_nulo() {
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("O número de telefone deve ser informado");
		telefone.setNumeroTelefone(null);
	}

	@Test
	public void nao_deve_aceitar_numeroTelefone_vazio() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O número de telefone deve ser informado.");
		telefone.setNumeroTelefone("");
	}

	@Test
	public void nao_deve_aceitar_numeroTelefone_menor_que_limite_para_celular() {
		thrown.expect(IllegalStateException.class);
		thrown.expectMessage(
				"Para telefone fixo, por favor informar 8 dígitos. Para telefone celular, por favor informar 9 dígitos.");
		telefone.setTipoTelefone("Celular");
		telefone.setNumeroTelefone("12345678");
	}

	@Test
	public void nao_deve_aceitar_numeroTelefone_maior_que_limite_para_celular() {
		thrown.expect(IllegalStateException.class);
		thrown.expectMessage(
				"Para telefone fixo, por favor informar 8 dígitos. Para telefone celular, por favor informar 9 dígitos.");
		telefone.setTipoTelefone("Celular");
		telefone.setNumeroTelefone("1234567890");
	}

	@Test
	public void nao_deve_aceitar_numeroTelefone_menor_que_limite_para_fixo() {
		thrown.expect(IllegalStateException.class);
		thrown.expectMessage(
				"Para telefone fixo, por favor informar 8 dígitos. Para telefone celular, por favor informar 9 dígitos.");
		telefone.setTipoTelefone("Fixo");
		telefone.setNumeroTelefone("1234567");
	}

	@Test
	public void nao_deve_aceitar_numeroTelefone_maior_que_limite_para_fixo() {
		thrown.expect(IllegalStateException.class);
		thrown.expectMessage(
				"Para telefone fixo, por favor informar 8 dígitos. Para telefone celular, por favor informar 9 dígitos.");
		telefone.setTipoTelefone("Fixo");
		telefone.setNumeroTelefone("123456789");
	}

	@Test
	public void nao_deve_aceitar_numeroTelefone_celular_diferente_de_tipo_celular() {
		thrown.expect(IllegalStateException.class);
		thrown.expectMessage(
				"Para telefone fixo, por favor informar 8 dígitos. Para telefone celular, por favor informar 9 dígitos.");
		telefone.setTipoTelefone("Fixo");
		telefone.setNumeroTelefone("123456789");
	}
}
