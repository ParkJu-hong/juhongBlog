//package juhongBlog.juhongBlog.controller;
//
//import juhongBlog.juhongBlog.domain.User;
//import juhongBlog.juhongBlog.repository.UserRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.repository.query.FluentQuery;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.function.Function;
//
//public class UserControllerTest {
//
//    UserRepository userRepository = new UserRepository() {
//        @Override
//        public void flush() {
//
//        }
//
//        @Override
//        public <S extends User> S saveAndFlush(S entity) {
//            return null;
//        }
//
//        @Override
//        public <S extends User> List<S> saveAllAndFlush(Iterable<S> entities) {
//            return null;
//        }
//
//        @Override
//        public void deleteAllInBatch(Iterable<User> entities) {
//
//        }
//
//        @Override
//        public void deleteAllByIdInBatch(Iterable<Long> longs) {
//
//        }
//
//        @Override
//        public void deleteAllInBatch() {
//
//        }
//
//        @Override
//        public User getOne(Long aLong) {
//            return null;
//        }
//
//        @Override
//        public User getById(Long aLong) {
//            return null;
//        }
//
//        @Override
//        public User getReferenceById(Long aLong) {
//            return null;
//        }
//
//        @Override
//        public <S extends User> List<S> findAll(Example<S> example) {
//            return null;
//        }
//
//        @Override
//        public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
//            return null;
//        }
//
//        @Override
//        public <S extends User> List<S> saveAll(Iterable<S> entities) {
//            return null;
//        }
//
//        @Override
//        public List<User> findAll() {
//            return null;
//        }
//
//        @Override
//        public List<User> findAllById(Iterable<Long> longs) {
//            return null;
//        }
//
//        @Override
//        @Test
//        public <S extends User> S save(S entity) {
//            // given
//            List<String> roles = new ArrayList<String>();
//            roles.add("USER_ROLES");
//            User user = new User("박주홍", "ghdwnqkr123@naver.com", "1234", "1234", roles);
//
//            //when
//            userController.userJoin(user);
//
//            // then
//
//            return null;
//        }
//
//        @Override
//        public Optional<User> findById(Long aLong) {
//            return Optional.empty();
//        }
//
//        @Override
//        public boolean existsById(Long aLong) {
//            return false;
//        }
//
//        @Override
//        public long count() {
//            return 0;
//        }
//
//        @Override
//        public void deleteById(Long aLong) {
//
//        }
//
//        @Override
//        public void delete(User entity) {
//
//        }
//
//        @Override
//        public void deleteAllById(Iterable<? extends Long> longs) {
//
//        }
//
//        @Override
//        public void deleteAll(Iterable<? extends User> entities) {
//
//        }
//
//        @Override
//        public void deleteAll() {
//
//        }
//
//        @Override
//        public List<User> findAll(Sort sort) {
//            return null;
//        }
//
//        @Override
//        public Page<User> findAll(Pageable pageable) {
//            return null;
//        }
//
//        @Override
//        public <S extends User> Optional<S> findOne(Example<S> example) {
//            return Optional.empty();
//        }
//
//        @Override
//        public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
//            return null;
//        }
//
//        @Override
//        public <S extends User> long count(Example<S> example) {
//            return 0;
//        }
//
//        @Override
//        public <S extends User> boolean exists(Example<S> example) {
//            return false;
//        }
//
//        @Override
//        public <S extends User, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
//            return null;
//        }
//    };
//    UserController userController = new UserController(userRepository);
//}
