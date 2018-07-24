package app.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class UniversityTest {

    private University university;

    @Before
    public void init() {
        this.university = new University();
    }

    @Test
    public void testAverageYearsOfStudentsInUniversity() {
        // Arrange
        Student pesho = Mockito.mock(Student.class);
        Mockito.when(pesho.getAge()).thenReturn(23);
        Student gosho = Mockito.mock(Student.class);
        Mockito.when(gosho.getAge()).thenReturn(33);
        Student sasho = Mockito.mock(Student.class);
        Mockito.when(sasho.getAge()).thenReturn(28);
        this.university.addStudent(pesho);
        this.university.addStudent(gosho);
        this.university.addStudent(sasho);

        // Act
        double actualAverageAge = this.university.getStudentsAverageAge();
        double expectedAverageAge = 84 / 3;

        // Assert
        Assert.assertEquals(expectedAverageAge, actualAverageAge, 0.1);
        Assert.assertEquals(this.university, this.university);
    }


}