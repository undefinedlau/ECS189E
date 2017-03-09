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
import static org.junit.Assert.assertNull;
/**
 * Created by test on 3/6/17.
 */
public class InstructorTest {

    private IInstructor instructor;
    private IAdmin admin;
    private IStudent student;


    @Before
    public void setup() {
        this.instructor = new Instructor();
        this.admin = new Admin();
        this.student = new Student();
    }

    @Test
    public void test1() {
        this.admin.createClass("Test", 2018, "Instructor", 15);
        this.instructor.addHomework("Instructor", "Test",2018, "homework1", "description1");
        assertTrue(this.instructor.homeworkExists("Test", 2018, "homework1"));
    } // can assign hw in future

    @Test
    public void test1v1() {
        this.admin.createClass("Test", 2017, "Instructor", 15);
        this.instructor.addHomework("Instructor", "Test",2017, "homework1", "description1");
        assertTrue(this.instructor.homeworkExists("Test", 2017, "homework1"));
    } // can assign hw in present

    @Test
    public void test1v3() {
        this.admin.createClass("Test", 2017, "Instructor", 15);
        this.instructor.addHomework("Instructor1", "Test",2017, "homework1", "description1");
        assertFalse(this.instructor.homeworkExists("Test", 2017, "homework1"));
    } // cannot work in present - inst. not assigned

    @Test
    public void test2() {
        this.admin.createClass("Test", 2018, "Instructor", 15);
        this.instructor.addHomework("Instructor1", "Test",2018, "homework1", "description1");
        assertFalse(this.instructor.homeworkExists("Test", 2018, "homework1"));
    } // cannot assign hw to a class instructor wasnt assigned (future)

    @Test
    public void test2v1() {
        this.admin.createClass("Test", 2015, "Instructor", 15);
        this.instructor.addHomework("Instructor", "Test",2015, "homework1", "description1");
        assertFalse(this.instructor.homeworkExists("Test", 2015, "homework1"));
    } // cannot assign hw -- past

    @Test
    public void test2v11() {
        this.admin.createClass("Test", 2015, "Instructor", 15);
        this.instructor.addHomework("Instructor1", "Test",2015, "homework1", "description1");
        assertFalse(this.instructor.homeworkExists("Test", 2015, "homework1"));
    } // cannot assign hw -- past and instructor was not assigned

    @Test
    public void test2v2() {
        this.admin.createClass("Test", 2015, "Instructor", 15);
        this.instructor.addHomework("Instructor1", "Test",2015, "homework1", "description1");
        assertFalse(this.instructor.homeworkExists("Test", 2015, "homework1"));
    } // past year and instructor was not assigned




    @Test
    public void test3() {
        this.admin.createClass("Test", 2017, "Instructor", 15);
        this.instructor.assignGrade("Instructor", "Test", 2017, "hw1", "Brian", -1);
        assertNull(this.instructor.getGrade("Test", 2017, "hw1", "Brian"));
    } // cannot assign a negative grade to a class with no hw and student not submitted (present)

    @Test
    public void test4() {
        this.admin.createClass("Test", 2017, "Instructor", 15);
        this.instructor.assignGrade("Instructor", "Test", 2017, "hw1", "Brian", 0);
        assertNull(this.instructor.getGrade("Test", 2017, "hw1", "Brian"));
    } // cannot assign a 0 grade to a class with no hw and student not submitted (present)

    @Test
    public void test5() {
        this.admin.createClass("Test", 2017, "Instructor", 15);
        this.instructor.assignGrade("Instructor", "Test", 2017, "hw1", "Brian", 1);
        assertNull(this.instructor.getGrade("Test", 2017, "hw1", "Brian"));
    } // cannot assign a positive grade to a class with no hw and student not submitted (present)

    @Test
    public void testidkwhereiam() {
        this.admin.createClass("Test", 2017, "Instructor", 15);
        this.instructor.assignGrade("Instructor", "Test", 2017, "hw1", "Brian", 101);
        assertNull(this.instructor.getGrade("Test", 2017, "hw1", "Brian"));
    } // cannot assign a positive grade over 100 to a class with no hw and student not submitted (present)

    @Test
    public void test3v1() {
        this.admin.createClass("Test", 2016, "Instructor", 15);
        this.instructor.assignGrade("Instructor", "Test", 2016, "hw1", "Brian", -1);
        assertNull(this.instructor.getGrade("Test", 2016, "hw1", "Brian"));
    } // cannot assign a negative grade to a class with no hw and student not submitted (past)

