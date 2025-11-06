import java.util.ArrayList;

public class ArrayStack<T> {
    private ArrayList<T> items;

    public ArrayStack() {
        items = new ArrayList<>();
    }

    public void push(T item) {
        items.add(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new ArrayStackException("Underflow Error");
        }
        return items.remove(items.size() - 1);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public static class ArrayStackException extends RuntimeException {
        public ArrayStackException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
