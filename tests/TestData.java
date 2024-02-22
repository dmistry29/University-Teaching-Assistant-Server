package tests;

// (c) Larry Herman, 2024.  You are allowed to use this code yourself, but
// not to provide it to anyone else.

/* Although the project grading policies say not to use this form of import
 * (to use explicit imports instead), we have to use it here, because we
 * don't know what classes you will write in the taPayrollManagerSystem
 * package.
 */
import taPayrollManagerSystem.*;

/* This class contains utility methods that create and return example
 * ARegularCourse objects that the public (and secret) tests can use, to reduce
 * the amount of code needed in different tests to create objects to test
 * the methods with.  You can use these methods in your student tests as
 * well, but don't modify this class, because our version is going to be
 * used on the submit server.  (You can either write your own helper methods
 * in your StudentTests class, and you can add your own classes to the tests
 * package, if you want to use modified versions of these methods.)
 */

public class TestData {

    public static ARegularCourse stat400() {
        ARegularCourse course=
            SomeUniversity.createARegularCourse("STAT", 400, 6);

        course.addGradTA("Wally", "Walrus", 21000.0);
        course.addGradTA("Freddy", "Frog", 18900.0);
        course.addGradTA("Peggy", "Penguin", 19950.0);
        course.addGradTA("Shelly", "Sheep", 19425.0);

        return course;
    }

    public static ARegularCourse engl101() {
        ARegularCourse course=
            SomeUniversity.createARegularCourse("ENGL", 101, 6);

        course.addUGTA("Paul", "Pupil", 15.0);
        course.addUGTA("Steve", "Student", 15.25);
        course.addUGTA("Ursula", "Undergraduate", 16.0);
        course.addUGTA("Junior", "Junior", 15.75);
        course.addUGTA("Sophie", "Sophomore", 16.5);
        course.addUGTA("Frieda", "Freshperson", 15.5);

        return course;
    }

    public static ARegularCourse psyc100() {
        ARegularCourse course=
            SomeUniversity.createARegularCourse("PSYC", 100, 20);

        course.addGradTA("Lizzie", "Lizard", 18900.0);
        course.addUGTA("Paul", "Pupil", 15.0);
        course.addUGTA("Frieda", "Freshperson", 15.5);
        course.addGradTA("Shelly", "Sheep", 19425.0);
        course.addUGTA("Junior", "Junior", 15.75);
        course.addUGTA("Steve", "Student", 15.25);
        course.addGradTA("Penny", "Penguin", 19950.0);
        course.addUGTA("Sophie", "Sophomore", 16.5);
        course.addUGTA("Ursula", "Undergraduate", 16.0);
        course.addGradTA("Wally", "Walrus", 21000.0);

        return course;
    }

    public static ARegularCourse arec365() {
        ARegularCourse course=
            SomeUniversity.createADifferentialCourse("PSYC", 100, 10);

        course.addGradTA("Wally", "Walrus", 21000.0);
        course.addUGTA("Freddy", "Frog", 15.0);
        course.addGradTA("Peggy", "Penguin", 19950.0);
        course.addUGTA("Shelly", "Sheep", 16.0);

        course.holdSomeOfficeHours("Shelly", "Sheep", 6);
        course.holdSomeOfficeHours("Freddy", "Frog", 2);
        course.holdSomeOfficeHours("Wally", "Walrus", 4);
        course.holdSomeOfficeHours("Freddy", "Frog", 5);
        course.holdSomeOfficeHours("Freddy", "Frog", 3);
        course.holdSomeOfficeHours("Peggy", "Penguin", 3);
        course.holdSomeOfficeHours("Wally", "Walrus", 6);
        course.holdSomeOfficeHours("Freddy", "Frog", 2);
        course.holdSomeOfficeHours("Peggy", "Penguin", 3);
        course.holdSomeOfficeHours("Peggy", "Penguin", 5);
        course.holdSomeOfficeHours("Freddy", "Frog", 4);
        course.holdSomeOfficeHours("Peggy", "Penguin", 3);
        course.holdSomeOfficeHours("Shelly", "Sheep", 6);

        return course;
    }

    public static ARegularCourse cmsc132() {
        ARegularCourse course=
            SomeUniversity.createADifferentialCourse("CMSC", 132, 3);

        course.addGradTA("Oscar", "Ostrich", 20475.0);
        course.addUGTA("Zena", "Zebra", 13.25);
        course.addGradTA("Horace", "Horse", 19215.0);

        return course;
    }

    public static ARegularCourse cmsc250() {
        ARegularCourse course=
            SomeUniversity.createADifferentialCourse("CMSC", 250, 4);

        course.addGradTA("Emily", "Emu", 18270.0);
        course.addUGTA("Rhianna", "Rhinoceros", 13.35);
        course.addGradTA("Manuel", "Manatee", 18690.0);
        course.addGradTA("Otto", "Otter", 19320.0);

        course.gradeProjects("Rhianna", "Rhinoceros", 16);
        course.gradeProjects("Emily", "Emu", 10);
        course.gradeProjects("Rhianna", "Rhinoceros", 4);
        course.gradeProjects("Emily", "Emu", 20);
        course.gradeProjects("Emily", "Emu", 14);
        course.gradeProjects("Manuel", "Manatee", 12);
        course.gradeProjects("Manuel", "Manatee", 12);
        course.gradeProjects("Manuel", "Manatee", 6);
        course.gradeProjects("Otto", "Otter", 32);

        return course;
    }

}