    @Test
    public void test4v1() {
        this.admin.createClass("Test", 2016, "Instructor", 15);
        this.instructor.assignGrade("Instructor", "Test", 2016, "hw1", "Brian", 0);
        assertNull(this.instructor.getGrade("Test", 2016, "hw1", "Brian"));;
    } // cannot assign a 0 grade to a class with no hw and student not submitted (past)

    @Test
    public void test4v2() {
        this.admin.createClass("Test", 2016, "Instructor", 15);
        this.instructor.assignGrade("Instructor", "Test", 2016, "hw1", "Brian", 1);
        assertNull(this.instructor.getGrade("Test", 2016, "hw1", "Brian"));;
    } // cannot assign a positive grade to a class with no hw and student not submitted (past)

    @Test
    public void test4v9() {
        this.admin.createClass("Test", 2016, "Instructor", 15);
        this.instructor.assignGrade("Instructor", "Test", 2016, "hw1", "Brian", 101);
        assertNull(this.instructor.getGrade("Test", 2016, "hw1", "Brian"));;
    } // cannot assign a positive grade over 100 to a class with no hw and student not submitted (past)

    @Test
    public void test3v2() {
        this.admin.createClass("Test", 2018, "Instructor", 15);
        this.instructor.assignGrade("Instructor", "Test", 2018, "hw1", "Brian", -1);
        assertNull(this.instructor.getGrade("Test", 2018, "hw1", "Brian"));
    } // cannot assign a negative grade to a class with no hw and student not submitted (future)

    @Test
    public void test4v4() {
        this.admin.createClass("Test", 2018, "Instructor", 15);
        this.instructor.assignGrade("Instructor", "Test", 2018, "hw1", "Brian", 0);
        assertNull(this.instructor.getGrade("Test", 2018, "hw1", "Brian"));
    } // cannot assign a 0 grade to a class with no hw and student not submitted (future)

    @Test
    public void test4v5() {
        this.admin.createClass("Test", 2018, "Instructor", 15);
        this.instructor.assignGrade("Instructor", "Test", 2018, "hw1", "Brian", 1);
        assertNull(this.instructor.getGrade("Test", 2018, "hw1", "Brian"));
    } // cannot assign a positive grade to a class with no hw and student not submitted (future)

    @Test
    public void test4v6() {
        this.admin.createClass("Test", 2018, "Instructor", 15);
        this.instructor.assignGrade("Instructor", "Test", 2018, "hw1", "Brian", 101);
        assertNull(this.instructor.getGrade("Test", 2018, "hw1", "Brian"));
    } // cannot assign a positive grade over 100 to a class with no hw and student not submitted (future)





    @Test
    public void test7() {
        this.admin.createClass("Test", 2017, "Instructor", 15);
        this.instructor.addHomework("Instructor", "Test", 2017, "hw1", "des1");
        this.instructor.assignGrade("Instructor", "Test", 2017, "hw1", "Brian", -1);
        assertNull(this.instructor.getGrade("Test", 2017, "hw1", "Brian"));
    } // cannot assign a negative grade if student did not submit (present)

    @Test
    public void test8() {
        this.admin.createClass("Test", 2017, "Instructor", 15);
        this.instructor.addHomework("Instructor", "Test", 2017, "hw1", "des1");
        this.instructor.assignGrade("Instructor", "Test", 2017, "hw1", "Brian", 0);
        assertNull(this.instructor.getGrade("Test", 2017, "hw1", "Brian"));
    } // cannot assign a 0 grade if student did not submit (present)

    @Test
    public void test9() {
        this.admin.createClass("Test", 2017, "Instructor", 15);
        this.instructor.addHomework("Instructor", "Test", 2017, "hw1", "des1");
        this.instructor.assignGrade("Instructor", "Test", 2017, "hw1", "Brian", 1);
        assertNull(this.instructor.getGrade("Test", 2017, "hw1", "Brian"));
    } // cannot assign a positive grade if student did not submit (present)

    @Test
    public void test9v12() {
        this.admin.createClass("Test", 2017, "Instructor", 15);
        this.instructor.addHomework("Instructor", "Test", 2017, "hw1", "des1");
        this.instructor.assignGrade("Instructor", "Test", 2017, "hw1", "Brian", 101);
        assertNull(this.instructor.getGrade("Test", 2017, "hw1", "Brian"));
    } // cannot assign a positive grade over 100 if student did not submit (present)

    @Test
    public void test7v1() {
        this.admin.createClass("Test", 2014, "Instructor", 15);
        this.instructor.addHomework("Instructor", "Test", 2014, "hw1", "des1");
        this.instructor.assignGrade("Instructor", "Test", 2014, "hw1", "Brian", -1);
        assertNull(this.instructor.getGrade("Test", 2014, "hw1", "Brian"));
    } // cannot assign a negative grade if student did not submit (past)

