package Implementation_Design_Patterns;

public class Adapter {
    public static void main(String[] args){
        DataAdapterAbstract cl = new DataAdapterConcrete();
        cl.print();
    }
}


interface DataAdapterAbstract{
    void print();
};

class DataAdapterConcrete implements DataAdapterAbstract{
    DataAdaptee d;
    DataAdapterConcrete(){
        d = new DataAdaptee();
    }

    public void print(){
        d.printAdaptee();
    }

};


class DataAdaptee{
    void printAdaptee(){
        System.out.println("Printing from DataAdaptee");
    }
};