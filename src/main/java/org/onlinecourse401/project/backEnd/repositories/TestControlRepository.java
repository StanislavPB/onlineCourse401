package org.onlinecourse401.project.backEnd.repositories;

import org.onlinecourse401.project.backEnd.entity.TestControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestControlRepository implements TestControlRepositoryInterface {

    private Integer testControlID = 0;
    private List<TestControl> testControls;

    public TestControlRepository() {
        this.testControls = new ArrayList<>();
    }

    @Override
    public TestControl add(TestControl newTestControl) {
        newTestControl.setTestControlID(++testControlID);
        testControls.add(newTestControl);
        return newTestControl;
    }


    @Override
    public Optional<TestControl> findById(Integer id) {                   //find by index
        for(TestControl testControl : testControls){
           if (testControl.getTestControlID().equals(id))
           {
                return Optional.of(testControl);
            }
        }

        return Optional.empty();
    }

    public Optional<TestControl> findByTitle(String titleOFTest) {             //find by title
        for(TestControl testControl : testControls){
            if (testControl.getTitle().equals(titleOFTest))
            {
                return Optional.of(testControl);
            }
        }

        return Optional.empty();
    }


    @Override
    public List<TestControl> findAll() {
        return testControls;
    }
}
