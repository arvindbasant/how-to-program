package javase.basics;

public class StackDemo {

    int stack[] = new int[10];
    int top;

    StackDemo() {
        top = -1;
    }

    void push(int value) {
        if (stack.length == 9) {
            System.out.println("Stack is full");
        } else {
            stack[++top] = value;
        }
    }

    int pop() {
        if(top == -1) {
            System.out.println("stack is empty");
            return 0;
        }else {
            int val = stack[top];
            top--;
            return val;
            // return stack[top--];
        }
    }
}
