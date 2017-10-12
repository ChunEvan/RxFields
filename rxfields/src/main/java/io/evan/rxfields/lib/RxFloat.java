package io.evan.rxfields.lib;

/**
 * Created by Evan on 2017/10/12 下午5:12.
 */

public class RxFloat extends RxField<Float> {
    public RxFloat() {
        super(0F);
    }

    public RxFloat(Float field) {
        super(field);
    }

    public void add(float value) {
        set(get() + value);
    }
}
