package br.com.contmatic.empresawilliam.templates;

import br.com.contmatic.empresawilliam.Endereco;
import br.com.six2six.fixturefactory.*;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class EnderecoTemplate implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(Endereco.class).addTemplate("valid", new Rule() {
			{
				add("tipoLogradouro", random("Rua", "Avenida", "Praça", "Parque"));
				add("nomeLogradouro", random("Exemplo", "Teste", "Qualquer Lugar", "Lugar Nenhum"));
				add("numeroEndereco", random(Integer.class, range(1, 9999)));
				add("tipoEndereco", random("Comercial", "Residencial"));
				add("cep", random("12345000", "54321000", "12345123", "54321321"));
			}
		});

	}

}