package com.adeng.codewar.train.dnastrand;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


public class DnaStrand {



    /**
     * 自定义CharArraySpliterator
     */
    static final class CharArraySpliterator implements Spliterator {
        private final char[] array;
        private int index;        // current index, modified on advance/split
        private final int fence;  // one past last index
        private final int characteristics;

        public CharArraySpliterator(char[] array, int additionalCharacteristics) {
            this(array, 0, array.length, additionalCharacteristics);
        }

        public CharArraySpliterator(char[] array, int origin, int fence, int additionalCharacteristics) {
            this.array = array;
            this.index = origin;
            this.fence = fence;
            this.characteristics = additionalCharacteristics | Spliterator.SIZED | Spliterator.SUBSIZED;
        }

        @Override
        public Spliterator trySplit() {
            int lo = index, mid = (lo + fence) >>> 1;
            return (lo >= mid)
                    ? null
                    : new CharArraySpliterator(array, lo, index = mid, characteristics);
        }

        @Override
        public void forEachRemaining(Consumer action) {
            char[] a;
            int i, hi; // hoist accesses and checks from loop
            if (action == null)
                throw new NullPointerException();
            if ((a = array).length >= (hi = fence) &&
                    (i = index) >= 0 && i < (index = hi)) {
                do {
                    action.accept(a[i]);
                } while (++i < hi);
            }
        }

        @Override
        public boolean tryAdvance(Consumer action) {
            if (action == null)
                throw new NullPointerException();
            if (index >= 0 && index < fence) {
                action.accept(array[index++]);
                return true;
            }
            return false;
        }

        @Override
        public long estimateSize() {
            return (long) (fence - index);
        }

        @Override
        public int characteristics() {
            return characteristics;
        }

        @Override
        public Comparator<? super Character> getComparator() {
            if (hasCharacteristics(Spliterator.SORTED))
                return null;
            throw new IllegalStateException();
        }
    }

    /*
    在DNA字符串中，符号“A”和“T”是彼此的互补，如“C”和“G”。
    你有DNA的一个功能（字符串，除了Haskell）; 你需要得到另一个互补的一面。
    DNA链永远不会是空的或根本没有DNA（再次，除了Haskell）。
    */
    public static String makeComplement(String dna) {
        //Your code
        char[] charArray = dna.toCharArray();

        /* 构建流的拆分器 */
        Spliterator spliterator =
                new CharArraySpliterator(charArray,
                        Spliterator.ORDERED | Spliterator.IMMUTABLE);

        /* 构建流 */
        Character t = 'T';
        Character a = 'A';
        Character c = 'C';
        Character g = 'G';

        StringBuffer sb = new StringBuffer();

        StreamSupport.stream(spliterator, false).forEach(ch -> {
            if (t == ch) {
                sb.append(a);
            } else if (a == ch) {
                sb.append(t);
            } else if (c == ch) {
                sb.append(g);
            } else if (g == ch) {
                sb.append(c);
            } else {
                sb.append(ch);
            }
        });


        return sb.toString();
    }


    public static void main(String[] args) {

        String str = "TAACG";

        char[] charArray = str.toCharArray();
        System.out.println(charArray);

/*        //不使用流的方式
        for (int i = 0; i < charArray.length; i++) {
            if ("T".toCharArray()[0] == charArray[i]) {
                charArray[i] = "A".toCharArray()[0];
            } else if ("A".toCharArray()[0] == charArray[i]) {
                charArray[i] = "T".toCharArray()[0];
            } else if ("C".toCharArray()[0] == charArray[i]) {
                charArray[i] = "G".toCharArray()[0];
            } else if ("G".toCharArray()[0] == charArray[i]) {
                charArray[i] = "C".toCharArray()[0];
            }
        }*/

        /*   *//* 构建流的拆分器 *//*
        Spliterator spliterator =
                new CharArraySpliterator(charArray,
                        Spliterator.ORDERED | Spliterator.IMMUTABLE);

        *//* 构建流 *//*

        Character t = 'T';
        Character a = 'A';
        Character c = 'C';
        Character g = 'G';

        StringBuffer sb = new StringBuffer();

        StreamSupport.stream(spliterator, false).forEach(ch -> {
            if (t == ch) {
                sb.append(a);
            } else if (a == ch) {
                sb.append(t);
            } else if (c == ch) {
                sb.append(g);
            } else if (g == ch) {
                sb.append(c);
            } else {
                sb.append(ch);
            }
        });


        System.out.println(sb.toString());
        */


        //使用流的方式转换
        HashMap<Character, Character> map = new HashMap<>(4);
        map.put('A', 'T');
        map.put('T', 'A');
        map.put('C', 'G');
        map.put('G', 'C');

        String result = str.chars().mapToObj(c -> String.valueOf(map.get((char) c))).collect(Collectors.joining());

        System.out.println(result);
    }
}
