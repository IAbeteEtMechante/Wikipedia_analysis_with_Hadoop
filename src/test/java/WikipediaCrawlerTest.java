import junit.framework.TestCase;
import org.junit.Test;

// import static org.junit.Assert.*;

public class WikipediaCrawlerTest extends TestCase {

    @Test
    public void testParseFromJsonResponse() throws Exception {
        String result =
                WikipediaCrawler.parseFromJsonResponse(WikipediaCrawler.prepUrl("articles"));
        assertEquals(result, "Isaac_Newton,20151001,11417");
    }
}