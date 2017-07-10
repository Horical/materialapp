package com.horical.hrc7.lib_base.helper.finder;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
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
        loadView(fragment, container);
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
     * @param viewGroup Viewgroup
     */
    public static View inflateView(ViewGroup viewGroup) {
        Class clazz = viewGroup.getClass();
        MyLayout myLayout = (MyLayout) clazz.getAnnotation(MyLayout.class);
        if (myLayout == null)
            throw new RuntimeException(viewGroup.getClass().getSimpleName() + " not found layout");
        View viewContainer =
                LayoutInflater.from(viewGroup.getContext()).inflate(findIdLayout(viewGroup.getContext(), myLayout), viewGroup, true);
        if (viewContainer == null)
            throw new RuntimeException(viewGroup.getClass().getSimpleName() + " not found layout");
        return viewContainer;
    }

    /**
     * Inflate layout xml to java
     *
     * @param viewGroup Viewgroup
     */
    public static View inflateView(ViewGroup viewGroup,boolean attach) {
        Class clazz = viewGroup.getClass();
        MyLayout myLayout = (MyLayout) clazz.getAnnotation(MyLayout.class);
        if (myLayout == null)
            throw new RuntimeException(viewGroup.getClass().getSimpleName() + " not found layout");
        View viewContainer =
                LayoutInflater.from(viewGroup.getContext()).inflate(findIdLayout(viewGroup.getContext(), myLayout), viewGroup, attach);
        if (viewContainer == null)
            throw new RuntimeException(viewGroup.getClass().getSimpleName() + " not found layout");
        return viewContainer;
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
        dialog.setContentView(findIdLayout(dialog.getContext(), myLayout));
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
        return LayoutInflater.from(fragment.getContext()).inflate(findIdLayout(fragment.getContext(), myLayout), container, false);
    }

    /**
     * Load child view by anotation @ChildView into field defined by view Object
     *
     * @param view Object instance of View, fragment, Dialog, Activity
     */
    public static void loadView(Object view) {
        if (!((view instanceof View)
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
                findAndMapToView(view, view, field, viewChild);
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
        try {
            itemView = clazz.getSuperclass().getSuperclass().getDeclaredField("itemView").get(view);
            if (itemView == null) throw new ClassNotFoundException("Not found item view");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // finding view child
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            ViewChild viewChild = field.getAnnotation(ViewChild.class);
            if (viewChild != null) {
                findAndMapToView(view, itemView, field, viewChild);
            }
        }
    }

    /**
     * Load child view by anotation @ChildView into field defined by view Object
     *
     * @param viewGroup view contain childs view
     * @param container Object instance of View, fragment, Dialog, Activity,... and obj has view container
     */
    public static void loadView(Object container, View viewGroup) {
        Class clazz = container.getClass();

        // finding view child
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            ViewChild viewChild = field.getAnnotation(ViewChild.class);
            if (viewChild != null) {
                findAndMapToView(container, viewGroup, field, viewChild);
            }
        }
    }

    private static void findAndMapToView(Object container, Object viewGroup, Field field, ViewChild viewChild) {
        Class clazz = viewGroup.getClass();
        try {
            Method findViewById = clazz.getMethod("findViewById", int.class);
            Context context = null;
            if (viewGroup instanceof Activity)
                context = (Context) container;
            else
                context = (Context) clazz.getMethod("getContext").invoke(viewGroup);

            View view = null;
            int id = 0;
            if (viewChild.value() != 0) {
                id = viewChild.value();
            } else if (!viewChild.name().equals("")) {
                id = getViewIdByName(context, viewChild.name());
            } else {
                id = getViewIdByName(context, field.getName());
            }
            if (id == 0) throw new ClassNotFoundException("Can't find view");

            view = (View) findViewById.invoke(viewGroup, (id));
            if (view == null) throw new ClassNotFoundException("Can't find view");

            field.setAccessible(true);
            field.set(container, view);
            field.setAccessible(false);

        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static int findIdLayout(Context context, MyLayout myLayout) {
        int id = 0;
        if (myLayout.value() != 0) {
            id = myLayout.value();
        } else if (!myLayout.name().equals("")) {
            id = getLayoutIdByName(context, myLayout.name());
        }

        if (id == 0)
            throw new RuntimeException(" Not found id layout");
        return id;
    }

    public static int getLayoutIdByName(Context context, String name) {
        return context.getResources().getIdentifier(name, "layout", context.getPackageName());
    }

    private static int getViewIdByName(Context context, String name) {
        return context.getResources().getIdentifier(name, "id", context.getPackageName());
    }

}
