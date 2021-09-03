package ru.job4j.collection;

import org.junit.Test;
import ru.job4j.collection.comparators.JobAscByName;
import ru.job4j.collection.comparators.JobAscByPriority;
import ru.job4j.collection.comparators.JobDescByName;
import ru.job4j.collection.comparators.JobDescByPriority;

import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {

    Job job1 = new Job("Fix bug", 0);
    Job job2 = new Job("Fix bug", 1);
    Comparator<Job> comparator;

    @Test
    public void byNameAndDescPriority() {
        comparator = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = comparator.compare(job1, job2);
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void byNameAndPriority() {
        comparator = new JobAscByPriority().thenComparing(new JobAscByName());
        int rsl = comparator.compare(job1, new Job("Fix bug a1", 0));
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void ascByName() {
        comparator = new JobAscByName();
        int rsl = comparator.compare(job1, job2);
        assertThat(rsl, is(0));
    }

    @Test
    public void descByName() {
        comparator = new JobDescByName();
        int rsl = comparator.compare(job1, job2);
        assertThat(rsl, is(0));
    }

    @Test
    public void ascByPriority() {
        comparator = new JobAscByPriority();
        int rsl = comparator.compare(job1, job2);
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void descByPriority() {
        comparator = new JobDescByPriority();
        int rsl = comparator.compare(job1, job2);
        assertThat(rsl, greaterThan(0));
    }
}