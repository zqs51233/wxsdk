package com.wxsdk.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectByteArrayUtils {

    public static Object toObject(byte[] bytes) throws Exception {
        if (bytes == null) {
            return null;
        }
        ByteArrayInputStream bin = new ByteArrayInputStream(bytes);
        ObjectInputStream in = new ObjectInputStream(bin);
        Object ret = in.readObject();
        in.close();
        return ret;
    }

    public static byte[] toBytes(Object obj) throws Exception {
        if (obj == null) {
            return null;
        }
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bout);
        out.writeObject(obj);
        return bout.toByteArray();
    }
}
