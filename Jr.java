
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
            if(str.startsWith("laocaitangguo")) {
                if(v > 1476406800 && v < 1476493200) {
                    j = j + 1;
                } else {
                    System.out.println(str + "=" + v);
                }
 
            }
        }
        System.out.print(j);
    }
}