package pl.szczerbaniak.model;

public class AdminActions {
    private Admins currentAdmin;
    private Admins adminToTakeActionOn;

    public AdminActions() {
    }

    public AdminActions(Admins currentAdmin, Admins adminToTakeActionOn) {
        this.currentAdmin = currentAdmin;
        this.adminToTakeActionOn = adminToTakeActionOn;
    }

    public Admins getCurrentAdmin() {
        return currentAdmin;
    }

    public void setCurrentAdmin(Admins currentAdmin) {
        this.currentAdmin = currentAdmin;
    }

    public Admins getAdminToTakeActionOn() {
        return adminToTakeActionOn;
    }

    public void setAdminToTakeActionOn(Admins adminToTakeActionOn) {
        this.adminToTakeActionOn = adminToTakeActionOn;
    }
}
