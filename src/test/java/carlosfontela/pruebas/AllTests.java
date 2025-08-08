package carlosfontela.pruebas;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ PruebaPalindromo.class, TestCuentas.class, TestCuentasPooV4.class, TestJUnit.class,
		TestPalindromoV4.class })
public class AllTests {

}
