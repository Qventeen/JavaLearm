package com.jr.level.level21.task2101;

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
        byte[] netAddress = new byte[4];
        for(int i = 0; i < netAddress.length; i++){
            netAddress[i] = (byte) (ip[i] & mask[i]);
        }
        return netAddress;
    }

    public static void print(byte[] bytes) {
        byte tmp = 0;
        StringBuffer sb = new StringBuffer();
        for(int i = bytes.length-1; i >= 0; i--){
            tmp = bytes[i];
            for(int k = 0; k < 8;k++ ){
                 sb.append(tmp & 1);
                 tmp >>>= 1;
            }
            sb.append(' ');
        }
        sb.reverse();
        System.out.println(sb);
    }
}
