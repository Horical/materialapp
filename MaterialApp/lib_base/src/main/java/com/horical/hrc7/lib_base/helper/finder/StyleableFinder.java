package com.horical.hrc7.lib_base.helper.finder;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

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
    public static final byte PREFERENCE = 0x09;
    public static final byte STRING = 0x0a;

    public static void load(View view, AttributeSet attrs) throws IllegalAccessException {
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

                switch (myAttr.type()) {
                    case DIMENSION:
                        f.set(view, typedArray.getDimension(myAttr.attr(), f.getFloat(view)));
                        break;
                    case BOOL:
                        f.set(view, typedArray.getBoolean(myAttr.attr(), f.getBoolean(view)));
                        break;
                    case COLOR:
                        f.set(view, typedArray.getColor(myAttr.attr(), f.getInt(view)));
                        break;
                    case STRING:
                        f.set(view, typedArray.getString(myAttr.attr()));
                        break;
                    case INTERGER:
                        f.set(view, typedArray.getInteger(myAttr.attr(), f.getInt(view)));
                        break;
                    case FLOAT:
                        f.set(view, typedArray.getFloat(myAttr.attr(), f.getFloat(view)));
                        break;
                    case ENUM:
                        throw new RuntimeException("Enum not supported currently");
                    case FLAG:
                        throw new RuntimeException("Flag not supported currently");
                    case FRAGTION:
                        throw new RuntimeException("Fragtion not supported currently");
                    case PREFERENCE:
                        throw new RuntimeException("Fragtion not supported currently");
                }
                f.setAccessible(false);
            }
        }
        typedArray.recycle();
    }

    private static int[] getResourceDeclareStyleableIntArray(Context context, String name) {
        try {
            //use reflection to access the resource class
            Field[] fields2 = Class.forName(context.getPackageName() + ".R$styleable").getFields();

            //browse all fields
            for (Field f : fields2) {
                //pick matching field
                if (f.getName().equals(name)) {
                    //return as int array
                    return (int[]) f.get(null);
                }
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }

        return null;
    }

    private static int getAttr(Context context, String attrName) {
        return context.getResources().getIdentifier(attrName, "attr",
                context.getApplicationContext().getPackageName());
    }
}
