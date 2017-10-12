package io.evan.rxfields.lib;

/**
 * Created by Evan on 2017/10/12 下午5:09.
 */

public class RxCharSequence extends RxField<CharSequence> {


    public RxCharSequence(CharSequence field) {
        super(field, new Comparator<CharSequence>() {
            @Override
            public boolean isEqual(CharSequence lhs, CharSequence rhs) {
                return (lhs==rhs) || (lhs!=null && rhs!=null && lhs.toString().equals(rhs.toString()));
            }
        });
    }
}
