package Powtorzenie.T7;

class A {
    int a;
    A(int a){
        this.a = a;
    }
    public int getA(){
        return a;
    }
}
class B extends A{
    float b;
    B(int y){
    super(y);
    }

    public float getB(){
        return b;
    }
}
class C extends B{
    C(int a, float c){
        super(a);
        b = c;

    }
}