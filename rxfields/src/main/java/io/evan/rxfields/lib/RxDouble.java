package io.evan.rxfields.lib;

/**
 * Created by Evan on 2017/10/12 下午5:10.
 */

public class RxDouble extends RxField<Double> {

    public RxDouble() {
        super(0D);
    }

    public RxDouble(Double field) {
        super(field);
    }

    public void add(double value) {
        set(get() + value);
    }
}
