package CommonSyntax;

import java.util.ArrayList;
import java.util.List;

public class Java8 {

    public static void main(String[] args){
        List<Integer> list=new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.stream().parallel().forEach(item-> System.out.println(item));
        list.stream().forEachOrdered(item-> System.out.println(item));
    }
}
