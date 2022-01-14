package basic;

public class Main {
    public static void main(String[] args) {
        ThirdHashMap<String,String> map = new ThirdHashMap();
        for (int i = 0; i < 100; i++) {
            map.put("刘华强" + i, "你这瓜保熟吗？" + i);
        }
        System.out.println(map.size());
        for (int i = 0; i < 100; i++) {
            System.out.println(map.get("刘华强" + i));
        }

        map.put("刘华强1","哥们，你这瓜保熟吗？");
        map.put("刘华强1","你这瓜熟我肯定要啊！");
        System.out.println(map.get("刘华强1"));

        map.put(null, "zhangsan");
        map.put(null, "lisi");
        System.out.println(map.get(null));
    }
}
