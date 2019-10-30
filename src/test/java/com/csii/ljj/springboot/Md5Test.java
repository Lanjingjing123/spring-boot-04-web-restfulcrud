package com.csii.ljj.springboot;

import org.apache.commons.codec.digest.DigestUtils;


import java.beans.Encoder;
import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Md5Test {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\ljj\\Desktop\\BBG\\联合贷产品\\众邦\\转发_ 厦门国际银行联合贷日终对帐文件demo\\handlepaopiwenjian\\20320709\\CFSP002000030_20320709_1_4483913D59D37D872498D728DB47B05D.txt";
        InputStream is = new FileInputStream(new File(path));
       String MD5 = DigestUtils.md5Hex(is);
        MD5 = MD5.toUpperCase();
       String originMd5 = "4483913D59D37D872498D728DB47B05D";
       System.out.println(MD5+"\n"+originMd5);
       // path+filename

        String money = "10.53";
        BigDecimal mm = new BigDecimal(money);
        System.out.println("money:"+money);

        BigDecimal one = new BigDecimal(10.35).setScale(2, RoundingMode.HALF_UP);
        System.out.println(one);
        BigDecimal two = BigDecimal.ZERO;
        BigDecimal total = one.add(two);
        System.out.println(total);


        String a = "2019/10/29";
        String b = "2019/10/20";
        String[] arr = {a,b};
        String result = arr[0].replace("/","");
        System.out.println(result);
        for (String s : arr) {
            System.out.println(s);
        }
//        String[] split = abc.replace();


//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\ljj\\Desktop\\BBG\\联合贷产品\\众邦\\转发_ 厦门国际银行联合贷日终对帐文件demo\\handlepaopiwenjian\\20320705\\TEST.txt"),"GBK"));
//        StringBuffer sb = new StringBuffer();
//        sb.append("a").append("|&|").append("").append("|&|").append("b").append("|&|").append("");
//        System.out.println("sb.length:"+sb.length());
//        bw.write(sb.toString());
//        bw.flush();
//        bw.close();
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\ljj\\Desktop\\BBG\\联合贷产品\\众邦\\转发_ 厦门国际银行联合贷日终对帐文件demo\\handlepaopiwenjian\\20320705\\TEST.txt"), "GBK"));
//        String line = null;
//
//        while ((line=br.readLine())!=null){
//            System.out.println(line);
//            String[] arr = line.split("\\|&\\|");
//            System.out.println(arr.length);
//            System.out.println("=================================");
////            System.out.println(arr[0]+","+arr[1]);
//        }


    }
}
