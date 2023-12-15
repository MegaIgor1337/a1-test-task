package a1.test.task.task3.service;

import a1.test.task.task3.entity.Login;
import a1.test.task.task3.entity.Posting;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizationService {
    public List<Posting> authorizeDeliveries(List<Login> logins, List<Posting> postings) {
        return postings.stream()
                .peek(posting -> {
                    boolean isAuthorized = logins.stream()
                            .anyMatch(login -> login.getAppAccountName()
                                                       .equals(posting.getUsername()) && login.isActive());
                    posting.setAuthorizedDelivery(isAuthorized);
                })
                .toList();
    }
}
