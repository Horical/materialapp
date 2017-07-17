package com.horical.hrc7.lib_base.helper.finder;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

import com.horical.hrc7.lib_base.R;

import java.lang.reflect.Field;

/**
 * Created by HRC7 on 7/6/2017.
 */

public class StyleableFinder {
    public static final byte DIMENSION = 0x01;
    public static final byte BOOL = 0x02;
    public static final byte COLOR = 0x03;
    public static final byte ENUM = 0x04;
    public static final byte FLAG = 0x05;
    public static final byte FLOAT = 0x06;
    public static final byte FRAGTION = 0x07;
    public static final byte INTERGER = 0x08;
    public static final byte REFERENCE = 0x09;
    public static final byte STRING = 0x0a;

    public static void load(View view, AttributeSet attrs) {
        if (attrs == null) return;
        Class clazz = view.getClass();
        int[] declareStyleableArray = getResourceDeclareStyleableIntArray(view.getContext(), clazz.getSimpleName());
        TypedArray typedArray = view.getContext().obtainStyledAttributes(attrs, declareStyleableArray);
        if (typedArray == null) return;

        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            MyAttr myAttr = f.getAnnotation(MyAttr.class);
            if (myAttr != null) {
                f.setAccessible(true);

                int id = getAttr(view.getContext(), declareStyleableArray, myAttr, f);
                try {
                    switch (myAttr.type()) {
                        case DIMENSION:
                            f.set(view, typedArray.getDimension(id, myAttr.defFloat()));
                            break;
                        case BOOL:
                            f.set(view, typedArray.getBoolean(id, myAttr.defBool()));
                            break;
                        case COLOR:
                            f.set(view, typedArray.getColor(id, myAttr.defInt()));
                            break;
                        case STRING:
                            f.set(view, typedArray.getString(id));
                            break;
                        case INTERGER:
                            f.set(view, typedArray.getInteger(id, myAttr.defInt()));
                            break;
                        case FLOAT:
                            f.set(view, typedArray.getFloat(id, myAttr.defFloat()));
                            break;
                        case REFERENCE:
                            f.set(view, typedArray.getResourceId(id, myAttr.defInt()));
                            break;
                        case ENUM:
                            throw new RuntimeException("Enum not supported currently");
                        case FLAG:
                            throw new RuntimeException("Flag not supported currently");
                        case FRAGTION:
                            throw new RuntimeException("Fragtion not supported currently");

                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                f.setAccessible(false);
            }
        }
        typedArray.recycle();
    }

    private static int[] getResourceDeclareStyleableIntArray(Context context, String name) {
        try {
            //use reflection to access the resource class
            Field field = Class.forName(context.getPackageName() + ".R$styleable").getDeclaredField(name);
            if (field != null) return (int[]) field.get(null);
            //browse all fields
//            for (Field f : fields2) {
//                //pick matching field
//                if (f.getName().equals(name)) {
//                    //return as int array
//                    return (int[]) f.get(null);
//                }
//            }
        } catch (Throwable t) {
            t.printStackTrace();
        }

        return null;
    }

    private static int getAttr(Context context, int[] declareStyleableArray, MyAttr myAttr, Field f) {
        int id = -1;
        if (myAttr.id() != -1) {
            id = myAttr.id();
        } else {
            String key = null;

            if (!myAttr.name().equals("")) {
                key = myAttr.name();
            } else {
                key = f.getName();
            }

            int tmp = context.getResources().getIdentifier(key, "attr",
                    context.getPackageName());
            for (int i = 0; i < declareStyleableArray.length; i++) {
                if (tmp == declareStyleableArray[i]) {
                    id = i;
                    break;
                }
            }
        }
        if (id == -1) throw new RuntimeException("Can't found attribute");
        return id;
    }
}
