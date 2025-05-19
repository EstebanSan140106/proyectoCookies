package services;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Arrays;
import java.util.Optional;

public class LoginServiceImplement implements LoginService {

    @Override
    public Optional<String> getUsername(HttpServletRequest req){
        Cookie[] cookies = req.getCookies() != null ? req.getCookies() : new Cookie[0];
        return Arrays.stream(cookies)
                .filter(c-> "username".equals(c.getName()))
                //Covertimos la cookie a String
                .map(Cookie::getValue)
                .findAny();

    }
}
