package model.event.eventInstance;

import common.Simple;
import model.Description;
import model.event.EventTb;

/**
 * Created by xliu on 2016/9/20.
 */
public class FZRYXX extends EventTb{
    public static String les[]={"CSRQ","SG","ZC","RSRQ","XQ","CSRIQI"};
    public static String bgs[]={"CSRQ","SG","ZC","RSRQ","XQ","CSRIQI"};
    public static String eqs[]={"CSRQ","SG","ZC","RSRQ","XQ","CSRIQI"};
    public static String lks[]={"XM","CYM","SF","JZDXZ","HJDXZ","TBTZ","JYAQ"};
    public static String ins[]={"XB","MZ","AJLB","HJD"};
    public static String nes[]={"XB","MZ","AJLB","HJD"};

    public FZRYXX(){
        this.tb="js_fzryxx";
        this.id ="gmsfhm";
    }
    public FZRYXX(String tb){
        this.tb=tb;
        this.id ="gmsfhm";
    }
//    public static void main(String args[]){
//
//        String ans=Simple.getGMSFHM(Description.randomDescription("js_fzryxx"));
//        int start=0,end,len=ans.length();
//        while(start<len){
//            end=Math.min(start+200,len);
//            System.out.println(ans.substring(start,end));
//            start=end;
//        }
//    }
}
