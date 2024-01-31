package linkedlist;

class DLinkedList<Type> { 
   Node<Type> head; 
   Node<Type> tail; 
   int size; 
 
   public void swapFirstSecond() {
	   if (head != null && head.next != null) {
           Node<Type> first = head;
           Node<Type> second = head.next;
           first.next = second.next;
           if (second.next != null) {
               second.next.prev = first;
           }
           second.prev = null;
           second.next = first;
           first.prev = second;
           head = second;
       }
   }
   
   public Type remove(int i) {
	   Node<Type> current = head;
       int count = 0;
       while (current != null && count < i) {
           current = current.next;
           count++;
       }
       if (current == null) throw new IndexOutOfBoundsException();
       if (current.prev != null) {
           current.prev.next = current.next;
       } else {
           head = current.next;
       }
       if (current.next != null) {
           current.next.prev = current.prev;
       } else {
           tail = current.prev;
       }
       size--;
       return current.data;
   }
   
   public Type removeFirst() {
	   if (head == null) throw new IllegalStateException("List is empty");
       Type data = head.data;
       head = head.next;
       if (head != null) {
           head.prev = null;
       } else {
           tail = null;
       }
       size--;
       return data;
	   
   }
   
   public Type removeLast() {
	   if (tail == null) throw new IllegalStateException("List is empty");
	   Type data = tail.data;
	   tail = tail.prev;
	   if (tail != null) {
		   tail.next = null;
	   }
	   else {
		   head = null;
	   }
       size--;
       return data;
   }
   
   public void duplicate(int i) {
	   if(i<0 || i>=size) {
		   throw new IndexOutOfBoundsException();
	   }
	   Node<Type> current = head;
	   for (int j=0; j<i; j++) {
		   current = current.next;
	   }
	   Node<Type> dup = new Node<>(current.data);
	   dup.next = current.next;
	   dup.prev = current;
	   current.next = dup;
	   if (dup.next != null) {
		   dup.next.prev = dup;
	   } 
	   else {
		   tail = dup;
	   }
	   size++;
   }
   
   public void addLast(Type data) {
	   Node<Type> newNode = new Node<>(data);
	   if (tail == null) {
		   head = tail = newNode;
	   }
	   else {
		   tail.next = newNode;
		   newNode.prev = tail;
		   tail = newNode;
	   }
	   size++;
	   
   }
   
   
}