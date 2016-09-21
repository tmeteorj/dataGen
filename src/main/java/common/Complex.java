package common;

import com.alibaba.fastjson.JSONObject;

import model.Description;
import sun.security.krb5.internal.crypto.Des;

/**
 * Created by xliu on 2016/9/20.
 */
public class Complex {
    public static String aInB(Description a,Description b){
        String da=Simple.getGMSFHM(a,null);
        String db=Simple.getGMSFHM(b,null);
        return String.format("%s and %s in ( %s )",da,a.ids.get(0),db);
    }
    public static void main(String args[]){
        Description rka=new Description();
        Description rkb=new Description();
        Description tl=new Description();
        rka.tbs.add("js_rkxx");
        rka.ids.add("js_rkxx.gmsfhm");
        rka.attrs.add("js_rkxx.gmsfhm");
        rka.bgs.put("js_rkxx.SG","180");
        rka.nes.put("js_rkxx.JG_SSXQDM","四川");

        tl.tbs.add("js_tielu");
        tl.ids.add("js_tielu.id_no");
        tl.attrs.add("js_tielu.coach_no");
        tl.attrs.add("js_tielu.board_train_code");
        tl.attrs.add("js_tielu.train_date");
        tl.eqs.put("js_tielu.id_no","$js_rkxx.gmsfhm$");
        tl.bgs.put("js_tielu.train_date","20160303");
        tl.les.put("js_tielu.train_date","20160403");
        String tls;
        System.out.println(tls=aInB(tl,rka));

        int idx=1;
        String tbtmp="s"+idx++;
        rkb.tbs.add("js_rkxx");
        rkb.ids.add("js_rkxx.gmsfhm");
        rkb.tbs.add("js_tielu");
        rkb.ids.add("js_tielu.id_no");
        rkb.attrs.add("js_rkxx.gmsfhm");
        rkb.les.put("js_rkxx.SG","165");
        rkb.ins.put("js_rkxx.JG_SSXQDM","四川");
        rkb.eqs.put("js_tielu.id_no","$js_rkxx.gmsfhm$");
        rkb.eqs.put("js_tielu.coach_no",String.format("$%s.coach_no$",tbtmp));
        rkb.eqs.put("js_tielu.board_train_code",String.format("$%s.board_train_code$",tbtmp));
        rkb.eqs.put("js_tielu.train_date",String.format("$%s.train_date$",tbtmp));
        System.out.println(tls=Simple.getGMSFHM(rkb,String.format("(%s) %s",tls,tbtmp)));


        //System.out.println(Simple.getGMSFHM(tl));
    }
}
