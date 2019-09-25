package com.example.foryoudicodingconsummer.interfaces;

import android.database.Cursor;

public interface LoadNotesCallback {
    void postExecute(Cursor notes);
}
