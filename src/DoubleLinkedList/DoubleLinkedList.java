package DoubleLinkedList;

public class DoubleLinkedList<T> extends LLBase<T> implements LLInterface<T> {

    DoubleLinkedList() {
        head = null;
        size = 0;
        tail = null;
    }


    @Override
    public int capacity() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(T o) {
        Node<T> pointer = head;
        int i =0;
        while (pointer !=null && i<size){
            if (pointer.getValue().equals(o)){
                return true;
            }
            i++;
            pointer = pointer.getNext();
        }
        return false;
    }

    @Override
    public T[] toArray(T[] array) throws IllegalArgumentException {
        if (array.length < size){
            throw new IllegalArgumentException();
        }
        Node<T> pointer = head;
        int index = 0;
        while (pointer !=null && index<size){
            array[index]= pointer.getValue();
            pointer = pointer.getNext();
            index++;
        }
        return array;
    }

    @Override
    public void add(T e) {
        Node<T> insert = new Node<T>(e);
            if (size > 0) {
                tail.setNext(insert);
                insert.setPrevious(tail);
                tail = insert;
            } else {
                head = insert;
                tail = insert;
                insert.setNext(null);
                insert.setPrevious(null);
            }
            size++;
    }

    @Override
    public void add(int index, T element) throws IndexOutOfBoundsException {
        Node<T> pointer = head;
        if (index >= size){
            add(element);
        }else if (index < 0){
            throw new IndexOutOfBoundsException();
        }else if (head == null){
            add(element);
        }else if (index == 0){
            Node<T> insert = new Node<T>(element);
            head.setPrevious(insert);
            insert.setNext(head);
            head = insert;
            size++;
        }else{
            for (int i=0; i<size; i++) {
                if (i == index-1) {
                    Node<T> insert = new Node<T>(element);
                    insert.setNext(pointer.getNext());
                    insert.setPrevious(pointer);
                    pointer.getNext().setPrevious(insert);
                    pointer.setNext(insert);
                    size++;
                    break;
                }

                if (pointer.getNext() != null) {
                    pointer = pointer.getNext();
                }
            }
        }
    }

    @Override
    public boolean remove(T o) {
        Node<T> pointer = head;
        if (o.equals(head.getValue())){
            Node<T> insert = head.getNext();
            head = insert;
            size--;
            return true;
        }
        if (o.equals(tail.getValue())){
            Node<T> insert = tail.getPrevious();
            tail = insert;
            size--;
            return true;
        }
        int index = 0;
        while (pointer !=null && index<size){
            if (pointer.getValue().equals(o)){
                break;
            }else if (index == size-1){
                size--;
                return false;
            }
            index++;
            pointer = pointer.getNext();
        }
        pointer.getNext().setPrevious(pointer.getPrevious());
        pointer.getPrevious().setNext(pointer.getNext());
        size--;
            return true;
        }


    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> out = null;
        if (index == 0) {
            Node<T> insert = head.getNext();
            out = head;
            insert.setPrevious(null);
            head = insert;
            size--;
            return out.getValue();
        }
        if (index == size - 1) {
            Node<T> insert = tail.getPrevious();
            out = tail;
            insert.setNext(null);
            tail = insert;
            size--;
            return out.getValue();
        }
        Node<T> pointer = head;
        int i = 0;
        while (pointer !=null && i<size) {
            if (i == index){
                out = pointer;
                pointer.getNext().setPrevious(pointer.getPrevious());
                pointer.getPrevious().setNext(pointer.getNext());
            }
            i++;
            pointer = pointer.getNext();
        }
        size--;
    return out.getValue();
    }


    @Override
    public void clear() {
        size = 0;
        head = null;
        tail = null;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> pointer = head;
        int i = 0;
        while (pointer !=null && i<size) {
            if (i == index) {
                return pointer.getValue();
            }
            pointer = pointer.getNext();
            i++;
        }
        return null;
    }


    @Override
    public T set(int index, T element) throws IndexOutOfBoundsException {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> pointer = head;
        Node<T> out = new Node<T>(null);
        Node<T> insert = new Node<T>(element);
        int i = 0;
        while (pointer !=null && i<size){
            if (i == index){
                out = pointer;
                pointer.getPrevious().setNext(insert);
                pointer = pointer.getNext();
                pointer.setPrevious(insert);
            }
            pointer = pointer.getNext();
            i++;
        }
        return out.getValue();
    }

    @Override
    public int indexOf(T o) {
        Node<T> pointer = head;
        int i = 0;
        while (pointer !=null && i<size){
            if (pointer.getValue().equals(o)){
                break;
            }
            pointer = pointer.getNext();
            i++;
        }
        return i;
    }

    @Override
    public int lastIndexOf(T o) {
        Node<T> pointer = tail;
        int i = size-1;
        boolean set = false;
        while (pointer !=null && i>=0){
            if (pointer.getValue().equals(o)){
                set = true;
                break;
            }
            pointer = pointer.getPrevious();
            i--;
        }
        if (!set){
            return -1;
        }
        return i;
    }

    @Override
    public void printForward() {
        Node<T> pointer = head;
        int i=0;
        while (pointer !=null && i<size){
            System.out.println(pointer.toString());
            pointer = pointer.getNext();
            i++;
        }
    }

    @Override
    public void printReverse() {
        Node<T> pointer = tail;
        int i=size-1;
        while (pointer !=null && i>=0){
            if (i == 0) {
                System.out.println(pointer.toString());
                break;
            }
            System.out.println(pointer.toString());
            pointer = pointer.getPrevious();
            i++;
        }
    }
}

