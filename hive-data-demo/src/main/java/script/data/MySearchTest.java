package script.data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MySearchTest {
    //private static String url = "http://rch.hfkktt.com/mp/article/index?_t=1542364074826";
    private static String url = "http://rch.hfkktt.com/mp/api/articles?before=&categories=";
    private static String blogName = "guoxiaolongonly";

    public static void main(String[] args) {
        getArticleListFromUrl(url);
    }

    /**
     *  * 获取文章列表
     *  *
     *  * @param listurl
     *  
     */
    public static void getArticleListFromUrl(final String listurl) {
        Document doc = null;
        try {
            String referrer = "http://rch.hfkktt.com/mp/article/index?_t=1542364074826";
            Map<String, String > cookies = new HashMap<String, String>();
            cookies.put("viewerWxOpenId","oxHmT1SDJA_O3z-mtTyWiJQKzWJA");
            cookies.put("viewerWxUnionId2","oLcWOv4E_G68ujA0zaYxlvjJeeig");
            cookies.put("wxMpToken","3486706fa7f9af5550b2d3658e7fad9eb5331ab08688c6e392236fef5aac6627");
            cookies.put("wxMpTokenForHomepage","3486706fa7f9af5550b2d3658e7fad9eb5331ab08688c6e392236fef5aac6627");
            String ua = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36 MicroMessenger/6.5.2.501 NetType/WIFI WindowsWechat QBCore/3.43.901.400 QQBrowser/9.0.2524.400";
            doc = Jsoup.connect(listurl).userAgent(ua)
                    .referrer(referrer)
                    .cookies(cookies)
                    .header("Content-Type", "application/json;charset=UTF-8")
                    .ignoreContentType(true)
                    .timeout(3000).post();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(doc.body().toString());
    }

}
