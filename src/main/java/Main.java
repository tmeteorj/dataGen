import common.Complex;
import common.JSONReader;
import common.Simple;
import model.Description;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by xliu on 2016/9/21.
 */
public class Main {
    public static void main(String args[]) throws IOException {

        Description rka= JSONReader.getDescriptionOne("data/rka.json",new String[]{"js_rkxx"},new String[]{"gmsfhm"},new String[]{"gmsfhm"});
        //System.out.println(Simple.getGMSFHM(rka,null));
        Description fza=JSONReader.getDescriptionOne("data/fza.json",new String[]{"js_fzryxx"},new String[]{"gmsfhm"},new String[]{"gmsfhm"});
        //System.out.println(Simple.getGMSFHM(fza,null));
        Description tla=JSONReader.getDescriptionOne("data/tla.json",new String[]{"js_tielu"},new String[]{"coach_no","board_train_code","train_date"},new String[]{"id_no"});
        //System.out.println(Simple.getGMSFHM(tla,null));
        Description rkb= JSONReader.getDescriptionOne("data/rkb.json",new String[]{"js_rkxx","js_tielu"},new String[]{"gmsfhm"},new String[]{"gmsfhm"});
        //System.out.println(Simple.getGMSFHM(rkb,null));
        Description tlb=JSONReader.getDescriptionOne("data/tlb.json",new String[]{"js_tielu"},new String[]{"coach_no","board_train_code","train_date"},new String[]{"id_no"});
        //System.out.println(Simple.getGMSFHM(tlb,null));
        Description rkc= JSONReader.getDescriptionOne("data/rkc.json",new String[]{"js_rkxx","js_tielu"},new String[]{"gmsfhm"},new String[]{"gmsfhm"});
        //System.out.println(Simple.getGMSFHM(rkc,null));

        rkc.eqs.put(rkc.getTB(1)+".board_train_code","$js_tielu6.board_train_code$");
        rkc.eqs.put(rkc.getTB(1)+".coach_no","$js_tielu6.coach_no$");
        rkc.eqs.put(rkc.getTB(1)+".train_date","$js_tielu6.train_date$");
        rkc.eqs.put(rkc.getTB(1)+".id_no","$"+rkc.getTB(0)+".gmsfhm$");

        tlb.eqs.put(tlb.getTB(0)+".id_no","$"+rkc.getTB(0)+".gmsfhm$");

        rkb.eqs.put(rkb.getTB(1)+".board_train_code","$js_tielu3.board_train_code$");
        rkb.eqs.put(rkb.getTB(1)+".coach_no","$js_tielu3.coach_no$");
        rkb.eqs.put(rkb.getTB(1)+".train_date","$js_tielu3.train_date$");
        rkb.eqs.put(rkb.getTB(1)+".id_no","$"+rkb.getTB(0)+".gmsfhm$");

        System.out.println(Complex.generate(rka,fza,tla,rkb,tlb,rkc));
//        OutputStreamWriter fw=new OutputStreamWriter(new FileOutputStream(new File("ans.sql")),"utf-8");
//        fw.write();
//        fw.close();
    }
}
