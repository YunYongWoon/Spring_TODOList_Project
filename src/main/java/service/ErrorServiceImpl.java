package service;

import org.springframework.stereotype.Service;

@Service
public class ErrorServiceImpl implements ErrorService{
    public ErrorServiceImpl(){}

    @Override
    public void makeError() {
        throw new NullPointerException();
    }
}
