package model.event.eventInstance;

import common.Simple;
import model.Description;
import model.code.CodeTb;
import model.code.codeInstance.AJLB;
import model.code.codeInstance.MZ;
import model.code.codeInstance.XB;
import model.code.codeInstance.XZQH;
import model.event.EventTb;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xliu on 2016/9/20.
 */
public class RK extends EventTb{
    public static String les[]={"CSRQ","SG","SWRQ"};
    public static String bgs[]={"CSRQ","SG","SWRQ"};
    public static String eqs[]={"CSRQ","SG","SWRQ"};
    public static String lks[]={"XM","XMPY","CYM","CSD_QHNXXDZ","HJDZ_QHNXXDZ","CYZK_DWMC","CYZK_ZY"};
    public static String ins[]={"MZDM","HJDZ_SSXQDM","JG_SSXQDM","XBDM"};
    public static String nes[]={"MZDM","HJDZ_SSXQDM","JG_SSXQDM","XBDM"};

    public RK(){
        this.tb ="js_rkxx";
        this.id ="gmsfhm";
    }
    public RK(String tb){
        this.tb = tb;
        this.id ="gmsfhm";
    }

}
