<%@page import="org.teameleven.caps.model.User"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-inverse bg-black sidebar" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle"     data-toggle="collapse" data-target="#bs-sidebar-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Team Eleven CAPS</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-sidebar-navbar-collapse-1">
            <ul class="nav navbar-nav">
               
                <%
                    User u = ((User)request.getSession().getAttribute("user"));
                    String type = u != null ? u.getRole() : null;

//                    session.getAttribute(role);
                    if(type != null && type.equals("student"))
                    {
                %>
                 <li class="active"><a href="../student/Mainpage">Home<span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-home"></span></a></li>
                <li ><a href="../student/profile">Profile<span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-user"></span></a></li>
                <li ><a href="../student/grade">Grades and GPA<span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-list-alt"></span></a></li>
                <li ><a href="../student/view">Courses<span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-book"></span></a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Enrollment Details <span class="caret"></span><span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-tasks"></span></a>
                    <ul class="dropdown-menu forAnimate" role="menu">
                        <li><a href="../student/enroll">Enrolled Courses</a></li>
                        <li><a href="../student/view">Active Courses</a></li>
                    </ul>
                </li>
                <%}
                %>
                <%
                    if(type != null && type.equals("lecturer"))
                    {
                %>
                 <li class="active"><a href="../lecturer/Mainpage">Home<span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-home"></span></a></li>
                <li ><a href="/lecturer/profile">Profile<span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-user"></span></a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Courses Details <span class="caret"></span><span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-folder-open"></span></a>
                    <ul class="dropdown-menu forAnimate" role="menu">
                        <li><a href="../lecturer/viewcourses">Courses Taught</a></li>
                        <li><a href="../lecturer/gradecourse">Grade Course</a></li>
                    </ul>
                </li>
                <li ><a href="../lecturer/viewenrolment">Course Enrollment<span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-list-alt"></span></a></li>
                <li ><a href="../lecturer/viewperformance">Student Performance<span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-book"></span></a></li>

                <%}
                %>
                <%
                    if(type != null && type.equals("admin"))
                    {
                %>
                 <li class="active"><a href="../admin/Mainpage">Home<span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-home"></span></a></li>
                <li ><a href="#">Profile<span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-user"></span></a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Student Management <span class="caret"></span><span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-user"></span></a>
                    <ul class="dropdown-menu forAnimate" role="menu">
                        <li><a href="../admin/student.new">Add Student</a></li>
                        <li><a href="../admin/student.list">Manage the Students</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Lecturer Management <span class="caret"></span><span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-leaf"></span></a>
                    <ul class="dropdown-menu forAnimate" role="menu">
                        <li><a href="../admin/lecturer.new">Add Lecturer</a></li>
                        <li><a href="../admin/lecturer.list">Manage the Lecturer</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Courses Management <span class="caret"></span><span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-tasks"></span></a>
                    <ul class="dropdown-menu forAnimate" role="menu">
                        <li><a href="../admin/course.add">Add Courses</a></li>
                        <li><a href="../admin/course.list">Manage the Courses</a></li>
                    </ul>
                </li>
                <li ><a href="../admin/enroll.show">Manage Enrollment<span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-th-list"></span></a></li>
                <%}
                %>
                <li ><a href="../login/logout">Logout<span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-minus-sign"></span></a></li>

            </ul>
        </div>
    </div>
</nav>


