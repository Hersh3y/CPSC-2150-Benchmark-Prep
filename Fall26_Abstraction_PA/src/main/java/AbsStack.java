public abstract class AbsStack<T> implements IStack<T>
{
    protected int size;

    protected AbsStack()
    {
        this.size = 0;
    }

   public int size()
   {
       return this.size;
   }
}
