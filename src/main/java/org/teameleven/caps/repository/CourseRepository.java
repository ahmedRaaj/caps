/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.teameleven.caps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.teameleven.caps.model.Course;

/**
 *
 * @author ahmedraaj
 */
public interface CourseRepository extends JpaRepository<Course, Integer> {
    
}