    @Test
    public void test8v1() {
        this.admin.createClass("Test", 2014, "Instructor", 15);
        this.instructor.addHomework("Instructor", "Test", 2014, "hw1", "des1");
        this.instructor.assignGrade("Instructor", "Test", 2014, "hw1", "Brian", 0);
        assertNull(this.instructor.getGrade("Test", 2014, "hw1", "Brian"));
    } // cannot assign a 0 grade if student did not submit (past)

    @Test
    public void test9v1() {
        this.admin.createClass("Test", 2014, "Instructor", 15);
        this.instructor.addHomework("Instructor", "Test", 2014, "hw1", "des1");
        this.instructor.assignGrade("Instructor", "Test", 2014, "hw1", "Brian", 1);
        assertNull(this.instructor.getGrade("Test", 2014, "hw1", "Brian"));
    } // cannot assign a positive grade if student did not submit (past)

    @Test
    public void test9v10() {
        this.admin.createClass("Test", 2014, "Instructor", 15);
        this.instructor.addHomework("Instructor", "Test", 2014, "hw1", "des1");
        this.instructor.assignGrade("Instructor", "Test", 2014, "hw1", "Brian", 101);
        assertNull(this.instructor.getGrade("Test", 2014, "hw1", "Brian"));
    } // cannot assign a positive grade over 100 if student did not submit (past)

    @Test
    public void test7v2() {
        this.admin.createClass("Test", 2018, "Instructor", 15);
        this.instructor.addHomework("Instructor", "Test", 2018, "hw1", "des1");
        this.instructor.assignGrade("Instructor", "Test", 2018, "hw1", "Brian", -1);
        assertNull(this.instructor.getGrade("Test", 2018, "hw1", "Brian"));
    } // cannot assign a negative grade if student did not submit (future)

    @Test
    public void test8v2() {
        this.admin.createClass("Test", 2018, "Instructor", 15);
        this.instructor.addHomework("Instructor", "Test", 2018, "hw1", "des1");
        this.instructor.assignGrade("Instructor", "Test", 2018, "hw1", "Brian", 0);
        assertNull(this.instructor.getGrade("Test", 2018, "hw1", "Brian"));
    } // cannot assign a 0 grade if student did not submit (future)

    @Test
    public void test9v2() {
        this.admin.createClass("Test", 2018, "Instructor", 15);
        this.instructor.addHomework("Instructor", "Test", 2018, "hw1", "des1");
        this.instructor.assignGrade("Instructor", "Test", 2018, "hw1", "Brian", 1);
        assertNull(this.instructor.getGrade("Test", 2018, "hw1", "Brian"));
    } // cannot assign a positive grade if student did not submit (future)

    @Test
    public void test9v3() {
        this.admin.createClass("Test", 2018, "Instructor", 15);
        this.instructor.addHomework("Instructor", "Test", 2018, "hw1", "des1");
        this.instructor.assignGrade("Instructor", "Test", 2018, "hw1", "Brian", 101);
        assertNull(this.instructor.getGrade("Test", 2018, "hw1", "Brian"));
    } // cannot assign a positive grade over 100 if student did not submit (future)




    @Test
    public void test10(){
        this.admin.createClass("Test", 2017, "Instructor", 15);
        this.instructor.addHomework("Instructor", "Test", 2017, "hw1", "des1");
        this.student.registerForClass("Brian", "Test", 2017);
        this.student.submitHomework("Brian", "hw1", "ans1", "Test", 2017);
        this.instructor.assignGrade("Instructor", "Test", 2017, "hw1", "Brian", -1);
        assertNull(this.instructor.getGrade("Test", 2017, "hw1", "Brian"));
    } // cannot assign a negative grade, student is registered and submitted hw (present)

    @Test
    public void test11(){
        this.admin.createClass("Test", 2017, "Instructor", 15);
        this.instructor.addHomework("Instructor", "Test", 2017, "hw1", "des1");
        this.student.registerForClass("Brian", "Test", 2017);
        this.student.submitHomework("Brian", "hw1", "ans1", "Test", 2017);
        this.instructor.assignGrade("Instructor", "Test", 2017, "hw1", "Brian", 0);
        int grade = this.instructor.getGrade("Test", 2017, "hw1", "Brian");
        assertTrue(grade >= 0);
    } // can assign a zero grade, student is registered, and submitted hw (present)

