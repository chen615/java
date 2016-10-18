
import redis.clients.jedis.Jedis;

public class Jr
{
    public static void main(String args[])
    {
        Jedis redis = new Jedis("127.0.0.1", 6379);
        // redis.auth(""); // password
        
        redis.set("java-redis", "chen jian ping");
    }
}