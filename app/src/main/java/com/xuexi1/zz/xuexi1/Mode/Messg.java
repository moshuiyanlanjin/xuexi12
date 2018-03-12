package com.xuexi1.zz.xuexi1.Mode;

/**
 * Created by Administrator on 2018-03-01.
 */

public class Messg {
    public static final int TYPE_SEND = 1;
    public static final int TYPE_ROOM=0;
    public String sendmsg;
    public int type;



    public Messg(String sendmsg,int type){
       this.sendmsg = sendmsg;
        this.type = type;
    }
    public String getSendmsg() {
        return sendmsg;
    }

    public void setSendmsg(String sendmsg) {
        this.sendmsg = sendmsg;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
