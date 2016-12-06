/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.teameleven.caps.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ahmedraaj
 */
@Entity
@Table(name = "enroled_courses")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "EnroledCourse.findAll", query = "SELECT e FROM EnroledCourse e")
//    , @NamedQuery(name = "EnroledCourse.findByStudentsstudentId", query = "SELECT e FROM EnroledCourse e WHERE e.enroledCoursesPK.studentsstudentId = :studentsstudentId")
//    , @NamedQuery(name = "EnroledCourse.findByCoursescourseId", query = "SELECT e FROM EnroledCourse e WHERE e.enroledCoursesPK.coursescourseId = :coursescourseId")
//    , @NamedQuery(name = "EnroledCourse.findByStartingDate", query = "SELECT e FROM EnroledCourse e WHERE e.startingDate = :startingDate")
//    , @NamedQuery(name = "EnroledCourse.findByEndingDate", query = "SELECT e FROM EnroledCourse e WHERE e.endingDate = :endingDate")
//    , @NamedQuery(name = "EnroledCourse.findByGradePoint", query = "SELECT e FROM EnroledCourse e WHERE e.gradePoint = :gradePoint")
//    , @NamedQuery(name = "EnroledCourse.findByStatus", query = "SELECT e FROM EnroledCourse e WHERE e.status = :status")})
public class EnroledCourse implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EnroledCoursePK enroledCoursePK;
    @Column(name = "startingDate")
    private String startingDate;
    @Column(name = "endingDate")
    private String endingDate;
    @Column(name = "gradePoint")
    private String gradePoint;
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "courses_courseId", referencedColumnName = "courseId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Course courses;
    @JoinColumn(name = "students_studentId", referencedColumnName = "studentId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Student student;

    public EnroledCourse() {
    }

    public EnroledCourse(EnroledCoursePK enroledCoursesPK) {
        this.enroledCoursePK = enroledCoursesPK;
    }

    public EnroledCourse(int studentsstudentId, int coursescourseId) {
        this.enroledCoursePK = new EnroledCoursePK(studentsstudentId, coursescourseId);
    }

    public EnroledCoursePK getEnroledCoursePK() {
        return enroledCoursePK;
    }

    public void setEnroledCoursePK(EnroledCoursePK enroledCoursePK) {
        this.enroledCoursePK = enroledCoursePK;
    }

    public String getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public String getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(String endingDate) {
        this.endingDate = endingDate;
    }

    public String getGradePoint() {
        return gradePoint;
    }

    public void setGradePoint(String gradePoint) {
        this.gradePoint = gradePoint;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Course getCourses() {
        return courses;
    }

    public void setCourses(Course courses) {
        this.courses = courses;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enroledCoursePK != null ? enroledCoursePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnroledCourse)) {
            return false;
        }
        EnroledCourse other = (EnroledCourse) object;
        if ((this.enroledCoursePK == null && other.enroledCoursePK != null) || (this.enroledCoursePK != null && !this.enroledCoursePK.equals(other.enroledCoursePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.capse.entity.EnroledCourses[ enroledCoursesPK=" + enroledCoursePK + " ]";
    }
    
}
