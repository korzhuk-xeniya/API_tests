package api;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class UpdateUser {
    private String name;
    private String job;

    public UpdateUser(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public UpdateUser() {
    }
}
