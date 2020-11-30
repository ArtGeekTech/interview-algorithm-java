import java.util.Stack;

public class MaxStack {
    private Stack<Integer> nums;
    private Stack<Integer> maxs;
    private Stack<Integer> buffer;

    /** initialize your data structure here. */
    public MaxStack() {
        nums = new Stack<>();
        maxs = new Stack<>();
        buffer = new Stack<>();
    }

    public void push(int x) {
        nums.push(x);
        if (maxs.isEmpty() || x >= maxs.peek()) {
            maxs.push(x);
        }
    }

    public int pop() {
        int top = nums.pop();
        if (top == peekMax()) {
            maxs.pop();
        }
        return top;
    }

    public int top() {
        return nums.peek();
    }

    public int peekMax() {
        return maxs.peek();
    }

    public int popMax() {
        int max = peekMax();
        while (top() != max) {
            buffer.push(nums.pop());
        }
        pop();
        while (!buffer.isEmpty()) {
            push(buffer.pop());
        }
        return max;
    }
}
