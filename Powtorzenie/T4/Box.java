package Powtorzenie.T4;

public class Box<T>{
    private T element;
    public Box(T element){
        this.element = element;
    }
    public T getElement(){
        return element;
    }

    public void setElement(T element){
        this.element = element;
    }

    @Override
    public String toString(){
        return "element: " + element;
    }
}
