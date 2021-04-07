package com.tunix70.crudv4;


import com.tunix70.crudv4.model.Post;
import com.tunix70.crudv4.model.PostStatus;
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

        System.out.println(ww.getAll());
//
//        System.out.println("\n========================\n");

//         System.out.println(pp.getById(1l));
//
//        System.out.println("\n========================\n");
//
//            pp.save(new Post(null, "textadd", 63335l, 366644l, PostStatus.ACTIVE));
//
//        System.out.println("\n========================\n");
//
//        System.out.println(pp.update(new Post(1l, "textupdate", 63335l, 366644l, PostStatus.ACTIVE)));
//
//        System.out.println("\n========================\n");
//        pp.deleteById(4l);
//        System.out.println(rr.getAll());
    }
}
