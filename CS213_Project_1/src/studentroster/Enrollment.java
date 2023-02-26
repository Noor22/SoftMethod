package studentroster;

public class Enrollment {
    private EnrollStudent[] enrollStudents;
    private int size;

    public Enrollment(){
        this.enrollStudents = new EnrollStudent[Constant.INITIAL_SIZE.getValue()];
        this.size = 0;
    }

    public void add(EnrollStudent enrollStudent){ //add to the end of array. move the last one in the array to replace the deletting index position

    }

    public void remove(EnrollStudent enrollStudent){

    }

    public boolean contains(EnrollStudent enrollStudent){
        return true;
    }

    public void print() {} //print the array as is without sorting
}
