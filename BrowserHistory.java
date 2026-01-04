package BrowserHistory;

import java.util.Stack;

public class BrowserHistory {
    public Stack<String> backStack = new Stack<>();
    public Stack<String> forwardStack = new Stack<>();

    public BrowserHistory(String homepage) {
        backStack.push(homepage);
    }

    public void visit(String url) {
        while (!forwardStack.isEmpty()) {
            forwardStack.pop();
        }
        backStack.push(url);
    }

    public String back(int steps) {
        while (backStack.size() > 1 && steps-- > 0) {
            forwardStack.push(backStack.peek());
            backStack.pop();
        }
        return backStack.peek();
    }

    public String forward(int steps) {
        while (!forwardStack.isEmpty() && steps-- > 0) {
            backStack.push(forwardStack.peek());
            forwardStack.pop();
        }
        return backStack.peek();
    }

    public String getCurrentPage() {
        return backStack.peek();
    }

    public void printStacks() {
        System.out.println("Back Stack: " + backStack);
        System.out.println("Forward Stack: " + forwardStack);
    }
}