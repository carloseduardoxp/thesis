import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;

public class ContactUtils {

    public static void viewContactByLookupKey(Context context, String lookupKey) {
        // Create the lookup Uri using the lookupKey
        Uri contactUri = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_LOOKUP_URI, lookupKey);

        // Create the intent to view the contact
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(contactUri);

        // Start the activity
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }
}
