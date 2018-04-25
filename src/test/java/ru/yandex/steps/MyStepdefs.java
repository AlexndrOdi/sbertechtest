package ru.yandex.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.pages.Yandex.YandexPage;
import ru.yandex.pages.Yandex.YmMainPage;
import ru.yandex.pages.Yandex.YmSearchPage;


public class MyStepdefs{
    private WebDriver driver;
    private YandexPage yandexPage;
    private YmMainPage ymMainPage;
    private YmSearchPage ymSearchPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C://Users/aodincov/Desktop/доки/stepic_java_webserver-master/stepic_java_webserver-master/chromedriver/chromedriver.exe");
        try{
            driver = new ChromeDriver();
            System.out.println("Browser open");
        }catch (IllegalStateException e){
            throw new IllegalStateException("Check path to ChromeDriver");
        }
    }

    @After
    public void close(){
        driver.quit();
    }

    @Когда("^пользователь открывает браузер и нажимает полноэкранные режим$")
    public void открываетсяБраузер() throws Throwable {
        driver.manage().window().fullscreen();
    }

    @И("^пользователь переходит на yandex.ru$")
    public void пользовательПереходит() throws Throwable {
        driver.get("https://yandex.ru/");
    }

    @Тогда("^открывается страница yandex.ru$")
    public void открываетсяСтраница() throws Throwable {
        yandexPage = new YandexPage(this.driver);
        Assert.assertTrue(yandexPage.checkTitle("Яндекс"));
    }

    @Когда("^пользователь нажимает маркет$")
    public void пользовательНажимаетМаркет() throws Throwable {
        yandexPage.navigateToMarket();
    }

    @Тогда("^переходит на яндекс маркет$")
    public void переходитНаЯндексМаркет() throws Throwable {
        Assert.assertTrue(driver.getTitle().equals("Яндекс.Маркет — выбор и покупка товаров из проверенных интернет-магазинов"));
    }

    @Когда("^пользователь выбирает раздел комьютеры$")
    public void пользовательВыбираетРазделКомьютеры() throws Throwable {
        ymMainPage = new YmMainPage(driver);
        ymMainPage.pressComp();
    }

    @И("^выбирает раздел Ноутбуки$")
    public void выбираетРазделНоутбуки() throws Throwable {
        ymMainPage.pressLaptop();
    }

    @Тогда("^пользователь находится в разделе Ноутбуки$")
    public void пользовательНаходитсяВРазделеНоутбуки() throws Throwable {
        System.out.println("In laptop");
    }

    @Когда("^пользователь переходит в расширенный поиск$")
    public void пользовательПереходитВРасширенныйПоиск() throws Throwable {
        ymMainPage.pressFilters();
    }

    @И("^выбирает производителя HP и Lenovo$")
    public void выбираетПроизводителяHPИLenovo() throws Throwable {
        ymSearchPage = new YmSearchPage(driver);
        ymSearchPage.setCheckBox("HP");
        ymSearchPage.setCheckBox("Lenovo");
    }

    /*@И("^нажимает кнопку Применить$")
    public void нажимаетКнопкуПрименить() throws Throwable {

    }

    @Тогда("^отображается (\\d+) элементов на странице$")
    public void отображаетсяЭлементовНаСтранице(int countElements) throws Throwable {
        ResultPage resultPage = new ResultPage();
        resultPage.chekResultCount("10");
    }*/
}
