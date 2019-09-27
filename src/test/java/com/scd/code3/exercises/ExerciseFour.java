package com.scd.code3.exercises;

import com.scd.code3.queue.IQueue;

/**
 * @author James Chen
 * @date 27/09/19
 */
public class ExerciseFour {

    private static class CSeqQueue<E> implements IQueue<E> {

        private Object[] elements;

        private int front;

        private int rear;

        private int num;

        private int maxSize;

        public CSeqQueue(int maxSize){
            front = rear = 0;
            num = 0;
            this.maxSize = maxSize;
            elements = new Object[maxSize];
        }


        @Override
        public void clear() {
            front = rear = 0;
            num = 0;
        }

        @Override
        public boolean isEmpty() {
            return num == 0;
        }

        @Override
        public int length() {
            return num;
        }

        @Override
        public E peek() {
            if (isEmpty()) {
                return null;
            } else {
                return (E) elements[front];
            }
        }

        @Override
        public void offer(E e) throws Exception {
            if (num == maxSize) {
                throw new RuntimeException("queue max size " + num);
            }
            elements[rear] = e;
            rear = (rear + 1) % maxSize;
            num++;
        }

        @Override
        public E poll() {
            if (isEmpty()) {
                return null;
            } else {
                E e = (E) elements[front];
                elements[front] = null;
                front = (front + 1) % maxSize;
                num--;
                return e;
            }
        }

        @Override
        public void disPlay() {
            StringBuilder stringBuilder = new StringBuilder("");
            if (front < rear) {
                for (int i = front; i < rear; i++) {
                    stringBuilder.append(elements[i]).append(" ");
                }
            } else {
                for (int i = front; i < maxSize; i++) {
                    stringBuilder.append(elements[i]).append(" ");
                }
                for (int i = 0; i < rear; i++) {
                    stringBuilder.append(elements[i]).append(" ");
                }
            }
            System.out.println(stringBuilder.toString().trim());
        }
    }

    public static void testOffer() throws Exception {
        CSeqQueue<String> cSeqQueue = new CSeqQueue<String>(5);
        cSeqQueue.offer("1");
        cSeqQueue.offer("2");
        cSeqQueue.offer("3");
        cSeqQueue.offer("4");
        cSeqQueue.offer("5");
        System.out.println(cSeqQueue.length());
        cSeqQueue.offer("6");
    }

    public static void testPeekPoll() throws Exception {
        CSeqQueue<String> cSeqQueue = new CSeqQueue<String>(5);
        cSeqQueue.offer("1");
        cSeqQueue.offer("2");
        cSeqQueue.offer("3");
        cSeqQueue.offer("4");
        cSeqQueue.offer("5");
        System.out.println(cSeqQueue.peek());
        System.out.println(cSeqQueue.poll());
    }

    public static void testDisplay() throws Exception {
        CSeqQueue<String> cSeqQueue = new CSeqQueue<String>(5);
        cSeqQueue.offer("1");
        cSeqQueue.offer("2");
        cSeqQueue.offer("3");
        cSeqQueue.offer("4");
        cSeqQueue.offer("5");
        cSeqQueue.poll();
        cSeqQueue.poll();
        cSeqQueue.offer("6");
        cSeqQueue.disPlay();
    }

    public static void main(String[] args) throws Exception {
//        testOffer();
//        testPeekPoll();
        testDisplay();
    }
}
