package com.falace.extension.integration;

import java.util.ArrayList;
import java.util.List;

public class Resource {

    List<String> buffer;


    public void open(){
        buffer = new ArrayList<>();
    }

    public void close(){
        buffer = null;
    }

    public void write(String value){
        buffer.add(value);
    }

    public int size(){
        return buffer.size();
    }

    public void clear(){
        buffer.clear();
    }

    public boolean isClear(){
        return buffer.isEmpty();
    }

    public boolean isOpen(){
        return buffer != null;
    }
}
