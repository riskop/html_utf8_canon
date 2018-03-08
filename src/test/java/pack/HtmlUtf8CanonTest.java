package pack;

import org.apache.commons.text.StringEscapeUtils;
import org.jsoup.Jsoup;
import org.junit.Test;

public class HtmlUtf8CanonTest {

    /**
     * goal is to replace HTML entities with UTF-8 characters where possible
     * (in other words, replace all entities *except* &lt; &gt; &amp; &quot; &apos;)
     * 
     * @throws Exception
     */
    @Test
    public void test() throws Exception {

        String html = 
                "<html><head><META http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">" +
                "</head><body>&aacute;rv&iacute;zt&#x0171;r&#x0151;&lt;b</body></html>";

        // this is not good, keeps only the text content
        String s1 = Jsoup.parse(html).text();
        System.out.println("s1: " + s1);
        
        // this is better, but it unescapes the &lt; which is not what I want
        String s2 = StringEscapeUtils.unescapeHtml4(html);
        System.out.println("s2: " + s2);
    }

}
