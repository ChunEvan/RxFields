package io.evan.rxfields.lib;

/**
 * Created by Evan on 2017/10/12 下午5:15.
 */

public class RxLong extends RxField<Long> {

    public RxLong() {
        super(0L);
    }

    public RxLong(Long field) {
        super(field);
    }

    public void add(long value) {
        set(get() + value);
    }
}
