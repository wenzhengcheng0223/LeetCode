import java.util.Stack;

/**
 * @Description :剑指 Offer 30. 包含min函数的栈
 * @Author : WenZhengcheng
 * @Date : create in 2021-08-20 下午 06:11
 * @Email : wenzhengcheng0223@163.com
 * @Since : JDK 1.8
 * @PackageName : PACKAGE_NAME
 * @ProjectName : LeetCode
 * @Version : 1.0.0
 */
public class Offer30 {
    class MinStack {
        private Stack<Integer> dataStack,minStack;
        /** initialize your data structure here. */
        public MinStack() {
            dataStack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            dataStack.push(x);
            if (minStack.isEmpty() || minStack.peek()>= dataStack.peek() ){
                minStack.push(x);
            }
        }

        public void pop() {
           int value = dataStack.pop();
            if (value == minStack.peek()){
                minStack.pop();
            }
        }

        public int top() {
            return dataStack.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }
}
