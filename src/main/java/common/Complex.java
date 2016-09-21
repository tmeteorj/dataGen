package common;

import com.alibaba.fastjson.JSONObject;

import model.Description;
import sun.security.krb5.internal.crypto.Des;

/**
 * Created by xliu on 2016/9/20.
 */
public class Complex {
    public static String aInB(Description a,String  db){
        String da=Simple.getGMSFHM(a,null);
        return String.format("%s and %s in ( %s )",da,a.ids.get(0),db);
    }
    public static String aInB(Description a,Description b){
        String da=Simple.getGMSFHM(a,null);
        String db=Simple.getGMSFHM(b,null);
        return String.format("%s and %s in ( %s )",da,a.ids.get(0),db);
    }
    public static String generate(Description rka,
                           Description fza,
                           Description tla,
                           Description rkb,
                           Description tlb,
                           Description rkc){
        String tls;
        System.out.println("A with fz:\n"+(tls=aInB(rka,fza)));
        System.out.println("Train with A:\n"+(tls=aInB(tla,tls)));
        System.out.println("B with Train:\n"+(tls=Simple.getGMSFHM(rkb,String.format("(%s) js_tielu3",tls))));
        System.out.println("Train with B:\n"+(tls=aInB(tlb,tls)));
        System.out.println("C with B:\n"+(tls=Simple.getGMSFHM(rkc,String.format("(%s) js_tielu6",tls))));
        return tls;
    }
    public static void gen(){
        int idrk=1,idfz=1,idtl=1;
        String tbrka,tbfza,tbtla;
        String tbtlb,tbrkb,tbrkb2,tbrkb3;
        String tbtlc,tbrkc,tbrkc2,tbrkc3;
        String tls;
        Description rka=new Description();
        Description fza=new Description();
        Description tla=new Description();
        Description rkb=new Description();
        Description tlb=new Description();
        Description rkc=new Description();
        //犯罪行为A
        tbfza="js_fzryxx"+idfz++;
        fza.tbs.add("js_fzryxx "+tbfza);
        fza.ids.add(tbfza+".gmsfhm");
        fza.attrs.add(tbfza+".gmsfhm");
        fza.bgs.put(tbfza+".SG","180");
        fza.lks.put(tbfza+".jyaq","打劫");

        //有犯罪行为A，特征A的人A
        tbrka="js_rkxx"+idrk++;
        rka.tbs.add("js_rkxx "+tbrka);
        rka.ids.add(tbrka+".gmsfhm");
        rka.attrs.add(tbrka+".gmsfhm");
        rka.bgs.put(tbrka+".SG","180");
        rka.nes.put(tbrka+".JG_SSXQDM","四川");
        System.out.println("A with fz:\n"+(tls=aInB(rka,fza)));

        //有犯罪行为A，特征A的人A坐的有特征A的火车
        tbtla="js_tielu"+idtl++;
        tla.tbs.add("js_tielu "+tbtla);
        tla.ids.add(tbtla+".id_no");
        tla.attrs.add(tbtla+".coach_no");
        tla.attrs.add(tbtla+".board_train_code");
        tla.attrs.add(tbtla+".train_date");
        tla.eqs.put(tbtla+".id_no","$"+tbrka+".gmsfhm$");
        tla.bgs.put(tbtla+".train_date","20160303");
        tla.les.put(tbtla+".train_date","20160403");
        System.out.println("Train with A:\n"+(tls=aInB(tla,tls)));

        //有犯罪行为A，特征A的人A坐的有特征A的火车上，同行的有特征B的人B
        tbrkb="js_rkxx"+idrk++;
        tbrkb2="js_tielu"+idtl++;
        tbrkb3="js_tielu"+idtl++;
        rkb.tbs.add("js_rkxx "+tbrkb);
        rkb.ids.add(tbrkb+".gmsfhm");
        rkb.tbs.add("js_tielu "+tbrkb2);
        rkb.ids.add(tbrkb2+".id_no");
        rkb.attrs.add(tbrkb+".gmsfhm");
        rkb.les.put(tbrkb+".SG","165");
        rkb.ins.put(tbrkb+".JG_SSXQDM","四川");
        rkb.eqs.put(tbrkb2+".id_no","$"+tbrkb+".gmsfhm$");
        rkb.eqs.put(tbrkb2+".coach_no",String.format("$%s.coach_no$",tbrkb3));
        rkb.eqs.put(tbrkb2+".board_train_code",String.format("$%s.board_train_code$",tbrkb3));
        rkb.eqs.put(tbrkb2+".train_date",String.format("$%s.train_date$",tbrkb3));
        System.out.println("B with Train:\n"+(tls=Simple.getGMSFHM(rkb,String.format("(%s) %s",tls,tbrkb3))));

        //B坐的有特征B的火车
        tbtlb="js_tielu"+idtl++;
        tbrkc="js_rkxx"+idrk++;
        tlb.tbs.add("js_tielu "+tbtlb);
        tlb.ids.add(tbtlb+".id_no");
        tlb.attrs.add(tbtlb+".coach_no");
        tlb.attrs.add(tbtlb+".board_train_code");
        tlb.attrs.add(tbtlb+".train_date");
        tlb.eqs.put(tbtlb+".id_no","$"+tbrkc+".gmsfhm$");
        tlb.bgs.put(tbtlb+".train_date","20160403");
        tlb.les.put(tbtlb+".train_date","20160503");
        System.out.println("Train with B:\n"+(tls=aInB(tlb,tls)));

        //与B同行的C
        tbrkc="js_rkxx"+idrk++;
        tbrkc2="js_tielu"+idtl++;
        tbrkc3="js_tielu"+idtl++;
        rkc.tbs.add("js_rkxx "+tbrkc);
        rkc.ids.add(tbrkc+".gmsfhm");
        rkc.tbs.add("js_tielu "+tbrkc2);
        rkc.ids.add(tbrkc2+".id_no");
        rkc.attrs.add(tbrkc+".gmsfhm");
        rkc.les.put(tbrkc+".SG","199");
        rkc.ins.put(tbrkc+".JG_SSXQDM","长沙");
        rkc.eqs.put(tbrkc2+".id_no","$"+tbrkc+".gmsfhm$");
        rkc.eqs.put(tbrkc2+".coach_no",String.format("$%s.coach_no$",tbrkc3));
        rkc.eqs.put(tbrkc2+".board_train_code",String.format("$%s.board_train_code$",tbrkc3));
        rkc.eqs.put(tbrkc2+".train_date",String.format("$%s.train_date$",tbrkc3));
        System.out.println("C with B:\n"+(tls=Simple.getGMSFHM(rkc,String.format("(%s) %s",tls,tbrkc3))));
    }
    public static void main(String args[]){
        int idrk=1,idfz=1,idtl=1;
        String tbrka,tbfza,tbtla;
        String tbtlb,tbrkb,tbrkb2,tbrkb3;
        String tbtlc,tbrkc,tbrkc2,tbrkc3;
        String tls;
        Description rka=new Description();
        Description fza=new Description();
        Description tla=new Description();
        Description rkb=new Description();
        Description tlb=new Description();
        Description rkc=new Description();
        //犯罪行为A
        tbfza="js_fzryxx"+idfz++;
        fza.tbs.add("js_fzryxx js_fzryxx1");
        fza.ids.add(tbfza+".gmsfhm");
        fza.attrs.add(tbfza+".gmsfhm");
        fza.bgs.put(tbfza+".SG","180");
        fza.lks.put(tbfza+".jyaq","打劫");

        //有犯罪行为A，特征A的人A
        tbrka="js_rkxx"+idrk++;
        rka.tbs.add("js_rkxx "+tbrka);
        rka.ids.add(tbrka+".gmsfhm");
        rka.attrs.add(tbrka+".gmsfhm");
        rka.bgs.put(tbrka+".SG","180");
        rka.nes.put(tbrka+".JG_SSXQDM","四川");

        //有犯罪行为A，特征A的人A坐的有特征A的火车
        tbtla="js_tielu"+idtl++;
        tla.tbs.add("js_tielu "+tbtla);
        tla.ids.add(tbtla+".id_no");
        tla.attrs.add(tbtla+".coach_no");
        tla.attrs.add(tbtla+".board_train_code");
        tla.attrs.add(tbtla+".train_date");
        tla.eqs.put(tbtla+".id_no","$"+tbrka+".gmsfhm$");
        tla.bgs.put(tbtla+".train_date","20160303");
        tla.les.put(tbtla+".train_date","20160403");

        //有犯罪行为A，特征A的人A坐的有特征A的火车上，同行的有特征B的人B
        tbrkb="js_rkxx"+idrk++;
        tbrkb2="js_tielu"+idtl++;
        tbrkb3="js_tielu"+idtl++;
        rkb.tbs.add("js_rkxx "+tbrkb);
        rkb.ids.add(tbrkb+".gmsfhm");
        rkb.tbs.add("js_tielu "+tbrkb2);
        rkb.ids.add(tbrkb2+".id_no");
        rkb.attrs.add(tbrkb+".gmsfhm");
        rkb.les.put(tbrkb+".SG","165");
        rkb.ins.put(tbrkb+".JG_SSXQDM","四川");
        rkb.eqs.put(tbrkb2+".id_no","$"+tbrkb+".gmsfhm$");
        rkb.eqs.put(tbrkb2+".coach_no",String.format("$%s.coach_no$",tbrkb3));
        rkb.eqs.put(tbrkb2+".board_train_code",String.format("$%s.board_train_code$",tbrkb3));
        rkb.eqs.put(tbrkb2+".train_date",String.format("$%s.train_date$",tbrkb3));

        //B坐的有特征B的火车
        tbtlb="js_tielu"+idtl++;
        tbrkc="js_rkxx"+idrk++;
        tlb.tbs.add("js_tielu "+tbtlb);
        tlb.ids.add(tbtlb+".id_no");
        tlb.attrs.add(tbtlb+".coach_no");
        tlb.attrs.add(tbtlb+".board_train_code");
        tlb.attrs.add(tbtlb+".train_date");
        tlb.eqs.put(tbtlb+".id_no","$"+tbrkc+".gmsfhm$");
        tlb.bgs.put(tbtlb+".train_date","20160403");
        tlb.les.put(tbtlb+".train_date","20160503");

        //与B同行的C
        tbrkc="js_rkxx"+idrk++;
        tbrkc2="js_tielu"+idtl++;
        tbrkc3="js_tielu"+idtl++;
        rkc.tbs.add("js_rkxx "+tbrkc);
        rkc.ids.add(tbrkc+".gmsfhm");
        rkc.tbs.add("js_tielu "+tbrkc2);
        rkc.ids.add(tbrkc2+".id_no");
        rkc.attrs.add(tbrkc+".gmsfhm");
        rkc.les.put(tbrkc+".SG","199");
        rkc.ins.put(tbrkc+".JG_SSXQDM","长沙");
        rkc.eqs.put(tbrkc2+".id_no","$"+tbrkc+".gmsfhm$");
        rkc.eqs.put(tbrkc2+".coach_no",String.format("$%s.coach_no$",tbrkc3));
        rkc.eqs.put(tbrkc2+".board_train_code",String.format("$%s.board_train_code$",tbrkc3));
        rkc.eqs.put(tbrkc2+".train_date",String.format("$%s.train_date$",tbrkc3));

        System.out.println(generate(rka,
                fza,
                tla,
                rkb,
                tlb,
                rkc));
    }
}
