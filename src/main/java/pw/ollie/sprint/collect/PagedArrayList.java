/*
 * This file is part of sprintj, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2014 Oliver Stanley <http://ollie.pw>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package pw.ollie.sprint.collect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/**
 * An implementation of a {@link PagedList} which wraps around an {@link
 * ArrayList} to store elements and then provides the ability to page those
 * elements.
 *
 * @param <E> the type of element stored
 */
public class PagedArrayList<E> implements PagedList<E> {
    private final List<E> delegate;
    private final Map<Integer, List<E>> pages;

    private int elementsPerPage = 6;

    public PagedArrayList() {
        this.delegate = new ArrayList<>();
        this.pages = new HashMap<>();
    }

    public PagedArrayList(List<E> delegate) {
        this.delegate = new ArrayList<>(delegate);
        this.pages = new HashMap<>();
    }

    public List<E> getPage(int page) {
        return pages.get(page);
    }

    public int getElementsPerPage() {
        return elementsPerPage;
    }

    public void setElementsPerPage(int elementsPerPage) {
        this.elementsPerPage = elementsPerPage;
        calculatePages();
    }

    private void calculatePages() {
        if (isEmpty()) {
            return;
        }

        pages.clear();
        int amtPages = (int) Math.ceil(size() / elementsPerPage);
        for (int page = 1; page <= amtPages; page++) {
            int pageStart = (page - 1) * elementsPerPage;
            pages.put(page, subList(pageStart, pageStart + elementsPerPage));
        }
    }

    @Override
    public int size() {
        return delegate.size();
    }

    @Override
    public boolean isEmpty() {
        return delegate.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return delegate.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return delegate.iterator();
    }

    @Override
    public Object[] toArray() {
        return delegate.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return delegate.toArray(a);
    }

    @Override
    public boolean add(E e) {
        boolean result = delegate.add(e);
        calculatePages();
        return result;
    }

    @Override
    public boolean remove(Object o) {
        boolean result = delegate.remove(o);
        calculatePages();
        return result;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return delegate.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean result = delegate.addAll(c);
        calculatePages();
        return result;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        boolean result = delegate.addAll(index, c);
        calculatePages();
        return result;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean result = delegate.removeAll(c);
        calculatePages();
        return result;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean result = delegate.retainAll(c);
        calculatePages();
        return result;
    }

    @Override
    public void clear() {
        delegate.clear();
        calculatePages();
    }

    @Override
    public E get(int index) {
        return delegate.get(index);
    }

    @Override
    public E set(int index, E element) {
        E result = delegate.set(index, element);
        calculatePages();
        return result;
    }

    @Override
    public void add(int index, E element) {
        delegate.add(index, element);
        calculatePages();
    }

    @Override
    public E remove(int index) {
        E result = delegate.remove(index);
        calculatePages();
        return result;
    }

    @Override
    public int indexOf(Object o) {
        return delegate.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return delegate.lastIndexOf(o);
    }

    @Override
    public ListIterator<E> listIterator() {
        return delegate.listIterator();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return delegate.listIterator(index);
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return delegate.subList(fromIndex, toIndex);
    }
}