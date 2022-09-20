import org.junit.Test;

public class bytes2hex {
    public static void main(String[] args) {
        byte[] bytes = new byte[10];
        bytes[0] = (byte) 0xab;
        bytes[1] = (byte) 0xcd;
        bytes[2] = (byte) 0xaa;
        bytes[3] = (byte) 0x10;
        bytes[4] = (byte) 0x01;
        bytes[5] = (byte) 0x010;
        bytes[6] = (byte) 0x010;
        bytes[7] = (byte) 0x010;
        bytes[8] = (byte) 0x010;
        bytes[9] = (byte) 0x010;
        System.out.println((byte) 0x010 == (byte) 0x10);
        String s = bytes2hex(bytes);
        System.out.println(s);

        System.out.println(s.substring(6, s.length()));

    }
    public static String bytes2hex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        String tmp;
//        sb.append("[");
        for (byte b : bytes) {
            // 将每个字节与0xFF进行与运算，然后转化为10进制，然后借助于Integer再转化为16进制
            tmp = Integer.toHexString(0xFF & b);
            if (tmp.length() == 1) {
                tmp = "0" + tmp;//只有一位的前面补个0
            }
            sb.append(tmp);//每个字节用空格断开
        }
        sb.delete(sb.length() - 1, sb.length());//删除最后一个字节后面对于的空格
//        sb.append("]");
        return sb.toString();
    }

    @Test
    public void text(){
        String str = "1002031";

        byte[] data = new byte[str.getBytes().length+2];

        byte[] bytes = str.getBytes();

        data[0] = -1;
        data[1] = -1;
        for (int i = 0; i < bytes.length; i++) {
            data[2+i] = bytes[i];
        }

        for (byte datum : data) {
            System.out.print(datum);
        }

    }

}
