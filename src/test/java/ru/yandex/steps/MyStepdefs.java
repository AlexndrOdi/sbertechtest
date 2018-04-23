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


public class MyStepdefs{
    private WebDriver driver;
    private YandexPage yandexPage;
    private YmMainPage ymMainPage;

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
        ymMainPage.chooseComp();
//        Assert.assertTrue(driver.getTitle().equals("Компьютерная техника — купить на Яндекс.Маркете"));
    }

    /*@И("^выбирает раздел Ноутбуки$")
    public void выбираетРазделНоутбуки() throws Throwable {
        driver.findElement(By.linkText("Ноутбуки")).click();
    }

    @Тогда("^пользователь находится в разделе Ноутбуки$")
    public void пользовательНаходитсяВРазделеНоутбуки() throws Throwable {
        Assert.assertTrue(driver.getTitle().equals("Ноутбуки — купить на Яндекс.Маркете"));
    }

    @Когда("^пользователь переходит в расширенный поиск$")
    public void пользовательПереходитВРасширенныйПоиск() throws Throwable {

        driver.findElement(By.cssSelector("#search-prepack > div > div > div:nth-child(2) > div > div._3U2TeVBOWN > div > div > a")).click();

        Assert.assertTrue(driver.getTitle().equals("Все фильтры — Ноутбуки — выбор по параметрам на Яндекс.Маркете"));
    }

    @И("^выбирает производителя HP и Lenovo$")
    public void выбираетПроизводителяHPИLenovo() throws Throwable {

        driver.findElement(By.cssSelector("body > div.main > div:nth-child(5) > div > div.n-filter-panel-extend.i-bem.n-filter-panel-extend_js_inited > div:nth-child(1) > div:nth-child(2) > div.n-filter-block__body.i-bem.n-filter-block__body_js_inited > div > div.n-filter-block__list-items.i-bem > div:nth-child(6) > a > span")).click();
        driver.findElement(By.cssSelector("body > div.main > div:nth-child(5) > div > div.n-filter-panel-extend.i-bem.n-filter-panel-extend_js_inited > div:nth-child(1) > div:nth-child(2) > div.n-filter-block__body.i-bem.n-filter-block__body_js_inited > div > div.n-filter-block__list-items.i-bem > div:nth-child(7) > a > span")).click();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);

        Assert.assertTrue(driver.findElement(By.id("glf-7893318-152981")).isSelected());
        Assert.assertTrue(driver.findElement(By.id("glf-7893318-152981")).isSelected());
    }

    @И("^нажимает кнопку Применить$")
    public void нажимаетКнопкуПрименить() throws Throwable {
        driver.findElement(By.linkText("Показать подходящие"));
    }

    @Тогда("^отображается (\\d+) элементов на странице$")
    public void отображаетсяЭлементовНаСтранице(int countElements) throws Throwable {
        ResultPage resultPage = new ResultPage();
        resultPage.chekResultCount("10");
    }*/
}
