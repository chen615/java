
import org.apache.http.client.ClientProtocolException;
// import org.apache.http.HttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;

import org.apache.http.entity.StringEntity;

// import org.apache.http.protocol.HTTP;

import org.apache.http.util.EntityUtils;
import org.apache.http.HttpEntity;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;


public class Hcurl
{
    public static void main(String args[]) throws IOException
    {
        Hcurl hcurl = new Hcurl();
        hcurl.doGet();
        // hcurl.doPost();
        // hcurl.doPostBody();
    }

    private void doGet() throws IOException
    {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // String url = "http://m.cctvmall.com/games/cod/buymessage?skucode=8019870001";
        String url = "http://api.jisuapi.com/express/query?appkey=f14073139cdf7c5e&type=auto&number=610416881782";
        try {
            HttpGet request = new HttpGet(url);
            request.setHeader("", "");

            CloseableHttpResponse response = httpclient.execute(request);

            // System.out.println(response.getStatusLine());
            // System.out.println(response.getStatusLine().getStatusCode());
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity, "utf-8");
            // System.out.println(result);
            // System.out.println(entity.getContent());
            // System.out.println(EntityUtils.toString(entity));

            //没有对象直接解析JSON对象
            JSONObject jobj = JSON.parseObject(result);
            System.out.println(jobj.getString("status"));
            System.out.println(jobj.getString("msg"));
            String results = jobj.getString("result");
            // System.out.println(results);

            JSONObject jobj1 = JSON.parseObject(results);
            System.out.println(jobj1.getString("number"));
            System.out.println(jobj1.getString("type"));
            System.out.println(jobj1.getString("deliverystatus"));
            System.out.println(jobj1.getString("issign"));

            String lists = jobj1.getString("list");
            // System.out.println(jobj1.getString("list"));

            //没有对象直接解析JSON数组
            JSONArray jarr = JSON.parseArray(lists);
            for(int i=0,len=jarr.size();i<len;i++){
                JSONObject temp=  jarr.getJSONObject(i);
                System.out.printf("name:%s, %s\n",temp.getString("time"), temp.getString("status"));
            }

        } catch(Exception e) {
            System.out.println("error: " + e.getMessage());
        } finally {
            httpclient.close();
        }
    }

    private void doPost() throws IOException
    {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String url = "http://local.mvc.com/";
        try {
            HttpPost request = new HttpPost(url);
            // request.setHeader("", "");

            List<NameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair("username", "chen jian ping"));

            request.setEntity(new UrlEncodedFormEntity(params, "utf-8"));
            CloseableHttpResponse response = httpclient.execute(request);

            // System.out.println(response.getStatusLine());
            // System.out.println(response.getStatusLine().getStatusCode());
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity, "utf-8");
            System.out.println(result);
            // System.out.println(entity.getContent());
            // System.out.println(EntityUtils.toString(entity));


        } catch(Exception e) {
            System.out.println("error: " + e.getMessage());
        } finally {
            httpclient.close();
        }
    }

    private void doPostBody() throws IOException
    {
        String uri = "http://local.mvc.com/";

        List<Object> list = new ArrayList<>();
        list.add("chen");

        JSONObject jsonobject = new JSONObject();
        jsonobject.put("username", "Li Ming");
        jsonobject.put("age", 23);
        jsonobject.put("list", list);

        // System.out.println(jsonobject.toString());
        CloseableHttpClient httpclient = HttpClients.createDefault();

        try {
            HttpPost request = new HttpPost(uri);
            request.addHeader("Content-Type", "application/json");
            request.setEntity(new StringEntity(jsonobject.toString()));
            CloseableHttpResponse response = httpclient.execute(request);

            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity, "utf-8");
            System.out.println(result);
        } catch(Exception e){

        } finally {
            httpclient.close();
        }

        // RequestEntity entity = new StringRequestEntity(data.toString(), "application/json", null);
        // request.setRequestEntity(entity);
    }
}