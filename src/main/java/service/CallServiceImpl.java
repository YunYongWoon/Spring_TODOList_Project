package service;

import org.springframework.stereotype.Service;

@Service
public class CallServiceImpl implements CallService{
    @Override
    public void CheckCall() {
        System.out.println("CallCheck 실행됨");
    }
}
