package api;

public class UpdateUserResponse {
    private String updatedAt;
    private String name;
    private String job;

    public UpdateUserResponse(String updatedAt, String name, String job) {
        this.updatedAt = updatedAt;
        this.name = name;
        this.job = job;
    }

    public UpdateUserResponse() {
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getJob() {
        return job;
    }

    public String getName() {
        return name;
    }
}
