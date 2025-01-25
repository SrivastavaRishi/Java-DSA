package com.Demo;

public class StringAndStringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<26;i++){
            sb.append((char)('a' + i));
        }
        System.out.println(sb);
    }
}
