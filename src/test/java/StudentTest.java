import api.IAdmin;
import api.IInstructor;
import api.IStudent;
import api.core.impl.Admin;
import api.core.impl.Instructor;
import api.core.impl.Student;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
/**
 * Created by test on 3/6/17.
 */
public class StudentTest {

    private IStudent student;
    //private IStudent student2;
    private IAdmin admin;
    private IInstructor instructor;

    @Before
    public void setup() {
        this.student = new Student();
        //this.student2 = new Student();
        this.admin = new Admin();
        this.instructor = new Instructor();
    }

    @Test
    public void test1() {
        this.student.registerForClass("Brian", "ECS189E", 2018);
        assertFalse(this.student.isRegisteredFor("Brian","ECS189E", 2018));
    } // cannot register for a class that has not been created (future)

    @Test
    public void test1v1() {
        this.student.registerForClass("Brian", "ECS189E", 2017);
        assertFalse(this.student.isRegisteredFor("Brian","ECS189E", 2017));
    } // cannot register for a class that has not been created (present)

    @Test
    public void test1v2() {
        this.student.registerForClass("Brian", "ECS189E", 2016);
        assertFalse(this.student.isRegisteredFor("Brian","ECS189E", 2016));
    } // cannot register for a class that has not been created (past)

    @Test
    public void test2() {
        this.admin.createClass("ECS189E", 2018, "Instructor", 1);
        this.student.registerForClass("Brian", "ECS189E", 2018);
        assertTrue(this.student.isRegisteredFor("Brian", "ECS189E", 2018));
    } // registering for a class that has been created and is not full

    @Test
    public void test3() {
        this.admin.createClass("ECS189E", 2017, "Instructor", 1);
        this.student.registerForClass("Brian", "ECS189E", 2017);
        this.student.registerForClass("Lau", "ECS189E", 2017);
        assertFalse(this.student.isRegisteredFor("Lau", "ECS189E", 2017));
    } // cannot register for a full class (present)

    @Test
    public void test3v1() {
        this.admin.createClass("ECS189E", 2018, "Instructor", 1);
        this.student.registerForClass("Brian", "ECS189E", 2018);
        this.student.registerForClass("Lau", "ECS189E", 2018);
        assertFalse(this.student.isRegisteredFor("Lau", "ECS189E", 2018));
    } // cannot register for a full class (future)

    @Test
    public void test3v2() {
        this.admin.createClass("ECS189E", 2016, "Instructor", 1);
        this.student.registerForClass("Brian", "ECS189E", 2016);
        this.student.registerForClass("Lau", "ECS189E", 2016);
        assertFalse(this.student.isRegisteredFor("Lau", "ECS189E", 2016));
    } // cannot register for a full class (past)




    @Test
    public void test4() {
        this.admin.createClass("ECS189E", 2017, "Instructor", 1000000000);
        this.student.registerForClass("Brian", "ECS189E", 2017);
        assertTrue(this.student.isRegisteredFor("Brian", "ECS189E", 2017));
        this.student.dropClass("Brian", "ECS189E", 2017);
        assertFalse(this.student.isRegisteredFor("Brian", "ECS189E", 2017));
    } // successful drop of class: student is registered and class has not ended -- should work

    @Test
    public void test4v1() {
        this.admin.createClass("ECS189E", 2018, "Instructor", 1000000000);
        this.student.registerForClass("Brian", "ECS189E", 2018);
        assertTrue(this.student.isRegisteredFor("Brian", "ECS189E", 2018));
        this.student.dropClass("Brian", "ECS189E", 2018);
        assertFalse(this.student.isRegisteredFor("Brian", "ECS189E", 2018));
    } // successful drop of class: student is registered and class has not ended -- should work

    @Test
    public void test5() {
        this.admin.createClass("ECS189E", 2017, "Instructor", 1000000000);
        assertFalse(this.student.isRegisteredFor("Brian", "ECS189E", 2017));
        this.student.dropClass("Brian", "ECS189E", 2017);
        assertFalse(this.student.isRegisteredFor("Brian", "ECS189E", 2017));
    } // unsuccessful drop of class: student is not registered for class

    @Test
    public void test5v1() {
        this.admin.createClass("ECS189E", 2016, "Instructor", 1000000000);
        assertFalse(this.student.isRegisteredFor("Brian", "ECS189E", 2016));
        this.student.dropClass("Brian", "ECS189E", 2016);
        assertFalse(this.student.isRegisteredFor("Brian", "ECS189E", 2016));
    } // unsuccessful drop of class: student is not registered for class, cannot drop ended class








