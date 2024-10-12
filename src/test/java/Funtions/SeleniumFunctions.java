package Funtions;

import StepDefinitions.Hooks;
import com.sun.source.util.SourcePositions;
import io.qameta.allure.Allure;
import jdk.swing.interop.SwingInterOpUtils;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import static org.apache.commons.io.FilenameUtils.removeExtension;

import java.io.FileReader;
import java.io.IOException;

public class SeleniumFunctions {
    WebDriver driver;

    public SeleniumFunctions() {
        driver = Hooks.driver;
    }

    private static Logger log = Logger.getLogger(SeleniumFunctions.class);
    public static Properties prop = new Properties();
    public static InputStream in = SeleniumFunctions.class.getResourceAsStream("../test.properties");

    /**
     * Scenario Test Data
     **/
    public static Map<String, String> ScenaryData = new HashMap<>();
    public static Map<String, String> HandleMyWindows = new HashMap<>();
    public static String Environment = "";

    public static String PagesFilesPath = "src/test/resources/Pages/";
    public static String FileName = "";
    public static String GetFieldBy = "";
    public static String ValueToFind = "";
    public static int EXPLICIT_TIMEOUT = 60;
    public static String ElementText = "";
    public static String PathStore = "";
    public static boolean isDisplayed = Boolean.parseBoolean(null);

    public static Object readJson() throws Exception {
        FileReader reader = new FileReader(PagesFilesPath + FileName);
        try {
            if (reader != null) {
                JSONParser jsonParser = new JSONParser();
                return jsonParser.parse(reader);
            } else {
                return null;
            }
        } catch (FileNotFoundException | NullPointerException e) {
            log.error("ReadEntity: No existe el Archivo " + FileName);
            throw new IllegalStateException("ReadEntity: No existe el Archivo " + FileName, e);
        }
    }

    public static JSONObject ReadEntity(String element) throws Exception {
        JSONObject Entity = null;
        JSONObject jsonObject = (JSONObject) readJson();
        Entity = (JSONObject) jsonObject.get(element);
        log.info(Entity.toJSONString());
        return Entity;
    }

    public static By getCompleteElement(String element) throws Exception {
        By result = null;
        JSONObject Entity = ReadEntity(element);

        GetFieldBy = (String) Entity.get("GetFieldBy");
        ValueToFind = (String) Entity.get("ValueToFind");

        if ("className".equalsIgnoreCase(GetFieldBy)) {
            result = By.className(ValueToFind);
        } else if ("cssSelector".equalsIgnoreCase(GetFieldBy)) {
            result = By.cssSelector(ValueToFind);
        } else if ("id".equalsIgnoreCase(GetFieldBy)) {
            result = By.id(ValueToFind);
        } else if ("linkText".equalsIgnoreCase(GetFieldBy)) {
            result = By.linkText(ValueToFind);
        } else if ("name".equalsIgnoreCase(GetFieldBy)) {
            result = By.name(ValueToFind);
        } else if ("link".equalsIgnoreCase(GetFieldBy)) {
            result = By.partialLinkText(ValueToFind);
        } else if ("tagName".equalsIgnoreCase(GetFieldBy)) {
            result = By.tagName(ValueToFind);
        } else if ("XPath".equalsIgnoreCase(GetFieldBy)) {
            result = By.xpath(ValueToFind);
        }
        return result;
    }

    public String readProperties(String property) throws IOException {
        prop.load(in);
        return prop.getProperty(property);
    }


    public ISelect selectOption(String element) throws Exception {
        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        log.info(String.format("esperedo Elemento: " + element));
        Select opt = new Select(driver.findElement(SeleniumElement));
        return opt;
    }


    //*SELECT*//

