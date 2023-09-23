package net.demo.collections;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Data {
    int value;
    Data(int value){
        this.value = value;
    }
}
public class QueueDemo {
    public static void main(String[] args) {
        /*Queue<String> container = new LinkedList<>();
        container.add("one");*/

        Data[] dataArr = new Data[]{ new Data(1), new Data(2),
                new Data(3), new Data(4) };

        List<Data> dataList = Arrays.asList(dataArr); //1

        for(Data element :  dataList){

            dataList.removeIf( (Data d) -> { return d.value%2 ==  0; } );  //2

        }
    }
}
