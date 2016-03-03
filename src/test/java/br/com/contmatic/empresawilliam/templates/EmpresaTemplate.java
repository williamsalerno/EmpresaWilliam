package br.com.contmatic.empresawilliam.templates;

import br.com.contmatic.empresawilliam.Empresa;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class EmpresaTemplate implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(Empresa.class).addTemplate("empresa_valida", new Rule() {
			{
				add("razaoSocial", random("Uniesquina", "Uniquintal", "Unip", "Fiap"));
				add("cnpj", random("12345678911234", "00111222333344", "44333222111100", "43211987654321"));
				add("proprietario", random("Fulano", "Ciclano", "Alguém", "Eu"));
				add("email", random("fulano@exemplo.com", "ciclano@teste.com", "eu@teste.com.br"));
				add("site", random("teste.com.br", "exemplo.com"));
			}
		});
		
	}

}
