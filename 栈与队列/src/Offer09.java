import java.util.Stack;

/**
 * @Description :剑指 Offer 09. 用两个栈实现队列
 * @Author : WenZhengcheng
 * @Date : create in 2021-08-20 下午 06:00
 * @Email : wenzhengcheng0223@163.com
 * @Since : JDK 1.8
 * @PackageName : PACKAGE_NAME
 * @ProjectName : LeetCode
 * @Version : 1.0.0
 */
public class Offer09 {
    class CQueue {
        Stack stack1;
        Stack stack2;
        public CQueue() {
            stack1 = new Stack<Integer>();
            stack2 = new Stack<Integer>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if(stack2.isEmpty())
            {
                while (!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
            if (stack2.isEmpty()) {
                return -1;
            }
            else{
                int value = (int) stack2.pop();
                return value;
            }


        }
    }
/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
}
