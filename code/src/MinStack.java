import java.util.Stack;

public class MinStack {
    private Stack<Integer> nums;
    private Stack<Integer> mins;

    /** initialize your data structure here. */
    public MinStack() {
        nums = new Stack<>();
        mins = new Stack<>();
    }

    public void push(int x) {
        nums.push(x);
        if (mins.isEmpty() || x <= mins.peek()) {
            mins.push(x);
        }
    }

    public void pop() {
        int top = nums.pop();
        if (mins.peek() == top) {
            mins.pop();
        }
    }

    public int top() {
        return nums.peek();
    }

    public int getMin() {
        return mins.peek();
    }
}
