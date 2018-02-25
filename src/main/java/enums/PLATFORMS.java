package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PLATFORMS {
    ANDROID("Android"),
    IOS("iOS");

    final public String name;
}
