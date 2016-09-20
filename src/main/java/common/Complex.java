package common;

import model.Description;
import sun.security.krb5.internal.crypto.Des;

/**
 * Created by xliu on 2016/9/20.
 */
public class Complex {
    public static String aInB(Description a,Description b){
        String da=Simple.getGMSFHM(a);
        String db=Simple.getGMSFHM(b);
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
        System.out.println(aInB(tl,rka));

        //System.out.println(Simple.getGMSFHM(tl));
    }
}
