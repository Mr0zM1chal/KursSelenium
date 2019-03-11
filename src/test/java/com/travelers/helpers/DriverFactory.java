package com.travelers.helpers;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaDriverService;
import org.openqa.selenium.remote.session.FirefoxFilter;

import java.io.File;

public class DriverFactory {

    private static WebDriver driverInstance;

    public static WebDriver getDriver(DriverType driverType) throws NoSuchDriverException {
        if(driverInstance == null) {
            System.out.println("Inicializacja drivera");
            getSpecWebDriver(DriverType.CHROME);
            Dimension dimension = new Dimension(500, 500);
            driverInstance.manage().window().maximize();
        }
        return driverInstance;
    }
    public static void getSpecWebDriver(DriverType driverType) throws NoSuchDriverException {
        switch (driverType){
            case OPERA:
                File driverExe = new File("\\src\\main\\resources\\executables\\drivers\\operadriver.exe");
                OperaDriverService driverService = new OperaDriverService
                        .Builder()
                        .usingDriverExecutable(driverExe)
                        .usingAnyFreePort()
                        .build();
                driverInstance = new OperaDriver(driverService);
                break;
            case CHROME:
                File driverExe1 = new File("src//main//resources//executables//drivers//chromedriver.exe");
                ChromeDriverService driverService1 = new ChromeDriverService
                        .Builder()
                        .usingDriverExecutable(driverExe1)
                        .usingAnyFreePort()
                        .build();
                driverInstance = new ChromeDriver(driverService1);
                break;
            case FIREFOX:
                File driverExe2 = new File("\\src\\main\\resources\\executables\\drivers\\geckodriver.exe");
                GeckoDriverService driverService2 = new GeckoDriverService
                        .Builder()
                        .usingDriverExecutable(driverExe2)
                        .usingAnyFreePort()
                        .build();
                driverInstance = new FirefoxDriver(driverService2);
                break;
                default:
                    System.out.println("Brak żądanego drivera.");
                    throw new NoSuchDriverException();
        }
    }
}
