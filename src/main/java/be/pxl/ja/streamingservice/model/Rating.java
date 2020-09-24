package be.pxl.ja.streamingservice.model;

public enum Rating {
    LITTLE_KIDS(0),
    OLDER_KIDS(7),
    TEENS(12),
    MATURE(16);

    private int age;

    Rating(int age) {
        this.age = age;
    }
}
