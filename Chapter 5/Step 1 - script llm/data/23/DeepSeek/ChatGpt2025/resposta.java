class Box<T> {
    private T content;

    public void setContent(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    public static void main(String[] args) {
        // Usage:
        Box<String> stringBox = new Box<>();
        stringBox.setContent("Hello");
        stringBox.getContent();  // No casting needed
    }
}