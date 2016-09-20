package common;

import model.Description;
import model.code.CodeTb;
import model.code.codeInstance.AJLB;
import model.code.codeInstance.MZ;
import model.code.codeInstance.XB;
import model.code.codeInstance.XZQH;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/9/20.
 */
public class Simple {
    private static  Logger LOGGER= LoggerFactory.getLogger(Simple.class);

    public static String getOPS(String attr,String sep,String value){
        if(sep.equals("=")&&value.charAt(0)=='$'&&value.charAt(value.length()-1)=='$'){
            return String.format("%s%s%s",attr,sep,value.substring(1,value.length()-1));
        }
        return String.format("%s%s\'%s\'",attr,sep,value);
    }
    public static String getLKS(String attr,String value){
        return String.format("%s like \'%%%s%%\'",attr,value);
    }
    public static CodeTb getCodetb(String attr){
        attr=attr.toUpperCase();
        if(attr.contains("MZDM")||attr.contains("XB")){
            return new MZ();
        }else if(attr.contains("XBDM")||attr.contains("MZ")){
            return new XB();
        }else if(attr.contains("JG_SSXQDM")||attr.contains("HJD")||attr.contains("HJDZ_SSXQDM")){
            return new XZQH();
        }else if(attr.contains("AJLB")){
            return new AJLB();
        }else{
            LOGGER.warn("getCodetb is null for attr {}",attr);
            return null;
        }
    }
    public static String getINS(String attr,String value){
        CodeTb codeTb =getCodetb(attr);
        if(codeTb ==null)return "";
        return String.format("%s in ( %s )",attr, codeTb.getDM(value));
    }
    public static String getNES(String attr,String value){
        CodeTb codeTb =getCodetb(attr);
        if(codeTb ==null)return "";
        return String.format("not exists ( %s and %s=%s.%s)", codeTb.getDM(value),attr, codeTb.tb, codeTb.dm);
    }

    public static String getGMSFHM(Description des){
        String ans="";
        String preffix="select";
        for(String s:des.attrs){
            ans=ans+preffix+String.format(" %s %s",s,s.substring(s.indexOf(".")+1));
            preffix=",";
        }

        preffix=" from";
        for(String s:des.tbs){
            ans=ans+preffix+String.format(" %s",s);
            preffix=",";
        }
        preffix=" where ";
        for(Map.Entry<String,String> entry:des.les.entrySet()){
            ans+=preffix+ Simple.getOPS(entry.getKey(),"<",entry.getValue());
            preffix=" and ";
        }
        for(Map.Entry<String,String> entry:des.bgs.entrySet()){
            ans+=preffix+Simple.getOPS(entry.getKey(),">",entry.getValue());
            preffix=" and ";
        }
        for(Map.Entry<String,String> entry:des.eqs.entrySet()){
            ans+=preffix+Simple.getOPS(entry.getKey(),"=",entry.getValue());
            preffix="and ";
        }
        for(Map.Entry<String,String> entry:des.lks.entrySet()){
            ans+=preffix+Simple.getLKS(entry.getKey(),entry.getValue());
            preffix=" and ";
        }
        for(Map.Entry<String,String> entry:des.ins.entrySet()){
            ans+=preffix+Simple.getINS(entry.getKey(),entry.getValue());
            preffix=" and ";
        }
        for(Map.Entry<String,String> entry:des.nes.entrySet()){
            ans+=preffix+Simple.getNES(entry.getKey(),entry.getValue());
            preffix=" and ";
        }
        return ans;
    }
}
