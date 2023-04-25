package readers.json;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import readers.MyPojo;

import java.util.List;


@Getter
@Setter
@ToString
public class ConfigJsonPojo extends MyPojo {

    private String url;
    private List<User> users;

    @Getter
    @Setter
    @ToString
    public static class User{
        private String type;
        private String valid;
        private String username;
        private String password;
    }
}
