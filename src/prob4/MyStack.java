package prob4;

public class MyStack implements Stack {

	private String[] buffer;
	private int capacity;
	private int top;

	public MyStack(int capacity) throws MyStackException {
		if(capacity <= 0){
			throw new MyStackException("init stack capcity should be over 0");
		}
		this.capacity=capacity;
		this.top=0;
		resize();
	}

	@Override
	public void push(String str) throws RuntimeException {
		if(top==capacity){
			System.out.println("Stack is full: stack is resized");
			capacity*=2;
			resize();
		}
		buffer[top++]=str;

	}

	@Override
	public String pop() throws RuntimeException {
		if(top==0){
			return "Stack is empty";
		}
		return buffer[--top];
	}

	@Override
	public boolean isEmpty() {
		return top==0;
	}

	@Override
	public int size() {
		return top;
	}

	public void resize(){
		String[] newbuffer = new String[capacity];
		if(buffer!=null){
			System.arraycopy(buffer, 0, newbuffer, 0, top);
		}
		buffer=newbuffer;
	}

}
