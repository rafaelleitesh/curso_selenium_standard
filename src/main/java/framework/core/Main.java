package framework.core;

import org.openqa.selenium.WebDriver;

public class Main {
    public static void main(String[] args) {

        DriverFactory.getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

    }
}
