package suite;

import framework.core.DriverFactory;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.TesteAlert;
import test.TesteCadastro;
import test.TesteCampoTreinamento;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TesteCampoTreinamento.class,
        TesteAlert.class,
        TesteCadastro.class
})
public class SuiteTeste {

}
