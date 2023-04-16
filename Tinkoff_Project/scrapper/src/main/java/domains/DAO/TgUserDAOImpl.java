package domains.DAO;

import domains.TgUser;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class TgUserDAOImpl implements TgUserDAO{
    private final JdbcTemplate jdbcTemplate;

    public TgUserDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public TgUser add(TgUser tgUser) {
        String sql = "INSERT INTO tg_user (chat_id, user_name) VALUES (?, ?)";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, tgUser.getChatId());
            ps.setString(2, tgUser.getUserName());
            return ps;
        }, keyHolder);

        tgUser.setId(keyHolder.getKey().longValue());
        return tgUser;
    }

    @Override
    public void remove(long id) {
        String sql = "DELETE FROM tg_user WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<TgUser> findAll() {
        String sql = "SELECT * FROM tg_user";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            TgUser tgUser = new TgUser();
            tgUser.setId(rs.getLong("id"));
            tgUser.setChatId(rs.getLong("chat_id"));
            tgUser.setUserName(rs.getString("user_name"));
            return tgUser;
        });
    }
}
