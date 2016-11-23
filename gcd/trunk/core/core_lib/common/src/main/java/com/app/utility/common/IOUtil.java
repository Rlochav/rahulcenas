package com.app.utility.common;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class IOUtil {

   // private static final Logger logger = Logger.getAnonymousLogger(IOUtil.class);
    /**
     * Loads a file from CLASSPATH
     * @param fileName : String file name
     * @return : Returns the input stream of the resource
     */
    public static InputStream getResourceAsStream(String fileName) {
            InputStream inputStream = IOUtil.class.getClassLoader().getResourceAsStream(fileName);
            if (inputStream == null) {
                    inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            }
            if (inputStream == null) {
                    inputStream = IOUtil.class.getResourceAsStream(fileName);
            }
            if (inputStream == null) {
                    inputStream = Object.class.getClassLoader().getResourceAsStream(fileName);
            }
            return inputStream;
    }
    

    /**
     * Loads file from file system.
     * @param fileName
     * @return
     */
    public static File getResourceAsFile(String fileName) {
            File file = new File(IOUtil.class.getResource(fileName).getFile());
            if(file == null){
                    return null;
            }
            if(!file.exists()){
                    return null;
            }
            return file;
    }
    
    /**
     * Close a writer silently
     * @param writer
     */
    public static void close(Writer writer){
            if(writer != null){
                    try {
                            writer.flush();
                            writer.close();
                    } catch (IOException e) {
                            e.printStackTrace();
                    }
            }
    }
    
    /**
     *  Close a InputStream silently
     * @param inputStream
     */
    public static void close(InputStream inputStream){
            if(inputStream != null){
                    try {
                            inputStream.close();
                    } catch (IOException e) {
                            e.printStackTrace();
                    }
            }
    }
    
    /**
     *  Close a OutputStream silently
     * @param outputStream
     */
    public static void close(OutputStream outputStream){
            if(outputStream != null){
                    try {
                            outputStream.flush();
                            outputStream.close();
                    } catch (IOException e) {
                            e.printStackTrace();
                    }
            }
    }
    
    public static void close(Reader reader){
            if(reader != null){
                    try {
                            reader.close();
                    } catch (IOException e) {
                            e.printStackTrace();
                    }
            }
    }
    
    
    /**
     *      Colse the Writer/Reader/Streams silently.
     * @param T extends Closeable
     * @param t
     */
    public static <T extends Closeable> void close(T t){
            close(t, true);
    }
    
    /**
     *      Colse the Writer/Reader/Streams and if there is any exception, then log that based on the value of silent.
     * @param T extends Closeable
     * @param t
     * @param silent
     */
    public static <T extends Closeable> void close(T t, boolean silent){
            if(null != t){
                    try {
                            t.close();
                    } catch (IOException e) {
                            if(!silent){
                                   // logger.error(e);
                            }
                    }
            }
    }

    public static void writeAsText(String fileName, String text) {
            BufferedWriter bufferedWriter = null;
            try {
                    bufferedWriter = new BufferedWriter(new FileWriter(new File(fileName)));
                    bufferedWriter.write(text);
            } catch (Exception e) {
                    e.printStackTrace();
            }
    }

}

