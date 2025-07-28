int[] original = {1, 2, 3};

// Create a new array with one extra space
int[] newArray = new int[original.length + 1];

// Copy original elements
for (int i = 0; i < original.length; i++) {
    newArray[i] = original[i];
}

// Add new element at the end
newArray[newArray.length - 1] = 4;

// Now newArray contains {1, 2, 3, 4}
