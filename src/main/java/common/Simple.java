package common;

import model.Description;
import model.code.CodeTb;
import model.code.codeInstance.AJLB;
import model.code.codeInstance.MZ;
import model.code.codeInstance.XB;
import model.code.codeInstance.XZQH;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by Administrator on 2016/9/20.
 */
public class Simple {
    private static  Logger LOGGER= LoggerFactory.getLogger(Simple.class);

    public static String getOPS(String tb,String attr,String sep,String value){
        return String.format("%s.%s%s\'%s\'",tb,attr,sep,value);
    }
    public static String getLKS(String tb,String attr,String value){
        return String.format("%s.%s like \'%%%s%%\'",tb,attr,value);
    }
    public static CodeTb getCodetb(String attr){
        attr=attr.toUpperCase();
        if("MZDM".equals(attr)||"XB".equals(attr)){
            return new MZ();
        }else if("XBDM".equals(attr)||"MZ".equals(attr)){
            return new XB();
        }else if("JG_SSXQDM".equals(attr)||"HJD".equals(attr)||"HJDZ_SSXQDM".equals(attr)){
            return new XZQH();
        }else if("AJLB".equals(attr)){
            return new AJLB();
        }else{
            LOGGER.warn("getCodetb is null for attr {}",attr);
            return null;
        }
    }
    public static String getINS(String tb,String attr,String value){
        CodeTb codeTb =getCodetb(attr);
        if(codeTb ==null)return "";
        return String.format("%s.%s in ( %s )",tb,attr, codeTb.getDM(value));
    }
    public static String getNES(String tb,String attr,String value){
        CodeTb codeTb =getCodetb(attr);
        if(codeTb ==null)return "";
        return String.format("not exists ( %s and %s.%s=%s.%s)", codeTb.getDM(value),tb,attr, codeTb.tb, codeTb.dm);
    }

    public static String getGMSFHM(Description des){

        String tb=des.tb;
        String id=des.id;
        String ans=String.format("select %s.%s from %s ",tb,id,tb);
        String preffix="where ";
        for(Map.Entry<String,String> entry:des.les.entrySet()){
            ans+=preffix+ Simple.getOPS(tb,entry.getKey(),"<",entry.getValue())+" ";
            preffix="and ";
        }
        for(Map.Entry<String,String> entry:des.bgs.entrySet()){
            ans+=preffix+Simple.getOPS(tb,entry.getKey(),">",entry.getValue())+" ";
            preffix="and ";
        }
        for(Map.Entry<String,String> entry:des.eqs.entrySet()){
            ans+=preffix+Simple.getOPS(tb,entry.getKey(),"=",entry.getValue())+" ";
            preffix="and ";
        }
        for(Map.Entry<String,String> entry:des.lks.entrySet()){
            ans+=preffix+Simple.getLKS(tb,entry.getKey(),entry.getValue())+" ";
            preffix="and ";
        }
        for(Map.Entry<String,String> entry:des.ins.entrySet()){
            ans+=preffix+Simple.getINS(tb,entry.getKey(),entry.getValue())+" ";
            preffix="and ";
        }
        for(Map.Entry<String,String> entry:des.nes.entrySet()){
            ans+=preffix+Simple.getNES(tb,entry.getKey(),entry.getValue())+" ";
            preffix="and ";
        }
        return ans;
    }
}
