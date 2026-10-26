import java.util.ArrayList;

public interface IStack<T>
{
    //primary needs immediate access to private data; are not implemented here
    void push(T aData);
    T pop();
    int size();

    //secondary don't need **immediate** access to private data; implemented here*
    default T peek()
    {
        T temp = pop();
        push(temp);
        return temp;
    }

    //{"cat", "dog", null, null, null}
    default boolean find(T aData) // makes more sense as a primary method.
    {
        ArrayList<T> tempCollection = new ArrayList<>();
        int stackSize = size();
        for(int i = 0; i < stackSize; i++)
        {
            tempCollection.add(this.pop());
        }
        boolean ret = tempCollection.contains(aData);
        //dog, cat
        for(int i = stackSize-1; i > 0; i--)
        {
            this.push(tempCollection.get(i));
        }
        return ret;
    }
}
