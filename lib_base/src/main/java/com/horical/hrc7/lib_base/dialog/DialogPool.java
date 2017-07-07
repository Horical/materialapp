package com.horical.hrc7.lib_base.dialog;

import android.content.Context;


import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


/**
 * Created by Billy Phan on 6/21/2017.
 */

public class DialogPool {
    private static Set<BaseDialog> dialogs;

    public synchronized static BaseDialog with(Context context, Class clazz) {
        if (dialogs == null) dialogs = new HashSet<>();

        Iterator<BaseDialog> iterator = dialogs.iterator();
        while (iterator.hasNext()) {
            BaseDialog dialog = iterator.next();
            if (dialog.getContext() == context) {
                return dialog;
            }
        }

        BaseDialog dialog;
        try {
            dialog = (BaseDialog) clazz.getConstructor(Context.class).newInstance(context);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        dialogs.add(dialog);
        return dialog;
    }
}
