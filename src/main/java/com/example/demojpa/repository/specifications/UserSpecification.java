//package com.example.demojpa.repository.specifications;
//
//import com.example.demojpa.entity.User;
//import com.example.demojpa.entity.User_;
//import org.springframework.data.jpa.domain.Specification;
//
//public class UserSpecification {
//    public static Specification<User> findName(String name){
//        return ((root, query, criteriaBuilder) -> {
//            return criteriaBuilder.equal(root.get(User_.NAME),name);
//        });
//
//    }
//    public static Specification<User> findNameLike(String name){
//        return ((root, query, criteriaBuilder) -> {
//            return criteriaBuilder.equal(root.get(User_.NAME),"%"+name+"%");
//        });
//    }
//    public static Specification<User> findHashCodeLike(String hashCode){
//        return ((root, query, criteriaBuilder) -> {
//            return criteriaBuilder.equal(root.get(User_.HASHCODE),"%"+hashCode+"%");
//        });
//    }
//}
