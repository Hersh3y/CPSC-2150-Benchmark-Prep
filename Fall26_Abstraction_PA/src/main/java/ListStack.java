import java.util.ArrayList;

public class ListStack<T> extends AbsStack<T>
{
    private ArrayList<T> data;

    public ListStack()
    {
        super();
        this.data = new ArrayList<>();
    }

    @Override
    public void push(T aData) {
        this.size++;
        data.add(aData);
    }

    @Override
    public T pop() {
        this.size--;
        return data.remove(data.size()-1);
    }

    @Override
    public boolean find(T aData) {
        return data.contains(aData);
    }
}
