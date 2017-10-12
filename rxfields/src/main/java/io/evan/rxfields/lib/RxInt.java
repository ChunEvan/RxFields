package io.evan.rxfields.lib;

/**
 * Created by Evan on 2017/10/12 下午5:13.
 */

public class RxInt extends RxField<Integer> {

    public RxInt() {
        super(0);
    }

    public RxInt(Integer field) {
        super(field);
    }

    public void add(int value) {
        set(get() + value);
    }
}
