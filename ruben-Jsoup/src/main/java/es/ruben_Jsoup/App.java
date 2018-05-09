package es.ruben_Jsoup;

import org.openqa.selenium.firefox.FirefoxDriver;

import es.ruben_Jsoup.service.InterfazService;
import es.ruben_Jsoup.service.SeleniumService;

/**
 * TODO JAVADOC App
 *
 * @version 1.0.0
 * @author ruben.merino (ver. 1.0.0)
 */
public class App {
    /**
     * TODO JAVADOC METODO
     *
     * @param args
     */
    public static void main(final String[] args) {

        final InterfazService iservice = new InterfazService();

        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");

        SeleniumService.driver = new FirefoxDriver();

        iservice.mostrarInicio();

    }

}
