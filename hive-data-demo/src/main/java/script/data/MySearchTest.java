package script.data;

import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MySearchTest {
    //private static String url = "http://rch.hfkktt.com/mp/article/index?_t=1542364074826";
    private static String url = "http://api.tongji.qinglizi.cn/app/list?pn=1&rn=20";
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
            String referrer = "http://www.qinglizi.cn/home/list";
            Map<String, String > cookies = new HashMap<String, String>();
            cookies.put("X-TOKEN","1c60ad1fb4248fd0f262f160664b4841");
            cookies.put("Set-Cookie","SID=p43gq0j23ts4emlmkca2iovd74; path=/; HttpOnly");
            String ua = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36 MicroMessenger/6.5.2.501 NetType/WIFI WindowsWechat QBCore/3.43.901.400 QQBrowser/9.0.2524.400";
            doc = Jsoup.connect(listurl).userAgent(ua)
                    .referrer(referrer)
//                    .cookies(cookies)
                    .header("X-TOKEN", "1c60ad1fb4248fd0f262f160664b4841")
                    .header("Cookie", "SID=h0fr6siqghubq75d03o6ahi2d0; ")
                    .header("Content-Type", "application/json;charset=UTF-8")
                    .ignoreContentType(true)
                    .timeout(3000).post();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String body = doc.body().html().toString().replace("&quot;", "\"");
        JSONObject jsonObject = JSONObject.parseObject(body);
        System.out.println(jsonObject.toJSONString());

    }

}
