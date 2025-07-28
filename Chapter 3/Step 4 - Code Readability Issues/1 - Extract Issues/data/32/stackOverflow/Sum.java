
import java.util.Set;

import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import java.util.List;

public class Sum {

    public String hash(final Set<String> strings) {
        final HashFunction function = Hashing.murmur3_128();

        // Hashing.combineUnordered will throw an exception if input is empty.
        if (strings.isEmpty()) {
            return function.newHasher()
                    .hash()
                    .toString();
        }

        final List<HashCode> stringsHashes = strings.stream()
                .map(string -> function.newHasher()
                .putString(string, Charsets.UTF_8)
                .hash())
                .toList();

        return Hashing.combineUnordered(stringsHashes).toString();
    }

}
