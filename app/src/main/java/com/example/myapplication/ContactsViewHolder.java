package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;

public class ContactsViewHolder {
    public static List<ContactsService> getContacts(Context context) {
        List<ContactsService> contacts = new ArrayList<ContactsService>();

        ContentResolver contentResolver = context.getContentResolver();

        if (contentResolver != null) {
            Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);

            if ((cursor != null ? cursor.getCount() : 0) > 0) {
                while (cursor != null && cursor.moveToNext()) {
                    @SuppressLint("Range")
                    String id = cursor.getString(cursor.getColumnIndex(
                            ContactsContract.Contacts._ID
                    ));

                    @SuppressLint("Range")
                    String name = cursor.getString(cursor.getColumnIndex(
                            ContactsContract.Contacts.DISPLAY_NAME
                    ));

                    ContactsService contact = new ContactsService(Integer.parseInt(id), name);

                    contacts.add(contact);

                }
            }
            if (cursor != null) {
                cursor.close();
            }
        }
        return contacts;
    }
}
