package HashMap;

import DoubleLinkedList.DoubleLinkedList;

public class HashMap<KEYTYPE, DATATYPE> extends HMBase<KEYTYPE, DATATYPE> {

    public HashMap(int size) {
        N = size;
        hashmap = new DoubleLinkedList[N];
        for (int i =0; i<size; i++){
            hashmap[i] = new DoubleLinkedList<Node<KEYTYPE, DATATYPE>>();
        }
    }

    @Override
    protected int hash(Object key) {
        //_+ first hash function
        /**
        String s = key.toString();
        int sum=0;
        for (int i=0; i<s.length(); i++){
            sum += s.charAt(i);
         }
         return sum % N;
         **/
        //_+ second hash function
//        /**
        String s = key.toString();
        int h = 0, high;
        for(int i= 0; i< s.length(); i++) {
            h= ( h<< 4 ) + s.charAt(i);
            if((high= h& 0xF0000000) != 0) {
                h^= high>> 24;
            }
            h&= ~high;
        }


        return h % N;
//                **/
    }

    @Override
    public void add(KEYTYPE key, DATATYPE e) {
        Node insert = new Node(key, e);
        hashmap[hash(key)].add(insert);
    }


    @Override
    public int[] getSizes() {
        int[] returnSize = new int[N];
        for (int i=0; i<N; i++){
            returnSize[i] = hashmap[i].size();
        }
        return returnSize;
    }
}
