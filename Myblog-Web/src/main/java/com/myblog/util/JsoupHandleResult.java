package com.myblog.util;

import com.alibaba.fastjson.JSONArray;
import net.sf.json.JSONObject;
import org.jboss.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * /**
 *
 * @author: wuci
 * @date: 2018/7/19
 * @copyright:zjkj
 * @since : v 1.0
 */
public class JsoupHandleResult {
    private static final Logger LOG = Logger.getLogger(JsoupHandleResult.class);

    public static JSONObject getBaiduResult(String searchCondition, Long page) {
        JSONObject response = new JSONObject();
        JSONArray results = new JSONArray();
        try {
            Document dom = Jsoup.connect("http://www.baidu.com/s?wd=" + searchCondition + "&pn=" + page).get();
            Element content = dom.getElementById("content_left");
            Elements elementsByClass = content.getElementsByClass("result");
            Elements elementsByClass2 = content.getElementsByClass("result-op");
            addJsonArr(elementsByClass2, results);
            addJsonArr(elementsByClass, results);
            LOG.info("results>>>>>>:" + results);
            response.put("results", results);
            response.put("page", page);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    private static JSONArray addJsonArr(Elements elementsByClass, JSONArray results) {
        for (Element element : elementsByClass) {
            JSONObject params = new JSONObject();
            params.put("title", element.getElementsByTag("h3").text());
            params.put("href", element.getElementsByTag("a").attr("href"));
            results.add(params);
        }
        return results;
    }

    public static void main(String[] args) {

        getBaiduResult("王力宏", 0L);
    }

}
