package com.privalia.Utils;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.lang.UnhandledException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.io.FileHandler;
import java.io.IOException;

public class Utilities extends Base {
	
	protected static WebDriver driver;

	/*
	 * Método constructor que inicializa el driver
	 */
	public Utilities(WebDriver driver) {
		Utilities.driver = driver;
	}

	public void waitSleep(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Método para setear la url de una pagina al driver
	 */
	public void visit(String url) {
		driver.get(url);
	}

	/*
	 * Método para imrimir un texto en consola
	 */
	public static void print(String inputText) {
		System.out.println(inputText);
	}

	/*
	 * Método que prepara un WebDriverWait Se utiliza para esperar que se muestr un
	 * elemento o si se puede hacer clic, etc.
	 */
	public WebDriverWait esperarElemento() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		return wait;
	}

	/*
	 * Método para refrescar la p�gina
	 */
	public static void recargar() {
		returnDriver().navigate().refresh();
	}

	public static WebElement waitElementToClick(WebElement element) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(returnDriver()).withTimeout(Duration.ofSeconds(10))
				.ignoring(NoSuchElementException.class).ignoring(UnknownError.class).ignoring(WebDriverException.class);
		try {
			return wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			System.out.println("Don't found element " + e.getMessage());
			return null;
		}
	}

	public static WebElement waitElementVisible(WebElement element) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(returnDriver()).withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class).ignoring(UnknownError.class)
				.ignoring(WebDriverException.class);

		try {
			return wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			System.out.println("Don't found element " + e.getMessage());
			return null;
		}
	}

	/*
	 * Método para validar si se muestra un elemento
	 */
	public static Boolean isDisplayed(WebElement element) {
		try {
			return returnDriver().findElement((By) element).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	public static void clickElement(WebElement element) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(returnDriver()).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);

		// draw a border around the found element

		if (returnDriver() instanceof JavascriptExecutor) {
			((JavascriptExecutor) returnDriver()).executeScript("arguments[0].style.border='3px solid red'", element);
		}
		element.click();

	}

	public static void sendText(WebElement element, String value) {

		String selectAll = Keys.chord(Keys.HOME, Keys.SHIFT, Keys.END);

		Wait<WebDriver> wait = new FluentWait<WebDriver>(returnDriver()).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);

		if (returnDriver() instanceof JavascriptExecutor) {
			((JavascriptExecutor) returnDriver()).executeScript("arguments[0].style.border='3px solid red'", element);
		}
		element.sendKeys(selectAll, value, Keys.TAB);

	}

	public static void selectListByValue(WebElement element, String value) {

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(returnDriver()).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class).ignoring(UnknownError.class)
				.ignoring(WebDriverException.class);
		try {

			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			System.out.println("No se encontró el elemento " + e.getMessage());
		}

		if (returnDriver() instanceof JavascriptExecutor) {
			((JavascriptExecutor) returnDriver()).executeScript("arguments[0].style.border='3px solid red'", element);
		}

		Select cmb = new Select(element);
		cmb.selectByValue(value);

