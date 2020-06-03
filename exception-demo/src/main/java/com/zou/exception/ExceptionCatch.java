package com.zou.exception;

import com.google.common.collect.ImmutableMap;
import com.zou.controller.ExceptionController;
import com.zou.util.CommonCode;
import com.zou.util.ResponseResult;
import com.zou.util.ResultCode;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


//使用该注解定义全局异常处理类

/**
 * 在@ControllerAdvice中添加对应的参数，可以只捕获指定的controller
 * 例如 ： @ControllerAdvice(basePackageClasses = ExceptionController.class)
 **/
@ControllerAdvice(basePackageClasses = ExceptionController.class)
public class ExceptionCatch {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionCatch.class);

    //定义map，配置异常类型所对应的错误代码
    private static ImmutableMap<Class<? extends Throwable>, ResultCode> EXCEPTIONS;
    //定义map的builder对象，去构建ImmutableMap
    protected static ImmutableMap.Builder<Class<? extends Throwable>, ResultCode> builder = ImmutableMap.builder();

    static {
        //定义异常类型所对应的错误代码
        builder.put(HttpMessageNotReadableException.class, CommonCode.INVALID_PARAM);
    }


    //捕获Exception此类异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult exception(Exception exception) {
        //记录日志
        LOGGER.error("catch exception:{}", exception.getMessage());
        if (EXCEPTIONS == null) {
            EXCEPTIONS = builder.build();//EXCEPTIONS构建成功
        }
        //从EXCEPTIONS中找异常类型所对应的错误代码，如果找到了将错误代码响应给用户，如果找不到给用户响应99999异常
        ResultCode resultCode = EXCEPTIONS.get(exception.getClass());
        if (resultCode != null) {
            return new ResponseResult(resultCode);
        } else {
            //返回99999异常
            return new ResponseResult(CommonCode.SERVER_ERROR);
        }
    }


    //捕获CustomException此类异常
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public ResponseResult customException(CustomException customException) {
        //记录日志
        LOGGER.error("catch exception:{}", customException.getMessage());
        ResultCode resultCode = customException.getResultCode();
        return new ResponseResult(resultCode);
    }

    //捕获CustomException此类异常
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public ResponseResult arithmeticException(Exception exception) {
        //记录日志
        LOGGER.error("catch exception:{}", exception.getMessage());
        if (EXCEPTIONS == null) {
            EXCEPTIONS = builder.build();//EXCEPTIONS构建成功
        }
        //从EXCEPTIONS中找异常类型所对应的错误代码，如果找到了将错误代码响应给用户，如果找不到给用户响应99999异常
        ResultCode resultCode = EXCEPTIONS.get(exception.getClass());
        if (resultCode != null) {
            return new ResponseResult(resultCode);
        } else {
            //返回99999异常
            return new ResponseResult(CommonCode.SERVER_ERROR);
        }
    }

    @InitBinder("date")
    public void processParam(WebDataBinder dataBinder) {

        dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
        // dataBinder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
    }

    @ModelAttribute(binding = false)
    public Map<String, String> presetParam(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        return map;
    }
    @ModelAttribute(binding = false)
    public void presetParam(Model model){
        model.addAttribute("globalAttr","this is a global attribute");
    }


    public static void main(String[] args) throws Exception {
        getFile();
        /*       *//** 将文件中的公钥对象读出 *//*
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("publickey.keystore"));
        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("privatekey.keystore"));
        Key key = (Key) ois.readObject();
        Key key1 = (Key) ois1.readObject();
        ois.close();

        byte[] encrypt = encrypt((PublicKey) key, "aaa".getBytes());

        String decrypt = decrypt((PrivateKey) key1, encrypt);
        System.out.println(decrypt);*/

    }

    //解密数据
    private static String decrypt(PrivateKey privateKey, byte[] byteArray) {
        try {
            Provider provider = new org.bouncycastle.jce.provider.BouncyCastleProvider();
            Security.addProvider(provider);
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", provider);
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] plainText = cipher.doFinal(byteArray);
            return new String(plainText);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //加密数据
    public static byte[] encrypt(PublicKey publicKey, byte[] data) throws Exception {
        Cipher ci = Cipher.getInstance("RSA");
        ci.init(Cipher.ENCRYPT_MODE, publicKey);
        return ci.doFinal(data);
    }

    //生成秘钥对文件
    public static void getFile() throws Exception {
        //生成密钥对
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(1024);
        KeyPair key = keyGen.generateKeyPair();
        PublicKey publicKey = key.getPublic();
        PrivateKey privateKey = key.getPrivate();
        String s = new String(Base64.encodeBase64(publicKey.getEncoded()));
        String s1 = new String(Base64.encodeBase64(privateKey.getEncoded()));
        System.out.println(s);
        System.out.println(s1);
        System.out.println();

        ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream("publickey.keystore"));
        ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("privatekey.keystore"));
        oos1.writeObject(publicKey);
        oos2.writeObject(privateKey);

        oos1.close();
        oos2.close();
    }


}
