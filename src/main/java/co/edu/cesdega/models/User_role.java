package co.edu.cesdega.models;

public class User_role {
    private Long userRoleId;
    private User user;
    private Role role;

    // Constructor vacío
    public User_role() {
    }

    // Constructor lleno
    public User_role(Long userRoleId, User user, Role role) {
        this.userRoleId = userRoleId;
        this.user = user;
        this.role = role;
    }

    // Getters y Setters
    public Long getUserRoleId() { return userRoleId; }
    public void setUserRoleId(Long userRoleId) { this.userRoleId = userRoleId; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

    @Override
    public String toString() {
        return "UserRole [userRoleId=" + userRoleId + ", user=" + user.getUsername() + ", role=" + role.getName() + "]";
    }
}
