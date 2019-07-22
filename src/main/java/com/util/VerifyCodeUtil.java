package com.util;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Random;
import java.lang.String;


import javax.imageio.ImageIO;

public class VerifyCodeUtil {

    //使用到Algerian字体，系统里没有的话需要安装字体，字体只显示大写，去掉了1,0,i,o几个容易混淆的字符
       public static final String VERIFY_CODES = "23456789ABCDEFGHJKLMNPQRSTUVWXYZ";
        private static Random random = new Random();




     /**
     * 使用系统默认字符源生成验证码
     * @param verifySize    验证码长度
     * @return
     */
            public static String generateVerifyCode(int verifySize){
          return generateVerifyCode(verifySize,VERIFY_CODES);
     }
    public static String generateVerifyCode(int verifySize, String sources){
            if(sources == null || sources.length() == 0){
                sources = VERIFY_CODES;
        }
            int codesLen = sources.length();
            Random rand = new Random(System.currentTimeMillis());
            StringBuilder verifyCode = new StringBuilder(verifySize);
           for(int i = 0; i < verifySize; i++){
                   verifyCode.append(sources.charAt(rand.nextInt(codesLen - 1)));
           }
      return verifyCode.toString();
     }
}
