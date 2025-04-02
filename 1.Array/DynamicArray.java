class DynamicArray{
    private int array[];
    private int count;
    private int sizeOfArray;
    
    // default constructor
    //1. A constructor has the same name as the class in which it is defined.
    //2. Constructors do not have any return type, not even void. The main purpose of a constructor is to initialize the object, not to return a value.
    //3. When an object of a class is created, the constructor is called automatically to initialize the object’s attributes.
    //4. Constructors are primarily used to set the initial state or values of an object’s attributes when it is created.
    public DynamicArray(){
        array = new int[1];
        count =0;
        sizeOfArray = 1;
    }

    // add element at the end
    public void addElment(int a){
        if(count == sizeOfArray){
            growSize();
        }
        array[count] = a;
        count++;
    }

    // grow the size of array by 2 
    public void growSize(){
        int temp[] = null;
        if(count == sizeOfArray){
            temp = new int[sizeOfArray*2];
            for(int i=0; i<sizeOfArray; i++){
                temp[i] = array[i];
            }
        }
        array = temp;
        sizeOfArray = sizeOfArray*2; 
    }

    // adding the element in array at specific position
    public void addElmentAt(int index, int a){
        if(count == sizeOfArray){
            growSize();
        }
        for(int i=count-1; i>=index; i--){
            array[i+1] = array[i];
        }
        array[index] = a;
        count++;
    }

    // remove last element from the array
    public void remove(){
        if(count > 0){
            array[count-1] = 0;
            count--;
        }
    }

    // remove element at the specific position
    public void removeAt(int index){
        if(count > 0){
            for(int i=index; i>=count-1; i++){
                array[i] = array[i+1];
            }
            array[count-1] = 0;
            count--;
        }
    }

    // after deleting the element from the array shrink the size of the array
    public void shrinkSize(){
        int temp[] = null;
        if(count > 0){
            temp = new int[count];
            for(int i=0; i<count; i++){
                temp[i] = array[i];
            }
            sizeOfArray = count;
            array = temp;
        }
    }

    public void printArray(){
        if(count > 0){
            for(int i=0; i<sizeOfArray; i++){
                System.out.print(array[i]+" ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        System.out.println("*********** Nitesh Kumar ****************");
        DynamicArray da = new DynamicArray();
        da.addElment(5);
        da.addElment(6);
        da.addElment(3);
        da.addElment(8);
        da.addElment(4);
        da.addElment(2);
        da.printArray();
        da.shrinkSize();
        da.printArray();
    }
}


// output
// *********** Nitesh Kumar ****************
// 5 6 3 8 4 2 0 0 
// 5 6 3 8 4 2 