    @Test
    public void test12(){
        this.admin.createClass("Test", 2017, "Instructor", 15);
        this.instructor.addHomework("Instructor", "Test", 2017, "hw1", "des1");
        this.student.registerForClass("Brian", "Test", 2017);
        this.student.submitHomework("Brian", "hw1", "ans1", "Test", 2017);
        this.instructor.assignGrade("Instructor", "Test", 2017, "hw1", "Brian", 1);
        int grade = this.instructor.getGrade("Test", 2017, "hw1", "Brian");
        assertTrue(grade >= 0);
    } // can assign a positive grade, student is registered, and submitted hw (present)

    @Test
    public void test13(){
        this.admin.createClass("Test", 2017, "Instructor", 15);
        this.instructor.addHomework("Instructor", "Test", 2017, "hw1", "des1");
        this.student.registerForClass("Brian", "Test", 2017);
        this.student.submitHomework("Brian", "hw1", "ans1", "Test", 2017);
        this.instructor.assignGrade("Instructor", "Test", 2017, "hw1", "Brian", 101);
        int grade = this.instructor.getGrade("Test", 2017, "hw1", "Brian");
        assertTrue(grade >= 0);
    } // can assign a grade over 100, student is registered, and submitted hw (present)


    @Test
    public void test14() {
        this.admin.createClass("Test", 2016, "Instructor", 0);
        this.instructor.addHomework("Instructor", "Test", 2016, "hw1", "des1");
        this.student.submitHomework("Brian", "hw1", "ans1", "Test", 2016);
        this.instructor.assignGrade("Instructor", "Test", 2016, "hw1", "Brian", 101);
        int grade = this.instructor.getGrade("Test", 2016, "hw1", "Brian");
        assertFalse(grade >= 0);
    } // cannot assign grade over 100 to class with capacity 0, student not registered (past)

    @Test
    public void test15() {
        this.admin.createClass("Test", 2017, "Instructor", 0);
        this.instructor.addHomework("Instructor", "Test", 2017, "hw1", "des1");
        this.student.submitHomework("Brian", "hw1", "ans1", "Test", 2017);
        this.instructor.assignGrade("Instructor", "Test", 2017, "hw1", "Brian", 101);
        int grade = this.instructor.getGrade("Test", 2017, "hw1", "Brian");
        assertFalse(grade >= 0);
    } // cannot assign grade over 100 to class with capacity 0, student not registered (present)

    @Test
    public void test16() {
        this.admin.createClass("Test", 2018, "Instructor", 0);
        this.instructor.addHomework("Instructor", "Test", 2018, "hw1", "des1");
        this.student.submitHomework("Brian", "hw1", "ans1", "Test", 2018);
        this.instructor.assignGrade("Instructor", "Test", 2018, "hw1", "Brian", 101);
        int grade = this.instructor.getGrade("Test", 2018, "hw1", "Brian");
        assertFalse(grade >= 0);
    } // cannot assign grade over 100 to class with capacity 0, student not registered (future)

    @Test
    public void test17() {
        this.admin.createClass("Test", 2016, "Instructor", -1);
        this.instructor.addHomework("Instructor", "Test", 2016, "hw1", "des1");
        this.student.submitHomework("Brian", "hw1", "ans1", "Test", 2016);
        this.instructor.assignGrade("Instructor", "Test", 2016, "hw1", "Brian", -1);
        int grade = this.instructor.getGrade("Test", 2016, "hw1", "Brian");
        assertFalse(grade >= 0);
    } // cannot assign negative grade to class with negative capacity, student not registered (past)

    @Test
    public void test18() {
        this.admin.createClass("Test", 2017, "Instructor", -1);
        this.instructor.addHomework("Instructor", "Test", 2017, "hw1", "des1");
        this.student.submitHomework("Brian", "hw1", "ans1", "Test", 2017);
        this.instructor.assignGrade("Instructor", "Test", 2017, "hw1", "Brian", -1);
        int grade = this.instructor.getGrade("Test", 2017, "hw1", "Brian");
        assertFalse(grade >= 0);
    } // cannot assign negative grade to class with negative capacity, student not registered (present)

    @Test
    public void test19() {
        this.admin.createClass("Test", 2018, "Instructor", -1);
        this.instructor.addHomework("Instructor", "Test", 2018, "hw1", "des1");
        this.student.submitHomework("Brian", "hw1", "ans1", "Test", 2018);
        this.instructor.assignGrade("Instructor", "Test", 2018, "hw1", "Brian", -1);
        int grade = this.instructor.getGrade("Test", 2018, "hw1", "Brian");
        assertFalse(grade >= 0);
    } // cannot assign negative grade to class with negative capacity, student not registered (future)



}

