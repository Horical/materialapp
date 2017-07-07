package com.horical.hrc7.lib_base.helper.finder;

import android.app.Activity;
import android.app.Dialog;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.horical.hrc7.lib_base.base.BaseActivity;
import com.horical.hrc7.lib_base.base.anotation.MyHandler;
import com.horical.hrc7.lib_base.base.anotation.MyServe;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * Created by quang.pv on 6/9/2017.
 */

public class ViewFinder {
    /**
     * Inflate view from xml layout
     * Find child view and loadView to view group
     *
     * @param view Inflate layout xml into this
     */
    static public View load(ViewGroup view) {
        View container = inflateView(view);
        loadView(view);
        return container;
    }

    /**
     * Inflate view from xml layout
     * Find child view and loadView to dialog
     *
     * @param dialog Inflate layout xml into dialog
     */
    static public void load(Dialog dialog) {
        inflateView(dialog);
        loadView(dialog);
    }

    /**
     * Inflate view from xml layout
     * Find child view and loadView to view group
     *
     * @param activity
     */
    static public void load(BaseActivity activity) {
        loadMPV(activity);
        loadView(activity);
    }

    /**
     * Inflate view from xml layout
     * Find child view and loadView to view group
     *
     * @param fragment
     */
    static public View load(Fragment fragment, ViewGroup viewGroup) {
        View container = inflateView(fragment, viewGroup);
        loadView(fragment,container);
        return container;
    }

    /**
     * Register Handler and Serve
     *
     * @param baseActivity
     */
    private static void loadMPV(BaseActivity baseActivity) {
        Class clazz = baseActivity.getClass();
        MyHandler myHandler = (MyHandler) clazz.getAnnotation(MyHandler.class);
        if (myHandler == null)
            throw new RuntimeException("have not defined anotation MyHandler");

        MyServe myServe = (MyServe) clazz.getAnnotation(MyServe.class);

        if (myServe == null)
            throw new RuntimeException("have not defined anotation MyServe");

        //mapping
        try {

            Object objServe = myServe.value().getConstructor().newInstance();
            Object objHandler = myHandler.value().getConstructor().newInstance();

            Field serveOfObjectHandler = myHandler.value().getSuperclass().getDeclaredField("serve");
            Field viewOfObjectHandler = myHandler.value().getSuperclass().getDeclaredField("view");
            Field handlerOfObjectServe = myServe.value().getSuperclass().getDeclaredField("handler");
            Field handlerOfActivity = clazz.getSuperclass().getDeclaredField("handler");

            serveOfObjectHandler.setAccessible(true);
            viewOfObjectHandler.setAccessible(true);
            handlerOfObjectServe.setAccessible(true);
            handlerOfActivity.setAccessible(true);

            serveOfObjectHandler.set(objHandler, objServe);
            viewOfObjectHandler.set(objHandler, baseActivity);
            handlerOfObjectServe.set(objServe, objHandler);
            handlerOfActivity.set(baseActivity, objHandler);

            serveOfObjectHandler.setAccessible(false);
            viewOfObjectHandler.setAccessible(false);
            handlerOfObjectServe.setAccessible(false);
            handlerOfActivity.setAccessible(false);

        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Inflate layout xml to java
     *
     * @param view Viewgroup
     */
    public static View inflateView(ViewGroup view) {
        Class clazz = view.getClass();
        MyLayout myLayout = (MyLayout) clazz.getAnnotation(MyLayout.class);
        if (myLayout == null)
            throw new RuntimeException(view.getClass().getSimpleName() + " not found layout");
        return LayoutInflater.from(view.getContext()).inflate(myLayout.value(), view, true);
    }

    /**
     * Inflate layout xml to java
     *
     * @param view Viewgroup
     */
    public static View inflateView(ViewGroup view, boolean attachToRoot) {
        Class clazz = view.getClass();
        MyLayout myLayout = (MyLayout) clazz.getAnnotation(MyLayout.class);
        if (myLayout == null)
            throw new RuntimeException(view.getClass().getSimpleName() + " not found layout");
        return LayoutInflater.from(view.getContext()).inflate(myLayout.value(), view, attachToRoot);
    }

    /**
     * Inflate layout xml to java
     *
     * @param dialog Dialog
     */
    public static void inflateView(Dialog dialog) {
        Class clazz = dialog.getClass();
        MyLayout myLayout = (MyLayout) clazz.getAnnotation(MyLayout.class);
        if (myLayout == null)
            throw new RuntimeException(clazz.getSimpleName() + " not found layout");
        dialog.setContentView(myLayout.value());
    }

    /**
     * Inflate layout xml to java
     *
     * @param fragment Fragment
     */
    public static View inflateView(Fragment fragment, ViewGroup container) {
        Class clazz = fragment.getClass();
        MyLayout myLayout = (MyLayout) clazz.getAnnotation(MyLayout.class);
        if (myLayout == null)
            throw new RuntimeException(fragment.getClass().getSimpleName() + " not found layout");
        return LayoutInflater.from(fragment.getContext()).inflate(myLayout.value(), container, false);
    }

    /**
     * Load child view by anotation @ChildView into field defined by view Object
     *
     * @param view Object instance of View, fragment, Dialog, Activity
     */
    public static void loadView(Object view) {
        if (!((view instanceof View)
                || (view instanceof Fragment)
                || (view instanceof Dialog)
                || (view instanceof Activity)
        ))
            throw new RuntimeException(view.getClass().getSimpleName() + " is not support find view");

        Class clazz = view.getClass();
        // finding view child
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            ViewChild viewChild = field.getAnnotation(ViewChild.class);
            if (viewChild != null) {
                try {
                    Method findViewById = clazz.getMethod("findViewById", int.class);
                    View v = (View) findViewById.invoke(view, viewChild.value());
                    if (v == null) throw new RuntimeException("Can't find view");
                    field.setAccessible(true);
                    field.set(view, v);
                    field.setAccessible(false);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (NoSuchMethodException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * Load child view by anotation @ChildView into field defined by view Object
     *
     * @param view Object instance of View, fragment, Dialog, Activity
     */
    public static void loadViewHolder(RecyclerView.ViewHolder view) {
        Class clazz = view.getClass();
        Object itemView = null;
        Method findViewById = null;
        try {
            itemView = clazz.getSuperclass().getSuperclass().getDeclaredField("itemView").get(view);
            findViewById = itemView.getClass().getMethod("findViewById", int.class);

        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        // finding view child
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            ViewChild viewChild = field.getAnnotation(ViewChild.class);
            if (viewChild != null) {
                try {
                    View v = (View) findViewById.invoke(itemView, viewChild.value());
                    if (v == null) throw new RuntimeException("Can't find view");
                    field.setAccessible(true);
                    field.set(view, v);
                    field.setAccessible(false);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * Load child view by anotation @ChildView into field defined by view Object
     *
     * @param viewContainer view contain childs view
     * @param obj           Object instance of View, fragment, Dialog, Activity,... and obj has view container
     */
    public static void loadView(Object obj, View viewContainer) {
        Class clazz = obj.getClass();

        // finding view child
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            ViewChild viewChild = field.getAnnotation(ViewChild.class);
            if (viewChild != null) {
                try {
                    View v = viewContainer.findViewById(viewChild.value());
                    if (v == null) throw new RuntimeException("Can't find view");
                    field.setAccessible(true);
                    field.set(obj, v);
                    field.setAccessible(false);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
