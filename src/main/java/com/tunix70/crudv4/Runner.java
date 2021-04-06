package com.tunix70.crudv4;


import com.tunix70.crudv4.model.Region;
import com.tunix70.crudv4.repository.DAO.PostDAOImpl;
import com.tunix70.crudv4.repository.DAO.RegionDAOImpl;
import com.tunix70.crudv4.repository.DAO.WriterDAOImpl;
import com.tunix70.crudv4.view.ConsoleView;

public class Runner {
    public static void main(String[] args) {
        RegionDAOImpl rr = new RegionDAOImpl();
        PostDAOImpl pp = new PostDAOImpl();
        WriterDAOImpl ww = new WriterDAOImpl();

        System.out.println(pp.getAll());
//
//        System.out.println("\n========================\n");

//         System.out.println(rr.getById(1l));
//
//        System.out.println("\n========================\n");
//
//            rr.save(new Region(9l, "new"));
//
//        System.out.println("\n========================\n");
//
//        System.out.println(rr.update(new Region(1l, "one")));
//
//        System.out.println("\n========================\n");
//        rr.deleteById(2l);
//        System.out.println(rr.getAll());
    }
}
