package com.emart.user.dao;

import com.emart.user.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao  extends JpaRepository<User, Long> {
    
  @Query(value="select count(*) from t_buyer as t where t.email = ?1 and t.password = ?2",nativeQuery=true)
  public int findBuyer(String mail,String password);
        
  @Query(value="select count(*) from t_seller as t where t.email = ?1 and t.password = ?2",nativeQuery=true)
  public int findSeller(String mail,String password);
  
  @Query(value="select count(*) from t_seller as s, t_buyer as b where t.email = ?1 or t.email = ?1",nativeQuery=true)
  public User findByEmail(String mail);
    
}