package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CONTACT_MANAGER_CONSTATNS {
    NAME("Contact Name"),
    PHONE("Contact Phone"),
    EMAIL("Contact Email");

    private final String text;

}
