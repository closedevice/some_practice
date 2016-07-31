package com.sbbic.classloader;

import sun.misc.Launcher;

import javax.xml.bind.annotation.XmlSeeAlso;
import java.net.URL;

/**
 * Created by God on 2016/5/12.
 * @see
 */
public class ClassloaderTest {
    public static void main(String[] args) {
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL urL : urLs) {
            System.out.println(urL.toExternalForm());
        }
    }
}
