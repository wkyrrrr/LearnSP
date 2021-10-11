package com.jykj.common.api;

import com.geektime.spring.hello.demo.DemoApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * @author abner
 */
@SpringBootApplication
@RestController
public class BookManagerApiController {
//    public static void main(String[] args) {
//        SpringApplication.run(BookManagerApiController.class, args);
//    }

    @RequestMapping("/book")
    public String getBookInfo(@RequestParam(name = "param") String param){
        return call("https://api.zuk.pw/situ/book/isbn/", param);
    }



    private static String call(String url, String isbn){
        String urlName = url + isbn;
        String result = "";
        try{
            URL realURL = new URL(urlName);
            URLConnection urlConnection = realURL.openConnection();
            urlConnection.setRequestProperty("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
            urlConnection.setRequestProperty("accept-encoding", "gzip, deflate, br");
            urlConnection.setRequestProperty("accept-language", "zh-CN,zh;q=0.9,en;q=0.8,ja;q=0.7");
            urlConnection.setRequestProperty("connection", "Keep-Alive");
            urlConnection.setRequestProperty("sec-ch-ua-platform", "macOS");
            urlConnection.setRequestProperty("Upgrade-Insecure-Requests", "1");
            urlConnection.setRequestProperty("sec-ch-ua", "Google Chrome;v=93,  Not;A Brand;v=99, Chromium;v=93");
            urlConnection.setRequestProperty("user-agent", " Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/93.0.4577.82 Safari/537.36");
            urlConnection.connect();

            Map<String, List<String>> map = urlConnection.getHeaderFields();
            for (String s:map.keySet()){
                System.out.println(s + "-->" + map.get(s));
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null){
                result = "\n" + line;
            }

        }
        catch (IOException ioException){
            ioException.printStackTrace();
        }

        return  result;
    }
}
