class PrivateAccess {
    static class InnerOne {
        private int value;
    }

    static class InnerTwo {
        int getOne ( InnerOne other ) {
            return other.value;
        }
    }
}
