package entities.nativeApp;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Contact {
    public static final Contact IGOR = new Contact("Igor Vereshov", "+79061111111", "mail@mailserver.io");

    private String name;
    private String phone;
    private String email;
}
