package io.evan.rxfields.lib;

import java.util.Arrays;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by Evan on 2017/10/12 下午4:56.
 */

public class RxArray<T> {

    private  T[] array;
    private PublishSubject<Opt<T[]>> subject=PublishSubject.create();

    public RxArray(T[] array){
        this.array = array;
    }

    public void set(int index,T value){
        if (index >=0 && index<this.array.length){
            this.array[index]=value;
        }
    }

    public T get(int index){
        if (index >= 0 && index<this.array.length){
            return this.array[index];
        }
        return null;
    }

    public T[] get(){
        return Arrays.copyOf(array,array.length);
    }

    public void reset(T[] array){
        this.array = Arrays.copyOf(array,array.length);
        subject.onNext(new Opt<T[]>(this.array));
    }

    public boolean contains(T item){
        return indexOf(item)>=0;
    }

    public int indexOf(T item){
        return Arrays.binarySearch(this.array,item);
    }

    public boolean isEmpty(){
        return this.array.length ==0;
    }

    public void sort(java.util.Comparator<T> comparator){
        Arrays.sort(this.array,comparator);
        subject.onNext(new Opt<T[]>(this.array));
    }

    public Observable<Opt<T[]>> ob(){
        return Observable.merge(Observable.just(new Opt<>(array)),subject);
    }
}
