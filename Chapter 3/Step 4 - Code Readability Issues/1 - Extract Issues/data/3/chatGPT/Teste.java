public class Teste {

    public static void main(String[] args) {
        String[] projection = {ContactsContract.Contacts.LOOKUP_KEY};
        String selection = ContactsContract.CommonDataKinds.Phone.NUMBER + "=?";
        String[] selectionArgs = {phoneNumber};
        
        Cursor cursor = getContentResolver().query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                projection,
                selection,
                selectionArgs,
                null);
        
        String lookupKey = null;
        
        if (cursor != null && cursor.moveToFirst()) {
            lookupKey = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.LOOKUP_KEY));
            cursor.close();
        }

        Uri contactUri = ContactsContract.Contacts.getLookupUri(
        getContentResolver(),
        Uri.parse("content://com.android.contacts/contacts"),
        lookupKey);

        Intent intent = new Intent(Intent.ACTION_VIEW, contactUri);
        startActivity(intent);

        
    }
}