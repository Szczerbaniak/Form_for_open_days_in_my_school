package pl.szczerbaniak.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.szczerbaniak.model.Visitors;
import pl.szczerbaniak.service.TableService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "visitors", produces = "application/json")
public class Controller {

    @Autowired
    private TableService tableService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "/getVisitors")
    public List<Visitors> getVisitors() {
//        tableService.getAdminByUsername("test");
        return tableService.getAllVisitors();
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, path = "/addVisitor")
    public Visitors addVisitor(@RequestBody Visitors visitor) {
        tableService.addVisitor(visitor);
        return visitor;
    }
}
