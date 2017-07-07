package com.horical.hrc7.libsupports;

import android.content.Context;
import android.content.SharedPreferences;

import com.snappydb.DB;
import com.snappydb.DBFactory;
import com.snappydb.SnappyDB;
import com.snappydb.SnappydbException;

import java.io.Serializable;

/**
 * Created by Billy Phan on 6/21/2017.
 */

public class CacheHelper {
    final private String folder;
    final private String file;

    Preference preference;
    Storage storage;

    public CacheHelper(Context context, String folder, String file) {
        this.folder = folder;
        this.file = file;
        preference = new Preference(context);
        storage = new Storage(context);
    }

    public Preference prefer() {
        return preference;
    }

    public Storage store() {
        return storage;
    }

    public class Preference {
        SharedPreferences mShare;
        final Context context;

        private Preference(Context context) {
            this.context = context;
            mShare = context.getSharedPreferences(file, Context.MODE_PRIVATE);
        }

        public void save(String key, Object value) {
            SharedPreferences.Editor editor = mShare.edit();
            if (value instanceof String) {
                editor.putString(key, (String) value);
            } else if (value instanceof Integer) {
                editor.putInt(key, (Integer) value);
            } else if (value instanceof Long) {
                editor.putLong(key, (Integer) value);
            } else if (value instanceof Double || value instanceof Float) {
                editor.putFloat(key, (Float) value);
            } else if (value instanceof Boolean) {
                editor.putBoolean(key, (Boolean) value);
            } else throw new RuntimeException("Value input not support");
            editor.commit();
        }

        public <T> T load(String key, T defaultValue) {
            if (defaultValue instanceof String) {
                return (T) mShare.getString(key, (String) defaultValue);
            } else if (defaultValue instanceof Integer) {
                return (T) Integer.valueOf(mShare.getInt(key, (Integer) defaultValue));
            } else if (defaultValue instanceof Long) {
                return (T) Long.valueOf(mShare.getLong(key, (Long) defaultValue));
            } else if (defaultValue instanceof Double || defaultValue instanceof Float) {
                if (defaultValue instanceof Double)
                    return (T) Double.valueOf(mShare.getFloat(key, (Float) defaultValue));
                else return (T) Float.valueOf(mShare.getFloat(key, (Float) defaultValue));
            } else if (defaultValue instanceof Boolean) {
                return (T) Boolean.valueOf(mShare.getBoolean(key, (Boolean) defaultValue));
            } else {
                throw new RuntimeException("Default value not support");
            }
        }
    }

    public class Storage {

        private final Context context;
        private DB mDb;

        private Storage(Context context) {
            this.context = context;
            try {
                this.mDb = new SnappyDB.Builder(context)
                        .directory(folder) //optional
                        .name(file)//optional
                        .build();
//                this.mDb = DBFactory.open(context, AppConfig.FILE_CACHE);
                this.mDb.close();
            } catch (SnappydbException e) {
                throw new RuntimeException(e);
            }
        }

        public Storage save(String key, Object value) {
            try {
                this.mDb = DBFactory.open(context, file);
                if (mDb.exists(key))
                    mDb.del(key);
                mDb.put(key, value);
                this.mDb.close();
                return this;
            } catch (SnappydbException e) {
                throw new RuntimeException(e);
            }
        }

        public <T> T load(String key, Class<T> clazz) {
            try {
                this.mDb = DBFactory.open(context, file);
                T value = mDb.getObject(key, clazz);
                this.mDb.close();
                return value;
            } catch (SnappydbException e) {
                throw new RuntimeException(e);
            }
        }

        public <T> T[] loadArray(String key, Class<T> clazz) {
            try {
                this.mDb = DBFactory.open(context, file);
                T[] value = mDb.getObjectArray(key, clazz);
                this.mDb.close();
                return value;
            } catch (SnappydbException e) {
                throw new RuntimeException(e);
            }
        }

        public <T extends Serializable> T loadSerialize(String key, Class<T> clazz) {
            try {
                this.mDb = DBFactory.open(context, file);
                T value = mDb.get(key, clazz);
                this.mDb.close();
                return value;
            } catch (SnappydbException e) {
                throw new RuntimeException(e);
            }
        }

        public String[] findKeys(String key) {
            try {
                this.mDb = DBFactory.open(context, file);
                String[] keys = mDb.findKeys(key);
                this.mDb.close();
                return keys;
            } catch (SnappydbException e) {
                throw new RuntimeException(e);
            }
        }

        public String[] findKeys(String key, int limit) {
            try {
                this.mDb = DBFactory.open(context, file);
                String[] keys = mDb.findKeys(key, limit);
                this.mDb.close();
                return keys;
            } catch (SnappydbException e) {
                throw new RuntimeException(e);
            }
        }

        public String[] findKeys(String key, int offset, int limit) {
            try {
                this.mDb = DBFactory.open(context, file);
                String[] keys = mDb.findKeys(key, offset, limit);
                this.mDb.close();
                return keys;
            } catch (SnappydbException e) {
                throw new RuntimeException(e);
            }
        }

        public String[] findKeys(String keyFrom, String keyTo) {
            try {
                this.mDb = DBFactory.open(context, file);
                String[] keys = mDb.findKeysBetween(keyFrom, keyTo);
                this.mDb.close();
                return keys;
            } catch (SnappydbException e) {
                throw new RuntimeException(e);
            }
        }

        public String[] findKeys(String keyFrom, String keyTo, int limit) {
            try {
                this.mDb = DBFactory.open(context, file);
                String[] keys = mDb.findKeysBetween(keyFrom, keyTo, limit);
                this.mDb.close();
                return keys;
            } catch (SnappydbException e) {
                throw new RuntimeException(e);
            }
        }

        public String[] findKeys(String keyFrom, String keyTo, int offset, int limit) {
            try {
                this.mDb = DBFactory.open(context, file);
                String[] keys = mDb.findKeysBetween(keyFrom, keyTo, offset, limit);
                this.mDb.close();
                return keys;
            } catch (SnappydbException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
