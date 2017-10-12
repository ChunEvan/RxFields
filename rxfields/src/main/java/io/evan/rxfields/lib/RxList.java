package io.evan.rxfields.lib;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by Evan on 2017/10/12 下午5:21.
 */

public class RxList<T> {

    private List<T> list;
    private PublishSubject<Opt<List<T>>> subject = PublishSubject.create();

    public RxList(List<T> list) {
        this.list = (list == null) ? new LinkedList<T>() : list;
    }

    public void reset(T item) {
        this.list.clear();
        this.list.add(item);
        subject.onNext(new Opt<List<T>>(this.list));
    }

    public void reset(Collection<? extends T> collection) {
        this.list.clear();
        this.list.addAll(collection);
        subject.onNext(new Opt<List<T>>(this.list));
    }

    public void add(T item) {
        this.list.add(item);
        subject.onNext(new Opt<List<T>>(this.list));
    }

    public void add(int index, T item) {
        this.list.add(index, item);
        subject.onNext(new Opt<List<T>>(this.list));
    }

    public void addAll(Collection<? extends T> collection) {
        this.list.addAll(collection);
        subject.onNext(new Opt<List<T>>(this.list));
    }

    public void addAll(int position, Collection<? extends T> collection) {
        this.list.addAll(position, collection);
        subject.onNext(new Opt<List<T>>(this.list));
    }

    public void remove(T item) {
        if (this.list.contains(item)) {
            this.list.remove(item);
            subject.onNext(new Opt<List<T>>(this.list));
        }
    }

    public void remove(int index) {
        if (index >= 0 && index < this.list.size()) {
            this.list.remove(index);
            subject.onNext(new Opt<List<T>>(this.list));
        }
    }

    public void removeAll(Collection<? extends T> collection) {
        this.list.removeAll(collection);
        subject.onNext(new Opt<List<T>>(this.list));
    }

    public void clear() {
        this.list.clear();
        subject.onNext(new Opt<List<T>>(this.list));
    }

    public boolean contains(T item) {
        return this.list.contains(item);
    }

    public int indexOf(T item) {
        return this.list.indexOf(item);
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public int size() {
        return this.list.size();
    }

    public void sort(Comparator<T> comparator) {
        Collections.sort(this.list, comparator);
        subject.onNext(new Opt<List<T>>(this.list));
    }

    public List<T> get() {
        return new ArrayList<>(this.list);
    }

    public io.reactivex.Observable<Opt<List<T>>> ob() {
        return Observable.merge(Observable.just(new Opt<>(list)), subject);
    }
}
