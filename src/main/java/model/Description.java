package model;

import model.event.eventInstance.FZRYXX;
import model.event.eventInstance.RK;
import model.event.eventInstance.TIELU;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by xliu on 2016/9/20.
 */
public class Description {
    public String tb;
    public String id;
    public Map<String,String> les;
    public Map<String,String> bgs;
    public Map<String,String> eqs;
    public Map<String,String> lks;
    public Map<String,String> ins;
    public Map<String,String> nes;

    public Description(){
        this.tb = "some_tb";
        this.id = "GMSFHM";
        this.les = new HashMap<String, String>();
        this.bgs = new HashMap<String, String>();
        this.eqs = new HashMap<String, String>();
        this.lks = new HashMap<String, String>();
        this.ins = new HashMap<String, String>();
        this.nes = new HashMap<String, String>();
    }
    public Description(String tb,String id,Map<String, String> les, Map<String, String> bgs, Map<String, String> eqs, Map<String, String> lks, Map<String, String> ins, Map<String, String> nes) {
        this.tb = tb;
        this.id = id;
        this.les = les;
        this.bgs = bgs;
        this.eqs = eqs;
        this.lks = lks;
        this.ins = ins;
        this.nes = nes;
    }

    public static String randomChoice(final String attrs[]){
        int rd=(int)(Math.random()*attrs.length);
        return attrs[rd];
    }
    public static String randomName(){
        String base="城市地理区块的不同属性在一定程度上影响着居住在其上的用户的行为模式与通讯特点与此同时用户的行为特征也在一定程度上反映出了地块的本身属性通过研究地块下的人类行为动力学以及通讯网络的特性对地块属性进行鉴别分析对地块类别演化进行推演归纳对人口迁徙进行建模预测能够对城市规划起到决策支持的作用在此背景下本文对真实的大规模手机数据进行包括人类行为动力学以及复杂网络的分析具体工作如下";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        int length=random.nextInt(5)+5;
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
    public static Description randomDescription(String tb){
        Description rd=new Description();
        rd.tb=tb;
        rd.id="GMSFHM";
        if("js_rkxx".equals(tb)){
            rd.les.put(randomChoice(RK.les),String.valueOf((int)(Math.random()*100000)));
            rd.bgs.put(randomChoice(RK.bgs),String.valueOf((int)(Math.random()*100000)));
            rd.eqs.put(randomChoice(RK.eqs),String.valueOf((int)(Math.random()*100000)));
            rd.lks.put(randomChoice(RK.lks),randomName());
            rd.ins.put(randomChoice(RK.ins),randomName());
            rd.nes.put(randomChoice(RK.nes),randomName());
        }else if("js_fzryxx".equals(tb)){
            rd.les.put(randomChoice(FZRYXX.les),String.valueOf((int)(Math.random()*100000)));
            rd.bgs.put(randomChoice(FZRYXX.bgs),String.valueOf((int)(Math.random()*100000)));
            rd.eqs.put(randomChoice(FZRYXX.eqs),String.valueOf((int)(Math.random()*100000)));
            rd.lks.put(randomChoice(FZRYXX.lks),randomName());
            rd.ins.put(randomChoice(FZRYXX.ins),randomName());
            rd.nes.put(randomChoice(FZRYXX.nes),randomName());
        }else if("js_tielu".equals(tb)){
            rd.id="id_no";
            rd.les.put(randomChoice(TIELU.les),String.valueOf((int)(Math.random()*100000)));
            rd.bgs.put(randomChoice(TIELU.bgs),String.valueOf((int)(Math.random()*100000)));
            rd.eqs.put(randomChoice(TIELU.eqs),String.valueOf((int)(Math.random()*100000)));
            rd.lks.put(randomChoice(TIELU.lks),randomName());
        }
        return rd;
    }
}
