package com.vamsi.examples.AllExamples.Service;

import com.vamsi.examples.AllExamples.Model.ObjectLock;
import com.vamsi.examples.AllExamples.Repository.LockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LockService {

    @Autowired
    LockRepository lockRepository;
    public void createObjects() {
       List<ObjectLock> list=List.of(new ObjectLock(1,234.4f,"vamsi") , new ObjectLock(2,3899.4f,"Leo"),new ObjectLock(3,9874.5f,"Coolie"));
       lockRepository.saveAll(list);
    }

    public List<ObjectLock> display() {
         return  lockRepository.findAll();
    }
}