    public void waitForElementPresent(String element) throws Exception {
        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_TIMEOUT);
        log.info("esperando el elemento: " + element + " a ser presentado");
        wait.until(ExpectedConditions.presenceOfElementLocated(SeleniumElement));
    }


    public void page_has_loaded() {
        String GetActual = driver.getCurrentUrl();
        System.out.println(String.format("Cheking si la pagina esta cargada. ", GetActual));
        log.info(String.format("Cheking si la pagina esta cargada. ", GetActual));
        new WebDriverWait(driver, EXPLICIT_TIMEOUT).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete")
        );
    }


    public void ScreenSchot(String TestCaptura) throws IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmm");
        String screenShotName = readProperties("ScreenShotPath") + "\\" + readProperties("browser") + "\\" + TestCaptura + "_(" + dateFormat.format(GregorianCalendar.getInstance().getTime()) + ")";
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        System.out.println("Screenshot saved as: " + screenShotName);
        log.info("Screenshot saved as: " + screenShotName);
        FileUtils.copyFile(scrFile, new File(String.format("%s.png", screenShotName)));
    }


    public String GetTextElement(String element) throws Exception {
        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_TIMEOUT);
        wait.until(ExpectedConditions.presenceOfElementLocated(SeleniumElement));
        log.info(String.format("esperando el elemento: %s", element));

        ElementText = driver.findElement(SeleniumElement).getText();

        return ElementText;
    }

    public boolean isElementDisplayed(String element) throws Exception {
        try {
            By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
            log.info(String.format("Esperar elemento: ", element));
            WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_TIMEOUT);
            isDisplayed = wait.until(ExpectedConditions.presenceOfElementLocated(SeleniumElement)).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            isDisplayed = false;
            log.info(e);
        }
        log.info(String.format(" el elemento visible es: ", element, isDisplayed));
        System.out.println(String.format(" el elemento visible es: %s", element, isDisplayed));
        return isDisplayed;
    }

    public void scrolltoElement(String element) throws Exception {
        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        log.info("Scrolling to the element: " + element);
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(SeleniumElement));
    }

    public void checkbox(String element) throws Exception {
        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        boolean isChecked = driver.findElement(SeleniumElement).isSelected();
        if (!isChecked) {
            log.info("Marco la casilla: " + element);
            driver.findElement(SeleniumElement).click();
        }
    }

    public void checkPartialTextElementPresent(String element, String text) throws Exception {
        System.out.println("Esto es una prueba de imprimir");
        ElementText = GetTextElement(element);
        boolean isFound = ElementText.indexOf(text) != -1 ? true : false;
        System.out.println(isFound);
        Assert.assertTrue("este Texto esta presente en el elemento: " + element + "el texto actual es: " + ElementText, isFound);

    }

    public byte[] attachScreenShot(String TestCaptura) {
        log.info("atteching ScreenShot");
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment(TestCaptura, new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        return screenshot;
    }


    // Crear documento cvs------------------------------------------

    public void createCsvFile(String filePath) throws IOException {
        // Definimos los títulos de las columnas
        String[] headers = {"ID", "Name", "Date", "Status"};
        // Creamos el archivo .csv
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Escribimos los títulos en la primera fila
            for (int i = 0; i < headers.length; i++) {
                writer.write(headers[i]);
                if (i < headers.length - 1) {
                    writer.write(",");
                }
            }
            writer.newLine();
            // Agregamos cinco filas de contenido
            for (int i = 1; i <= 5; i++) {
                String id = "ID_" + i;
                String name = "Name_" + i;
                String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                String status = (i % 2 == 0) ? "Active" : "Inactive";
                // Escribimos la fila en el archivo
                writer.write(id + "," + name + "," + date + "," + status);
                writer.newLine();
            }
        } catch (IOException e) {
            log.error("Error al crear el archivo CSV: " + e.getMessage());
            throw e;
        }
        log.info("Archivo CSV creado en: " + filePath);
    }

    //Cargar documento------------------------------------------

    public void fileUpload(String element) throws Exception {
        String attribute = readProperties("FileUpload");
        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        WebElement fileInput = driver.findElement(SeleniumElement);
        fileInput.sendKeys(attribute);
        log.info(String.format("se sube el archivo Correctamente"));
    }
    public void fileUploadFoto(String element) throws Exception {
        String attribute = readProperties("FileUploadFoto");
        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        WebElement fileInput = driver.findElement(SeleniumElement);
        fileInput.sendKeys(attribute);
        log.info(String.format("se sube el archivo Correctamente"));
    }

    //Validar Descarga archivo----------------------------------------------

    public void validateFileDownload() throws IOException {
        String downloadDir = readProperties("download.directory");
        String fileName = readProperties("download.fileName");

        File dir = new File(downloadDir);
        File[] dirContents = dir.listFiles();

        boolean found = false;
        for (File file : dirContents) {
            if (file.getName().equals(fileName)) {
                found = true;
                break;
            }
        }

        Assert.assertTrue("El archivo " + fileName + " no se encontró en el directorio de descargas.", found);
        log.info("Archivo " + fileName + " encontrado en el directorio de descargas.");
    }

    //Autocompletar----------------------
    public void escribirYSeleccionarOpcion(String element, String letra, String opcion) throws Exception {
        // Localiza la casilla de texto para autocompletar
        By seleniumElement = getCompleteElement(element);
        waitForElementPresent(element);

        WebElement inputBox = driver.findElement(seleniumElement);
        // Escribe la letra en la casilla de texto
        inputBox.clear();
        inputBox.sendKeys(letra);
        log.info("Se escribió: " + letra + " en el elemento: " + element);

        // Espera a que las opciones aparezcan
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_TIMEOUT);
        By dropdownOptions = By.xpath("//ul[@class='dropdown-options']/li[contains(text(), '" + opcion + "')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownOptions));

        // Selecciona la opción deseada
        WebElement optionToSelect = driver.findElement(dropdownOptions);
        optionToSelect.click();
        log.info("Se seleccionó la opción: " + opcion);
    }

}











