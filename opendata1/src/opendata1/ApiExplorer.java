package opendata1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class ApiExplorer {
    public static void main(String[] args) throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/9720000/searchservice/basic"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=mYR1nXRUuKTuyHRCCa31tVeDRnS0iqhCjiONTl39LXxYPXZPMu1vBAFlY3KU2LG8tGImfuD4Yr5nE714VhVYOQ%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageno","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("displaylines","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과(record)수*/
        urlBuilder.append("&" + URLEncoder.encode("search","UTF-8") + "=" + URLEncoder.encode("전체,코로나|서명,미국", "UTF-8")); /*검색항목,검색키워드[|검색항목,검색키워드] 형태의 검색조건 (각 항목은 AND 연산처리)*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
    }
}