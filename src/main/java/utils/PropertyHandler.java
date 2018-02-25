package utils;

import lombok.SneakyThrows;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyHandler {
    @SneakyThrows
    public static Properties assembleProperties(String path){
        Properties props = new Properties();
        File src  = new File(path);
        try(FileInputStream inputStream = new FileInputStream(src)){
            props.load(inputStream);
        }
        return props;
    }
}
