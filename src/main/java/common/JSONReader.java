package common;

import com.alibaba.fastjson.JSONObject;
import model.Description;

import java.io.*;
import java.nio.Buffer;

/**
 * Created by xliu on 2016/9/21.
 */
public class JSONReader {
    static Description getDescription(String inputpath) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(new File(inputpath))));
        String line;
        StringBuffer sb=new StringBuffer();
        while((line=br.readLine())!=null){
            sb.append(line);
        }
        JSONObject js=JSONObject.parseObject(sb.toString());
        Description des=new Description();
        des.tbs.add(js.getString("tb"));
        JSONObject les=JSONObject.parseObject(js.getString("les"));
        System.out.println(les);
        return des;
    }
    public static void main(String args[]) throws IOException {
        getDescription("data/rka.json");
    }
}
