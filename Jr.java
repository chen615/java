
import redis.clients.jedis.Jedis;

import java.util.Map;

public class Jr
{
    public static void main(String args[])
    {
        Jedis redis = new Jedis("192.168.10.191", 6379);
        // redis.auth(""); // password
        
        // redis.set("java-redis", "chen jian ping");
        
        Map<String, String> m = redis.hgetAll("National_brand");
        int j = 0;
        String str = "";
        int v = 0;
        for(Map.Entry entry : m.entrySet()) {
            str = (String)entry.getKey().toString();
            v = Integer.parseInt(entry.getValue().toString());
            if(str.startsWith("baiyunshan")) {
                if(v > 1477875600 && v < 1477962000) {
                    j = j + 1;
                } else {
                    System.out.println(str + "=" + v);
                }
 
            }
        }
        System.out.print(j);
    }
}