package readers.yaml;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import readers.MyPojo;


@Getter
@Setter
@ToString
public class ConfigYamlPojo extends MyPojo {
    private Application application;
    private Users users;

    @Getter
    @Setter
    @ToString
    public static class Application {
        private String url;
    }


    @Getter
    @Setter
    @ToString
    public static class Users {
        private User user1;
        private User user2;
        private User user3;
        private User user4;
        private User user5;
    }

    @Getter
    @Setter
    @ToString
    public static class User {
        private String username;
        private String password;
        private String valid;
    }

}
