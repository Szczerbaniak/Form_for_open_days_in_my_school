package pl.szczerbaniak.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.szczerbaniak.model.AdminActions;
import pl.szczerbaniak.model.Admins;
import pl.szczerbaniak.model.Visitors;
import pl.szczerbaniak.service.TableService;

import java.util.List;
import java.util.logging.Logger;

@RestController
@CrossOrigin
@RequestMapping(path = "visitors", produces = "application/json")
public class Controller {

    Logger logger = Logger.getLogger(Controller.class.getName());



    @Autowired
    private TableService tableService;

    @ResponseBody
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/deleteAdmin")
    public List<Visitors> deleteAdmin() {
//        tableService.getAdminByUsername("test");
        tableService.deleteAdmin();
        return tableService.getAllVisitors();
    }

    @ResponseBody
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/getVisitors")
    public List<Visitors> getVisitors() {
//        tableService.getAdminByUsername("test");
        return tableService.getAllVisitors();
    }

    @ResponseBody
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, path = "/addVisitor")
    public Visitors addVisitor(@RequestBody Visitors visitor) {
        tableService.addVisitor(visitor);
        return visitor;
    }

    @ResponseBody
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, path = "/isAdminCorrect")
    public boolean isAdminCorrect(@RequestBody Admins givenAdmin) {
        String adminPassword = givenAdmin.getPassword();

        if (adminPassword.equals(tableService.getAdminPass(givenAdmin.getUsername()))) {
            return true;
        } else {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseBody
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, path = "/addAdmin")
    public AdminActions addAdmin(@RequestBody AdminActions adminData) {
        Admins currentAdmin = adminData.getCurrentAdmin();
        Admins adminToAdd = adminData.getAdminToTakeActionOn();

        if (currentAdmin.getPassword().equals(tableService.getAdminPass(currentAdmin.getUsername()))) {
            try {
                tableService.addAdmin(adminData.getAdminToTakeActionOn());
            } catch (Exception e) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return adminData;
    }

    @ResponseBody
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/getAdmins")
    public List<Admins> getAdmins() {
//        tableService.getAdminByUsername("test");
        return tableService.getAllAdmins();
    }

    @ResponseBody
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/getAdmin")
    public String getAdmin() {
//        tableService.getAdminByUsername("test");
        return tableService.getAdminPass("test");
    }
}
