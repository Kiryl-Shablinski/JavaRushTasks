package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);

       print(ip);          //11000000 10101000 00000001 00000010
       print(mask);        //11111111 11111111 11111110 00000000
       print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
       byte[] address = new byte[4];
        for (int i=0; i<ip.length||i<mask.length;i++){
            address[i] = (byte) (ip[i]&mask[i]);
        }

        return address;
    }

    public static void print(byte[] bytes) {
       for (byte tmp : bytes) {
            if (tmp<0) {
                System.out.printf("%.8s ", Integer.toBinaryString(tmp << (32 - 8)));
            }else {
                String text = String.format("%8s", Integer.toString(tmp,2));
                System.out.print(text.replace(' ', '0')+" ");
            }
       }
        System.out.println();
    }
}
