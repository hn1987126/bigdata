package cn.jhsoft.study;


/**
 * Created by chen on 2017/8/5.
 */
public class StringDemo {

    public static void main(String[] args) {

        // 将字符串变为字节数组
        String s = "ab你好";
        byte[] b = s.getBytes();
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }

        char c[] = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }

        System.out.println(String.valueOf(4) + 1);
        System.out.println("ab".equalsIgnoreCase("AB"));
        System.out.println("ab".contains("A"));
        System.out.println("ab".endsWith("a"));


        System.out.println("be".compareTo("ba"));

        System.out.println("abca".indexOf("a", 2));

        StringBuilder sb = new StringBuilder();
        sb.append("sb").append(true);
        //sb.insert(1, "sbsb");
        System.out.println(sb);
        System.out.println(sb.delete(1, 3));

        System.out.println(sb.charAt(2));

        System.out.println(sb.replace(0, 1, "sb"));


        System.out.println(Integer.parseInt("1"));
        Integer i = new Integer("123");
        System.out.println(i.intValue());


        System.out.println(Integer.toBinaryString(10)); // 二进制
        System.out.println(Integer.toHexString(10)); // 十六进制
        System.out.println(Integer.toOctalString(10)); // 八进制
        System.out.println(Integer.toString(10, 8)); // 转八进制，后面的进制随便自己传

        // 其他进制转 2进制
        System.out.println(Integer.parseInt("110", 2));
        System.out.println();


    }

}
