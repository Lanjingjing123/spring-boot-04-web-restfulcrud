package com.csii.ljj.springboot;

import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FileTest {

    // 贷款基本信息交易码
    private static String loanFundamentalInfo = "CFSP002000110";

    private static String  repayPlan = "CFSP002000030";

    private static String  repayDetl = "CFSP002000040";

    @Test
    public void getFileList(){
        File dirFile = new File("C:\\Users\\ljj\\Desktop\\BBG\\联合贷产品\\众邦\\转发_ 厦门国际银行联合贷日终对帐文件demo\\handlepaopiwenjian\\20320705");
        Map<String,String> map = new HashMap<String,String>();

        if (!dirFile.exists()){
            throw new RuntimeException("路径不存在");
        }

        if (dirFile.isDirectory()){
            System.out.println("目录");
        }

        if(dirFile.isFile()){
            System.out.println("文件");
        }

        String[] fileNames = dirFile.list();


        for (String fileName:fileNames) {
            System.out.println(fileName);
            if (fileName.contains(loanFundamentalInfo)){
                System.out.println("111");
                map.put(loanFundamentalInfo,fileName);
            }
            if (fileName.contains(repayPlan)){
                System.out.println("111");
                map.put(repayPlan,fileName);
            }

            if (fileName.contains(repayDetl)){
                System.out.println("111");
                map.put(repayDetl,fileName);
            }
        }
        System.out.println("loanFundamentalInfo:"+map.get(loanFundamentalInfo));
        System.out.println("repayPlan:"+map.get(repayPlan));
        System.out.println("repayDetl:"+map.get(repayDetl));
      if(map.size() != 3){
         throw new RuntimeException("文件数量或者格式不对！");
      }





    }
}
