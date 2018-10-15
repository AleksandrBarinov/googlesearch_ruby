import hooks.Hooks;
import org.testng.annotations.Test;
import pages.MainPage;

public class SearchResultTest extends Hooks{

    @Test
    public void searchRubyTest() {

        MainPage mainPage = new MainPage(Hooks.driver);

        mainPage.fillSearchField("Ruby");

        mainPage.checkSearchResult("Ruby — Википедия");

    }

}
