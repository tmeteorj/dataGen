package common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import model.Description;

import java.io.*;
import java.nio.Buffer;
import java.util.Map;

/**
 * Created by xliu on 2016/9/21.
 */
public class JSONReader {
    public static Description getDescriptionOne(String inputpath,String stb[],String attrs[],String ids[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(new File(inputpath)),"utf-8"));
        String line;
        StringBuffer sb=new StringBuffer();
        while((line=br.readLine())!=null){
            sb.append(line);
        }
        JSONObject js=JSONObject.parseObject(sb.toString());
        Description des=new Description();
        JSONArray tbs= JSONArray.parseArray(JSON.toJSONString(js.get("tb")));
        for(int i=0;i<stb.length;i++) {
            des.tbs.add(stb[i] + " " + tbs.get(i));
            tbs.set(i,tbs.get(i)+".");
        }
        String tb=tbs.getString(0);
        for(String s:attrs){
            des.attrs.add(tb+s);
        }
        for(String s:ids){
            des.ids.add(tb+s);
        }
        for (Object o : JSON.parseObject(js.getString("les")).entrySet()) {
            Map.Entry<String,String> entry = (Map.Entry<String,String>)o;
            des.les.put(tb+entry.getKey(),entry.getValue());
        }
        for (Object o : JSON.parseObject(js.getString("bgs")).entrySet()) {
            Map.Entry<String,String> entry = (Map.Entry<String,String>)o;
            des.bgs.put(tb+entry.getKey(),entry.getValue());
        }
        for (Object o : JSON.parseObject(js.getString("eqs")).entrySet()) {
            Map.Entry<String,String> entry = (Map.Entry<String,String>)o;
            des.eqs.put(tb+entry.getKey(),entry.getValue());
        }
        for (Object o : JSON.parseObject(js.getString("lks")).entrySet()) {
            Map.Entry<String,String> entry = (Map.Entry<String,String>)o;
            des.lks.put(tb+entry.getKey(),entry.getValue());
        }
        for (Object o : JSON.parseObject(js.getString("ins")).entrySet()) {
            Map.Entry<String,String> entry = (Map.Entry<String,String>)o;
            des.ins.put(tb+entry.getKey(),entry.getValue());
        }
        for (Object o : JSON.parseObject(js.getString("nes")).entrySet()) {
            Map.Entry<String,String> entry = (Map.Entry<String,String>)o;
            des.nes.put(tb+entry.getKey(),entry.getValue());
        }
        return des;
    }

}
