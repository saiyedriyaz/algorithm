package net.demo.core;

public class PassByValue {

    static class StringWraper {
        StringBuilder sw;
    }
    public void testRefs(String str, StringBuilder sb, StringWraper sw){
        str = str + sb.toString();
        sb.append(str);
        str = null;
        sb = null;
        sw.sw = null;
    }

    public static void main(String[] args){
        String s = "aaa";
        StringBuilder sb = new StringBuilder("bbb");
        var sw = new StringWraper();
        sw.sw = sb;
        new PassByValue().testRefs(s, sb, sw);
        System.out.println("s="+s+" sb="+sb+", sw="+sw.sw);
    }
}
