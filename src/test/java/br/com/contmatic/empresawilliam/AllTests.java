package br.com.contmatic.empresawilliam;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ EmpresaTeste.class, EnderecoTeste.class, TelefoneTeste.class })
public class AllTests {
}
