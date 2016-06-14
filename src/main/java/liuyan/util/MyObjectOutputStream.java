package liuyan.util;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * �Զ���ObjectOutputStream,���׷��д�����󣬶�ȡ��������⣨׷��дString����������⣩
 * �ο�http://halzhang.iteye.com/blog/267917
 * */
public class MyObjectOutputStream extends ObjectOutputStream {  
    //����ɾ�̬�ĺô�  
    private static File f;  
  
    /** 
     * ��ʼ����̬�ļ����󣬲���������� 
     * @param file �ļ��������ڳ�ʼ����̬�ļ����� 
     * @param out ����� 
     * @return MyObjectOutputStream 
     * @throws IOException 
     */  
    public static  MyObjectOutputStream newInstance(File file, OutputStream out)  
            throws IOException {  
        f = file;//����������Ҫ�ĵط��������ļ������������ļ���������ͬһ��  
        return new MyObjectOutputStream(out, f);  
    }  
  
    @Override  
    protected void writeStreamHeader() throws IOException {  	//��дwriteStreamHeader()����
        if (!f.exists() || (f.exists() && f.length() == 0)) {  
            super.writeStreamHeader();  
        } else {  
            super.reset();  
        }  
  
    }  
  
    public MyObjectOutputStream(OutputStream out, File f) throws IOException {  
        super(out);  
    }  
}  