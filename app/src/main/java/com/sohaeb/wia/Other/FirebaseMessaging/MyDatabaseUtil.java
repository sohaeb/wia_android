package com.sohaeb.wia.Other.FirebaseMessaging;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by may on 2017-07-12.
 */

public class MyDatabaseUtil {


    private static FirebaseDatabase mDatabase;

    public static FirebaseDatabase getDatabase() {
        if (mDatabase == null) {
            mDatabase = FirebaseDatabase.getInstance();
            mDatabase.setPersistenceEnabled(true);
            // ...
        }

        return mDatabase;

    }


}
