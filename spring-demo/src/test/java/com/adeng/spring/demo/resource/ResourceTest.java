package com.adeng.spring.demo.resource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;


/**
 * Spring内置Resource
 *
 * @author
 * @create 2018-03-25 下午7:00
 */
public class ResourceTest {


    /**
     * ByteArrayResource可多次读取数组资源，即isOpen ()永远返回false。
     */
    @Test
    public void testByteArrayResource() {
        Resource resource = new ByteArrayResource("Hello World!".getBytes());
        if (resource.exists()) {
            dumpStream(resource);
        }
    }

    private void dumpStream(Resource resource) {
        try (//1.获取文件资源
             InputStream is = resource.getInputStream()) {

            //2.读取资源
            byte[] descBytes = new byte[is.available()];
            is.read(descBytes);
            System.out.println(new String(descBytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * InputStreamResource代表java.io.InputStream字节流，
     * 对于“getInputStream ”操作将直接返回该字节流，
     * 因此只能读取一次该字节流，即“isOpen”永远返回true。
     */
    @Test
    public void testInputStreamResource() {
        ByteArrayInputStream bis = new ByteArrayInputStream("Hello World!".getBytes());
        Resource resource = new InputStreamResource(bis);
        if (resource.exists()) {
            dumpStream(resource);
        }
        Assert.assertEquals(true, resource.isOpen());
    }


    /**
     * FileSystemResource代表java.io.File资源，
     * 对于“getInputStream ”操作将返回底层文件的字节流，
     * “isOpen”将永远返回false，从而表示可多次读取底层文件的字节流。
     */
    @Test
    public void testFileResource() {

        File file =
                new File(System.getProperty("user.dir") + "/src/main/resources/resource/test.txt");
        Resource resource = new FileSystemResource(file);
        if (resource.exists()) {
            dumpStream(resource);
        }
        Assert.assertEquals(false, resource.isOpen());
    }

    /**
     * 使用默认的加载器加载资源，将加载当前ClassLoader类路径上相对于根路径的资源
     *
     * @throws IOException
     */
    @Test
    public void testClasspathResourceByDefaultClassLoader() throws IOException {
        Resource resource =
                new ClassPathResource("resource/test1.properties");
        if (resource.exists()) {
            dumpStream(resource);
        }
        System.out.println("path:" + resource.getFile().getAbsolutePath());
        Assert.assertEquals(false, resource.isOpen());
    }

    /**
     * 使用指定的ClassLoader进行加载资源，将加载指定的ClassLoader类路径上相对于根路径的资源：
     *
     * @throws IOException
     */
    @Test
    public void testClasspathResourceByClassLoader() throws IOException {
        ClassLoader cl = this.getClass().getClassLoader();
        Resource resource = new ClassPathResource("resource/test1.properties", cl);
        if (resource.exists()) {
            dumpStream(resource);
        }
        System.out.println("path:" + resource.getFile().getAbsolutePath());
        Assert.assertEquals(false, resource.isOpen());
    }

    /**
     * 使用指定的类进行加载资源，将尝试加载相对于当前类的路径的资源
     *
     * @throws IOException
     */
    @Test
    public void testClasspathResourceByClass() throws IOException {
        Resource resource1 = new ClassPathResource("com/adeng/spring/demo/resource/test2.properties", this.getClass());
        if (resource1.exists()) {
            dumpStream(resource1);
        }
        System.out.println("path:" + resource1.getFile().getAbsolutePath());
        Assert.assertEquals(false, resource1.isOpen());

        Resource resource2 = new ClassPathResource("test2.properties", this.getClass());
        if (resource2.exists()) {
            dumpStream(resource2);
        }
        System.out.println("path:" + resource2.getFile().getAbsolutePath());
        Assert.assertEquals(false, resource2.isOpen());
    }
}
