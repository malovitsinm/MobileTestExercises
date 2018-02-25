package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BROWSERS {
    CHROME("Chrome"),
    SAFARI("Safari");

    final private String name;
}
