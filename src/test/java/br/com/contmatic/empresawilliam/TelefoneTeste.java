package br.com.contmatic.empresawilliam;

import static br.com.contmatic.empresawilliam.TelefoneType.CELULAR;
import static br.com.contmatic.empresawilliam.TelefoneType.FIXO;
import static br.com.contmatic.empresawilliam.util.ValidationUtil.hasErrors;

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

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TelefoneTeste {

    private Telefone telefone, telefoneCelular, telefoneInvalido, telefoneDDDMenor;
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
        this.telefoneInvalido = Fixture.from(Telefone.class).gimme("fixo_invalido");
        this.telefoneDDDMenor = Fixture.from(Telefone.class).gimme("ddd_menor_que_limite");
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
    public void nao_deve_aceitar_tipoTelefone_nulo() {
        telefone.setTipoTelefone(null);
        assertTrue(hasErrors(telefone, "O tipo de telefone deve ser preenchido."));
    }

    @Test
    public void deve_aceitar_ddd_valido() {
        telefone.setDdd(0);
        assertFalse(hasErrors(telefone, "O ddd deve ser preenchido."));
    }

    @Test
    public void nao_deve_aceitar_ddd_menor_que_limite() {
        assertTrue(hasErrors(telefoneDDDMenor, "O número de DDD informado deve ser entre 11 e 99."));
    }

    @Test
    public void nao_deve_aceitar_ddd_maior_que_limite() {
        assertTrue(hasErrors(telefoneInvalido, "O número de DDD informado deve ser entre 11 e 99."));
    }

    @Test
    public void nao_deve_aceitar_ddd_negativo() {
        assertTrue(hasErrors(telefoneDDDMenor, "O número de DDD informado deve ser entre 11 e 99."));
    }

    @Test
    public void deve_aceitar_numeroTelefone_valido() {
        telefone.verificaSeNumeroTelefoneValido(telefone.getNumeroTelefone());
    }

    @Test
    public void nao_deve_aceitar_numeroTelefone_nulo() {
        telefone.setNumeroTelefone(null);
        assertTrue(hasErrors(telefone, "O número de telefone deve ser informado."));
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
        thrown.expectMessage("Para telefone fixo, por favor informar 8 dígitos. Para telefone celular, por favor informar 9 dígitos.");
        telefone.setTipoTelefone(CELULAR);
        telefone.setNumeroTelefone("12345678");
    }

    @Test
    public void nao_deve_aceitar_numeroTelefone_maior_que_limite_para_celular() {
        thrown.expect(IllegalStateException.class);
        thrown.expectMessage("Para telefone fixo, por favor informar 8 dígitos. Para telefone celular, por favor informar 9 dígitos.");
        telefone.setTipoTelefone(CELULAR);
        telefone.setNumeroTelefone("1234567890");
    }

    @Test
    public void nao_deve_aceitar_numeroTelefone_menor_que_limite_para_fixo() {
        thrown.expect(IllegalStateException.class);
        thrown.expectMessage("Para telefone fixo, por favor informar 8 dígitos. Para telefone celular, por favor informar 9 dígitos.");
        telefone.setTipoTelefone(FIXO);
        telefone.setNumeroTelefone("1234567");
    }

    @Test
    public void nao_deve_aceitar_numeroTelefone_maior_que_limite_para_fixo() {
        thrown.expect(IllegalStateException.class);
        thrown.expectMessage("Para telefone fixo, por favor informar 8 dígitos. Para telefone celular, por favor informar 9 dígitos.");
        telefone.setTipoTelefone(FIXO);
        telefone.setNumeroTelefone("123456789");
    }

    @Test
    public void nao_deve_aceitar_numeroTelefone_celular_diferente_de_tipo_celular() {
        thrown.expect(IllegalStateException.class);
        thrown.expectMessage("Para telefone fixo, por favor informar 8 dígitos. Para telefone celular, por favor informar 9 dígitos.");
        telefone.setTipoTelefone(FIXO);
        telefone.setNumeroTelefone("123456789");
    }
}
