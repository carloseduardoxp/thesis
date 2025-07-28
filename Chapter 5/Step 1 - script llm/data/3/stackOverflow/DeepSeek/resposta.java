public class Teste {

    /**
     * Boolean parameter that may be used with {@link #CONTENT_VCARD_URI}
     * and {@link #CONTENT_MULTI_VCARD_URI} to indicate that the returned
     * vcard should not contain a photo.
     *
     * @hide
     */
    public static final String QUERY_PARAMETER_VCARD_NO_PHOTO = "nophoto";

    public static void main(String[] args) {
        String lookupKey = cursor.getString(
                 cursor.getColumnIndex(ContactsContract.Contacts.LOOKUP_KEY));
        Uri vcardUri = ContactsContract.Contacts.CONTENT_VCARD_URI
             .buildUpon().appendQueryParameter(QUERY_PARAMETER_VCARD_NO_PHOTO, String.valueOf(true))
             .build();
        Uri.withAppendedPath(vcardUri, lookupKey);
    }
}
