import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.util.Log;

public class ContactViewer {

    private static final String TAG = "ContactViewer";

    /**
     * Views a contact using the lookup key.
     *
     * @param context   The application context.
     * @param lookupKey The lookup key of the contact.
     */
    public static void viewContactByLookupKey(Context context, String lookupKey) {
        if (lookupKey != null) {
            Uri lookupUri = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_LOOKUP_URI, lookupKey);
            Intent intent = new Intent(Intent.ACTION_VIEW, lookupUri);
            context.startActivity(intent);
        } else {
            Log.e(TAG, "Lookup key is null, cannot view contact.");
        }
    }

    /**
     * Retrieves the lookup key for a contact given a specific column and value.
     * Note: This is a general approach and might return multiple or no lookup keys
     * depending on the uniqueness of the column and value. You might need to
     * adjust the query based on the specific column you are using. For unique
     * identifiers like phone number or email, you should use the dedicated
     * lookup URIs provided by ContactsContract.
     *
     * @param context       The application context.
     * @param columnName    The name of the column to search in (e.g., ContactsContract.CommonDataKinds.Phone.NUMBER,
     * ContactsContract.CommonDataKinds.Email.ADDRESS).
     * @param columnValue   The value to search for in the specified column.
     * @return The lookup key of the first matching contact, or null if no match is found.
     */
    public static String getLookupKeyByColumn(Context context, String columnName, String columnValue) {
        String lookupKey = null;
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = ContactsContract.Data.CONTENT_URI;
        String[] projection = new String[]{ContactsContract.Data.LOOKUP_KEY};
        String selection = columnName + " = ?";
        String[] selectionArgs = new String[]{columnValue};

        Cursor cursor = null;
        try {
            cursor = contentResolver.query(uri, projection, selection, selectionArgs, null);
            if (cursor != null && cursor.moveToFirst()) {
                int lookupKeyIndex = cursor.getColumnIndexOrThrow(ContactsContract.Data.LOOKUP_KEY);
                lookupKey = cursor.getString(lookupKeyIndex);
            }
        } catch (Exception e) {
            Log.e(TAG, "Error querying contacts: " + e.getMessage());
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return lookupKey;
    }

    /**
     * Example usage: Viewing a contact by their phone number.
     * For phone numbers, it's more efficient to use PhoneLookup.CONTENT_FILTER_URI.
     *
     * @param context     The application context.
     * @param phoneNumber The phone number to search for.
     */
    public static void viewContactByPhoneNumber(Context context, String phoneNumber) {
        Uri lookupUri = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(phoneNumber));
        String[] projection = {ContactsContract.PhoneLookup.LOOKUP_KEY};
        ContentResolver cr = context.getContentResolver();
        Cursor cursor = null;
        String lookupKey = null;
        try {
            cursor = cr.query(lookupUri, projection, null, null, null);
            if (cursor != null && cursor.moveToFirst()) {
                int lookupKeyIndex = cursor.getColumnIndexOrThrow(ContactsContract.PhoneLookup.LOOKUP_KEY);
                lookupKey = cursor.getString(lookupKeyIndex);
            }
        } catch (Exception e) {
            Log.e(TAG, "Error looking up contact by phone number: " + e.getMessage());
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

        if (lookupKey != null) {
            viewContactByLookupKey(context, lookupKey);
        } else {
            Log.i(TAG, "Contact with phone number " + phoneNumber + " not found.");
        }
    }

    /**
     * Example usage: Viewing a contact by their email address.
     * For email addresses, you can query ContactsContract.CommonDataKinds.Email.CONTENT_URI directly.
     *
     * @param context     The application context.
     * @param emailAddress The email address to search for.
     */
    public static void viewContactByEmail(Context context, String emailAddress) {
        ContentResolver cr = context.getContentResolver();
        Uri uri = ContactsContract.CommonDataKinds.Email.CONTENT_URI;
        String[] projection = new String[]{ContactsContract.CommonDataKinds.Email.LOOKUP_KEY};
        String selection = ContactsContract.CommonDataKinds.Email.ADDRESS + " = ?";
        String[] selectionArgs = new String[]{emailAddress};
        String lookupKey = null;
        Cursor cursor = null;
        try {
            cursor = cr.query(uri, projection, selection, selectionArgs, null);
            if (cursor != null && cursor.moveToFirst()) {
                int lookupKeyIndex = cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Email.LOOKUP_KEY);
                lookupKey = cursor.getString(lookupKeyIndex);
            }
        } catch (Exception e) {
            Log.e(TAG, "Error looking up contact by email: " + e.getMessage());
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

        if (lookupKey != null) {
            viewContactByLookupKey(context, lookupKey);
        } else {
            Log.i(TAG, "Contact with email address " + emailAddress + " not found.");
        }
    }
}
