package com.scd.code3.exercises;

import com.scd.code3.stack.IStack;

/**
 * @author James Chen
 * @date 26/09/19
 */
public class ExerciseThree {

    private static class DuSqStask<E> {

        private Object[] elements;

        private int leftTop;

        private int rightTop;

        private int maxSize;


        public DuSqStask(int maxSize){
            leftTop = 0;
            rightTop = maxSize - 1;
            this.maxSize = maxSize;
            elements = new Object[maxSize];
        }

        public void push(E e, int i) {
            if (length() == maxSize) {
                throw new RuntimeException("stack max length : " + maxSize);
            }
            // 左边添加
            if (i == 0) {
               elements[leftTop] = e;
               leftTop++;
            } else if (i == 1){
                elements[rightTop] = e;
                rightTop--;
            } else {
                throw new RuntimeException("param is error");
            }
        }


        public int length() {
            return maxSize - 1 - rightTop + leftTop;
        }

        public boolean isEmpty() {
            return leftTop == 0 && rightTop == maxSize - 1;
        }


        public E pop(int i) {
            Object e = null;
            if (i == 0){
                if (leftTop > 0) {
                    e = elements[leftTop - 1];
                    leftTop--;
                }
            } else if (i == 1) {
                if (rightTop < maxSize - 1) {
                    e = elements[rightTop + 1];
                    rightTop++;
                }
            } else {
                throw new RuntimeException("param is error");
            }
            return (E) e;
        }
    }

    public static void pushLeft() {
        DuSqStask<Integer> duSqStask = new DuSqStask<>(5);
        duSqStask.push(1, 0);
        duSqStask.push(2, 0);
        duSqStask.push(3, 0);
        duSqStask.push(4, 0);
        duSqStask.push(5, 0);
        duSqStask.push(6, 0);
    }

    public static void pushRight() {
        DuSqStask<Integer> duSqStask = new DuSqStask<>(5);
        duSqStask.push(1, 1);
        duSqStask.push(2, 1);
        duSqStask.push(3, 1);
        duSqStask.push(4, 1);
        duSqStask.push(5, 1);
        duSqStask.push(6, 1);
    }

    public static void pushLeftRight() {
        DuSqStask<Integer> duSqStask = new DuSqStask<>(5);
        duSqStask.push(1, 0);
        duSqStask.push(2, 0);
        duSqStask.push(3, 0);
        duSqStask.push(4, 1);
        duSqStask.push(5, 1);
        duSqStask.push(6, 1);
    }

    public static void popLeftRight() {
        DuSqStask<Integer> duSqStask = new DuSqStask<>(5);
        duSqStask.push(1, 0);
        duSqStask.push(2, 0);
        duSqStask.push(3, 0);
        duSqStask.push(4, 1);
        duSqStask.push(5, 1);
        System.out.println(duSqStask.pop(0));
        System.out.println(duSqStask.pop(0));
        System.out.println(duSqStask.pop(0));
        System.out.println(duSqStask.pop(0));
        System.out.println(duSqStask.length());
        System.out.println(duSqStask.pop(1));
        System.out.println(duSqStask.pop(1));
        System.out.println(duSqStask.pop(1));
        System.out.println(duSqStask.isEmpty());
    }

    public static void main(String[] args) {
//        pushLeft();
//        pushRight();
//        pushLeftRight();
        popLeftRight();
    }
}
