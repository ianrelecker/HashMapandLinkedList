package HashMap;

import DoubleLinkedList.DoubleLinkedList;

public class HashMap<KEYTYPE, DATATYPE> extends HMBase {
    int size = N;


    public HashMap(int size) {
        N = size;
        for (int i =0; i<size; i++){
            hashmap[i] = new DoubleLinkedList<Node>();
        }
    }

    @Override
    protected int hash(Object key) {
        //_+ first hash function
//        /**
        String s = key.toString();
        int sum=0;
        for (int i=0; i<s.length(); i++){
            sum += s.charAt(i);
        }
//         **/
        //_+ second hash function
        /**
        String s = key.toString();
        int h = 0, high;
        for(int i= 0; i< s.length(); i++) {
            h= ( h<< 4 ) + s.charAt(i);
            if((high= h& 0xF0000000) != 0) {
                h^= high>> 24;
            }
            h&= ~high;
        }

        **/
        return sum % N;
    }

    @Override
    public void add(Object key, Object e) {
//        Node insert = new Node<KEYTYPE, DATATYPE>(key, e);
//        hashmap[hash(key)] = ;
    }


    @Override
    public int[] getSizes() {
        int[] returnSize = new int[size];
        for (int i=0; i<size; i++){
            returnSize[i] = hashmap[i].size();
        }
        return returnSize;
    }
}
