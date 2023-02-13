package ru.yaroslavl.library.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.yaroslavl.library.models.Book;
import ru.yaroslavl.library.models.Person;
import java.util.List;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[]{id},
                        new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
    }

    public Person show(String name) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE name=?", new Object[]{name},
                        new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO Person(name, b_year) VALUES (?, ?)", person.getName(),
                person.getB_year());
    }

    public void update(int id, Person updatedPerson) {
        jdbcTemplate.update("UPDATE Person SET name=?, b_year=? WHERE id=?", updatedPerson.getName(),
                updatedPerson.getB_year(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
    }

    public List<Book> getBooks(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE owner_id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Book.class));
    }
}