    @Test
    public void test6() {
        this.admin.createClass("ECS189E", 2017, "Instructor", 10000000);
        this.student.registerForClass("Brian", "ECS189E", 2017);
        this.instructor.addHomework("Instructor", "ECS189E", 2017, "hw1", "description1");
        this.student.submitHomework("Brian", "hw1", "answer1", "ECS189E", 2017);
        assertTrue(this.student.hasSubmitted("Brian", "hw1","ECS189E", 2017));
    } // successful hw submission - hw exists, student registered, class in current year -- should work





    @Test
    public void test7() {
        this.admin.createClass("ECS189E", 2017, "Instructor", 1000000000);
        this.student.registerForClass("Brian", "ECS189E", 2017);
        this.student.submitHomework("Brian", "hw1", "answer1", "ECS189E", 2017);
        assertFalse(this.student.hasSubmitted("Brian", "hw1","ECS189E", 2017));
    } // unsuccessful hw submission - hw does not exist, present

    @Test
    public void test7v1() {
        this.admin.createClass("ECS189E", 2016, "Instructor", 1000000000);
        this.student.registerForClass("Brian", "ECS189E", 2016);
        this.student.submitHomework("Brian", "hw1", "answer1", "ECS189E", 2016);
        assertFalse(this.student.hasSubmitted("Brian", "hw1","ECS189E", 2016));
    } // unsuccessful hw submission - hw does not exist, not in current year, past

    @Test
    public void test7v2() {
        this.admin.createClass("ECS189E", 2018, "Instructor", 1000000000);
        this.student.registerForClass("Brian", "ECS189E", 2018);
        this.student.submitHomework("Brian", "hw1", "answer1", "ECS189E", 2018);
        assertFalse(this.student.hasSubmitted("Brian", "hw1","ECS189E", 2018));
    } // unsuccessful hw submission - hw does not exist, not in current year, future






    @Test
    public void test8() {
        this.admin.createClass("ECS189E", 2017, "Instructor", 1000000000);
        this.instructor.addHomework("Instructor", "ECS189E", 2017, "hw1", "des1");
        this.student.submitHomework("Brian", "hw1", "answer1", "ECS189E", 2017);
        assertFalse(this.student.hasSubmitted("Brian", "hw1","ECS189E", 2017));
    } // unsuccessful hw submission - student is not registered (present)

    @Test
    public void test8v1() {
        this.admin.createClass("ECS189E", 2016, "Instructor", 1000000000);
        this.instructor.addHomework("Instructor", "ECS189E", 2016, "hw1", "des1");
        this.student.submitHomework("Brian", "hw1", "answer1", "ECS189E", 2016);
        assertFalse(this.student.hasSubmitted("Brian", "hw1","ECS189E", 2016));
    } // unsuccessful hw submission - student is not registered (past)

    @Test
    public void test8v2() {
        this.admin.createClass("ECS189E", 2018, "Instructor", 1000000000);
        this.instructor.addHomework("Instructor", "ECS189E", 2018, "hw1", "des1");
        this.student.submitHomework("Brian", "hw1", "answer1", "ECS189E", 2018);
        assertFalse(this.student.hasSubmitted("Brian", "hw1","ECS189E", 2018));
    } // unsuccessful hw submission - student is not registered (future)










    @Test
    public void test9() {
        this.admin.createClass("ECS189E", 2018, "Instructor", 1000000000);
        this.student.registerForClass("Brian", "ECS189E", 2018);
        this.instructor.addHomework("Instructor", "ECS189E", 2018, "hw1", "description1");
        this.student.submitHomework("Brian", "hw1", "answer1", "ECS189E", 2018);
        assertFalse(this.student.hasSubmitted("Brian", "hw1","ECS189E", 2018));
    } // unsuccessful hw submission - hw can only be submitted in class of current year (future)

    @Test
    public void test10() {
        this.admin.createClass("ECS189E", 2016, "Instructor", 1000000000);
        this.student.registerForClass("Brian", "ECS189E", 2016);
        this.instructor.addHomework("Instructor", "ECS189E", 2016, "hw1", "description1");
        this.student.submitHomework("Brian", "hw1", "answer1", "ECS189E", 2016);
        assertFalse(this.student.hasSubmitted("Brian", "hw1","ECS189E", 2016));
    } // unsuccessful hw submission - hw can only be submitted in class of current year (past)

}
