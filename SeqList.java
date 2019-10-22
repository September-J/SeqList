import java.util.Arrays;

public class SeqList {
    private int[] data = new int[10];//这个数组的最大容量是10，初始情况下，这10个元素并不都是有效元素
    private int size = 0;//size表示当前数组中有多少个有效元素
    public void display(){
        //System.out.println(Arrays.toString(data));
        System.out.println("[");
        for(int i = 0;i < size;i++){
            System.out.println(data[i]);
            if(i != size -1){
                System.out.println(",");
            }
        }
        System.out.println("]");
    }
    //pos是插入元素的位置，elem是插入的元素值
    public void add(int pos,int elem){
        if(pos > data.length || pos < 0){
            return;
        }
        if(size >= data.length){
            realloc();
        }
        if(pos == size){
            data[pos] = elem;
            size++;
        }else{
            for(int i = size;i > pos;i--){
                data[i] = data[i-1];
            }
            data[pos] = elem;
            size++;
        }
    }
    //扩容
    public void realloc(){
        int[] newData = new int[this.data.length*2];
        for(int i = 0;i < this.data.length;i++){
            newData[i] = this.data[i];
        }
        this.data = newData;
    }
    public boolean contains(int toFind){
        return this.search(toFind) != -1;
    }
    public int search(int toFind){
        for(int i = 0;i < this.size;i++){
            if(this.data[i] == toFind){
                return i;
            }
        }
        return -1;
    }
    public int getPos(int pos){
        return this.data[pos];
    }
    public void setPos(int pos,int elem){
        this.data[pos] = elem;
    }
    //按值删除，删除第一次出现的值
    public void remove(int toRemove){
        int pos = search(toRemove);
        if(pos == -1){
            return;
        }
        if(pos == this.size - 1){
            this.size--;
            return;
        }
        for(int i = pos;i < this.size - 1;i++){
            this.data[i] = this.data[i+1];
        }
        this.size--;
    }
    public int size(){
        return this.size;
    }
    public void clear(){
        this.size = 0;
        this.data = new int[10];
    }
}
