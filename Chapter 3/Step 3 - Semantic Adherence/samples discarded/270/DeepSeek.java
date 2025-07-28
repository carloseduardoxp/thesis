public static int countOccurrences(String str, String subStr) {
    int count = 0;
    int index = 0;
    
    while ((index = str.indexOf(subStr, index)) != -1) {
        count++;
        index += subStr.length();
    }
    
    return count;
}
