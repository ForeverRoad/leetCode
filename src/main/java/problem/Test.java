package problem;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author zcf
 * @Date 2020-07-06 21:37
 **/
public class Test {

    public static void main(String[] args) {
//        Map<String,String> map = new HashMap<>();
//        map.put("a","1");
//        map.put("b","2");
//        print(map);
//        System.out.println();
//        test(map);
//        print(map);
        String[] arr = {"1","2"};
        arr(arr);

        System.out.println(arr[0]);

    }

    public static void arr(String[] arr){
        arr[0] = "A";
        arr = new String[1];
        arr[0] = "0";
    }
    public static void test(Map<String,String> map){
        map.put("c","3");
        print(map);
        System.out.println();
        map = new HashMap<>();
        map.put("a","123");
    }


    public static void print(Map<String,String> map){
        map.forEach((k,v)->{
            System.out.println(k+",,,"+v);
        });
    }
}
