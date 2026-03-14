package co.edu.cesdega.models;

import java.util.Date;

public class User {
    private Long userId;
    private String username;
    private String email;
    private String passwordHash;
    private Boolean status;
    private Date createdAt;

    //constructor vacio
    public User(){
    }

    //constructor lleno
    public User(Long userId, String username, String email, String passwordHash, Boolean status, Date createdAt) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }

    public Boolean getStatus() { return status; }
    public void setStatus(Boolean status) { this.status = status; }

    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    @Override
    public String toString() {
        return "userId=" + userId +
                " username=" + username +
                " email=" + email +
                " passwordHash=" + passwordHash +
                " status=" + status +
                " createdAt=" + createdAt;
    }
}
