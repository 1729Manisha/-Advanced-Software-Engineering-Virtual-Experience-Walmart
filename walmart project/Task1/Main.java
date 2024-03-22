public class Main
{
	public static void main(String[] args) {
        // Create a new instance of the Heap with a child count of 2
        Heap<Integer> maxHeap = new Heap<>(2);

        //Inserting Elements
        maxHeap.insert(10);
        maxHeap.insert(15);
        maxHeap.insert(20);
        
        //Printing Complete Heap
        maxHeap.printCompleteHeap();
        //Popping Max elements
        maxHeap.popMax();

        //Printing Complete Heap
        maxHeap.printCompleteHeap();

    }
}