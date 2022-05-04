package com.shopme.admin.user;


import com.shopme.entity.Role;
import com.shopme.userrepository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class RoleRepositoryTests {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void testCreateFirstRole(){
        Role roleAdmin = new Role("Admin", "manage everything");
        Role savedRole = roleRepository.save(roleAdmin);

        assertThat(savedRole.getId()).isGreaterThan(0);
    }

    @Test
    public void createRestRoles(){
        Role roleSalesPerson = new Role("Salesperson", "manage product price, customers, shipping, " +
                " shipping orders and sales reports");

        Role roleEditor = new Role("Editor", "manage categories, brands, products, articles, " +
                " menus");

        Role roleShipper = new Role("Shipper", "view products, view orders, " +
                " and update order status");

        Role roleAssistant = new Role("Assistant","manage question and reviews");
        
        roleRepository.saveAll(Arrays.asList(roleSalesPerson, roleEditor, roleShipper, roleAssistant));
    }

}
