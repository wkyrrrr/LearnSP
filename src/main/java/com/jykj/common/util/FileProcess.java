package com.jykj.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

/**
 * @author abner
 */
public class FileProcess {
    public static String GetFileMD5(File file) throws FileNotFoundException {
        String md5Value = null;
        FileInputStream fileInputStream = new FileInputStream(file);
        try{
            MappedByteBuffer byteBuffer = fileInputStream.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(byteBuffer);
            BigInteger bigInteger = new BigInteger(1, messageDigest.digest());
            md5Value = bigInteger.toString(16);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (null != fileInputStream){
                try {
                    fileInputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return md5Value;
    }
}
