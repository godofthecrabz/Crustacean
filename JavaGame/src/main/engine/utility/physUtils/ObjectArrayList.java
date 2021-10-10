package main.engine.utility.physUtils;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.AbstractList;
import java.util.RandomAccess;

public final class ObjectArrayList<T> extends AbstractList<T> implements RandomAccess, Externalizable {

	private T[] array;
	private int size;

	public ObjectArrayList() {
		this(16);
	}
	
	@SuppressWarnings("unchecked")
	public ObjectArrayList(int initialCapacity) {
		array = (T[])new Object[initialCapacity];
	}
	
	@Override
	public boolean add(T value) {
		if (size == array.length) {
			expand();
		}
		
		array[size++] = value;
		return true;
	}

	@Override
	public void add(int index, T value) {
		if (size == array.length) {
			expand();
		}

		int num = size - index;
		if (num > 0) {
			System.arraycopy(array, index, array, index+1, num);
		}

		array[index] = value;
		size++;
	}

	@Override
	public T remove(int index) {
		if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
		T prev = array[index];
		System.arraycopy(array, index+1, array, index, size-index-1);
		array[size-1] = null;
		size--;
		return prev;
    }
	
	@SuppressWarnings("unchecked")
	private void expand() {
		T[] newArray = (T[])new Object[array.length << 1];
		System.arraycopy(array, 0, newArray, 0, array.length);
		array = newArray;
	}

	public void removeQuick(int index) {
		System.arraycopy(array, index+1, array, index, size - index - 1);
		array[size-1] = null;
		size--;
	}

	public T get(int index) {
		if (index >= size) throw new IndexOutOfBoundsException();
		return array[index];
	}

	public T getQuick(int index) {
		return array[index];
	}

	@Override
	public T set(int index, T value) {
		if (index >= size) throw new IndexOutOfBoundsException();
		T old = array[index];
		array[index] = value;
		return old;
	}

	public void setQuick(int index, T value) {
		array[index] = value;
	}

	public int size() {
		return size;
	}
	
	public int capacity() {
		return array.length;
	}
	
	@Override
	public void clear() {
		size = 0;
	}

	@Override
	public int indexOf(Object o) {
		int _size = size;
		T[] _array = array;
		for (int i=0; i<_size; i++) {
			if (o == null? _array[i] == null : o.equals(_array[i])) {
				return i;
			}
		}
		return -1;
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(size);
		for (int i=0; i<size; i++) {
			out.writeObject(array[i]);
		}
	}

	@SuppressWarnings("unchecked")
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		size = in.readInt();
		int cap = 16;
		while (cap < size) cap <<= 1;
		array = (T[])new Object[cap];
		for (int i=0; i<size; i++) {
			array[i] = (T)in.readObject();
		}
	}
	
}