import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

public class PlaywrightTest {

    private Browser browser;
    private Page page;

    @BeforeEach
    public void setUp() {
        Playwright playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        page = browser.newPage();
    }

    @Test
    public void testPageTitle() {
        page.navigate("https://example.com");
        Assertions.assertEquals("Example Domain", page.title());
    }

    @AfterEach
    public void tearDown() {
        if (browser != null) {
            browser.close();
        }
    }
}

