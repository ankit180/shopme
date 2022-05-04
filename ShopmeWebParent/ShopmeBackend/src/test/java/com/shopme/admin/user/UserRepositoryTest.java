package com.shopme.admin.user;

import com.shopme.entity.User;
import com.shopme.userrepository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {
    @Autowired
    private UserRepository repo;
    @Autowired
    private TestEntityManager entityManager;

//    @Test
//    public void testCreateUserWithOneRole(){
//        Role roleAdmin  = entityManager.find(Role.class, 17);
//        User userNamHm = new User("nam4@gmail.com", "nam2020", "Nam", "Ha");
//        userNamHm.addRole(roleAdmin);
//        User savedUser = repo.save(userNamHm);
//
//        assertThat(savedUser.getId()).isGreaterThan(0);
//    }
//
//    @Test
//    public void testCreateUserWithTwoRole(){
//        User userAnkit = new User("ankitkum@gmail.com", "ankit2020", "ankit", "kumar");
//        Role roleEditor = new Role(19);
//        Role roleAssistant = new Role(21);
//
//        userAnkit.addRole(roleEditor);
//        userAnkit.addRole(roleAssistant);
//
//        User savedUser = repo.save(userAnkit);
//
//        assertThat(savedUser.getId()).isGreaterThan(0);
//    }
//
//    @Test
//    public void ListAllUsers(){
//        List<User> listUsers = (List<User>) repo.findAll();
//        listUsers.forEach(user -> System.out.println(user));
//    }

//    @Test
//    public void testGetUserById(){
//        User userName = repo.findById(1).get();
//        assertThat(userName).isNotNull();
//    }
//
//    @Test
//    public void testUpdateUserDetails(){
//        User userName = repo.findById(1).get();
//        userName.setEnabled(true);
//        userName.setEmail("nam123456@gmail.com");
//
//        repo.save(userName);
//    }
//
//    @Test
//    public void testUpdateUserRoles(){
//        User userName = repo.findById(5).get();
//        Role roleEditor = new Role(19);
//        Role roleSalesPerson = new Role(18);
//
//        userName.getRoles().remove(roleEditor);
//        userName.addRole(roleSalesPerson);
//
//        repo.save(userName);
//    }
//
//
//    @Test
//    public void deleteUser(){
//       repo.deleteById(15);
//    }

//    @Test
//    public void testGetUserByEmail(){
//        String email = "nam1@gmail.com";
//        User user = repo.getUserByEmail(email);
//
//        assertThat(user).isNotNull();
//    }

//    @Test
//    public void testCountById(){
//        Integer id = 100;
//
//        Long countById = repo.countById(id);
//        assertThat(countById).isNotNull().isGreaterThan(0);
//
//    }

//    @Test
//    public void testDisableUser(){
//        Integer id = 19;
//        repo.enableStatus(id, false);
//    }

    @Test
    public void testEnableUser(){
        Integer id = 19;
        repo.enableStatus(id, true);
    }
}
