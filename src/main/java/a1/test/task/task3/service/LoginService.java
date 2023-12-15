package a1.test.task.task3.service;

import a1.test.task.task3.entity.Login;
import a1.test.task.task3.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final LoginRepository loginRepository;
    public void saveLogins(List<Login> logins) {
        loginRepository.saveAll(logins);
    }
}
