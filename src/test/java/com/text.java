package com;

import org.junit.Test;

import javax.management.openmbean.TabularData;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;

public class text {
    @Test
    public void text() {
        //        String s = "1110001001111001000100101";
        String s = "1111111111111111111111111111";
//        String wantData = "BTMKHH";
        byte[] Tdata = getDate(s);
        byte max = Tdata[0];
        byte min = Tdata[0];
        for (int i = 0; i < Tdata.length; i++) {
            if (Tdata[i] > max) {
                max = Tdata[i];
            }
            if (Tdata[i] < min) {
                min = Tdata[i];
            }
        }
        System.out.println();
        for (byte tdatum : Tdata) {
            System.out.print(tdatum + " ");
        }

        byte[] Sdata = new byte[6];
        Sdata[0] = (byte) (Tdata[0] + Tdata[1]);
        Sdata[1] = (byte) (Tdata[2] - Tdata[3]);
        Sdata[2] = (byte) (Tdata[4] + Tdata[5]);
        Sdata[3] = max;
        Sdata[4] = min;
        Sdata[5] = (Tdata[5]);
        System.out.println();
        for (byte sdatum : Sdata) {
            System.out.print(sdatum);
        }
        System.out.println();

        for (byte sdatum : Sdata) {
            System.out.print(sdatum);
        }
//        System.out.println((Tdata[0]+ Tdata[1]));
//        Sdata[0] = Tdata[0] + Tdata[1];
//        Sdata[1]=  Tdata[2] - Tdata[3];
//        Sdata[2]=  Tdata[4] + Tdata[5];
//        Sdata[3]=  取Tdata中最小的那一个;
//        Sdata[4]=  取Tdata中最大的那一个;
//        Sdata[5]=  Tdata[5];
//        System.out.println();
//        for (byte sdatum : Sdata) {
//            System.out.print(sdatum+" ");
//        }
    }

    public byte[] getDate(String str) {
        String GetDate = "";

        // 步长
        int endIndex2 = 2;
        int endIndex3 = 3;

        // 数据
        String Data = "";

        // 现在坐标与初始坐标
        int NowIndex = 0;

        for (int i = 0; i < 6; i++) {
            // 每次循环找到这次截取的第一个字符判断是否为0或1
            String FirstData = str.substring(NowIndex, NowIndex + 1);

            // 为1的话直接判断
            if (FirstData.equals("1")) {
                Data = str.substring(NowIndex, NowIndex + endIndex2);
                if ("11".equals(Data)) {
                    GetDate += "B";
                } else if ("10".equals(Data)) {
                    GetDate += "H";
                }
                NowIndex += endIndex2;
                // 为零则判断是否为2位或3位
            } else if ("0".equals(FirstData)) {
                // 截取2个字符
                Data = str.substring(NowIndex, NowIndex + endIndex2);
                if ("00".equals(Data)) {
                    GetDate += "K";
                    NowIndex += endIndex2;
                } else {
                    Data = str.substring(NowIndex, NowIndex + endIndex3);
                    if ("010".equals(Data)) {
                        GetDate += "M";
                    } else if ("011".equals(Data)) {
                        GetDate += "T";
                    }
                    NowIndex += endIndex3;
                }

            }
        }
        System.out.println(GetDate);
        byte[] bytes = GetDate.getBytes(StandardCharsets.UTF_8);
        byte[] Tdata = new byte[6];

//        for (int i = 0; i < 6; i++) {
//            switch (bytes[i]){
//                case 69:
//                    Tdata[i] = 0x45;
//                    break;
//                case 72:
//                    Tdata[i] = 0x48;
//                    break;
//                case 75:
//                    Tdata[i] = 0x4B;
//                    break;
//                case 77:
//                    Tdata[i] = 0x4D;
//                    break;
//                case 84:
//                    Tdata[i] = 0x54;
//                    break;
//                default:
//                    break;
//            }
//        }

        return bytes;
    }

//        System.out.println((byte)0xab);
//        System.out.println((byte)0xcd);
//        System.out.println((byte)0xaa);
//        System.out.println((byte)0x34);
//        System.out.println((byte)0xd2);
//        System.out.println((byte)0x11);


}
