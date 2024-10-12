package StepDefinitions;

import Funtions.SeleniumFunctions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



import java.io.IOException;
import java.util.ArrayList;

public class StepDefinitions {

    SeleniumFunctions functions = new SeleniumFunctions();

    WebDriver driver;

    public static boolean actual = Boolean.parseBoolean(null);

    /**** Atributo Login ******/
    Logger log = Logger.getLogger(StepDefinitions.class);

    public StepDefinitions() {
        driver = Hooks.driver;
    }

    @Given("^Cargar Pagina Web DemoQa")
    public void iAmInAppMainSite() throws IOException {
        String url = functions.readProperties("MainAppUrlBase");
        log.info("Navegacion a: " + url);
        driver.get(url);
        functions.page_has_loaded();
    }

    @Then("^Cargar la informacion del DOM (.*)$")
    public void cargarLaInformacionDelDOMAzloginJson(String json) throws Exception {
        SeleniumFunctions.FileName = json;
        SeleniumFunctions.readJson();
        log.info("Inicialize archivo: " + json);
    }


    @And("^busqueme (.*) en el select (.*)")
    public void iSetTextInDropdown(String option, String element) throws Exception {
        Select opt = (Select) functions.selectOption(element);
        opt.selectByVisibleText(option);
    }


    @And("^Hacer Click en El elemento (.*)")
    public void iDoClickInElement(String element) throws Exception {
        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        functions.waitForElementPresent(element);
        driver.findElement(SeleniumElement).click();
        log.info("hizo click en : " + element);
    }

    @And("^Hacer Doble Click en El elemento (.*)$")
    public void iDoDoubleClickInElement(String element) throws Exception {
        By seleniumElement = SeleniumFunctions.getCompleteElement(element);
        functions.waitForElementPresent(element);
        WebElement elemento = driver.findElement(seleniumElement);
        Actions actions = new Actions(driver);
        actions.doubleClick(elemento).perform();

        log.info("Hizo doble clic en : " + element);
    }

    @And("^Hacer Clic Derecho en El elemento (.*)$")
    public void iDoRightClickInElement(String element) throws Exception {
        By seleniumElement = SeleniumFunctions.getCompleteElement(element);
        functions.waitForElementPresent(element);
        WebElement elemento = driver.findElement(seleniumElement);
        Actions actions = new Actions(driver);
        actions.contextClick(elemento).perform();

        log.info("Hizo clic derecho en : " + element);
    }


    @And("^Tomar Captura de pantalla: (.*)")
    public void iTakeScreenshot(String TestCaptura) throws IOException {
        functions.ScreenSchot(TestCaptura);
    }


    /**
     * Buscador de Select por el texto
     **/
    @And("^Seleccione el Texto (.*) del Selector (.*)")
    public void iSetTextColombiaInDropdownCountry(String option, String element) throws Exception {
        Select opt = (Select) functions.selectOption(element);
        opt.selectByVisibleText(option);
    }


    //*Tiempo de espera*//

    /**
     * colocar tiempo de espera
     **/
    @And("^espereme (.*) segundos")
    public void iWaitSeconds(int seconds) throws InterruptedException {
        int secs = seconds * 1000;
        Thread.sleep(secs);
    }


    @Then("^Validar si el elemento (.*) se visualiza$")
    public void checkIfELementIsPresent(String element) throws Exception {
        boolean isDisplayed = functions.isElementDisplayed(element);
        Assert.assertTrue("Elemento no presente: " + element, isDisplayed);
    }

    @And("^Busque el elemento (.*)")
    public void scrollToElement(String element) throws Exception {
        functions.scrolltoElement(element);
    }

    @And("^lleneme el campo (.*) con el texto (.*)")
    public void iSet(String element, String text) throws Exception {
        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        functions.waitForElementPresent(element);
        driver.findElement(SeleniumElement).clear();
        driver.findElement(SeleniumElement).sendKeys(text);
        log.info("se coloco: " + text + "del elemento:" + element);
    }

    @And("^Marco la casilla (.*)$")
    public void MarcoLaCasillaDeVerificacion(String element) throws Exception {
        functions.waitForElementPresent(element);
        functions.checkbox(element);
    }

    @Then("^Validar si el elemento (.*) contiene el texto (.*)")
    public void assertIfContainsText(String element, String text) throws Exception {
        functions.checkPartialTextElementPresent(element, text);
    }

    @And("^Adjunto una Captura de pantalla al informe (.*)")
    public void attachAScreenShotToReport(String TestCaptura) {
        functions.attachScreenShot(TestCaptura);

    }

    @When("^Cerrar la pestaña actual$")
    public void closeCurrentTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
        driver.close();
        if (tabs.size() > 1) {
            driver.switchTo().window(tabs.get(tabs.size() - 2));
        }

        log.info("La pestaña actual ha sido cerrada.");
    }

    //crear documento cvs-------------------------------------------------

    @And("^Crear un archivo CSV en la ruta (.*)$")
    public void createCsvFile(String filePath) throws IOException {
        functions.createCsvFile(filePath);
    }

    //Cargar documento ----------------------------------------

    @Then("^Subir Archivo (.*)")
    public void fileUpload(String element) throws Exception {
        functions.fileUpload(element);
    }
    @Then("^Subir la foto (.*)")
    public void fileUploadFoto(String element) throws Exception {
        functions.fileUploadFoto(element);
    }
    @Then("^Validar que el archivo se haya descargado correctamente$")
    public void validarArchivoDescargado() throws Exception {
        functions.validateFileDownload();
    }
    //Autocompletar--------------------------------------

    @And("^Escribir en la casilla (.*) la letra (.*) y seleccionar la opción (.*)$")
    public void escribirYSeleccionarOpcion(String element, String letra, String opcion) throws Exception {
        functions.escribirYSeleccionarOpcion(element, letra, opcion);
    }

}

