package com.senac.influenceconnect.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.influenceconnect.models.Adm;
import com.senac.influenceconnect.models.Role;
import com.senac.influenceconnect.models.User;
import com.senac.influenceconnect.repositories.AdmRepository;
import com.senac.influenceconnect.repositories.RoleRepository;
import com.senac.influenceconnect.utils.Bcrypt;

@Service
public class AdmService {
	
	@Autowired
	private AdmRepository admRepository;
	@Autowired 
	private RoleRepository roleRepository;
	@Autowired
    private Bcrypt bcrypt;
	
	public boolean setDefaultAdms() {
		List<Adm> adms = admRepository.findAll();
        if(adms.isEmpty()) {
        	Role role = roleRepository.getReferenceById((long) 1);
        	User u = new User(role, "adm", "adm@adm.com", "12345678Aa!"); //Dúvida do Rafael: é pra chapar mesmo isso aqui? Não seria melhor via banco como eu estava sugerindo? De qualquer forma sigo com o Bcrypt da forma em que estão as coisas.
        	// Codifica a senha do usuário com Bcrypt antes de salvar
            String hashedPassword = bcrypt.hashPassword(u.getPassword());
            u.setPassword(hashedPassword);
            Adm adm = new Adm(null, u);
            admRepository.save(adm);
            return true;
        }
        return false;
	}
}
