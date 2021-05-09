package se.lexicon.armin.booklender.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.armin.booklender.dto.LoanDto;
import se.lexicon.armin.booklender.entity.Loan;
import se.lexicon.armin.booklender.repository.LoanRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LoanServiceImpl implements LoanService{

    LoanRepository loanRepository;
    ModelMapper modelMapper;

    @Autowired
    public void setLoanRepository(LoanRepository loanRepository){
        this.loanRepository = loanRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    @Override
    public LoanDto findById(long loanId) {
        Optional<Loan> loan = loanRepository.findById(loanId);
        return modelMapper.map(loan.get(), LoanDto.class);
    }

    @Override
    public List<LoanDto> findByBookId(int bookId) {
        return null;
    }

    @Override
    public List<LoanDto> findByUserId(int userId) {
        return null;
    }

    @Override
    public List<LoanDto> findByTerminated() {
        return null;
    }

    @Override
    public List<LoanDto> findAll() {
        return null;
    }

    @Override
    public LoanDto create(LoanDto loanDto) {
        return null;
    }

    @Override
    public LoanDto update(LoanDto loanDto) {
        return null;
    }

    @Override
    public boolean delete(long loanId) {
        return false;
    }
}
