package br.com.contmatic.empresawilliam.templates;

import static br.com.contmatic.empresawilliam.TelefoneType.CELULAR;
import static br.com.contmatic.empresawilliam.TelefoneType.FIXO;

import br.com.contmatic.empresawilliam.Telefone;
import br.com.contmatic.empresawilliam.TelefoneType;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class TelefoneTemplate implements TemplateLoader {

    @Override
    public void load() {
        Fixture.of(Telefone.class).addTemplate("fixo_valido", new Rule() {
            {
                add("tipoTelefone", random(FIXO));
                add("ddd", random(Integer.class, range(11, 99)));
                add("numeroTelefone", random("12345678", "87654321", "12344321", "88888888"));
            }
        });

        Fixture.of(Telefone.class).addTemplate("celular_valido", new Rule() {
            {
                add("tipoTelefone", random(CELULAR));
                add("ddd", random(Integer.class, range(11, 99)));
                add("numeroTelefone", random("123456789", "987654321", "123454321", "999999999"));
            }
        });

        Fixture.of(Telefone.class).addTemplate("fixo_invalido", new Rule() {
            {
                add("tipoTelefone", TelefoneType.FIXO);
                add("ddd", random(Integer.class, range(100, 500)));
                add("numeroTelefone", random("1234567", "987654321", "123454321", "7777777"));
            }
        });

        Fixture.of(Telefone.class).addTemplate("ddd_menor_que_limite").inherits("fixo_invalido", new Rule() {
            {
                add("ddd", random(Integer.class, range(-10, 10)));
            }
        });

    }

}
