//Name: Princess C. Alejandro 
//Section: BSIT – 2A
// Date: 09/05/25

import java.util.Scanner;
public class ArrayLinkedListSimulation {
  private int[] arr;       
  private int size;     

    // Constructor
    public ArrayLinkedListSimulation() {
        arr = new int[5]; 
        size = 0;
    }

    // Expand array if full
    private void expandArray() {
        int[] newArr = new int[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    // 1. Add element at the end
    public void add(int value) {
        if (size == arr.length) {
            expandArray();
        }
        arr[size] = value;
        size++;
    }

    // 2. Poll (Queue: remove first element)
    public int poll() {
        if (size == 0) {
            return -1; // empty
        }
        int first = arr[0];
        // shift elements left
        for (int i = 1; i < size; i++) {
            arr[i - 1] = arr[i];
        }
        size--;
        return first;
    }

    // 3. Peek (Queue: return first element)
    public int peek() {
        if (size == 0) {
            return -1;
        }
        return arr[0];
    }

    // 4. Pop (Stack: remove last element)
    public int pop() {
        if (size == 0) {
            return -1;
        }
        int last = arr[size - 1];
        size--;
        return last;
    }

    // 5. Clear all elements
    public void clear() {
        size = 0;  // just reset size, no need to recreate array
        System.out.println("All elements cleared.");
    }

    // Display array contents
    public void display() {
        if (size == 0) {
            System.out.println("Array is empty.");
            return;
        }
        System.out.print("Elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayLinkedListSimulation list = new ArrayLinkedListSimulation();

        int choice, value;
        do {
            System.out.println("\n=== Array Linked List Simulation ===");
            System.out.println("1. Add (enqueue/push)");
            System.out.println("2. Poll (dequeue)");
            System.out.println("3. Peek (front element)");
            System.out.println("4. Pop (stack pop)");
            System.out.println("5. Display elements");
            System.out.println("6. Clear all elements");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to add: ");
                    value = sc.nextInt();
                    list.add(value);
                    System.out.println(value + " added.");
                    break;
                case 2:
                    System.out.println("Polled: " + list.poll());
                    break;
                case 3:
                    System.out.println("Peek: " + list.peek());
                    break;
                case 4:
                    System.out.println("Popped: " + list.pop());
                    break;
                case 5:
                    list.display();
                    break;
                case 6:
                    list.clear();
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        sc.close();
    }
}
/*
SAMPLE OUTPUT 
Array Linked List Simulation 
1. Add (enqueue/push)
2. Poll (dequeue)
3. Peek (front element)
4. Pop (stack pop)
5. Display elements
0. Exit
Enter choice: 1
Enter value to add: 10
10 added.

Enter choice: 1
Enter value to add: 20
20 added.

Enter choice: 1
Enter value to add: 30
30 added.

Enter choice: 5
Elements: 10 20 30 

Enter choice: 3
Peek: 10

Enter choice: 2
Polled: 10

Enter choice: 5
Elements: 20 30 

Enter choice: 4
Popped: 30

Enter choice: 5
Elements: 20 
*/
