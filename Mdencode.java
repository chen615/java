
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Mdencode
{
    public static final String MD5="MD5";

    /**
     * ���ü����㷨�����ַ�������
     * @param str   ��Ҫ���ܵ�����
     * @param algorithm ���õļ����㷨
     * @return �ֽ�����
     */
    public static byte[] EncryptionStrBytes(String str, String algorithm) {
        // ����֮�������ֽ�����
        byte[] bytes = null;
        try {
            // ��ȡMD5�㷨ʵ�� �õ�һ��md5����ϢժҪ
            MessageDigest md = MessageDigest.getInstance(algorithm);
            //���Ҫ���м���ժҪ����Ϣ
            md.update(str.getBytes());
            //�õ���ժҪ
            bytes = md.digest();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("�����㷨: "+ algorithm +" ������: ");
        }
        return null==bytes?null:bytes;
    }

    /**
     * ���ֽ�����ת�����ַ�������
     * @param bytes
     * @return
     */
    public static String BytesConvertToHexString(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        for (byte aByte : bytes) {
          String s=Integer.toHexString(0xff & aByte);
            if(s.length()==1){
                sb.append("0"+s);
            }else{
                sb.append(s);
            }
        }
        return sb.toString();
    }

    /**
     * ���ü����㷨�����ַ�������
     * @param str   ��Ҫ���ܵ�����
     * @param algorithm ���õļ����㷨
     * @return �ֽ�����
     */
    public static String EncryptionStr(String str, String algorithm) {
        // ����֮�������ֽ�����
        byte[] bytes = EncryptionStrBytes(str,algorithm);
        return BytesConvertToHexString(bytes);
    }
    
    //������������
    public static void main(String[] args) {
        String test1="111111";
        String test2="QWERFVDSCX";
        String test3="23423KJHkdfg";
        String[] test={test1,test2,test3};
        for (String s : test) {
            String str=EncryptionStr(s,MD5);
            System.out.println("���ݣ�" + s+" ����֮��Ľ��Ϊ��"+str+" �ַ�������Ϊ��"+str.length());
        }
    }
    
}