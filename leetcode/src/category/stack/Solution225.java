package category.stack;

import java.util.LinkedList;
import java.util.Queue;

public class Solution225 {


    class MyStack {

         Queue<Integer> queue1;
         Queue<Integer> queue2;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        /**
         * Push element x onto category.stack.
         */
        public void push(int x) {
            if (queue1.isEmpty()) {
                queue1.offer(x);
            } else {
                queue2.offer(x);
                q1ToQ2();
                exChangeQ1Q2();
            }
        }

        private void exChangeQ1Q2() {
            Queue<Integer> tmp = queue1;
            queue1 = queue2;
            queue2 =tmp;
        }

        private void q1ToQ2() {
            while (!queue1.isEmpty()) {
                queue2.add(queue1.poll());
            }
        }
        /**
         * Removes the element on top of the category.stack and returns that element.
         */
        public int pop() {
            return queue1.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return queue1.peek();
        }

        /**
         * Returns whether the category.stack is empty.
         */
        public boolean empty() {
            return queue1.isEmpty();
        }
    }


}