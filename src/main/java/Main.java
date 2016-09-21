import common.Complex;
import common.JSONReader;
import common.Simple;
import model.Description;

import java.io.IOException;

/**
 * Created by xliu on 2016/9/21.
 */
public class Main {
    public static void main(String args[]) throws IOException {

        Description rka= JSONReader.getDescriptionOne("data/rka.json","js_rkxx",new String[]{"gmsfhm"},new String[]{"gmsfhm"});
        //System.out.println(Simple.getGMSFHM(rka,null));
        Description fza=JSONReader.getDescriptionOne("data/fza.json","js_fzryxx",new String[]{"gmsfhm"},new String[]{"gmsfhm"});
        //System.out.println(Simple.getGMSFHM(fza,null));
        Description tla=JSONReader.getDescriptionOne("data/tla.json","js_tielu",new String[]{"coach_no","board_train_code","train_date"},new String[]{"id_no"});
        //System.out.println(Simple.getGMSFHM(tla,null));
        Description rkb= JSONReader.getDescriptionOne("data/rkb.json","js_rkxx",new String[]{"gmsfhm"},new String[]{"gmsfhm"});
        //System.out.println(Simple.getGMSFHM(rkb,null));
        Description tlb=JSONReader.getDescriptionOne("data/tlb.json","js_tielu",new String[]{"coach_no","board_train_code","train_date"},new String[]{"id_no"});
        //System.out.println(Simple.getGMSFHM(tlb,null));
        Description rkc= JSONReader.getDescriptionOne("data/rkc.json","js_rkxx",new String[]{"gmsfhm"},new String[]{"gmsfhm"});
        //System.out.println(Simple.getGMSFHM(rkc,null));

        tla.eqs.put(tla.tbs.get(0)+".id_no","$"+rkb.tbs.get(0)+".gmsfhm$");
        System.out.println(Complex.generate(rka,fza,tla,rkb,tlb,rkc));
    }
}
