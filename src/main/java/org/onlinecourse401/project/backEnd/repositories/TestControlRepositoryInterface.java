package org.onlinecourse401.project.backEnd.repositories;

import org.onlinecourse401.project.backEnd.entity.TestControl;

import java.util.List;
import java.util.Optional;

public interface TestControlRepositoryInterface {
    public TestControl add(TestControl newTest);

    public Optional<TestControl> findById(Integer id);

    public Optional<TestControl> findByTitle(String titleOFTest);


    public List<TestControl> findAll();
}
