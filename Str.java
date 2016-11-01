
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import java.util.Map;
import java.util.HashMap;

import com.google.gson.Gson;
import com.alibaba.fastjson.JSON;

import com.cctvmall.entity.User;

public class Str
{
    public static void main(String args[])
    {
        String username = "chen jian ping";
        System.out.println(username);
        System.out.println(username.charAt(2));
        // System.out.println(username.codePointAt(2));
        System.out.println(username.concat("Li Ming"));
        System.out.println(username.contains("ping"));
        
        List<String> stu = new ArrayList<>();
        
        stu.add("chen");
        stu.add("jian");
        stu.add("ping");
        
        Iterator it = stu.iterator();
        while(it.hasNext()) {
            String str = (String)it.next();
            System.out.println(str);
        }
        
        List<String> stu1 = new ArrayList<String>();
        stu1.add("≥¬");
        stu1.add("Ω®");
        
        stu.addAll(1, stu1);
        
        Gson g = new Gson();
        System.out.println(g.toJson(stu));
        
        for(int i = 0; i < stu.size(); i = i + 1) {
            System.out.println(stu.get(i));
        }
        
        Map<String, Object> stu2 = new HashMap<String, Object>();
        
        stu2.put("name", "chen");
        stu2.put("age", 23);
        stu2.put("data", stu);
        
        System.out.println(g.toJson(stu2));
        
        System.out.println(JSON.toJSONString(stu2));        
        String array_json = "[{'id':1,'username':'’≈∑…','age':68},{'id':2,'username':'’‘‘∆','age':78}]";        
        List<User> users = JSON.parseArray(array_json, User.class);
        
        // System.out.println(g.toJson(users));
        for(int j = 0; j < users.size(); j = j + 1) {
            User user = users.get(j);
            System.out.println(user.getUsername());
        }
    }
}