package br.com.contmatic.empresawilliam;

import static br.com.contmatic.empresawilliam.util.ValidationUtil.hasErrors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
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

    private Telefone telefoneFixo, telefoneCelular, telefoneInvalido, telefoneDDDMenor;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void setUpBeforeClass() {
        FixtureFactoryLoader.loadTemplates("br.com.contmatic.empresawilliam.templates");
    }

    @Before
    public void setUp() {
        this.telefoneFixo = Fixture.from(Telefone.class).gimme("fixo_valido");
        this.telefoneCelular = Fixture.from(Telefone.class).gimme("celular_valido");
        this.telefoneInvalido = Fixture.from(Telefone.class).gimme("fixo_invalido");
        this.telefoneDDDMenor = Fixture.from(Telefone.class).gimme("ddd_menor_que_limite");
    }

    @After
    public void tearDown() {
        telefoneFixo = null;
        telefoneCelular = null;
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("Teste terminado");
    }

    
    // Testes
    @Test
    public void nao_deve_aceitar_tipoTelefone_nulo() {
        telefoneFixo.setTipoTelefone(null);
        assertTrue(hasErrors(telefoneFixo, "O tipo de telefone deve ser preenchido."));
    }

    @Test
    public void deve_aceitar_ddd_valido() {
        assertThat(hasErrors(telefoneFixo, null), is(false));
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
    public void deve_aceitar_telefoneFixo_valido() {
       assertThat(hasErrors(telefoneFixo, null), is(false));
    }

    @Test
    public void nao_deve_aceitar_telefoneFixo_nulo() {
        telefoneFixo.setTelefoneFixo(null);
        assertTrue(hasErrors(telefoneFixo, "O número de telefone não pode ser nulo."));
    }

    @Test
    public void nao_deve_aceitar_telefoneFixo_vazio() {
        telefoneFixo.setTelefoneFixo("");
        assertTrue(hasErrors(telefoneFixo, "O número de telefone não pode ficar vazio."));
    }
    
    @Test
    public void nao_deve_aceitar_telefoneFixo_em_branco() {
        telefoneFixo.setTelefoneFixo(" ");
        assertTrue(hasErrors(telefoneFixo, "O número de telefone não pode ficar vazio."));
    }

    @Test
    public void nao_deve_aceitar_telefoneFixo_menor_que_limite() {
        telefoneFixo.setTelefoneFixo("1234567");
        assertTrue(hasErrors(telefoneFixo, "Para telefone fixo, por favor informar 8 dígitos."));
    }

    @Test
    public void nao_deve_aceitar_telefoneFixo_maior_que_limite() {
        telefoneFixo.setTelefoneFixo("123456789");
        assertTrue(hasErrors(telefoneFixo, "Para telefone fixo, por favor informar 8 dígitos."));
    }
    
    @Test
    public void deve_aceitar_telefoneCelular_valido() {
       assertThat(hasErrors(telefoneCelular, null), is(false));
    }

    @Test
    public void nao_deve_aceitar_telefoneCelular_nulo() {
        telefoneCelular.setTelefoneCelular(null);
        assertTrue(hasErrors(telefoneCelular, "O número de telefone não pode ser nulo."));
    }

    @Test
    public void nao_deve_aceitar_telefoneCelular_vazio() {
        telefoneCelular.setTelefoneCelular("");
        assertTrue(hasErrors(telefoneCelular, "O número de telefone não pode ficar vazio."));
    }
    
    @Test
    public void nao_deve_aceitar_telefoneCelular_em_branco() {
        telefoneCelular.setTelefoneCelular(" ");
        assertTrue(hasErrors(telefoneCelular, "O número de telefone não pode ficar vazio."));
    }
    
    @Test
    public void nao_deve_aceitar_telefoneCelular_menor_que_limite() {
        telefoneCelular.setTelefoneCelular("12345678");
        assertTrue(hasErrors(telefoneCelular, "Para telefone celular, por favor informar 9 dígitos."));
    }

    @Test
    public void nao_deve_aceitar_telefoneCelular_maior_que_limite() {
        telefoneCelular.setTelefoneCelular("1234567890");
        assertTrue(hasErrors(telefoneCelular, "Para telefone celular, por favor informar 9 dígitos."));
    }
}
