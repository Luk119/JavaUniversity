package labolatory3.Tasks123456_8;

class Rectangle {

    private double length, width, area;

    Rectangle(){
        length = 1;
        width = 1;
        area =  length * width;
    }

    Rectangle(double length, double width){
        if(isValid(length, width)){
            this.length = length;
            this.width = width;
            area = width * length;
        }
    }

    Rectangle(double a){
        length = a;
        width = a;
        area = a*a;
    }

    Rectangle(double x1, double y1, double x2, double y2){
        length = Math.abs(x2 - x1);
        width = Math.abs(y2 - y1);
        area = width * length;
    }

    double getArea(){
        return length*width;
    }

    double getCircuit(){
        return 2*(length*width);
    }

    double getLength(){
        return length;
    }

    double getWidth(){
        return width;
    }

    void setLength(double length){
        this.length = length;
    }

    void setWidth(double width){
        this.width = width;
    }

    void print(){
        System.out.println("length: " + length + "\nwidth: " + width + "\narea: " + area);
    }

    boolean isValid(double len, double wid){
        if(len < 0 || wid < 0){
            return false;
        }
        return true;
    }
}
