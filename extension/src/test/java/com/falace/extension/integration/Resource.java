package com.falace.extension.integration;

import java.util.ArrayList;
import java.util.List;

class Resource {

    List<String> buffer;


    void open() {
        buffer = new ArrayList<>();
    }

    void close() {
        buffer = null;
    }

    void write(String value) {
        buffer.add(value);
    }

    int size() {
        return buffer.size();
    }

    void clear() {
        buffer.clear();
    }

    boolean isClear() {
        return buffer.isEmpty();
    }

    boolean isOpen() {
        return buffer != null;
    }
}
