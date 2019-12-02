package io.github.isandratskiy.driver;

import org.openqa.selenium.WebDriver;

public abstract class WebDriverProvider {
	private static final ThreadLocal<WebDriver> DRIVER_CONTAINER = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return DRIVER_CONTAINER.get();
	}

	public static void setDriver(WebDriver driver) {
		DRIVER_CONTAINER.set(driver);
	}

	public static void cleanUp() {
		DRIVER_CONTAINER.remove();
	}
}

