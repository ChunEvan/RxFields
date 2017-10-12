package io.evan.rxfields.lib;

/**
 * Created by Evan on 2017/10/12 下午5:17.
 */

public class RxShort extends RxField<Short> {

    public RxShort() {
        super((short) 0);
    }

    public RxShort(Short field) {
        super(field);
    }

    public void add(short value) {
        set((short) (get() + value));
    }
}
