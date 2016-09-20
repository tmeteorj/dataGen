package model.event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xliu on 2016/9/20.
 */
public class EventTb {
    public String tb;
    public String id;
    public List<String> attrs;
    public EventTb(){
        attrs=new ArrayList<String>();
    }
}
