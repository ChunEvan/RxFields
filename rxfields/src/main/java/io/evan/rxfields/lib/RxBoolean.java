package io.evan.rxfields.lib;

/**
 * Created by Evan on 2017/10/12 下午5:07.
 */

public class RxBoolean extends RxField<Boolean>{

    public RxBoolean(){
        super(false);
    }

    public RxBoolean(Boolean field) {
        super(field);
    }

    public void toggle(){
        set(!get());
    }

    public boolean TRUE(){
        return get();
    }

    public boolean FALSE(){
        return !get();
    }
}
