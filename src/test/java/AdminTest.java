import api.IAdmin;
import api.core.impl.Admin;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AdminTest {
    private IAdmin admin;

    @Before
    public void setup() {
        this.admin = new Admin();
    }


    @Test
    public void testMakeClass2() {
        this.admin.createClass("Test", 2016, "Instructor", 15);
        assertFalse(this.admin.classExists("Test", 2016));
    } // cannot make a class in the past

    @Test
    public void testMakeClass1() {
        this.admin.createClass("Test", 2017, "Instructor", 15);
        assertTrue(this.admin.classExists("Test", 2017));
    } // 2017 works

    @Test
    public void testMakeClass1v1() {
        this.admin.createClass("Test", 2018, "Instructor", 15);
        assertTrue(this.admin.classExists("Test", 2018));
    } // at or past 2017 so it works






    @Test
    public void testMakeClass3() {
        this.admin.createClass("Test", 2016, "Instructor", 0);
        assertFalse(this.admin.classExists("Test", 2016));
    } // cannot have a class capacity of zero (in the past)

    @Test
    public void testMakeClass4() {
        this.admin.createClass("Test", 2017, "Instructor", 0);
        assertFalse(this.admin.classExists("Test", 2017));
    } // cannot have a class capacity of zero (in the present)

    @Test
    public void testMakeClass5() {
        this.admin.createClass("Test", 2018, "Instructor", 0);
        assertFalse(this.admin.classExists("Test", 2018));
    } // cannot have a class capacity of zero (in the future)






    @Test
    public void testMakeClass6() {
        this.admin.createClass("Test", 2015, "Instructor", -1);
        assertFalse(this.admin.classExists("Test", 2015));
    } // cannot have a negative class capacity (in the past)

    @Test
    public void testMakeClass7() {
        this.admin.createClass("Test", 2017, "Instructor", -1);
        assertFalse(this.admin.classExists("Test", 2017));
    } // cannot have a negative class capacity (in the present)

    @Test
    public void testMakeClass8() {
        this.admin.createClass("Test", 2018, "Instructor", -1);
        assertFalse(this.admin.classExists("Test", 2018));
    } // cannot have a negative class capacity (in the future)







    @Test
    public void testMakeClass9() {
        this.admin.createClass("Class", 2015, "Instructor", 15);
        this.admin.createClass("Class1", 2015, "Instructor", 15);
        this.admin.createClass("Class2", 2015, "Instructor", 15);
        String inst1 = this.admin.getClassInstructor("Class", 2015);
        String inst2 = this.admin.getClassInstructor("Class1", 2015);
        String inst3 = this.admin.getClassInstructor("Class2", 2015);
        assertFalse(inst1.equals(inst2) && inst2.equals(inst3));
    } // cannot have instructor assigned to >2 classes in a year (past)

    @Test
    public void testMakeClass10() {
        this.admin.createClass("Class", 2017, "Instructor", 15);
        this.admin.createClass("Class1", 2017, "Instructor", 15);
        this.admin.createClass("Class2", 2017, "Instructor", 15);
        String inst1 = this.admin.getClassInstructor("Class", 2017);
        String inst2 = this.admin.getClassInstructor("Class1", 2017);
        String inst3 = this.admin.getClassInstructor("Class2", 2017);
        assertFalse(inst1.equals(inst2) && inst2.equals(inst3));
    } // cannot have instructor assigned to >2 classes in a year (present)

    @Test
    public void testMakeClass11() {
        this.admin.createClass("Class", 2018, "Instructor", 15);
        this.admin.createClass("Class1", 2018, "Instructor", 15);
        this.admin.createClass("Class2", 2018, "Instructor", 15);
        String inst1 = this.admin.getClassInstructor("Class", 2018);
        String inst2 = this.admin.getClassInstructor("Class1", 2018);
        String inst3 = this.admin.getClassInstructor("Class2", 2018);
        assertFalse(inst1.equals(inst2) && inst2.equals(inst3));
    } // cannot have instructor assigned to >2 classes in a year (future)




    @Test
    public void testMakeClass12() {
        this.admin.createClass("Test", 2015, "Instructor", 10);
        this.admin.createClass("Test", 2015, "Instructor1", 10);
        assertFalse(this.admin.classExists("Test", 2015));
    } // cannot have duplicated classes in the same year (past, different instructor, positive)

    @Test
    public void testMakeClass13() {
        this.admin.createClass("Test", 2015, "Instructor", 10);
        this.admin.createClass("Test", 2015, "Instructor", 10);
        assertFalse(this.admin.classExists("Test", 2015));
    } // cannot have duplicated classes in the same year (past, same instructor, positive)

    @Test
    public void testMakeClass14() {
        this.admin.createClass("Test", 2017, "Instructor", 10);
        this.admin.createClass("Test", 2017, "Instructor1", 10);
        assertFalse(this.admin.classExists("Test", 2017));
    } // cannot have duplicated classes in the same year (present, different instructor, positive)

    @Test
    public void testMakeClass15() {
        this.admin.createClass("Test", 2017, "Instructor", 10);
        this.admin.createClass("Test", 2017, "Instructor", 10);
        assertFalse(this.admin.classExists("Test", 2017));
    } // cannot have duplicated classes in the same year (present, same instructor, positive)

    @Test
    public void testMakeClass16() {
        this.admin.createClass("Test", 2018, "Instructor", 10);
        this.admin.createClass("Test", 2018, "Instructor", 10);
        assertFalse(this.admin.classExists("Test", 2018));
    } // cannot have duplicated classes in the same year (future, different instructor, positive)

    @Test
    public void testMakeClass17() {
        this.admin.createClass("Test", 2018, "Instructor", 10);
        this.admin.createClass("Test", 2018, "Instructor", 10);
        assertFalse(this.admin.classExists("Test", 2018));
    } // cannot have duplicated classes in the same year (future, same instructor, positive)




    @Test
    public void testMakeClass12v1() {
        this.admin.createClass("Test", 2015, "Instructor", 0);
        this.admin.createClass("Test", 2015, "Instructor1", 0);
        assertFalse(this.admin.classExists("Test", 2015));
    } // cannot have duplicated classes in the same year (past, different instructor, 0)

    @Test
    public void testMakeClass13v1() {
        this.admin.createClass("Test", 2015, "Instructor", 0);
        this.admin.createClass("Test", 2015, "Instructor", 0);
        assertFalse(this.admin.classExists("Test", 2015));
    } // cannot have duplicated classes in the same year (past, same instructor, 0)

    @Test
    public void testMakeClass14v1() {
        this.admin.createClass("Test", 2017, "Instructor", 0);
        this.admin.createClass("Test", 2017, "Instructor1", 0);
        assertFalse(this.admin.classExists("Test", 2017));
    } // cannot have duplicated classes in the same year (present, different instructor, 0)

    @Test
    public void testMakeClass15v1() {
        this.admin.createClass("Test", 2017, "Instructor", 0);
        this.admin.createClass("Test", 2017, "Instructor", 0);
        assertFalse(this.admin.classExists("Test", 2017));
    } // cannot have duplicated classes in the same year (present, same instructor, 0)

    @Test
    public void testMakeClass16v1() {
        this.admin.createClass("Test", 2018, "Instructor", 0);
        this.admin.createClass("Test", 2018, "Instructor", 0);
        assertFalse(this.admin.classExists("Test", 2018));
    } // cannot have duplicated classes in the same year (future, different instructor, 0)

    @Test
    public void testMakeClass17v1() {
        this.admin.createClass("Test", 2018, "Instructor", 0);
        this.admin.createClass("Test", 2018, "Instructor", 0);
        assertFalse(this.admin.classExists("Test", 2018));
    } // cannot have duplicated classes in the same year (future, same instructor, 0)












    @Test
    public void testMakeClass12v2() {
        this.admin.createClass("Test", 2015, "Instructor", -1);
        this.admin.createClass("Test", 2015, "Instructor1", -1);
        assertFalse(this.admin.classExists("Test", 2015));
    } // cannot have duplicated classes in the same year (past, different instructor, negative)

    @Test
    public void testMakeClass13v2() {
        this.admin.createClass("Test", 2015, "Instructor", -1);
        this.admin.createClass("Test", 2015, "Instructor", -1);
        assertFalse(this.admin.classExists("Test", 2015));
    } // cannot have duplicated classes in the same year (past, same instructor, negative)

    @Test
    public void testMakeClass14v2() {
        this.admin.createClass("Test", 2017, "Instructor", -1);
        this.admin.createClass("Test", 2017, "Instructor1", -1);
        assertFalse(this.admin.classExists("Test", 2017));
    } // cannot have duplicated classes in the same year (present, different instructor, negative)

    @Test
    public void testMakeClass15v2() {
        this.admin.createClass("Test", 2017, "Instructor", -1);
        this.admin.createClass("Test", 2017, "Instructor", -1);
        assertFalse(this.admin.classExists("Test", 2017));
    } // cannot have duplicated classes in the same year (present, same instructor, negative)

    @Test
    public void testMakeClass16v2() {
        this.admin.createClass("Test", 2018, "Instructor", -1);
        this.admin.createClass("Test", 2018, "Instructor", -1);
        assertFalse(this.admin.classExists("Test", 2018));
    } // cannot have duplicated classes in the same year (future, different instructor, negative)

    @Test
    public void testMakeClass17v2() {
        this.admin.createClass("Test", 2018, "Instructor", -1);
        this.admin.createClass("Test", 2018, "Instructor", -1);
        assertFalse(this.admin.classExists("Test", 2018));
    } // cannot have duplicated classes in the same year (future, same instructor, negative)












    @Test
    public void testMakeClass18() {
        this.admin.createClass("Test", 2018, "Instructor", 10);
        this.admin.createClass("Test", 2019, "Instructor", 10);
        assertTrue(this.admin.classExists("Test", 2018));
        assertTrue(this.admin.classExists("Test", 2019));
    } // this should work because classname/year is unique

    @Test
    public void testMakeClass19() {
        this.admin.createClass("Test", 2019, "Blau", 20);
        int old_cap = this.admin.getClassCapacity("Test", 2019);
        this.admin.changeCapacity("Test", 2019, 19);
        int new_cap = this.admin.getClassCapacity("Test", 2019);
        assertFalse(old_cap <= new_cap);
    } // cannot decrease the capacity of a created class

    @Test
    public void testMakeClass20() {
        this.admin.createClass("Test", 2019, "Blau", 20);
        int old_cap = this.admin.getClassCapacity("Test", 2019);
        this.admin.changeCapacity("Test", 2019, 21);
        int new_cap = this.admin.getClassCapacity("Test", 2019);
        assertTrue(old_cap <= new_cap);
    } // capacity that works

    @Test
    public void testMakeClass21() {
        this.admin.createClass("Test", 2019, "Blau", 20);
        int old_cap = this.admin.getClassCapacity("Test", 2019);
        this.admin.changeCapacity("Test", 2019, 20);
        int new_cap = this.admin.getClassCapacity("Test", 2019);
        assertTrue(old_cap <= new_cap);
    } // capacity that works, though nothing really happened

}
