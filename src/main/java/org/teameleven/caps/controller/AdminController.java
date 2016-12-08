/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.teameleven.caps.controller;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.teameleven.caps.model.Course;
import org.teameleven.caps.model.Student;
import org.teameleven.caps.repository.AdminRepository;
import org.teameleven.caps.repository.CourseRepository;
import org.teameleven.caps.repository.LecturerRepository;
import org.teameleven.caps.repository.StudentRepository;
import org.teameleven.caps.services.StudentService;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.teameleven.caps.model.EnroledCourse;
import org.teameleven.caps.model.User;
import org.teameleven.caps.repository.EnroledCourseRepository;

/**
 *
 * @author ahmedraaj
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    StudentRepository studentDao;
    @Autowired
    LecturerRepository lecDao;
    @Autowired
    AdminRepository adminDao;
    @Autowired
    CourseRepository courseDao;
    @Autowired
    EnroledCourseRepository enroledDao;

    @RequestMapping("/Mainpage")
    public ModelAndView AdminMainPage(HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("user");
        ModelAndView v = new ModelAndView("/adminMainPage");
        v.addObject("student", user.getAdmin());
        return v;
    }

    @RequestMapping("/student/list")
    public ModelAndView listAllStudent() {
        ModelAndView v = new ModelAndView("crud/student-list");
        v.addObject("studentList", studentDao.findAll());
        return v;
    }

    @RequestMapping("/student/add")
    public ModelAndView addOrUpdateStudent(@ModelAttribute("student") Student student) {
        studentDao.save(student);
        ModelAndView v = new ModelAndView("crud/student-list");
        v.addObject("studentList", studentDao.findAll());
        return v;
    }

    @RequestMapping("/student/edit")
    public ModelAndView showStudentFormEdit(@RequestParam("studentId") String studentId) {
        Student s = studentDao.findOne(Integer.parseInt(studentId));
        ModelAndView v = new ModelAndView("crud/student-form");
        v.addObject("student", s);
        return v;
    }

    @RequestMapping("/student/new")
    public ModelAndView showStudentFormNew() {
        Student s = new Student();
        User u = new User();
        s.setUser(u);
        ModelAndView v = new ModelAndView("crud/student-form");
        v.addObject("student", s);
        return v;
    }

    @RequestMapping("/student/del")
    public ModelAndView deleteStudent(@RequestParam("studentId") String studentId) {
        studentDao.delete(Integer.parseInt(studentId));
        ModelAndView v = new ModelAndView("crud/student-list");
        v.addObject("studentList", studentDao.findAll());
        return v;
    }

    @RequestMapping("/leclist")
    public ModelAndView listAllLecturers() {
        ModelAndView v = new ModelAndView("crud/lecturer-list");
        v.addObject("lecturerList", lecDao.findAll());
        return v;
    }

    @RequestMapping("/lecform")
    public ModelAndView createOrEditLecturer() {
        ModelAndView v = new ModelAndView("crud/lecturer-form");
        v.addObject("lecturerList", lecDao.findAll());
        return v;
    }

    @RequestMapping("/alist")
    public ModelAndView listAllAdmins() {
        ModelAndView v = new ModelAndView("crud/admin-list");
        return v;
    }

    @RequestMapping("/aform")
    public ModelAndView createOrEditAdmin() {

        ModelAndView v = new ModelAndView("crud/admin-form");
        v.addObject("adminList", adminDao.findAll());
        return v;
    }


    @RequestMapping("/clist")
    public ModelAndView listAllCourses() {
        List<Course> courseList=courseDao.findAll();
        ModelAndView v = new ModelAndView("crud/course-list");
        v.addObject("courseList",courseList);
        return v;
    }

    @RequestMapping(value = "/cform")
    public ModelAndView creatOrEditCourse(int courseId){
        HttpServletRequest request=null;
        ModelAndView v = new ModelAndView("crud/course-form");
        v.addObject("courseDetail",courseDao.findOne(courseId));
        return v;
    }

    @RequestMapping(value="/cupdate")
    public String UpdateCourse(Course course){
        HttpServletResponse response=null;
        return null;

    }



    private ModelAndView getDebug(String Message) {
        ModelAndView m = new ModelAndView("debug");
        m.addObject("message", Message);
        return m;
    }
}
