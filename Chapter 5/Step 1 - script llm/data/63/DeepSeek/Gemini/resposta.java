public class DeepSeek {

    public static Object[] removeElement(Object[] originalArray, int indexToRemove) {
        if (originalArray == null || indexToRemove < 0 || indexToRemove >= originalArray.length) {
            return originalArray;
        }

        Object[] newArray = new Object[originalArray.length - 1];

        int newArrayIndex = 0;
        for (int i = 0; i < originalArray.length; i++) {
            if (i != indexToRemove) {
                newArray[newArrayIndex] = originalArray[i];
                newArrayIndex++;
            }
        }

        return newArray;
    }

}
