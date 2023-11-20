package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.infra.security.TokenJWTData;
import med.voll.api.models.user.AutenticationData;
import med.voll.api.models.user.User;
import med.voll.api.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class AutenticationController {

    @Autowired
    private AuthenticationManager authenticationManager; // do proprio spring

    @Autowired
    private TokenService tokenService;
    @PostMapping
    public ResponseEntity login(@RequestBody @Valid AutenticationData data){
        var authenticationTokentoken = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        Authentication authentication = authenticationManager.authenticate(authenticationTokentoken);

        var tokenJWT = tokenService.generateToken((User) authentication.getPrincipal());

        return  ResponseEntity.ok(new TokenJWTData(tokenJWT));
    }
}
