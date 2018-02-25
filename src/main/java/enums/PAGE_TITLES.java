package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PAGE_TITLES {
    DOMAINS("IANA — Domain Name Services"),
    RESOURCES("IANA — Number Resources"),
    ASSIGNMENTS("IANA — Protocol Registries");

    private final String name;
}
