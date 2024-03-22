import java.util.ArrayList;
public class Heap< T extends Comparable<T>> 
{
  private final int childCount;
  private final ArrayList < T > data;
  public Heap (int childCount)
  {
	this.validateChildCount (childCount);
	this.childCount = childCount;
	this.data = new ArrayList < T > ();
  }

    // ensure childCount is valid
    // ensure childCount is greater than zero
  private void validateChildCount (int childCount)
  {
	if (childCount <= 0)
	  {
		throw new
		  IllegalArgumentException ("childCount must be greater than zero");
	  }
    // ensure childCount is a power of 2
	double logChildCount = Math.log (childCount) / Math.log (2);
	if (Math.ceil (logChildCount) != Math.floor (logChildCount))
	  {
		throw new
		  IllegalArgumentException ("childCount must be a power of 2");
	  }
  }

  public void insert(T item)
  {
     data.add(item);
     int itemindex = data.size()-1;

     while(itemindex>0)
     {
        itemindex=this.swapUP(itemindex);
     }
     System.out.println("Successfully Inserted "+ item+" into the Heap");
 }

  private int swapUP(int childindex)
  {  T childvalue=data.get(childindex);
     int parentindex = (int)Math.floor((float)(childindex-1)/childCount);
     if(parentindex>=0)
     {
        T parentvalue = data.get(parentindex);
        if(childvalue.compareTo(parentvalue)>0)
        {
            data.set(parentindex, childvalue);
            data.set(childindex, parentvalue);
            return parentindex;
        }
     }
    return -1;
  }

  public void printCompleteHeap()
  {  
     System.out.print("Complete Heap : ");
     for(T item: data)
     {
        System.out.print(item+" ");
     }
     System.out.println();
  }

  public void popMax()
  {
     if(data.size()>0)
     { 
       T maxItem= data.get(0);
       if(data.size()>1)
       {
       T lastItem= data.remove(data.size()-1);
       data.set(0,lastItem);
       int itemIndex=0;
       while(itemIndex>0)
       {
         itemIndex =this.swapDown(itemIndex);
       }
       }
       System.out.println("Succesfully Deleted "+ maxItem+" from the Heap");
     }
     else
     {
        System.out.println("Heap is Empty");
     }
  }

  private int swapDown(int parentIndex)
  { 
    T parentvalue= data.get(parentIndex);
    int largestChildIndex=0;
    T largestChildValue = null;
    for(int i=0; i<childCount; i++)
    {
      int childIndex = parentIndex * childCount * i-1;
      if(childIndex > data.size()-1)
      {
        T childValue= data.get(childIndex);
        if(largestChildValue==null || childValue.compareTo(largestChildValue)>0)
        {
            largestChildIndex=childIndex;
            largestChildValue=childValue;
        }
      }
    }

    if(largestChildValue!= null || parentvalue.compareTo(largestChildValue)<0)
    {
        data.set(parentIndex, largestChildValue);
        data.set(largestChildIndex, parentvalue);
        return largestChildIndex;
    }
    return -1;
  }
}
