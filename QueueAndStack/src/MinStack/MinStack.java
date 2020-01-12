package MinStack;

class Element{
    int val;
    int min;
    Element next;

    public Element(int val, int min){
        this.val = val;
        this.min = min;
    }
}

class MinStack {
    Element top;
    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if(top == null){
            top = new Element(x,x);
        }
        else{
            Element cur = new Element(x,Math.min(top.min, x));
            cur.next = top;
            top = cur;
        }
    }

    public void pop() {
        top = top.next;
    }

    public int top() {
        return top.val;
    }

    public int getMin() {
        return top.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */