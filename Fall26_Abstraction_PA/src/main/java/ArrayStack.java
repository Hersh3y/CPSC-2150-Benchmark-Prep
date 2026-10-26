public class ArrayStack<T> extends AbsStack<T>
{
    private T[] data;

    public ArrayStack(T[] data) {
        super();
        this.data = data;
    }

    //{"cat", "dog", null, null, null}
    @Override
    public void push(T aData) {
        for(int i = 0; i < data.length; i++)
        {
            if(data[i] == null)
            {
                data[i] = aData;
                this.size++;
                break;
            }
        }
    }
    @Override
    public T pop() {
        T temp = null;
        for(int i = data.length - 1; i >= 0; i--)
        {
            if(data[i] != null)
            {
                temp = data[i];
                data[i] = null;
                this.size--;
                break;
            }
        }
        return temp;
    }

    //{"cat", "dog", null, null, null}
    public T peekPrimary() {
        T temp = null;
        for(int i = data.length - 1; i >= 0; i--)
        {
            if(data[i] != null)
            {
                temp = data[i];
                break;
            }
        }
        return temp;
    }

    @Override
    public boolean find(T aData) {
        for(T item : data)
        {
            if(item.equals(aData))
                return true;
        }
        return false;
    }
}
