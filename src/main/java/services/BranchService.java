package services;

import models.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IBranchRepo;

import java.util.Optional;

@Service
public class BranchService implements IBranchService {
    @Autowired
    private IBranchRepo branchRepo;

    @Override
    public Iterable<Branch> findAll() {
        return branchRepo.findAll();
    }

    @Override
    public Optional<Branch> findById(Integer id) {
        return branchRepo.findById(id);
    }

    @Override
    public void save(Branch branch) {
        branchRepo.save(branch);
    }

    @Override
    public void delete(Integer id) {
        branchRepo.deleteById(id);
    }
}
