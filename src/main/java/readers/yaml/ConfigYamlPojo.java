package readers.yaml;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import readers.MyPojo;
import readers.json.ConfigJsonPojo;

import java.util.List;


@Getter
@Setter
@ToString
public class ConfigYamlPojo extends MyPojo {
    private String url;
    private List<ConfigJsonPojo.User> users;

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