//        waitForPageLoaded();
	}

	public static WebElement createWebElement(String elementText) {
		WebElement element = null;
		try {
			element = returnDriver().findElement(By.xpath(elementText));
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e);
		}
		return element;
	}

	public static void scrollToElement(WebElement element) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) returnDriver();
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static Logger log() {
		return LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
	}

	public static String getFeatureName(String id) {
		String[] strName = id.split(";");
		String output = strName[0].substring(0, 1).toUpperCase() + strName[0].substring(1);
		return output.replace('-', ' ');
	}

	public static String getExecutiveTime(long endMillis, long startMillis) {
		long millis = endMillis - startMillis;
		long second = (millis / 1000) % 60;
		long minute = (millis / (1000 * 60)) % 60;
		long hour = (millis / (1000 * 60 * 60)) % 24;

		return String.format("%02d:%02d:%02d:%d", hour, minute, second, millis);
	}

	public static void ScrollIntoView(WebElement element) {
		((JavascriptExecutor) returnDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static void waitPageLoad() {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(returnDriver()).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(UnhandledException.class).ignoring(UnknownError.class);
		try {
			wait.until(ExpectedConditions.visibilityOf((returnDriver().findElement(By.id("page")))));
		} catch (Exception e) {
			System.out.println("Don't load the page "+e.getMessage());
		}
	}

	public static void clickOnElementByActions(WebElement element) {
		Actions builder = new Actions(returnDriver());
		builder.moveToElement(element).click(element);
		builder.perform();
	}

	public void clearField(WebElement element) {
		try {
			element.clear();
		} catch (Exception e) {
			System.out.print(String.format("The following element could not be cleared: [%s]", element.getText()));
		}
	}

	public static void clickOnElementJS(WebElement element) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) returnDriver();
			if (returnDriver() instanceof JavascriptExecutor) {
				((JavascriptExecutor) returnDriver()).executeScript("arguments[0].style.border='3px solid red'",
						element);
			}
			jse.executeScript("return arguments[0].click()", element);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public static void scrollPageTo(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) returnDriver();
		String bottom = jse.executeScript("return arguments[0].getBoundingClientRect().bottom;", element).toString();
		jse.executeScript("window.scrollTo(0," + bottom + ")", element);
	}

	public static void sleep(long length) {
		try {
			Thread.sleep(length);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
    public static void capturarPantalla() {
        String proyectoSeleniumPath = System.getProperty("user.dir");
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("ddMMyy_HHmmss");
        String fechaHoraFormateada = fechaHoraActual.format(formato);

        System.out.println("Ruta del proyecto Selenium: " + proyectoSeleniumPath);
        String directoryPath = proyectoSeleniumPath+"/src/test/resources/files/screenshots";
        String fileName = "screenshot_"+fechaHoraFormateada+".png";
        String filePath = directoryPath + "/" + fileName; 
        File screenshotFile = ((TakesScreenshot) returnDriver()).getScreenshotAs(OutputType.FILE);

        try {
        	File directory = new File(directoryPath);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            FileHandler.copy(screenshotFile, new File(filePath));
            System.out.println("Captura de pantalla guardada en: " + filePath);
        } catch (IOException e) {
            System.err.println("Error al guardar la captura de pantalla: " + e.getMessage());
        }
    }
    
    
    public static void scrollWithJS(WebElement element) {
        ((JavascriptExecutor) returnDriver()).executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center', inline: 'center'});", element);
    }
    
    public static WebElement waitPresence(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(returnDriver(), Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            return null; // Si el elemento no está presente, devuelve null
        }
    }
    
    
    public static void waitForElementWithJavaScript(WebElement element, int timeoutInSeconds) {
        JavascriptExecutor js = (JavascriptExecutor) returnDriver();
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < TimeUnit.SECONDS.toMillis(timeoutInSeconds)) {
            try {
                String visibility = (String) js.executeScript("return arguments[0].style.visibility;", element);
                if ("visible".equals(visibility)) {
                    return;
                }
            } catch (Exception e) {
                System.out.println("Error al esperar el elemento: " + e.getMessage());
            }
        }
        System.out.println("La espera ha excedido el tiempo de espera máximo.");
    }
    
    public static void scrollAndClickElement(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) returnDriver();
        while (true) {
            try {
                // Verifica si el elemento está presente en la página
                if (element.isDisplayed()) {
                    // Si el elemento se encuentra, haz clic en él
                	element.click();
                    return;
                }
            } catch (org.openqa.selenium.NoSuchElementException e) {
                // Elemento no encontrado, continúa desplazándote hacia abajo
            }
            long lastHeight = (Long) jsExecutor.executeScript("return document.body.scrollHeight");
            jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");

            try {
                Thread.sleep(2000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            long newHeight = (Long) jsExecutor.executeScript("return document.body.scrollHeight");

            if (newHeight == lastHeight) {
                break;
            }
            lastHeight = newHeight;
        }
    }
    
    public static void scrollToEndAndBackToTop() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) returnDriver();
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        jsExecutor.executeScript("return document.readyState").equals("complete");
        jsExecutor.executeScript("window.scrollTo(0, 0);");
    }

    public static void scrollToEndAndBackToTopWithWait() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) returnDriver();

        // Realiza un scroll hacia abajo en saltos largos (por ejemplo, 1000 píxeles)
        int scrollStep = 1000;
        long lastHeight = (Long) jsExecutor.executeScript("return document.body.scrollHeight");

        while (true) {
            // Scroll hacia abajo
            jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            try {
                Thread.sleep(2000); // Espera un tiempo para que los elementos se carguen
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            long newHeight = (Long) jsExecutor.executeScript("return document.body.scrollHeight");

            // Verifica si el nuevo scroll llegó al final de la página
            if (newHeight == lastHeight) {
                break;
            }

            lastHeight = newHeight;
        }

        // Scroll de vuelta al principio de la página
        jsExecutor.executeScript("window.scrollTo(0, 0);");
    }
    
}
