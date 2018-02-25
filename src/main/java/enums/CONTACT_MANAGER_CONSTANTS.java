package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CONTACT_MANAGER_CONSTANTS {
    NAME("Contact Name"),
    PHONE("Contact Phone"),
    EMAIL("Contact Email"),
    ADDBTN("Add Contact");

    private final String text;

}
