package model;

import common.RandomData;

import model.event.eventInstance.FZRYXX;
import model.event.eventInstance.RK;
import model.event.eventInstance.TIELU;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by xliu on 2016/9/20.
 */
public class Description {
    public List<String> tbs;
    public List<String> ids;
    public List<String> attrs;
    public Map<String,String> les;
    public Map<String,String> bgs;
    public Map<String,String> eqs;
    public Map<String,String> lks;
    public Map<String,String> ins;
    public Map<String,String> nes;

    public Description(String tbs[],String ids[],String attrs[]){
        Collections.addAll(this.tbs = new ArrayList<String>(), tbs);
        Collections.addAll(this.ids = new ArrayList<String>(), ids);
        Collections.addAll(this.attrs = new ArrayList<String>(), attrs);
        this.les = new HashMap<String, String>();
        this.bgs = new HashMap<String, String>();
        this.eqs = new HashMap<String, String>();
        this.lks = new HashMap<String, String>();
        this.ins = new HashMap<String, String>();
        this.nes = new HashMap<String, String>();
    }

    public Description(){
        this.tbs=new ArrayList<String>();
        this.ids=new ArrayList<String>();
        this.attrs=new ArrayList<String>();
        this.les = new HashMap<String, String>();
        this.bgs = new HashMap<String, String>();
        this.eqs = new HashMap<String, String>();
        this.lks = new HashMap<String, String>();
        this.ins = new HashMap<String, String>();
        this.nes = new HashMap<String, String>();
    }
    public Description(String tbs[],String ids[],String attrs[],Map<String, String> les, Map<String, String> bgs, Map<String, String> eqs, Map<String, String> lks, Map<String, String> ins, Map<String, String> nes) {
        Collections.addAll(this.tbs = new ArrayList<String>(), tbs);
        Collections.addAll(this.ids = new ArrayList<String>(), ids);
        Collections.addAll(this.attrs = new ArrayList<String>(), attrs);
        this.les = les;
        this.bgs = bgs;
        this.eqs = eqs;
        this.lks = lks;
        this.ins = ins;
        this.nes = nes;
    }

    public static void put(Map<String,String> hash,String src){
        String attr=src.toUpperCase();
        if(attr.contains(".")){
            attr=attr.split(".")[1];
        }
        if(attr.contains("RQ")||attr.contains("RIQI")||attr.contains("DATE")){
            hash.put(src, RandomData.randomDate());
        }else if(attr.equals("SG")||attr.equals("ZC")||attr.equals("XQ")){
            hash.put(src, RandomData.randomCM(20,180));
        }else if(attr.equals("XM")||attr.equals("CYM")||attr.equals("ID_NAME")){
            hash.put(src,RandomData.randomName());
        }else if(attr.contains("DZ")||attr.contains("XZ")||attr.equals("HJD")||attr.contains("STATION")){
            hash.put(src,RandomData.randomCity());
        }else if(attr.contains("DM")||attr.contains("NO")){
            hash.put(src,RandomData.randomCM(0,40));
        }else if(attr.contains("XB")){
            hash.put(src,RandomData.randomSex());
        }else if(attr.contains("MZ")){
            hash.put(src,RandomData.randomMZ());
        }else{
            hash.put(src,RandomData.randomString());
        }
    }
    public static Description randomDescription(String tb,Description rd){
        if(rd==null){
            rd=new Description();
        }
        if("js_rkxx".equals(tb)){
            rd.tbs.add(tb);
            rd.ids.add(tb+".GMSFHM");
            put(rd.les,tb+"."+RandomData.randomChoice(RK.les));
            put(rd.bgs,tb+"."+RandomData.randomChoice(RK.bgs));
            put(rd.eqs,tb+"."+RandomData.randomChoice(RK.eqs));
            put(rd.lks,tb+"."+RandomData.randomChoice(RK.lks));
            put(rd.ins,tb+"."+RandomData.randomChoice(RK.ins));
            put(rd.nes,tb+"."+RandomData.randomChoice(RK.nes));
        }else if("js_fzryxx".equals(tb)){
            rd.tbs.add(tb);
            rd.ids.add(tb+".GMSFHM");
            put(rd.les,tb+"."+RandomData.randomChoice(FZRYXX.les));
            put(rd.bgs,tb+"."+RandomData.randomChoice(FZRYXX.bgs));
            put(rd.eqs,tb+"."+RandomData.randomChoice(FZRYXX.eqs));
            put(rd.lks,tb+"."+RandomData.randomChoice(FZRYXX.lks));
            put(rd.ins,tb+"."+RandomData.randomChoice(FZRYXX.ins));
            put(rd.nes,tb+"."+RandomData.randomChoice(FZRYXX.nes));
        }else if("js_tielu".equals(tb)){
            rd.tbs.add(tb);
            rd.ids.add(tb+".id_no");
            put(rd.les,tb+"."+RandomData.randomChoice(TIELU.les));
            put(rd.bgs,tb+"."+RandomData.randomChoice(TIELU.bgs));
            put(rd.eqs,tb+"."+RandomData.randomChoice(TIELU.eqs));
            put(rd.lks,tb+"."+RandomData.randomChoice(TIELU.lks));
        }
        return rd;
    }
}
